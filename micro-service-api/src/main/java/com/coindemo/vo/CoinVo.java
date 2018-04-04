package com.coindemo.vo;

import com.coindemo.model.Coins;

import lombok.Data;

@Data
public class CoinVo extends Coins{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fromUserId;
	
	private Long toUserId;

	
}
