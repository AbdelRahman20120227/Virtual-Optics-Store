package Model;

import javax.persistence.Entity;

@Entity
public class News {
	
	private int ID;
	private String content;
	private Admin admin;
	
	//Constructors
	public News() {
		super();
	}

	public News(int ID, String content, Admin admin) {
		super();
		this.ID = ID;
		this.content = content;
		this.admin = admin;
	}

	//Setters and Getters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
	
}
