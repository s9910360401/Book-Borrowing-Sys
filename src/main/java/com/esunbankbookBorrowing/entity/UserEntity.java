package com.esunbankbookBorrowing.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="User")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private Integer userId;
	
	@Column(name="Phone_Number")
	private String phoneNumber;
	
	@Column(name="Password")	
	private String password;
	
	@Column(name="UserName")		
	private String userName;
	
	@CreationTimestamp
	@Column(name="Registration_Time", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false, insertable = false)
	private Date registrationTime;
	
	@Column(name="Last_Login_Time", columnDefinition = "TIMESTAMP")
	private Timestamp lastLoginTime;
	
	public UserEntity() {
		super();
	}

	public UserEntity(Integer userId, String phoneNumber, String password, String userName, Date registrationTime,
			Timestamp lastloginTime) {
		super();
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userName = userName;
		this.registrationTime = registrationTime;
		this.lastLoginTime = lastloginTime;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}
	public Timestamp getLastloginTime() {
		return lastLoginTime;
	}
	public void setLastloginTime(Timestamp lastloginTime) {
		this.lastLoginTime = lastloginTime;
	}
		
}
