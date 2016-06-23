package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.JSONException;
import org.json.JSONObject;

import DBLayer.GlassesDAO;
import DBLayer.Globals;
import DBLayer.StoreDAO;
import DBLayer.UserDAO;
import Model.Admin;
import Model.Admin_Quantity;
import Model.Glasses;
import Model.Glasses_Store;
import Model.Store;

@Path("/glasses")
public class GlassesServices {
	@Path("getGlasses")
	@GET
	public String getGlasses(){
		List<Glasses> glasses1 = GlassesDAO.getGlasses();
		ArrayList<Glasses> glasses = new ArrayList<Glasses>();
		for(int i=0;i<glasses1.size();i++)
			glasses.add(glasses1.get(i));
		try {
			JSONObject obj = JsonParser.prepareGlassesJSON(glasses);
			return obj.toString();
		} catch (JSONException e) {
			return Globals.PARSING_ERROR;
		}
	}
	
	@Path("addStoreToGlasses")
	@POST
	public String addStoreToGlasses(@FormParam("store") int storeID, 
			@FormParam("glassesID") int glassesID, @FormParam("adminUserName") String userName,
			@FormParam("quantity") int quantity){
		
		Glasses glasses = GlassesDAO.getGlassesByID(glassesID);
		Store store = StoreDAO.getStoreByID(storeID);
		Admin admin = UserDAO.getAdminByUserName(userName);
		ArrayList<Glasses_Store> stores = glasses.getStore();
		for(Glasses_Store gs : stores){
			// if glasses already in store
			if(gs.getStore().getAddress().equals(store.getAddress())){
				ArrayList<Admin_Quantity> adminQuantities = gs.getAdminglasses();
				for(Admin_Quantity aq : adminQuantities){
					// if this admin has added the same glasses before
					if(aq.getAdmin().getUserName().equals(userName)){
						aq.setQuantity(aq.getQuantity() + quantity);
						GlassesDAO.updateGlasses(glasses);
						UserDAO.updateAdmin(admin);
						return Globals.SUCCESS;
					}
				}
				//if inner loop ended without finding admin 
				Admin_Quantity aq = new Admin_Quantity();
				admin.addGlasses(aq);
				aq.setQuantity(quantity);
				gs.addAdminGlasses(aq);
				GlassesDAO.updateGlasses(glasses);
				UserDAO.updateAdmin(admin);
				return Globals.SUCCESS;
			}
		}
		//if outer loop ended without finding this store
		Glasses_Store gs = new Glasses_Store(glasses, store, quantity);
		Admin_Quantity aq = new Admin_Quantity();
		admin.addGlasses(aq);
		aq.setQuantity(quantity);
		gs.addAdminGlasses(aq);
		GlassesDAO.updateGlasses(glasses);
		UserDAO.updateAdmin(admin);
		return Globals.SUCCESS;
	}
}
