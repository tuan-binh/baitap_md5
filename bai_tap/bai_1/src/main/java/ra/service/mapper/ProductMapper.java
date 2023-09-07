package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Product;
import ra.model.dto.request.ProductRequest;
import ra.model.dto.response.ProductResponse;
import ra.service.IGenericMapper;

@Component
public class ProductMapper implements IGenericMapper<Product, ProductRequest, ProductResponse> {
	@Override
	public Product toEntity(ProductRequest productRequest) {
		return Product.builder()
				  .name(productRequest.getName())
				  .price(productRequest.getPrice())
				  .status(productRequest.isStatus())
				  .build();
	}
	
	@Override
	public ProductResponse toResponse(Product product) {
		return ProductResponse.builder()
				  .id(product.getId())
				  .name(product.getName())
				  .price(product.getPrice())
				  .status(product.isStatus())
				  .build();
	}
}
