package com.coindemo.dao.impl;

import org.springframework.stereotype.Repository;

import com.coindemo.common.dao.impl.BaseDaoImpl;
import com.coindemo.dao.JavaProcessDao;
import com.coindemo.model.JavaProcess;

@Repository
public class JavaProcessDaoImpl extends BaseDaoImpl<JavaProcess,Long> implements JavaProcessDao{

}
