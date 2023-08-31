package ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int rate;
	private String author;
	private String content;
	private String url;
	private int likes;
	
	public Feedback() {
	}
	
	public Feedback(Long id, int rate, String author, String content, String url, int like) {
		this.id = id;
		this.rate = rate;
		this.author = author;
		this.content = content;
		this.url = url;
		this.likes = like;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getLike() {
		return likes;
	}
	
	public void setLike(int like) {
		this.likes = like;
	}
}
