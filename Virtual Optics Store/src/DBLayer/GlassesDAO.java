package DBLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



import Model.Glasses;

public class GlassesDAO {


	public static boolean addGlasses(Glasses glasses) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		
		Glasses oldGlasses = getGlassesByModelName(glasses.getModelName());
		
		if(oldGlasses == null){
			entityManager.persist(glasses);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return true;
		}
		else{
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return false;
		}
	}

	public static void updateGlasses(Glasses glasses) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		Glasses glasses2 = entityManager.find(Glasses.class, glasses.getID());
		entityManager.getTransaction().begin();

		// .......... update fields

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	public static ArrayList<Glasses> getGlasses() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("Select g from Glasses g");
		List<Glasses> glasses = query.getResultList();
		manager.close();
		factory.close();
		return (ArrayList<Glasses>)glasses;
	}
	
	public static Glasses getGlassesByModelName(String name){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("select g from Glasses g where modelName = :param1");
		query.setParameter("param1", name);
		List<Glasses> result = query.getResultList();
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		return (result.size() == 0) ? null : result.get(0);
	}
	public static ArrayList<String> getGlassesByBrand(String brand) {

		return null;
	}

	public static ArrayList<String> getGlassesByPrice(int low, int high) {

		return null;
	}
}
