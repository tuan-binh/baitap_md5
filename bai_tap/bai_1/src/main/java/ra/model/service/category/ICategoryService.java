package ra.model.service.category;

import org.springframework.data.domain.Page;
import ra.model.entity.Category;
import ra.model.service.IGenericService;

public interface ICategoryService extends IGenericService<Category,Long> {
	Page<Category> findAll(int page, int size);
}
