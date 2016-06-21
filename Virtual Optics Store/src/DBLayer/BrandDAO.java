package DBLayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Brand;
import Model.Store;

public class BrandDAO {
	private static final String PRESISTENCE_UNIT_NAME = "X";
	public static void addBrand(Brand brand){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PRESISTENCE_UNIT_NAME);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(brand);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	public static void updateBrand(Brand brand){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PRESISTENCE_UNIT_NAME);
		EntityManager manager = factory.createEntityManager();
		Brand brand1 = manager.find(Brand.class, brand.getbId());
		manager.getTransaction().begin();
       //store1.setAddress();            
        
       // update store
        
        manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
