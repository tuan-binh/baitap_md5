package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Category;
import ra.model.service.category.ICategoryService;

@Controller
@RequestMapping({"/category"})
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public ModelAndView addNewCategory() {
		return new ModelAndView("category/add", "category", new Category());
	}
	
	@GetMapping("/list")
	public ModelAndView listCategory() {
		return new ModelAndView("category/list","categories",categoryService.findAll());
	}
	
}
