package DBLayer;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.jdbc.Connection;

import Model.Glasses;

public class GlassesDAO {

	private static final String PRESISTENCE_UNIT_NAME = "X";

	public static void addGlasses(Glasses glasses) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(PRESISTENCE_UNIT_NAME);
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(glasses);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	public static void updateGlasses(Glasses glasses) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(PRESISTENCE_UNIT_NAME);
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
				.createEntityManagerFactory(PRESISTENCE_UNIT_NAME);
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("Select g from Glasses g");
		ArrayList<Glasses> glasses = (ArrayList<Glasses>) query.getResultList();
		manager.close();
		factory.close();
		return glasses;
	}

	public static ArrayList<String> getGlassesByBrand(String brand) {

		return null;
	}

	public static ArrayList<String> getGlassesByPrice(int low, int high) {

		return null;
	}
}
