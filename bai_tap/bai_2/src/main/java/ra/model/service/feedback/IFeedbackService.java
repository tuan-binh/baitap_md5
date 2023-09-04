package ra.model.service.feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.Feedback;

import java.util.List;

public interface IFeedbackService {
	List<Feedback> findAll();
	Feedback findById(Long id);
	void save(Feedback feedback);
	void delete(Long id);
	
	void like(Long id);
	
	Page<Feedback> findAll(Pageable pageable);
}
