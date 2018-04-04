package com.coindemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coindemo.unifiedexception.UnifiedExceptionHandler;

/**
 * 统一异常处理
 * @author boli
 *
 */
@Configuration
public class ExceptionResolverConfig {
	
	@Bean("exceptionResolver")
	public UnifiedExceptionHandler getUnifiedExceptionHandler(){
		return new UnifiedExceptionHandler();
	}
	
	
}

