package com.coindemo.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.coindemo.common.model.Page;
import com.coindemo.common.model.ResponseData;
import com.coindemo.common.model.ResponsePageData;


public class ResponseUtil{
	
	public static ResponseData wrapData(Object obj){
		List data = new ArrayList();
		data.add(obj);
		return new ResponseData(0,data,null);	
	}
	
	public static ResponseData wrapList(List data){
		return new ResponseData(0,data,null);	
	}
	
	public static ResponsePageData wrapPageData(Page page){
		Pageable pageable = page.getPageable();
		return new ResponsePageData(0,page.getContent(),null,
				pageable.getPageNumber(), pageable.getPageSize(), 
				page.getTotal());	
	}
	
	public static ResponseData wrapMessage(String message){
		return new ResponseData(0,null,message);
	}
	public static ResponseData wrapError(String message){
		return new ResponseData(1,null,message);
	}

	public static ResponseData wrapError(int errorCode,String message){
		return new ResponseData(errorCode,null,message);
	}
	
	public static ResponsePageData wrapPageError(String message){
		return new ResponsePageData(1,null,message, 0, 0, 0);
	}
	public static ResponsePageData wrapPageError(int errorCode,String message){
		return new ResponsePageData(errorCode,null,message, 0, 0, 0);
	}
	
	

}
