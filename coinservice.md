# coinservice
金币服务demo

服务说明文档
microService8080工程为Api服务工程
opsService8081工程为ops服务工程
两工程都是基于springboot+mybatis+mysql的技术框架， build工具为gradle

单元测试在microService8080工程下的test目录里，覆盖率统计暂时没实现，平时工作接触的比较少，具体的话可以通过jacoco+sonar来实现

运行：
    1，在micro-service\micro-service-web\src\main\resources\下修改application.properties中的数据库连接字符串；
    2，在mysql数据库中运行coinservice.sql的数据库文件；
    3，在项目根目录coinServiceDemo\microService8080\micro-service下执行gradlew clean build --refresh-dependencies的命令；
    4，在coinServiceDemo\microService8080\micro-service\micro-service-web\build\libs下可找到相应工程的jar包；
    5，在启动文件start.sh中指定的目录下传入工程的jar包，执行start.sh文件即可完成运行，start.sh会停止强制退出当前进程并进行重启。
数据库db说明：
个人用户金币账户表coins
CREATE TABLE `coins` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `coins` int(11) DEFAULT NULL COMMENT '金币',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_uid` bigint(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效',
  `sort_num` bigint(10) DEFAULT NULL COMMENT '排序',
  `version` varchar(10) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

java进程表
CREATE TABLE `java_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `java_process` int(11) DEFAULT NULL COMMENT 'java进程',
  `system_code` varchar(45) DEFAULT NULL COMMENT '系统编码',
  `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效',
  `created_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updated_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


microService8080接口：
1，http://host:8080/api/coin/get/{id}  get请求
   参数--id:用户id,获取指定用户id下的金币
2，http://host:8080/api/coin/add  post请求
   参数--userId:用户id, coins:金币，获取指定用户id下的金币
3，http://host:8080/api/coin/delete/{id}  get请求
   参数--id:用户id,删除指定用户id下的金币记录
4，http://host:8080/api/coin/add  post请求
   参数--fromUserId:转账用户id, toUserId:收款用户id, coins:金币，获取指定用户id下的金币

opsService8081接口：
1，http://host:8081/ops/jstack  get请求
   返回响应指定系统进程下的java jstack信息

业务说明：
microService8080服务
1，在microService8080服务启动时采用@PostConstruct注解，定义addPid()方法获取当前java工程的进程id，指定系统编码system_code,如"coins",并存入java_process表，若已存在记录则直接更新；
2，通过microService8080接口地址实现用户的金币查询、添加以及用户金币转账的功能。

opsService8081服务
在opsService8081服务中可以通过http://host:8081/ops/jstack接口地址返回microService8080服务响应进程id下的java jstack信息，具体通过从java_process表中获取最新的服务进程id（当前的），再进行逻辑处理。


