package com.coindemo.common.model;

import java.util.List;

import lombok.Data;

/**
 * 提供给web、移动端的响应数据结构
 * 
 * @author boli
 *
 * @param <T>
 */
@Data
public class ResponsePageData<T extends Object> extends ResponseData<T>{
	/**
	 * 分页的列表数据(T类型的集合)
	 */
	private PageBean page;

	public ResponsePageData(int code, List<T> data, String message, int pageNumber, int pageSize, long total) {
		super(code, data, message);
		this.page = new PageBean(pageNumber, pageSize, total);
	}


	
	

}
@Data
class PageBean{
	private int pageNumber;
	private int pageSize;
	private long total;
	
	public PageBean(int pageNumber, int pageSize, long total) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.total = total;
	}
	

	
	
}
