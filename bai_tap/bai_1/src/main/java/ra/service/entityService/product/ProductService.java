package ra.service.entityService.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exception.ProductException;
import ra.model.domain.Product;
import ra.model.dto.request.ProductRequest;
import ra.model.dto.response.ProductResponse;
import ra.repository.IProductRepository;
import ra.service.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<ProductResponse> findAll() {
		return productRepository.findAll().stream()
				  .map((item) -> productMapper.toResponse(item))
				  .collect(Collectors.toList());
	}
	
	@Override
	public ProductResponse findById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		return optionalProduct.map(product -> productMapper.toResponse(product)).orElse(null);
	}
	
	@Override
	public ProductResponse save(ProductRequest productRequest) throws ProductException {
		if (productRepository.existsByName(productRequest.getName())) {
			throw new ProductException("product exists name");
		}
		return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequest)));
	}
	
	@Override
	public ProductResponse update(ProductRequest productRequest, Long id) throws ProductException {
		if (productRepository.existsByName(productRequest.getName())) {
			throw new ProductException("product exists name");
		}
		Product product = productMapper.toEntity(productRequest);
		product.setId(id);
		return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequest)));
	}
	
	@Override
	public ProductResponse delete(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			productRepository.deleteById(id);
			return productMapper.toResponse(optionalProduct.get());
		}
		return null;
	}
}
