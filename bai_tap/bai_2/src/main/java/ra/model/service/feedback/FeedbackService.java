package ra.model.service.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.model.entity.Feedback;
import ra.model.repository.IFeedbackRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService implements IFeedbackService {
	
	@Autowired
	private IFeedbackRepository feedbackRepository;
	
	@Override
	public List<Feedback> findAll() {
		return (List<Feedback>) feedbackRepository.findAll();
	}
	
	@Override
	public Feedback findById(Long id) {
		Optional<Feedback> optionalFeedback = feedbackRepository.findById(id);
		return optionalFeedback.orElse(null);
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
		f.setLikes(f.getLikes() + 1);
		feedbackRepository.save(f);
	}
	
	@Override
	public Page<Feedback> findAll(int page,int size) {
		return feedbackRepository.findAll(PageRequest.of(page,size));
	}
}
