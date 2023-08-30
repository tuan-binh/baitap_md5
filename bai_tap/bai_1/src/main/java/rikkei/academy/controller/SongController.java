package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.dto.request.SongDTO;
import rikkei.academy.model.service.song.SongService;

@Controller
@RequestMapping({"/"})
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@GetMapping
	public ModelAndView home() {
		return new ModelAndView("home", "sounds", songService.findAll());
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("add", "sound", new SongDTO());
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute SongDTO sound) {
		songService.save(sound);
		return "redirect:/";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		return new ModelAndView("edit", "sound", songService.findById(id));
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute SongDTO sound) {
		songService.save(sound);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		songService.delete(id);
		return "redirect:/";
	}
	
}
