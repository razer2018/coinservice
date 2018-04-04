package com.coindemo.common.model;

import lombok.Data;

@Data
public class PagableEntity extends BaseEntity implements Pagable {

	private static final long serialVersionUID = 1L;
	protected Integer pageSize;
	protected Integer pageNumber;
	protected String direction;// asc,desc
	protected String property;// 排序的字段名称

	@Override
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize==null?10:pageSize;
	}
}
