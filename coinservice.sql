/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50629
Source Host           : 10.9.210.22:3302
Source Database       : galaxycloud

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2018-04-03 20:26:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coins
-- ----------------------------
DROP TABLE IF EXISTS `coins`;
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

-- ----------------------------
-- Records of coins
-- ----------------------------
INSERT INTO `coins` VALUES ('1', '1', '10', null, '1522727139439', null, '1522733053387', '1', null, '1');
INSERT INTO `coins` VALUES ('2', '2', '15', null, '1522727252342', null, null, '1', null, '1');
INSERT INTO `coins` VALUES ('4', '3', '50', null, '1522727692526', null, '1522733053376', '1', null, '1');

-- ----------------------------
-- Table structure for java_process
-- ----------------------------
DROP TABLE IF EXISTS `java_process`;
CREATE TABLE `java_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `java_process` int(11) DEFAULT NULL COMMENT 'java进程',
  `system_code` varchar(45) DEFAULT NULL COMMENT '系统编码',
  `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效',
  `created_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updated_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of java_process
-- ----------------------------
INSERT INTO `java_process` VALUES ('1', '21336', 'coins', '1', '1522736947864', '1522755459011');
