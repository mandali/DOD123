package com.omniwyse.dod.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Category  implements Serializable{
	
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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "category_brand", joinColumns = { @JoinColumn(name = "CAT_ID") }, inverseJoinColumns = { @JoinColumn(name = "BRD_ID") })
	private Set<Brand> brands=new HashSet<Brand>();	
	public Category(){
		
	}
	
	

	public Category(Long categoryId, String categoryName, Timestamp createddate) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createddate = createddate;
	}
	
	
	
	



	public Category(Long categoryId, String categoryName, Timestamp createddate, Set<Brand> brands) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createddate = createddate;
		this.brands = brands;
	}



	public Category(Long categoryId) {
		this.categoryId = categoryId;
	}



	public Long getCategoryId() {
		return categoryId;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
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
