package Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import DBLayer.UserDAO;
import Model.Customer;

@Path("/customer")
public class CustomerServices {
	
	@Path("/signup")
	@POST
	public String signup(@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("email") String email,@FormParam("password") String password
			,@FormParam("address") String address,@FormParam("phone") String phone,@FormParam("gender") String gender){
		Customer customer = new Customer(fname, lname, password, phone, address, gender,3,3, email);
		boolean done = UserDAO.createCustomer(customer);
		return done ? "OK" : "Error";
	}
	
	@Path("/login")
	@POST
	public String login(@FormParam("email") String email,@FormParam("password") String password){
		if(UserDAO.getCustomerByEmailAndPassword(email, password) != null){
			return "found";
		}
		else{
			return "not found";
		}
	}
	
	@Path("/getCustomerByEmail")
	@POST
	public String getCustomerByEmail(@FormParam("email") String email){
		System.out.println(email);
		if(UserDAO.getCustomerByEmail(email)){
			return "found";
		}
		else{
			return "not found";
		}
	}
}
