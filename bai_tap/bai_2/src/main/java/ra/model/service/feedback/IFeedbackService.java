package ra.model.service.feedback;

import ra.model.entity.Feedback;

import java.util.List;

public interface IFeedbackService {
	List<Feedback> findAll();
	Feedback findById(Long id);
	void save(Feedback feedback);
	void delete(Long id);
	
	void like(Long id);
}
