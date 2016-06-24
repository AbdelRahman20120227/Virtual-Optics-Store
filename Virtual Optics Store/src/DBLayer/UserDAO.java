package DBLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Admin;
import Model.Customer;

public class UserDAO {

	public static boolean createCustomer(Customer customer) {
		if(getCustomerByEmail(customer.getEmail()))
			return false;
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
		manager.close();
		factory.close();
		return true;
	}

	public static Customer getCustomerByEmailAndPassword(String email,
			String password) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager
				.createQuery("select c from Customer c where c.email = :param1"
						+ " and c.password = :param2");
		query.setParameter("param1", email);
		query.setParameter("param2", password);
		List<Customer> result = (List<Customer>) query.getResultList();
		transaction.commit();
		manager.close();
		factory.close();
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public static boolean getCustomerByEmail(String email) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager
				.createQuery("select c from Customer c where c.email = :param1");
		query.setParameter("param1", email);
		List<Customer> result = query.getResultList();
		transaction.commit();
		manager.close();
		factory.close();
		if (result.size() > 0) {
			return true;
		}
		return false;
	}
	public static void updateAdmin(Admin admin){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(admin);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	public static Admin getAdminByUserNameAndPassword(String userName, String password){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("select a from Admin a where a.userName = :param1"
				+ " and a.password = :param2");
		query.setParameter("param1", userName);
		query.setParameter("param2", password);
		List<Admin> result = query.getResultList();
		
		manager.getTransaction().commit();
		return (result.size() == 0) ? null : result.get(0);
	}
	public static Admin getAdminByUserName(String userName){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Globals.persistenceUnitName);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("select a from Admin a where a.userName = :param1");
		query.setParameter("param1", userName);
		List<Admin> result = query.getResultList();
		
		manager.getTransaction().commit();
		return (result.size() == 0) ? null : result.get(0);
	}
}
