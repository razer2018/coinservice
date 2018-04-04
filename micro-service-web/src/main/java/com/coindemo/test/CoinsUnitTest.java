package com.coindemo.test;

//import static org.junit.Assert.*;
//
//import javax.ws.rs.core.Application;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import com.coindemo.common.model.ResponseData;
//
///**
// * 单元测试类
// * 
// * @author boli
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
//public class CoinsUnitTest {
//
//	private static final Logger logger = LoggerFactory.getLogger(CoinsUnitTest.class);
//
//	private TestRestTemplate template = new TestRestTemplate();
//	private int port = 10120;
//
//
//	//获取指定用户金币测试
//	@Test
//	public void test1() {
//		String url = "http://localhost:" + port + "/micro/api/coin/get/1";
//		ResponseData result = template.getForObject(url, ResponseData.class);
//		logger.info(result.getData().toString());
//		assertNotNull(result);
//	}
//
//	//添加指定用户金币
//	@Test
//	public void test2() {
//	    String url = "http://localhost:"+port+"/micro/api/coin/add";
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>(); 
//        map.add("userId", "7");
//		map.add("coins", "100");
//		ResponseData result = template.postForObject(url, map, ResponseData.class);
//        assertNotNull(result);
//	}
//
//	//删除指定用户金币记录
//	@Test
//	public void test3() throws Exception {
//		String url = "http://localhost:" + port + "/micro/api/coin/delete/2";
//		ResponseData result = template.getForObject(url, ResponseData.class);
//		logger.info(result.getData().toString());
//		assertNotNull(result);
//	}
//	
//	//用户金币转账测试
//	@Test
//	public void test4() {
//	    String url = "http://localhost:"+port+"/micro/api/coin/transfer";
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>(); 
//        map.add("fromUserId", "3");
//		map.add("toUserId", "2");
//		map.add("coins", "20");
//		ResponseData result = template.postForObject(url, map, ResponseData.class);
//        assertNotNull(result);
//	}
//
//}
