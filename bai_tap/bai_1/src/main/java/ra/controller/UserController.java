package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.dto.request.LoginDTO;
import ra.model.dto.request.RegisterDTO;
import ra.model.entity.User;
import ra.model.service.user.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping
	public ModelAndView login() {
		return new ModelAndView("login", "user", new LoginDTO());
	}
	
	@GetMapping("/sign_up")
	public ModelAndView register() {
		return new ModelAndView("register", "user", new RegisterDTO());
	}
	
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute LoginDTO user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasFieldErrors()) {
			return "login";
		}
		User dataLogin = login(user);
		model.addAttribute("data", dataLogin);
		return "home";
	}
	
	@PostMapping("/register")
	public String handleRegister(@ModelAttribute RegisterDTO user, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "register";
		}
		User newUser = new User(null, user.getFullName(), user.getUsername(), user.getPassword(), true);
		userService.save(newUser);
		return "redirect:/";
	}
	
	public User login(LoginDTO loginDTO) {
		for (User u : userService.findAll()) {
			if (u.getUsername().equals(loginDTO.getUsername()) && u.getPassword().equals(loginDTO.getPassword())) {
				return u;
			}
		}
		return null;
	}
	
}
