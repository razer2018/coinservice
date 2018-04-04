package com.coindemo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coindemo.common.dao.BaseDao;
import com.coindemo.common.service.impl.BaseServiceImpl;
import com.coindemo.controller.CoinsController;
import com.coindemo.dao.JavaProcessDao;
import com.coindemo.model.JavaProcess;
import com.coindemo.service.JavaProcessService;

@Service
public class JavaProcessServiceImpl extends BaseServiceImpl<JavaProcess> implements JavaProcessService {

	@Autowired
	private JavaProcessDao javaProcessDao;

	private static final String SYS_CODE = "coins";

	private static final String JAVA_CMD = "jstack";

	private Logger logger = LoggerFactory.getLogger(JavaProcessServiceImpl.class);

	@Override
	protected BaseDao<JavaProcess, Long> getBaseDao() {
		return javaProcessDao;
	}

	@Override
	public JavaProcess getPid(String sysCode) {
		JavaProcess javaProcess = new JavaProcess();
		javaProcess.setSystemCode(sysCode);
		JavaProcess selectOne = javaProcessDao.selectOne(javaProcess);
		return selectOne;
	}

	// 在系统启动时就添加该系统的进程id
	@Override
	@PostConstruct
	@Transactional(rollbackFor = Exception.class)
	public JavaProcess addPid() {
		// 根据当前定义的系统编码先查询该系统的pid是否已经存在，若存在则更新
		JavaProcess jProcess = this.getPid(SYS_CODE);
		int processID = getProcessID();
		if (jProcess == null) {
			jProcess = new JavaProcess();
			jProcess.setSystemCode(SYS_CODE);
			jProcess.setJavaProcess(processID);
			javaProcessDao.insert(jProcess);
		} else {
			jProcess.setJavaProcess(processID);
			javaProcessDao.updateByIdSelective(jProcess);
		}
		return jProcess;
	}

	private int getProcessID() {
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		System.out.println(runtimeMXBean.getName());
		return Integer.valueOf(runtimeMXBean.getName().split("@")[0]).intValue();
	}

	@Override
	public String getjstack() {
		JavaProcess jProcess = this.getPid(SYS_CODE);
		String executeLinuxCmd = executeLinuxCmd(jProcess.getJavaProcess().toString());
		return executeLinuxCmd;
	}

	private String executeLinuxCmd(String cmd) {
		String result = null;
		try {
			cmd = JAVA_CMD + " " + cmd;
			// String[] cmd = new String[] { "/bin/sh", "-c", "ls -l" };
			Process ps = Runtime.getRuntime().exec(cmd);

			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			 result = sb.toString();
			logger.info(result);


		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return result;

	}
}
