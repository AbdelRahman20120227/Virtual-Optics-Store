package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Admin_Quantity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@ManyToOne
	private Glasses_Store glasseStore;
	@ManyToOne
	private Admin admin;
	private int quantity;
	
	// Constructors
	public Admin_Quantity(Glasses_Store glassesStore, Admin admin, int quantity) {
		super();
		this.glasseStore = glassesStore;
		this.admin = admin;
		this.quantity = quantity;
	}
	public Admin_Quantity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Setters and Getters
	public Glasses_Store getGlassesStore() {
		return glasseStore;
	}
	public void setGlassesStore(Glasses_Store glassesStore) {
		this.glasseStore = glassesStore;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
