package com.omniwyse.dod.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
	@Column(name = "P_DESC")
	private String productDescription;
	
	

}
