package ra.model.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import ra.model.entity.Category;
import ra.model.service.category.CategoryService;
import ra.model.service.category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryFormatter implements Formatter<Category> {
	
	private ICategoryService categoryService;
	
	public CategoryFormatter(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public Category parse(String text, Locale locale) throws ParseException {
		return categoryService.findById(Long.parseLong(text));
	}
	
	@Override
	public String print(Category object, Locale locale) {
		return null;
	}
}
