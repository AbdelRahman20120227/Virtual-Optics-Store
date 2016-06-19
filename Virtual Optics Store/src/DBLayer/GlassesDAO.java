package DBLayer;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	public static ArrayList<String> getGlasses() {
		

		return null;
	}
}
