package com.omni.dod.DTO;

import java.io.Serializable;
import java.util.Date;

public class PromotionDto implements Serializable{
	
	private Integer id;	
	private String product_id;
	private String description;
	private String category_name;
	private String product_image;
	private String originalPrice;
	private String discount;
	private Date createddate;
	private Date startdate;	
	private Date enddate;
	private String location;	
}
