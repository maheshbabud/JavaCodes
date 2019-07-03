package com.spring.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="LoginDetails")
public class LoginDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="login_id")
	private long loginId;
	
	@NotNull
	@Size(max=20)
	@Column(name="username")
	private String userName;
	
	@NotNull
	@Size(max=15,min=8)
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="user_status")
	private char user_status;
	
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;
	
	@Column(name="updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updated_date;
	
	@Size(max=30)
	@Column(name="system_ip")
	private String systemIp;
	
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	//@JsonIgnore
	@JsonBackReference
	private Users user;

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
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

	public char getUser_status() {
		return user_status;
	}

	public void setUser_status(char user_status) {
		this.user_status = user_status;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getSystemIp() {
		return systemIp;
	}

	public void setSystemIp(String systemIp) {
		this.systemIp = systemIp;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
