package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "status")
	private Integer status;
	
	
	@ManyToMany
	@JoinTable(name = "user_role",
	        	joinColumns = @JoinColumn(name = "user_id"),
	        	inverseJoinColumns = @JoinColumn(name = "role_id")
	    )
	private List<RoleEntity> roles = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<NewEntity> news = new ArrayList<>();
	
	
	
	public List<RoleEntity> getRoles() {
		return roles;
	}
	
	public List<NewEntity> getNews() {
		return news;
	}
	public void setNews(List<NewEntity> news) {
		this.news = news;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}