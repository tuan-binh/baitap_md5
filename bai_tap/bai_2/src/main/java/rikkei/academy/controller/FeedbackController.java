package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.dto.FeedbackDTO;
import rikkei.academy.model.service.IFeedbackService;

@Controller
@RequestMapping({"/"})
public class FeedbackController {
	
	@Autowired
	private IFeedbackService feedbackService;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("list", feedbackService.findAll());
		model.addAttribute("form", new FeedbackDTO());
		return "home";
	}
	
	@PostMapping
	public String postNew(@ModelAttribute FeedbackDTO feedbackDTO) {
		feedbackService.save(feedbackDTO);
		return "redirect:/";
	}
	
	@GetMapping("{id}")
	public String like(@PathVariable Long id) {
		feedbackService.like(id);
		return "redirect:/";
	}
	
}
