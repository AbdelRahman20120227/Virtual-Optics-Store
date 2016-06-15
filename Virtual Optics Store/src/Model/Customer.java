package Model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{
	
	private double leftSight;
	private double rightSight;
	private String email;
	@OneToMany(mappedBy= "Customer", cascade = CascadeType.ALL)
	ArrayList<Attempt>attempts;

	//Constructors
	public Customer(){
		super();
	}
	
	public Customer(int ID, String fName, String lName, String password,
			String phone, String address, String gender, double leftSight,
			double rightSight, String email) {
		super(ID, fName, lName, password, phone, address, gender);
		this.leftSight = leftSight;
		this.rightSight = rightSight;
		this.email = email;
		this.attempts = new ArrayList<Attempt>();
	}

	//Setters and Getters
	public double getLeftSight() {
		return leftSight;
	}
	public void setLeftSight(double leftSight) {
		this.leftSight = leftSight;
	}
	public double getRightSight() {
		return rightSight;
	}
	public void setRightSight(double rightSight) {
		this.rightSight = rightSight;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(ArrayList<Attempt> attempts) {
		this.attempts = attempts;
	}
	
	//Rest of functions
	public void addAttempts(Attempt attempt){
		this.attempts.add(attempt);
		attempt.setCustomer(this);
	}
}
