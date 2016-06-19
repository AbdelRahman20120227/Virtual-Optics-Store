package Services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import DBLayer.UserDAO;
import Model.Customer;

@Path("/customer")
public class CustomerServices {
	@Produces("text/plain")
	@Path("/test")
	@GET
	public String test(){
		System.out.println("jdjfdjfj");
		return "jndjknfjk";
	}
	@Produces("text/plain")
	@Path("/addCustomer")
	@POST
	public String addCustomer(@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("email") String email,@FormParam("password") String password
			,@FormParam("address") String address,@FormParam("phone") String phone,@FormParam("gender") String gender){
		Customer customer = new Customer(fname, lname, password, phone, address, gender,3,3, email);
		boolean done = UserDAO.createCustomer(customer);
		return done ? "OK" : "Error";
	}
	@Produces("text/plain")
	@Path("/searchCustomer")
	@POST
	public String searchCustomer(@FormParam("email") String email,@FormParam("password") String password){
		System.out.println(email + " " + password);
		if(UserDAO.getCustomerByEmailAndPassword(email, password) != null){
			return "found";
		}
		else{
			return "not found";
		}
	}
	
	@Produces("text/plain")
	@Path("/searchCustomerByEmail")
	@POST
	public String searchCustomerByEmail(@FormParam("email") String email){
		System.out.println(email);
		if(UserDAO.getCustomerByEmail(email)){
			return "found";
		}
		else{
			return "not found";
		}
	}
}
