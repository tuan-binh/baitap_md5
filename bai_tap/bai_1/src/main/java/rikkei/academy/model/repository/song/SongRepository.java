package rikkei.academy.model.repository.song;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
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
	public List<Song> findAll() {
		List<Song> list;
		String hql = "SELECT s FROM Song AS s";
		TypedQuery<Song> type = entityManager.createQuery(hql, Song.class);
		list = type.getResultList();
		return list;
	}
	
	@Override
	public void save(Song song) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			if (song.getId() == null) {
				session.save(song);
			} else {
				Song old = findById(song.getId());
				if (song.getUrl() == null) {
					old.setUrl(song.getUrl());
				}
				old.copy(song);
				session.saveOrUpdate(old);
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
	public Song findById(Long id) {
		String hql = "SELECT s FROM Song AS s WHERE id=:id";
		TypedQuery<Song> type = entityManager.createQuery(hql, Song.class);
		type.setParameter("id", id);
		return type.getSingleResult();
	}
}
