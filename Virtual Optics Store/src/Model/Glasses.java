package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Glasses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gID;
	private String color;
	private String modelName;
	private String model;
	private int convertable;
	private String shape;
	private int type;
	private String material;
	private int price;
	private Brand brand;
	
	// Constructors
	public Glasses(){
		super();
	}
	public Glasses(int gID, String color, String modelName, String model,
			int convertable, String shape, int type, String material, int price,Brand brand) {
		super();
		this.gID = gID;
		this.color = color;
		this.modelName = modelName;
		this.model = model;
		this.convertable = convertable;
		this.shape = shape;
		this.type = type;
		this.material = material;
		this.price = price;
		this.brand = brand;
	}
	// Setters and Getters
	public int getgID() {
		return gID;
	}
	public void setgID(int gID) {
		this.gID = gID;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getConvertable() {
		return convertable;
	}
	public void setConvertable(int convertable) {
		this.convertable = convertable;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
}
