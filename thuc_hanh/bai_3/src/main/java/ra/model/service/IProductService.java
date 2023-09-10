package ra.model.service;

import ra.model.entity.Product;

import java.util.Optional;

public interface IProductService {
	Iterable<Product> findAll();
	Optional<Product> findById(Long id);
}
