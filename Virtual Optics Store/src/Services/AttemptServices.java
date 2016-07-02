package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.JSONException;
import org.json.JSONObject;

import DBLayer.AttemptDAO;
import Model.Glasses;

@Path("/attempts")
public class AttemptServices {
	@Path("/getRecommendations")
	@POST
	public String getRecommendations(@FormParam ("email") String email){
		System.out.println("hereeeeeeeeee" + email);
		List<Glasses>list = AttemptDAO.getRecommendations(email);
		ArrayList<Glasses>glasses = new ArrayList<Glasses>(list);
		try {
			JSONObject json = JsonParser.prepareGlassesJSON(glasses);
			return json.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  return "error";
	}
}
