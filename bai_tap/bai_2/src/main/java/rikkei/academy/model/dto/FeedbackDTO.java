package rikkei.academy.model.dto;

import java.util.Date;

public class FeedbackDTO {
	private Long id;
	private int rate;
	private String author;
	private String content;
	private Date createDate = new Date(System.currentTimeMillis());
	private int like;
	
	public FeedbackDTO() {
	}
	
	public FeedbackDTO(Long id, int rate, String author, String content, Date createDate, int like) {
		this.id = id;
		this.rate = rate;
		this.author = author;
		this.content = content;
		this.createDate = createDate;
		this.like = like;
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
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getLike() {
		return like;
	}
	
	public void setLike(int like) {
		this.like = like;
	}
}
