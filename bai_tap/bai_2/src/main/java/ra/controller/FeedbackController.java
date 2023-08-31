package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Feedback;
import ra.model.service.feedback.IFeedbackService;

@Controller
@RequestMapping({"/"})
public class FeedbackController {
	
	@Autowired
	private IFeedbackService feedbackService;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("list", feedbackService.findAll());
		model.addAttribute("form", new Feedback());
		return "home";
	}
	
	@PostMapping
	public String postNew(@ModelAttribute Feedback form) {
		feedbackService.save(form);
		return "redirect:/";
	}
	
	@GetMapping("{id}")
	public String like(@PathVariable Long id) {
		feedbackService.like(id);
		return "redirect:/";
	}
	
}
