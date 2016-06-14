package Model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String fName;
	private String lName;
	private String password;
	private String phone;
	private String address;
	private String gender;
	@OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
	private ArrayList<Transaction> transactions;
	
	//Constructors
	public User(){
		super();
	}
	
	public User(int ID, String fName, String lName, String password,
			String phone, String address, String gender) {
		super();
		this.ID = ID;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.transactions = new ArrayList<Transaction>();
	}
	
	//Setters And Getters
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	//Rest of functions
	public void addTransaction(Transaction transaction){
		this.transactions.add(transaction);
	}
}
