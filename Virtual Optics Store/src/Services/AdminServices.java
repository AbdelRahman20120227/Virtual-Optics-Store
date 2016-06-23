package Services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.json.JSONException;
import org.json.JSONObject;

import DBLayer.BrandDAO;
import DBLayer.GlassesDAO;
import DBLayer.Globals;
import Model.Brand;
import Model.Glasses;


@Path("/admin")
public class AdminServices {
	
	
	@Path("/addNewGlasses")
	public String addNewGlasses(@Context ServletContext context, @Context HttpServletRequest request){
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(500000);
		FileUpload upload = new FileUpload(factory);
		Map<String, String> fields = new HashMap<String, String>();
		try {
			List<FileItem> items = upload.parseRequest(request);
			FileItem file = null;
			for(FileItem item : items){
				if(item.isFormField()){
					fields.put(item.getName(), item.getString());
				}
				else{
					file = item;
				}
			}
			if(file == null){
				return Globals.FILE_PROBLEM;
			}
			else{
				String color = fields.get("color");
				String modelName = fields.get("modelName");
				int convertable = Integer.parseInt(fields.get("convertable"));
				String brandName = fields.get("brand");
				String shape = fields.get("shape");
				int type = Integer.parseInt(fields.get("type"));
				String material = fields.get("material");
				double price = Double.parseDouble(fields.get("price"));
				
				Brand brand = BrandDAO.getBrandByName(brandName);
				if(brand == null){
					return Globals.BRAND_NOT_EXIST;
				}
				if(GlassesDAO.getGlassesByModelName(modelName) == null){
					String path = context.getRealPath("") + File.separator + "Glasses"
							+ File.separator + brandName + File.separator + file.getName();
					FileUtilities.saveFile(path, file.getInputStream());
					Glasses glasses = new Glasses(color, modelName, path, convertable, shape, type, material, price, brand);
					GlassesDAO.addGlasses(glasses);
					return Globals.SUCCESS;
				}
				else{
					return Globals.GLASSES_ALREADY_EXIST;
				}
			}
		} catch (Exception e) {
			return Globals.FILE_PROBLEM;
		}
	}
	
	@Path("getGlasses")
	@GET
	public String getGlasses(){
		ArrayList<Glasses> glasses = GlassesDAO.getGlasses();
		try {
			JSONObject obj = JsonParser.prepareGlassesJSON(glasses);
			return obj.toString();
		} catch (JSONException e) {
			return Globals.PARSING_ERROR;
		}
		
	}
}
