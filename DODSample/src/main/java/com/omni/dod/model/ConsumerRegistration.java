package com.omni.dod.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "user_table")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ConsumerRegistration {
	/*
	 * @Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private double otp;

	*//**
	 * @return the id
	 *//*
	public Integer getId() {
		return id;
	}

	*//**
	 * @param id
	 *            the id to set
	 *//*
	public void setId(Integer id) {
		this.id = id;
	}

	*//**
	 * @return the firstName
	 *//*
	public String getFirstName() {
		return firstName;
	}

	*//**
	 * @param firstName
	 *            the firstName to set
	 *//*
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	*//**
	 * @return the lastName
	 *//*
	public String getLastName() {
		return lastName;
	}

	*//**
	 * @param lastName
	 *            the lastName to set
	 *//*
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	*//**
	 * @return the username
	 *//*
	public String getUsername() {
		return username;
	}

	*//**
	 * @param username
	 *            the username to set
	 *//*
	public void setUsername(String username) {
		this.username = username;
	}

	public double getOtp() {
		return otp;
	}

	public void setOtp(double otp) {
		this.otp = otp;
	}

	
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {
		return "ConsumerRegistration [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + "]";
	}*/	
	//below are the fields i need to insert into table name : user_table
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column(name = "USER_TYPE")
	private String user_type;
	@Column(name = "EMAIL_ID")
	private String email_id;
	@Column(name = "PHONE_NO")
	private String phone_no;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "DATE")
	private Date createddate;
	
	
	
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
