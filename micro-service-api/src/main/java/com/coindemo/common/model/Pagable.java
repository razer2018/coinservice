package com.coindemo.common.model;

public interface Pagable {

	public void setPageSize(Integer pageSize);

	public Integer getPageSize();

	public void setPageNumber(Integer pageNumber);

	public Integer getPageNumber();

	public void setDirection(String direction);

	public String getDirection();

	public void setProperty(String property);

	public String getProperty();

}
