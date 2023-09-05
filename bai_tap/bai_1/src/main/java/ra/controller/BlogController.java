package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Blog;
import ra.model.service.blog.IBlogService;
import ra.model.service.category.ICategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/", "blog"})
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public String blogs(Model model,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "2") int size) {
		model.addAttribute("blogs",blogService.findAll(page,size));
		int n = blogService.findAll().size() / size + ((blogService.findAll().size() % size == 0) ? 0 : 1);
		List<Integer> pages = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			pages.add(i+1);
		}
		model.addAttribute("pages",pages);
		return "blog/blogs";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("blog",new Blog());
		model.addAttribute("categories",categoryService.findAll());
		return "blog/add";
	}
	
	@PostMapping("add")
	public String handleAdd(@ModelAttribute Blog blog) {
		blogService.save(blog);
		return "redirect:/";
	}
	
	@GetMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable Long id) {
		return new ModelAndView("blog/detail","blog",blogService.findById(id));
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id,Model model) {
		model.addAttribute("categories",categoryService.findAll());
		return new ModelAndView("blog/edit","blog",blogService.findById(id));
	}
	
	@PostMapping("/edit")
	public String handleEdit(@ModelAttribute Blog blog) {
		blogService.save(blog);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		blogService.delete(id);
		return "redirect:/";
	}
	
}
