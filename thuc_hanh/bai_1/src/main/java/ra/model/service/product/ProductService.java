package ra.model.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.model.repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	@Override
	public void save(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
		return productRepository.findAllByNameContaining(name, pageable);
	}
	
	@Override
	public Page<Product> findByNameProduct(String name, Pageable pageable) {
		return productRepository.findByNameProduct(name, pageable);
	}
}
