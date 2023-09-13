package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "new")
public class NewEntity extends BaseEntity {
	@Column(name  = "title")
	private String title;
	
	@Column(name  = "thumbnail")
	private String thumbnail;
	
	@Column(name  = "shortdescription")
	private String shortDescription;
	
	@Column(name  = "content")
	private String content;


	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
	
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
