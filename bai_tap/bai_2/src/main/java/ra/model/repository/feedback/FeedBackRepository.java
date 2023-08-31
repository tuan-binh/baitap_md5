package ra.model.repository.feedback;

import org.springframework.stereotype.Repository;
import ra.model.entity.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FeedBackRepository implements IFeedbackRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Feedback> findAll() {
		return entityManager.createQuery("SELECT f FROM Feedback AS f", Feedback.class).getResultList();
	}
	
	@Override
	public Feedback findById(Long id) {
		return entityManager.createQuery("SELECT f FROM Feedback AS f WHERE id=:id", Feedback.class).setParameter("id", id).getSingleResult();
	}
	
	@Override
	public void save(Feedback feedback) {
		if (feedback.getId() == null) {
			entityManager.persist(feedback);
		} else {
			entityManager.merge(feedback);
		}
	}
	
	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));
	}
}
