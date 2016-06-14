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
	private int bId;
	private String bName;
	private String bCountry;
	
	@OneToMany(mappedBy = "Brand", cascade = CascadeType.ALL)
	ArrayList<Glasses>glasses;
	
	// Constructors
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(int bId, String bName, String bCountry) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bCountry = bCountry;
	}

	// Setters and Getters
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbCountry() {
		return bCountry;
	}
	public void setbCountry(String bCountry) {
		this.bCountry = bCountry;
	}
	
	// Add glasses to owned store
	public void addGlasses(Glasses g){
		glasses.add(g);
		g.setBrand(this);
	}
}

