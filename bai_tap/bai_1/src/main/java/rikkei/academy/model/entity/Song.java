package rikkei.academy.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String author;
	private String genre;
	private String url;
	private boolean status;
	
	public Song() {
	
	}
	
	public Song(Long id, String name, String author, String genre, String url, boolean status) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.url = url;
		this.status = status;
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
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void copy(Song s) {
		this.id = s.getId();
		this.name = s.getName();
		this.author = s.getAuthor();
		this.genre = s.getGenre();
		this.url = s.getUrl();
		this.status = s.isStatus();
	}
	
}
