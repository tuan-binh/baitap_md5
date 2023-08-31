package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.entity.Todo;
import rikkei.academy.model.service.todo.ITodoService;

@Controller
@RequestMapping({"/"})
public class TodoController {
	
	@Autowired
	private ITodoService todoService;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("list", todoService.findAll());
		model.addAttribute("todoAdd",new Todo());
		return "home";
	}
	
//	@GetMapping("/add")
//	public ModelAndView add() {
//		return new ModelAndView("add", "todo", new Todo());
//	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id,Model model) {
		model.addAttribute("list", todoService.findAll());
		return new ModelAndView("home", "todoEdit", todoService.findById(id));
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		todoService.delete(id);
		return "redirect:/";
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute Todo todo) {
		todoService.save(todo);
		return "redirect:/";
	}
	
	@PostMapping("/edit")
	public String handleEdit(@ModelAttribute Todo todo) {
		todoService.save(todo);
		return "redirect:/";
	}
	
}
