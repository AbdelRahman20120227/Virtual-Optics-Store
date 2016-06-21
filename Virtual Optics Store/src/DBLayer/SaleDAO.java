package DBLayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Sale;
import Model.Store;

public class SaleDAO {
	private static final String PRESISTENCE_UNIT_NAME = "X";
	public static void addStore(Sale sale){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PRESISTENCE_UNIT_NAME);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(sale);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	public static void updateStore(Sale sale){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PRESISTENCE_UNIT_NAME);
		EntityManager manager = factory.createEntityManager();
		Sale sale1 = manager.find(Sale.class, sale.getSaleID());
		manager.getTransaction().begin();
       //store1.setAddress();            
        
       // update store
        
        manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
