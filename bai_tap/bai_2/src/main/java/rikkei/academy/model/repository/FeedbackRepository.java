package rikkei.academy.model.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.entity.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FeedbackRepository implements IFeedbackRepository {
	
	private static SessionFactory sessionFactory;
	private static EntityManager entityManager;
	
	static {
		try {
			sessionFactory = new Configuration()
					  .configure("hibernate.config.xml")
					  .buildSessionFactory();
			entityManager = sessionFactory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Feedback> findAll() {
		List<Feedback> list;
		String hql = "SELECT f FROM Feedback AS f";
		TypedQuery<Feedback> type = entityManager.createQuery(hql, Feedback.class);
		list = type.getResultList();
		return list;
	}
	
	@Override
	public void save(Feedback feedback) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			if (feedback.getId() == null) {
				session.save(feedback);
			} else {
				Feedback old = findById(feedback.getId());
				old.copy(feedback);
				session.saveOrUpdate(feedback);
			}
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
			session.delete(findById(id));
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
	public Feedback findById(Long id) {
		String hql = "SELECT f FROM Feedback AS f WHERE id=:id";
		TypedQuery<Feedback> type = entityManager.createQuery(hql, Feedback.class);
		type.setParameter("id", id);
		return type.getSingleResult();
	}
}
