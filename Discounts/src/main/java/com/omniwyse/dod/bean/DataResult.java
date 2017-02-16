package com.omniwyse.dod.bean;

public class DataResult {
	public boolean success = false;
	public String message = "";
	public int statusCode = 400;	

	public DataResult(boolean success, String message, int statusCode) {
		this.success = success;
		this.message = message;
		this.statusCode = statusCode;
	}	
}
