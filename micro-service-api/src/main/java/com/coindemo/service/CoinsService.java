package com.coindemo.service;

import com.coindemo.common.service.BaseService;
import com.coindemo.model.Coins;
import com.coindemo.vo.CoinVo;

public interface CoinsService extends BaseService<Coins> {

	/**
	 * 根据用户id查询当前用户的账户金币信息
	 * @param userId
	 * @return
	 */
	public Coins queryByUserId(Long userId);

	/**
	 * 为当前用户账户下添加金币，若已存在则更新
	 * @param params
	 * @return
	 */
	public Coins addCoin(Coins params);
	
	/**
	 * 删除当前用户下的金币
	 * @param userId
	 * @return
	 */
	public Coins deleteCoin(Long userId);
	
	/**
	 * 实现用户1给用户2转账
	 * @param params
	 * @return
	 */
	public Coins transfer(CoinVo params);
	
	
}
