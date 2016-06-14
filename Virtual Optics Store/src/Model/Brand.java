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
	private String Name;
	private String Country;
	
	@OneToMany(mappedBy = "Brand", cascade = CascadeType.ALL)
	ArrayList<Glasses>glasses;
	
	// Constructors
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(int ID, String Name, String Country) {
		super();
		this.ID = ID;
		this.Name = Name;
		this.Country = Country;
	}

	// Setters and Getters
	public int getbId() {
		return ID;
	}
	public void setbId(int ID) {
		this.ID = ID;
	}
	public String getbName() {
		return Name;
	}
	public void setbName(String Name) {
		this.Name = Name;
	}
	public ArrayList<Glasses> getGlasses() {
		return glasses;
	}
	public void setGlasses(ArrayList<Glasses> glasses) {
		this.glasses = glasses;
	}
	public String getbCountry() {
		return Country;
	}
	public void setbCountry(String Country) {
		this.Country = Country;
	}
	
	// Add glasses to owned store
	public void addGlasses(Glasses g){
		glasses.add(g);
		g.setBrand(this);
	}
}

