package ra.model.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T,E> {
	List<T> findAll();
	T findById(E id);
	void save(T t);
	void delete(E id);
}
