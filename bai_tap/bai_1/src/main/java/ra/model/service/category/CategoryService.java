package ra.model.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;
import ra.model.entity.Category;
import ra.model.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	@Override
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		return optionalCategory.orElse(null);
	}
	
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	@Override
	public Category delete(Long id) {
		if (findById(id) == null) {
			return null;
		}
		Category category = findById(id);
		categoryRepository.deleteById(id);
		return category;
	}
	
	@Override
	public Category findById(String id) {
		Category category = null;
		try {
			Long idFind = Long.valueOf(id);
			category = findById(idFind);
		} catch (Exception e) {
			return null;
		}
		return category;
	}
	
	@Override
	public Category save(Category product, String id) {
		Category category = null;
		try {
			Long idFind = Long.valueOf(id);
			category = findById(idFind);
		} catch (Exception e) {
			return null;
		}
		categoryRepository.save(category);
		return category;
	}
	
	@Override
	public Category delete(String id) {
		Category category = null;
		try {
			Long idFind = Long.valueOf(id);
			category = findById(idFind);
			categoryRepository.deleteById(idFind);
		} catch (Exception e) {
			return null;
		}
		return category;
	}
}
