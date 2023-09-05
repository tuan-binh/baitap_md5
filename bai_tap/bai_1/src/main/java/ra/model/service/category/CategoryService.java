package ra.model.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Service;
import ra.model.entity.Category;
import ra.model.formatter.CategoryFormatter;
import ra.model.repository.ICategoryRepository;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.LogRecord;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	@Override
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		return optionalCategory.orElse(null);
	}
	
	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
	
	@Override
	public Page<Category> findAll(int page, int size) {
		return categoryRepository.findAll(PageRequest.of(page,size));
	}
	
}
