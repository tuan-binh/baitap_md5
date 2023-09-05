package ra.model.service.blog;

import org.springframework.data.domain.Page;
import ra.model.entity.Blog;
import ra.model.service.IGenericService;

import java.awt.print.Pageable;
import java.util.List;

public interface IBlogService extends IGenericService<Blog,Long> {
	Page<Blog> findAll(int page,int size);

}
