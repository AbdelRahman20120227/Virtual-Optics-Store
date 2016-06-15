package Model;

import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Admin extends User{
	
	private ArrayList<News> news;
	private String userName;
	private Store store;

	//Constructors
	public Admin() {
		super();
	}
	
	public Admin(int ID, String fName, String lName, String password,
			String phone, String address, String gender,
			String userName, Store store) {
		super(ID, fName, lName, password, phone, address, gender);
		this.news = new ArrayList<News>();
		this.userName = userName;
		this.store = store;
	}
	
	//Getters and Setter
	public ArrayList<News> getNews() {
		return news;
	}
	public void setNews(ArrayList<News> news) {
		this.news = news;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	//rest of functions
	public void addNews(News news){
		this.news.add(news);
		news.setAdmin(this);
	}
	
}
