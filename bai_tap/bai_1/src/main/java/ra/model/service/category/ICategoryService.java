package ra.model.service.category;

import ra.model.entity.Category;
import ra.model.service.IGenericService;

public interface ICategoryService extends IGenericService<Category, Long> {
	Category findById(String id);
	
	Category save(Category product, String id);
	
	Category delete(String id);
}
