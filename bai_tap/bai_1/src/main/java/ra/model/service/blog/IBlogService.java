package ra.model.service.blog;

import ra.model.entity.Blog;
import ra.model.service.IGenericService;

public interface IBlogService extends IGenericService<Blog, Long> {
	Blog findById(String id);
	Blog save(Blog product,String id);
	
	Blog delete(String id);
}
