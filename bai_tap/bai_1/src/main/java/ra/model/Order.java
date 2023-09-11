package ra.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
	private Long id;
	private LocalDateTime localDateTime = LocalDateTime.now();
	private Map<Product, Integer> items = new HashMap<>();
	private double total;
	
	public void copyCart(Map<Product, Integer> cartItems) {
		this.items = new HashMap<>(cartItems);
	}
	
	public void setTotal(Float aFloat) {
	}
}
