package ra.service;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<T,E> {
	Iterable<T> findAll();
	Optional<T> findById(E id);
	void save(T t);
	void remove(E id);
}
