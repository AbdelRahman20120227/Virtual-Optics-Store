package DBLayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Store;

public class StoreDAO {
		public static void addStore(Store store){
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(store);
			manager.getTransaction().commit();
			manager.close();
			factory.close();
		}
		public static void updateStore(Store store){
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
			EntityManager manager = factory.createEntityManager();
			Store store1 = manager.find(Store.class, store.getID());
			manager.getTransaction().begin();
           //store1.setAddress();            
            
           // update store
            
            manager.getTransaction().commit();
			manager.close();
			factory.close();
		}
}
