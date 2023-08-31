package ra.model.service.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Feedback;
import ra.model.repository.feedback.IFeedbackRepository;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
	
	@Autowired
	private IFeedbackRepository feedbackRepository;
	
	@Override
	public List<Feedback> findAll() {
		return feedbackRepository.findAll();
	}
	
	@Override
	public Feedback findById(Long id) {
		return feedbackRepository.findById(id);
	}
	
	@Override
	public void save(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
	
	@Override
	public void delete(Long id) {
		feedbackRepository.delete(id);
	}
	
	public void like(Long id) {
		Feedback f = feedbackRepository.findById(id);
		f.setLike(f.getLike() + 1);
		feedbackRepository.save(f);
	}
	
}
