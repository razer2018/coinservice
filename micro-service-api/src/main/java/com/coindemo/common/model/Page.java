package com.coindemo.common.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long total;
	private Pageable pageable;
	private List<T> content;
	
	public Page(){
		super();
	}

	public Page(List<T> content, Long total) {
		super();
		this.total = total;
		this.content = content;
	}
	
	public Page(List<T> content, Pageable pageable, Long total) {
		super();
		this.total = total;
		this.pageable = pageable;
		this.content = content;
	}


}
