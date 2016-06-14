package Model;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {
	@Id
	@GeneratedValue
	private int ID;
	private String name;
	private String country;
	
	@OneToMany(mappedBy = "Brand", cascade = CascadeType.ALL)
	ArrayList<Glasses>glasses;
	
	// Constructors
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(int ID, String name, String country) {
		super();
		this.ID = ID;
		this.name = name;
		this.country = country;
	}

	// Setters and Getters
	public int getbId() {
		return ID;
	}
	public void setbId(int ID) {
		this.ID = ID;
	}
	public String getbName() {
		return name;
	}
	public void setbName(String Name) {
		this.name = Name;
	}
	public ArrayList<Glasses> getGlasses() {
		return glasses;
	}
	public void setGlasses(ArrayList<Glasses> glasses) {
		this.glasses = glasses;
	}
	public String getbCountry() {
		return country;
	}
	public void setbCountry(String Country) {
		this.country = Country;
	}
	
	// Add glasses to owned store
	public void addGlasses(Glasses g){
		glasses.add(g);
		g.setBrand(this);
	}
}

