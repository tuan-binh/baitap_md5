package rikkei.academy.model.repository.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
	
	private static SessionFactory sessionFactory;
	private static EntityManager entityManager;
	
	static {
		try {
			sessionFactory = new Configuration()
					  .configure()
					  .buildSessionFactory();
			entityManager = sessionFactory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Customer> findAll() {
		List<Customer> list;
		String hql = "SELECT c FROM Customer AS c";
		TypedQuery<Customer> type = entityManager.createQuery(hql, Customer.class);
		list = type.getResultList();
		return list;
	}
	
	@Override
	public void save(Customer customer) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			if(customer.getId() == null) {
				session.save(customer);
			} else {
				Customer old = findById(customer.getId());
				old.copy(customer);
				session.saveOrUpdate(customer);
			}
			
			// nếu đúng thì sẽ commit
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.isActive();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	@Override
	public void delete(Long id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			// xóa đối tượng thông qua session
			session.delete(findById(id));
			// nếu đúng thì sẽ commit
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.isActive();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	@Override
	public Customer findById(Long id) {
		String hql = "SELECT c FROM Customer AS c WHERE id=:id";
		TypedQuery<Customer> type = entityManager.createQuery(hql, Customer.class);
		type.setParameter("id", id);
		return type.getSingleResult();
	}
}
