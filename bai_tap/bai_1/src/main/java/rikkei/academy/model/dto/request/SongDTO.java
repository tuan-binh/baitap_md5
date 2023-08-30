package rikkei.academy.model.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class SongDTO {
	private Long id;
	private String name;
	private String author;
	private String genre;
	private MultipartFile url;
	private boolean status;
	
	public SongDTO() {
	}
	
	public SongDTO(Long id, String name, String author, String genre, MultipartFile url, boolean status) {
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
	
	public MultipartFile getUrl() {
		return url;
	}
	
	public void setUrl(MultipartFile url) {
		this.url = url;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
