package ra.model.service.blog;

import ra.model.entity.Blog;

import java.util.List;

public interface IBlogService {
	List<Blog> findAll();
	Blog findById(Long id);
	void save(Blog blog);
	void delete(Long id);
}
