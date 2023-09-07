package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exception.ProductException;
import ra.model.dto.request.ProductRequest;
import ra.model.dto.response.ProductResponse;
import ra.service.entityService.product.IProductService;

import java.util.List;

@RestController
@RequestMapping({"/product"})
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProduct() {
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
		return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductResponse> handleAddProduct(@RequestBody ProductRequest productRequest) throws ProductException {
		return new ResponseEntity<>(productService.save(productRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse> handleUpdateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id) throws ProductException {
		return new ResponseEntity<>(productService.update(productRequest, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ProductResponse> handleDeleteProduct(@PathVariable Long id) {
		return new ResponseEntity<>(productService.delete(id), HttpStatus.OK);
	}
	
}
