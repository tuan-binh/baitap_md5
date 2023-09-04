package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
		return new ModelAndView("category/add","category",new Category());
	}
	
	@GetMapping("/list")
	public String listCategory(Model model) {
		model.addAttribute("categories",categoryService.findAll());
		return "category/list";
	}
	
	@PostMapping("/add")
	public String handleAddCategory(@ModelAttribute Category category) {
		categoryService.save(category);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.delete(id);
		return "redirect:/";
	}

}
