package com.coindemo.common.model;

import java.io.Serializable;

import lombok.Data;
/**
 * 该类用于存储请求相关的关键数据
 */
@Data
public class Header implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Long userId;
	private String loginName;
	private Object attachment;


	
}
