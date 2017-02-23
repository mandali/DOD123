package com.omniwyse.dod.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Category implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
	@Column(name = "CAT_NAME")
    private String categoryName;	
	@Column(name = "CAT_CREATED")
	private Timestamp createddate;
	
	public Category(){
		
	}
	
	

	public Category(Long categoryId, String categoryName, Timestamp createddate) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createddate = createddate;
	}
	
	



	public Category(Long categoryId) {
		this.categoryId = categoryId;
	}



	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}


}
