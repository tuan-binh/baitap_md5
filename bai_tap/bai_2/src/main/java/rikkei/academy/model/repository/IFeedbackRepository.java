package rikkei.academy.model.repository;

import rikkei.academy.model.entity.Feedback;

import java.util.List;

public interface IFeedbackRepository {
	List<Feedback> findAll();
	
	void save(Feedback feedback);
	
	void delete(Long id);
	
	Feedback findById(Long id);
}
