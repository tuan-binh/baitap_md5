package rikkei.academy.model.repository.customer;

import org.hibernate.Session;
import org.hibernate.Transaction;
import rikkei.academy.model.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepository implements ICustomerRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> type = em.createQuery("SELECT c FROM Customer AS c", Customer.class);
		return type.getResultList();
	}
	
	@Override
	public Customer findById(Long id) {
		TypedQuery<Customer> type = em.createQuery("SELECT c FROM Customer AS c WHERE id=:id", Customer.class);
		type.setParameter("id", id);
		return type.getSingleResult();
	}
	
	@Override
	public void save(Customer customer) {
		if(customer.getId() == null) {
			em.merge(customer);
		} else {
			em.persist(customer);
		}
	}
	
	@Override
	public void remove(Long id) {
		Customer customer = findById(id);
		if(customer != null) {
			em.remove(customer);
		}
	}
}
