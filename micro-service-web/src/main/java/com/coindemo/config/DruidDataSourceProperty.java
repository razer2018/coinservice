package com.coindemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Configuration
@Data
public class DruidDataSourceProperty {
    // 数据库配置
	@Value("${spring.datasource.druid.url}")
    private String url;

	@Value("${spring.datasource.druid.username}")
    private String username;

	@Value("${spring.datasource.druid.password}")
    private String password;

	@Value("${spring.datasource.druid.driverClassName}")
    private String driverClassName;

    // 初始化大小，最小，最大
	@Value("${spring.datasource.druid.initialSize}")
    private int initialSize = 0;

	@Value("${spring.datasource.druid.minIdle}")
    private int minIdle;

	@Value("${spring.datasource.druid.maxActive}")
    private int maxActive = 8;

    // 配置获取连接等待超时的时间
	@Value("${spring.datasource.druid.maxWait}")
    private int maxWait;

    // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
	@Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis = 1000 * 60;

    // 配置一个连接在池中最小生存的时间，单位是毫秒
	@Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis = 1000 * 60 * 30;

    // 检测连接是否有效的sql
	@Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

	@Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle = false;

	@Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow = true;

	@Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn = false;

    // PSCache Mysql下建议关闭
	@Value("${spring.datasource.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements = false;

	@Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize = - 1;

    // 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
	@Value("${spring.datasource.druid.filters}")
    private String filters;

    // 合并多个DruidDataSource的监控数据
	@Value("${spring.datasource.druid.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat = false;

	@Value("${spring.datasource.druid.connectionProperties}")
    private String connectionProperties;


}