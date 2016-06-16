package DBLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Customer;

public class UserDAO {

	public static boolean createCustomer(Customer customer){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
		manager.close();
		factory.close();
		return true;
	}
	public static Customer getCustomerByEmailAndPassword(String email, String password){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery("select c from Customer c where c.email = :param1"
				+ " and c.password = :param2");
		query.setParameter("param1", email);
		query.setParameter("param2", password);
		List<Customer> result = query.getResultList();
		transaction.commit();
		manager.close();
		factory.close();
		if(result.size() > 0){
			return result.get(0);
		}
		return null;
	}
}
