package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Blog;
import ra.model.service.blog.BlogService;
import ra.model.service.blog.IBlogService;

@Controller
@RequestMapping({"/"})
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("blogs", blogService.findAll());
		return "home";
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("add", "blog", new Blog());
	}
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("blog", blogService.findById(id));
		return "view";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		return new ModelAndView("edit", "blog", blogService.findById(id));
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		blogService.delete(id);
		return "redirect:/";
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute Blog blog) {
		blogService.save(blog);
		return "redirect:/";
	}
	
	@PostMapping("/edit")
	public String handleEdit(@ModelAttribute Blog blog) {
		blogService.save(blog);
		return "redirect:/";
	}
	
}
