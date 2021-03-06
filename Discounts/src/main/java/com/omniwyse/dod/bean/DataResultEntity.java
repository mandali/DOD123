package com.omniwyse.dod.bean;

public class DataResultEntity<T> {
	public boolean success = false;
	public String message = "";
	public int statusCode = 400;
	public T data;
	
	public DataResultEntity(boolean successful, String message, int statusCode, T data) {
		this.success = successful;
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
}
