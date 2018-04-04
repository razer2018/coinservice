package com.coindemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coindemo.common.dao.BaseDao;
import com.coindemo.common.service.impl.BaseServiceImpl;
import com.coindemo.dao.CoinsDao;
import com.coindemo.model.Coins;
import com.coindemo.service.CoinsService;
import com.coindemo.vo.CoinVo;

@Service
public class CoinsServiceImpl extends BaseServiceImpl<Coins> implements CoinsService {

	@Autowired
	private CoinsDao coinsDao;

	@Override
	protected BaseDao<Coins, Long> getBaseDao() {
		return coinsDao;
	}

	@Override
	public Coins queryByUserId(Long userId) {
		Coins coins = new Coins();
		coins.setUserId(userId);
		Coins queryCoin = coinsDao.selectOne(coins);
		return queryCoin;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Coins addCoin(Coins params) {
		Coins queryByUserId = this.queryByUserId(params.getUserId());
		if (queryByUserId != null) {
			//增加乐观锁version为防止数据的高并发操作而带来的问题
			//可参考视情况额定
//			if (params.getVersion() == null) {
//				params.setMessage("数据版本不能为空");
//				return params;
//			} else if (params.getVersion().equals(queryByUserId.getVersion())) {
//				params.setId(queryByUserId.getId());
//				coinsDao.updateByIdSelective(queryByUserId);
//			} else {
//				params.setMessage("请刷新数据后重新再试");
//				return params;
//			}
			params.setId(queryByUserId.getId());
			coinsDao.updateByIdSelective(queryByUserId);
		} else {
			coinsDao.insert(params);
		}
		return params;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Coins deleteCoin(Long userId) {
		Coins queryByUserId = this.queryByUserId(userId);
		coinsDao.deleteById(queryByUserId.getId());
		return queryByUserId;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Coins transfer(CoinVo params) {
		// 查询出转账用户的账户
		Coins fromAccount = this.queryByUserId(params.getFromUserId());
		if (fromAccount.getCoins() < params.getCoins()) {
			params.setMessage("用户余额少于转账金额，请确认后再试");
			return params;
		}
		// 查询出收款用户的账户
		Coins toAccount = this.queryByUserId(params.getToUserId());
		fromAccount.setCoins(fromAccount.getCoins() - params.getCoins());
		toAccount.setCoins(toAccount.getCoins() + params.getCoins());
		// 饭别更新各用户账户的金币
		coinsDao.updateByIdSelective(fromAccount);
		coinsDao.updateByIdSelective(toAccount);
		return params;
	}

}
