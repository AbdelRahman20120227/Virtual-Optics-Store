package Services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
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
	@GET
	public String addCustomer(@Context HttpServletRequest request){
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		double leftSight = Double.valueOf(request.getParameter("leftSight"));
		double rightSight = Double.valueOf(request.getParameter("rightSight"));
		String email = request.getParameter("email");
		Customer customer = new Customer(fName, lName, password, phone, address, gender, leftSight, rightSight, email);
		boolean done = UserDAO.createCustomer(customer);
		return done ? "OK" : "Error";
	}
	@Produces("text/plain")
	@Path("/searchCustomer")
	@GET
	public String searchCustomer(@Context HttpServletRequest request){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(UserDAO.getCustomerByEmailAndPassword(email, password) != null){
			return "found";
		}
		else{
			return "not found";
		}
	}
}
