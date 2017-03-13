package com.omniwyse.dod.DTO;

import java.io.Serializable;

public class AliseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AliseVO(){
	}
	
	private String aliseId;
	private String aliseName;
	private String xAxis;
	private String yAxis;
	private String floor;

	public String getAliseId() {
		return aliseId;
	}
	public void setAliseId(String aliseId) {
		this.aliseId = aliseId;
	}
	public String getAliseName() {
		return aliseName;
	}
	public void setAliseName(String aliseName) {
		this.aliseName = aliseName;
	}
	public String getxAxis() {
		return xAxis;
	}
	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}
	public String getyAxis() {
		return yAxis;
	}
	public void setyAxis(String yAxis) {
		this.yAxis = yAxis;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	
	
	
	
	
}
