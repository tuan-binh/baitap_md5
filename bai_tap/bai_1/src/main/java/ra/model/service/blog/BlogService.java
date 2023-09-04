package ra.model.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;
import ra.model.repository.IBlogRepository;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
	
	@Autowired
	private IBlogRepository blogRepository;
	
	
	@Override
	public Iterable<Blog> findAll() {
		return blogRepository.findAll();
	}
	
	@Override
	public Optional<Blog> findById(Long id) {
		return blogRepository.findById(id);
	}
	
	@Override
	public void save(Blog blog) {
		blogRepository.save(blog);
	}
	
	@Override
	public void delete(Long id) {
		blogRepository.deleteById(id);
	}
	
	@Override
	public Page<Blog> findAll(Pageable pageable) {
		return blogRepository.findAll((org.springframework.data.domain.Pageable) pageable);
	}
	
	@Override
	public Page<Blog> findAllTitleContaining(String title, Pageable pageable) {
		return blogRepository.findAllByTitleContaining(title, (org.springframework.data.domain.Pageable) pageable);
	}
}
