package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.entity.Customer;
import rikkei.academy.model.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("listCustomer", customerService.findAll());
		return "home";
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("add", "customer", new Customer());
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable Long id) {
		return new ModelAndView("details", "customer", customerService.findById(id));
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		return new ModelAndView("edit", "customer", customerService.findById(id));
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		customerService.delete(id);
		return "redirect:/";
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute Customer customer) {
		customerService.save(customer);
		return "redirect:/";
	}
	
	@PostMapping("/edit")
	public String handleEdit(@ModelAttribute Customer customer) {
		customerService.save(customer);
		return "redirect:/";
	}
	
}
