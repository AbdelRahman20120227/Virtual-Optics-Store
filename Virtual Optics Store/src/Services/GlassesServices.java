package Services;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import DBLayer.GlassesDAO;
import Model.Glasses;

@Path("/Glasses")
public class GlassesServices {
	@Path("/addGlasses")
	@POST
	@Produces("text/plain")
	public void addGlasses(Glasses glasses){ 
        GlassesDAO.addGlasses(glasses); ;  
		ObjectMapper mapper = new ObjectMapper() ; 
	}
	
	
	@Path("/getGlasses")
	@POST
	@Produces("text/plain")
	public String getGlasses(){ 
		ArrayList<Glasses> glasses = GlassesDAO.getGlasses() ;  
		ObjectMapper mapper = new ObjectMapper() ; 
		try {
			return mapper.writeValueAsString(glasses) ;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error" ; 
	}
	
    
	
}
