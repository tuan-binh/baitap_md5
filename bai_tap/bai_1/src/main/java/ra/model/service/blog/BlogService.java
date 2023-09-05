package ra.model.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;
import ra.model.repository.IBlogRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
	
	@Autowired
	private IBlogRepository blogRepository;
	
	
	@Override
	public List<Blog> findAll() {
		return (List<Blog>) blogRepository.findAll();
	}
	
	@Override
	public Blog findById(Long id) {
		Optional<Blog> optionalBlog = blogRepository.findById(id);
		return optionalBlog.orElse(null);
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
	public Page<Blog> findAll(int page, int size) {
		return blogRepository.findAll(PageRequest.of(page,size));
	}
}
