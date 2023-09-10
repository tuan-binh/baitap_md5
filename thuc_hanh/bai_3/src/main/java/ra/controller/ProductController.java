package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Cart;
import ra.model.entity.Product;
import ra.model.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@ModelAttribute("cart")
	public Cart setupCart() {
		return new Cart();
	}
	
	@GetMapping("/shop")
	public ModelAndView showShop() {
		ModelAndView modelAndView = new ModelAndView("/shop");
		modelAndView.addObject("products", productService.findAll());
		return modelAndView;
	}
	
	@GetMapping("/add/{id}")
	public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
		Optional<Product> productOptional = productService.findById(id);
		if (!productOptional.isPresent()) {
			return "/error.404";
		}
		if (action.equals("increase")) {
			cart.addProduct(productOptional.get());
			return "redirect:/shopping-cart";
		} else if (action.equals("decrease")) {
			cart.removeProduct(productOptional.get());
			return "redirect:/shopping-cart";
		}
		
		cart.addProduct(productOptional.get());
		return "redirect:/shop";
	}
	
}
