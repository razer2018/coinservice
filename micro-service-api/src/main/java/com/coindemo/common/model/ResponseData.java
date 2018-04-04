package com.coindemo.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * 提供给web、移动端的响应数据结构
 * 
 * @author boli
 *
 * @param <T>
 */
public class ResponseData<T extends Object> implements Serializable{
	
	
	private int code;
	private String message;
	/**
	 * 非分页的对象集合
	 */
	private List<T> data;
	
	
	public ResponseData() {
		super();
	}
	public ResponseData(int code,List<T> data, String message) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

	
	
	
	
}
