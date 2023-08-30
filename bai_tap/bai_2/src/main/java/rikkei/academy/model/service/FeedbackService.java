package rikkei.academy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.dto.FeedbackDTO;
import rikkei.academy.model.entity.Feedback;
import rikkei.academy.model.repository.IFeedbackRepository;

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
	public void save(FeedbackDTO feedbackDTO) {
		Feedback feedback = new Feedback(feedbackDTO.getId(), feedbackDTO.getRate(), feedbackDTO.getAuthor(), feedbackDTO.getContent(), feedbackDTO.getCreateDate(), feedbackDTO.getLike());
		feedbackRepository.save(feedback);
	}
	
	@Override
	public void delete(Long id) {
		feedbackRepository.delete(id);
	}
	
	@Override
	public void like(Long id) {
		Feedback feedback = findById(id);
		feedback.setLike(feedback.getLike() + 1);
		feedbackRepository.save(feedback);
	}
}
