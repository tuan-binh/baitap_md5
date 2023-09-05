package ra.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Blog> blogs = new ArrayList<>();
	
	public Category() {
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
