package ra.service;

import ra.model.Product;

import java.util.List;
import java.util.Objects;

public class ProductService {
	
	private List<Product> list;
	
	public ProductService(List<Product> list) {
		this.list = list;
		list.add(new Product(1L,"quần đùi",1200,true));
		list.add(new Product(2L,"Áo Dài",1200,true));
		list.add(new Product(3L,"Mũ Cối",9999,true));
	}
	
	public List<Product> findAll() {
		return list;
	}
	
	public Product findById(Long id) {
		for (Product p : list) {
			if (Objects.equals(p.getId(), id)) {
				return p;
			}
		}
		return null;
	}
	
	public Product save(Product product) {
		if (findById(product.getId()) == null) {
			list.add(product);
		} else {
			list.set(list.indexOf(findById(product.getId())), product);
		}
		return product;
	}
	
	public Product delete(Long id) {
		Product product = findById(id);
		if (product != null) {
			list.remove(product);
			return product;
		}
		return null;
	}
	
	
}
