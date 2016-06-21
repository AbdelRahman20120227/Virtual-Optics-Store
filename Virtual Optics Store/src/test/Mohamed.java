package test;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Mohamed {
	private String name;
	private int id;
	private double age;
	public Mohamed(){}

	public Mohamed(String name, int id, double age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	
	public static void main(String[] args) {
    Mohamed mohamed = new Mohamed("Mohamed Veron", 20120313, 21.5) ; 
    Mohamed mohamed2 = new Mohamed("Mohamed Veron", 20120313, 22.5) ;
    ArrayList<Mohamed> arrayList = new ArrayList<Mohamed>() ; 
    arrayList.add(mohamed);
    arrayList.add(mohamed2) ;
    ObjectMapper mapper =  new ObjectMapper() ; 
    try {
	    String m  = mapper.writeValueAsString(arrayList);
	    System.out.println(m);
	    ArrayList<Mohamed> list = mapper.readValue(m, new TypeReference<ArrayList<Mohamed>>(){}); 
	    System.out.println(mohamed2.age);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}

}
