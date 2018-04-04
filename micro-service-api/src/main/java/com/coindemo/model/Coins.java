package com.coindemo.model;


import com.coindemo.common.model.PagableEntity;

import lombok.Data;

/**
 * 用户金币账户实体
 * @author boli
 *
 */
@Data
public class Coins extends PagableEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Integer coins;

    private Long createUid;

    private Long createdTime;

    private Long updateUid;

    private Long updatedTime;

    private String isValid;

    private Long sortNum;

    private String version;
    
    private String message;
}
