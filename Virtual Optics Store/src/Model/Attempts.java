package Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Attempts {
	@Id
	private int gID;
	
	@Id
	private int cID;
	
	private Date date;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne 
	private Glasses glasses;
	
	//Constructors
	public Attempts(){
		super();
	}
	public Attempts(int gID, int cID, Date date, Customer customer,
			Glasses glasses) {
		super();
		this.gID = gID;
		this.cID = cID;
		this.date = date;
		this.customer = customer;
		this.glasses = glasses;
	}
	
	// Setters And Getters
	public int getgID() {
		return gID;
	}
	public void setgID(int gID) {
		this.gID = gID;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Glasses getGlasses() {
		return glasses;
	}
	public void setGlasses(Glasses glasses) {
		this.glasses = glasses;
	}
	
}
