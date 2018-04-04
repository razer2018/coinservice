package com.coindemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coindemo.common.model.ResponseData;
import com.coindemo.common.utils.ResponseUtil;
import com.coindemo.model.Coins;
import com.coindemo.service.CoinsService;
import com.coindemo.vo.CoinVo;

@RestController
@RequestMapping("/api/coin")
public class CoinsController {

	@Autowired
	private CoinsService coinsService;

	private Logger logger = LoggerFactory.getLogger(CoinsController.class);

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseData<Coins> getCoin(@PathVariable("id") Long id) {
		Coins coins = coinsService.queryByUserId(id);
		return ResponseUtil.wrapData(coins);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<Coins> addCoin(@RequestBody Coins params) {
		if (StringUtils.isEmpty(params.getUserId())) {
			return ResponseUtil.wrapError("用户id不能为空");
		}
		if (StringUtils.isEmpty(params.getCoins()) && params.getCoins() == 0) {
			return ResponseUtil.wrapError("金币不能为空和0");
		}
		Coins addCoin = coinsService.addCoin(params);
		if (!StringUtils.isEmpty(addCoin.getMessage())) {
			logger.error(addCoin.getMessage());
			return ResponseUtil.wrapError(addCoin.getMessage());
		}
		return ResponseUtil.wrapData(addCoin);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseData<Coins> deleteCoin(@PathVariable("id") Long id) {
		if (StringUtils.isEmpty(id)) {
			return ResponseUtil.wrapError("用户id不能为空");
		}
		Coins addCoin = coinsService.deleteCoin(id);
		return ResponseUtil.wrapData(addCoin);
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<Coins> transfer(@RequestBody CoinVo params) {
		if (StringUtils.isEmpty(params.getFromUserId())) {
			return ResponseUtil.wrapError("转账用户id不能为空");
		}
		if (StringUtils.isEmpty(params.getToUserId())) {
			return ResponseUtil.wrapError("收款用户id不能为空");
		}
		if (StringUtils.isEmpty(params.getCoins()) && params.getCoins() == 0) {
			return ResponseUtil.wrapError("金币不能为空和0");
		}
		Coins transferCoin = coinsService.transfer(params);
		if (!StringUtils.isEmpty(transferCoin.getMessage())) {
			logger.error(transferCoin.getMessage());
			return ResponseUtil.wrapError(transferCoin.getMessage());
		}
		return ResponseUtil.wrapData(transferCoin);
	}
}
