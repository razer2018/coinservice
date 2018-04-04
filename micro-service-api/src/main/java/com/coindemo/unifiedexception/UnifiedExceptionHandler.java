package com.coindemo.unifiedexception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.coindemo.common.exception.DaoException;
import com.coindemo.common.model.ResponseData;
import com.coindemo.common.utils.ResponseUtil;

/**
 * 统一异常处理的类
 * Created by boli on 2018/4/3.
 */
public class UnifiedExceptionHandler extends AbstractHandlerExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(UnifiedExceptionHandler.class);

	private int order = 1;

	@Override
	public int getOrder() {
		return this.order;
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ResponseData data = null;
		logger.error(ex.getMessage(), ex);
		if (ex instanceof DaoException) {
			data = ResponseUtil.wrapError("调用数据服务失败，请稍候重试");
		} else {
			data = ResponseUtil.wrapError("服务器处理失败，请稍候重试");
		}
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			response.getOutputStream().write(JSON.toJSONString(data).getBytes("utf-8"));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return new ModelAndView();
	}
}
