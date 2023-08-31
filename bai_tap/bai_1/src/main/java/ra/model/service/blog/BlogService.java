package ra.model.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;
import ra.model.repository.blog.IBlogRepository;

import java.util.List;

@Service
public class BlogService implements IBlogService{
	
	@Autowired
	private IBlogRepository blogRepository;
	
	@Override
	public List<Blog> findAll() {
		return blogRepository.findAll();
	}
	
	@Override
	public Blog findById(Long id) {
		return blogRepository.findById(id);
	}
	
	@Override
	public void save(Blog blog) {
		blogRepository.save(blog);
	}
	
	@Override
	public void delete(Long id) {
		blogRepository.delete(id);
	}
}
