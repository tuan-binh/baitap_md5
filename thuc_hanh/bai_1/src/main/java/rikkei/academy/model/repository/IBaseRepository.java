package rikkei.academy.model.repository;

import java.util.List;

public interface IBaseRepository<T,E> {
	List<T> findAll();
	
	T findById(Long id);
	
	void save(T t);
	
	void remove(Long id);
}
