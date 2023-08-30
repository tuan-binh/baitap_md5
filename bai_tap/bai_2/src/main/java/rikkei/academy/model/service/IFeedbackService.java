package rikkei.academy.model.service;

import rikkei.academy.model.dto.FeedbackDTO;
import rikkei.academy.model.entity.Feedback;

import java.util.List;

public interface IFeedbackService {
	List<Feedback> findAll();
	Feedback findById(Long id);
	void save(FeedbackDTO feedbackDTO);
	void delete(Long id);
	void like(Long id);
}
