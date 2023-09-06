package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Blog;
import ra.model.service.blog.IBlogService;

import java.util.List;

@RestController
@RequestMapping({"/blog"})
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	@GetMapping
	public ResponseEntity<List<Blog>> getAllBlog() {
		List<Blog> blogs = blogService.findAll();
		if (blogs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(blogs, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable String id) {
		Blog blog = blogService.findById(id);
		if (blog == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(blog, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Blog> handleAdd(@RequestBody Blog blog) {
		blog.setId(null);
		Blog newBlog = blogService.save(blog);
		return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Blog> handleUpdate(@RequestBody Blog blog, @PathVariable String id) {
		Blog newBlog = blogService.save(blog, id);
		if (newBlog == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(newBlog, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Blog> handleDelete(@PathVariable String id) {
		Blog oldBlog = blogService.delete(id);
		if (oldBlog == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldBlog, HttpStatus.OK);
	}
	
}
