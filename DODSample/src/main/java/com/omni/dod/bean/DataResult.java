package com.omni.dod.bean;

public class DataResult<T> {
	public boolean successful = false;
	public String message = "";
	public int statusCode = 400;
	/*public T entity;
	public List<T> entities;*/

	public DataResult(boolean successful, String message, int statusCode) {
		this.successful = successful;
		this.message = message;
		this.statusCode = statusCode;
	}

	/*public DataResult(boolean successful, String message, int statusCode, List<T> entities) {
		this.successful = successful;
		this.message = message;
		this.statusCode = statusCode;
		this.entities = entities;
	}
	public DataResult(boolean successful, String message, int statusCode, T entity) {
		this.successful = successful;
		this.message = message;
		this.statusCode = statusCode;
		this.entity = entity;
	}*/
}
