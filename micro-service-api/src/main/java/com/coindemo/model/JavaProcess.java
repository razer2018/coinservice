package com.coindemo.model;

import com.coindemo.common.model.PagableEntity;

import lombok.Data;

/**
 * java进程实体
 * @author boli
 *
 */
@Data
public class JavaProcess extends PagableEntity{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;

    private Integer javaProcess;
    
    private String systemCode;
    
    private String isValid;

    private Long createdTime;

    private Long updatedTime;
}
