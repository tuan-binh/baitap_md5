package ra.model.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;
import ra.model.repository.IBlogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
	
	@Autowired
	private IBlogRepository blogRepository;
	
	@Override
	public List<Blog> findAll() {
		return blogRepository.findAll();
	}
	
	@Override
	public Blog findById(Long id) {
		Optional<Blog> optionalBlog = blogRepository.findById(id);
		return optionalBlog.orElse(null);
	}
	
	@Override
	public Blog save(Blog blog) {
		return blogRepository.save(blog);
	}
	
	@Override
	public Blog delete(Long id) {
		if (findById(id) == null) {
			return null;
		}
		Blog blog = findById(id);
		blogRepository.deleteById(id);
		return blog;
	}
	
	@Override
	public Blog findById(String id) {
		Blog blog = null;
		try {
			Long idFind = Long.valueOf(id);
			blog = findById(idFind);
		} catch (Exception e) {
			return null;
		}
		return blog;
	}
	
	@Override
	public Blog save(Blog product, String id) {
		Blog blog = null;
		try {
			Long idFind = Long.valueOf(id);
			blog = findById(idFind);
		} catch (Exception e) {
			return null;
		}
		blogRepository.save(blog);
		return blog;
	}
	
	@Override
	public Blog delete(String id) {
		Blog blog = null;
		try {
			Long idFind = Long.valueOf(id);
			blog = findById(idFind);
			blogRepository.deleteById(idFind);
		} catch (Exception e) {
			return null;
		}
		return blog;
	}
}
