package com.omniwyse.dod.bean;

import java.util.List;

public class DataResultlist<T> {
	public boolean success = false;
	public String message = "";
	public int statusCode = 400;	
	public List<T> data;
	
	public DataResultlist(boolean successful, String message, int statusCode, List<T> data) {
		this.success = successful;
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	
}
