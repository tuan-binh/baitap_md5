package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Category;
import ra.model.service.category.ICategoryService;

import java.util.List;

@RestController
@RequestMapping({"/category"})
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllBlog() {
		List<Category> categories = categoryService.findAll();
		if (categories.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getBlogById(@PathVariable String id) {
		Category category = categoryService.findById(id);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Category> handleAdd(@RequestBody Category category) {
		category.setId(null);
		Category newCategory = categoryService.save(category);
		return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> handleUpdate(@RequestBody Category category, @PathVariable String id) {
		Category newCategory = categoryService.save(category, id);
		if (newCategory == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> handleDelete(@PathVariable String id) {
		Category oldCategory = categoryService.delete(id);
		if (oldCategory == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldCategory, HttpStatus.OK);
	}
	
}
