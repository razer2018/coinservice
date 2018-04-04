package com.coindemo.dao.impl;

import org.springframework.stereotype.Repository;

import com.coindemo.common.dao.impl.BaseDaoImpl;
import com.coindemo.dao.CoinsDao;
import com.coindemo.model.Coins;

@Repository
public class CoinsDaoImpl extends BaseDaoImpl<Coins,Long> implements CoinsDao {

}
