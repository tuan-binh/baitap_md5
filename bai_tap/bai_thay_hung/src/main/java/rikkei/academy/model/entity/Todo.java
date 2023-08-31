package rikkei.academy.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	private boolean status = false;
	
	public Todo() {
	}
	
	public Todo(Long id, String content, boolean status) {
		this.id = id;
		this.content = content;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
