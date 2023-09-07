package ra.service.entityService.product;

import ra.exception.ProductException;
import ra.model.dto.request.ProductRequest;
import ra.model.dto.response.ProductResponse;

import java.util.List;

public interface IProductService {
	
	List<ProductResponse> findAll();
	
	ProductResponse findById(Long id);
	
	ProductResponse save(ProductRequest productRequest) throws ProductException;
	
	ProductResponse update(ProductRequest productRequest, Long id) throws ProductException;
	
	ProductResponse delete(Long id);
	
}
