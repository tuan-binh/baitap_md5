package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Cart;
import ra.model.Product;
import ra.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping({"/"})
@SessionAttributes("cart")
public class ProductController {
	
	private ProductService productService = new ProductService(new ArrayList<>());
	
	@ModelAttribute("cart")
	public Cart setupCart() {
		return new Cart();
	}
	
	@GetMapping("/shop")
	public ModelAndView showShop() {
		ModelAndView modelAndView = new ModelAndView("shop");
		modelAndView.addObject("products", productService.findAll());
		return modelAndView;
	}
	@GetMapping("/detail/{id}")
	public ModelAndView showDetail(@PathVariable Long id){
		return new ModelAndView("detail","product",productService.findById(id));
	}
	@GetMapping("/delete/{id}")
	public String deleteInCart(@PathVariable Long id,@ModelAttribute Cart cart){
		Optional<Product> productOptional = Optional.ofNullable(productService.findById(id));
		if (!productOptional.isPresent()) {
			return "404";
		}
		cart.deleteProduct(productOptional.get());
		return "redirect:/shopping-cart";
	}
	@GetMapping("/add/{id}")
	public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
		Optional<Product> productOptional = Optional.ofNullable(productService.findById(id));
		if (!productOptional.isPresent()) {
			return "404";
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
