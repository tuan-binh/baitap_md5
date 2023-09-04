package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Blog;
import ra.model.entity.Category;
import ra.model.service.blog.IBlogService;
import ra.model.service.category.ICategoryService;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping({"/", "blog"})
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public ModelAndView listBlog(Pageable pageable) {
		Page<Blog> blogs = blogService.findAll(pageable);
		return new ModelAndView("blog/blogs", "blogs", blogs);
	}
	
	@GetMapping("/addNewBlog")
	public String addNewBlog(Model model) {
		List<Category> categories = (List<Category>) categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("blog", new Blog());
		return "blog/add";
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute Blog blog) {
		blogService.save(blog);
		return "redirect:/";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		Blog blog = null;
		if (blogService.findById(id).isPresent()) {
			blog = blogService.findById(id).get();
		}
		model.addAttribute("blog", blog);
		return "blog/detail";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		return new ModelAndView("blog/edit", "blog", blogService.findById(id).get());
	}
	
	@PostMapping("/edit")
	public String handleEdit(@ModelAttribute Blog blog) {
		blogService.save(blog);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBlog(@PathVariable Long id) {
		blogService.delete(id);
		return "redirect:/";
	}
	
}
