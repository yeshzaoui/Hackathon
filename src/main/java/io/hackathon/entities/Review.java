package io.hackathon.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private int rating;
	
	@Column(nullable = false)
	private Date createdIn;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reviewer_id")
	private Profile reviewer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reviewing_id")
	private Profile reviewing;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getCreatedIn() {
		return createdIn;
	}
	public void setCreatedIn(Date createdIn) {
		this.createdIn = createdIn;
	}
	public Profile getReviewer() {
		return reviewer;
	}
	public void setReviewer(Profile reviewer) {
		this.reviewer = reviewer;
	}
	public Profile getReviewing() {
		return reviewing;
	}
	public void setReviewing(Profile reviewing) {
		this.reviewing = reviewing;
	}
	
}
