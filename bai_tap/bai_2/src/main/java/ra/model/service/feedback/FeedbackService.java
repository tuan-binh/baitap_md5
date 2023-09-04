package ra.model.service.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.model.entity.Feedback;
import ra.model.repository.IFeedbackRepository;

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
		return feedbackRepository.findById(id).get();
	}
	
	@Override
	public void save(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
	
	@Override
	public void delete(Long id) {
		feedbackRepository.deleteById(id);
	}
	
	public void like(Long id) {
		Feedback f = feedbackRepository.findById(id).get();
		f.setLike(f.getLike() + 1);
		feedbackRepository.save(f);
	}
	
	@Override
	public Page<Feedback> findAll(Pageable pageable) {
		return feedbackRepository.findAll(pageable);
	}
}
