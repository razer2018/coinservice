package com.coindemo.service;

import com.coindemo.common.service.BaseService;
import com.coindemo.model.JavaProcess;

public interface JavaProcessService extends BaseService<JavaProcess> {
	
	/**
	 * 获取指定系统的java进程id
	 * @param systemCode
	 * @return
	 */
	public JavaProcess getPid(String sysCode);
	
	/**
	 * 添加指定系统的java进程id
	 * @param systemCode
	 * @return
	 */
	public JavaProcess addPid();
	
	/**
	 * 获取当前java进程的jstack
	 * @param systemCode
	 * @return
	 */
	public String getjstack();

}
