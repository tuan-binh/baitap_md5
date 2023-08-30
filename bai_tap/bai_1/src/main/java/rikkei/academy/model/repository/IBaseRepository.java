package rikkei.academy.model.repository;

import java.util.List;

public interface IBaseRepository<T, E> {
	List<T> findAll();
	
	void save(T t);
	
	void delete(E id);
	
	T findById(E id);
}
