/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : redis_red_packet

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-04-17 13:18:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_red_packet
-- ----------------------------
DROP TABLE IF EXISTS `t_red_packet`;
CREATE TABLE `t_red_packet` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(12) DEFAULT NULL,
  `amount` decimal(16,2) DEFAULT NULL,
  `send_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `total` int(12) DEFAULT NULL,
  `unit_amount` decimal(12,0) DEFAULT NULL,
  `stock` bigint(12) DEFAULT NULL,
  `version` int(12) DEFAULT '0',
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_red_packet
-- ----------------------------
INSERT INTO `t_red_packet` VALUES ('1', '1', '200000.00', '2020-04-12 13:00:25', '20000', '10', '20000', '0', ' ');

-- ----------------------------
-- Table structure for t_user_red_packet
-- ----------------------------
DROP TABLE IF EXISTS `t_user_red_packet`;
CREATE TABLE `t_user_red_packet` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `red_packet_id` int(12) DEFAULT NULL,
  `user_id` int(12) DEFAULT NULL,
  `amount` decimal(16,2) DEFAULT NULL,
  `grab_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_red_packet
-- ----------------------------
INSERT INTO `t_user_red_packet` VALUES ('1', '3', '4', null, '2020-04-17 12:49:32', null);
INSERT INTO `t_user_red_packet` VALUES ('2', '3', '2', null, '2020-04-17 12:49:32', null);
INSERT INTO `t_user_red_packet` VALUES ('3', '3', '1', null, '2020-04-17 12:49:32', null);
INSERT INTO `t_user_red_packet` VALUES ('4', '3', '3', null, '2020-04-17 12:49:33', null);
INSERT INTO `t_user_red_packet` VALUES ('5', '3', '5', null, '2020-04-17 12:49:33', null);
INSERT INTO `t_user_red_packet` VALUES ('6', '3', '0', null, '2020-04-17 12:49:33', null);
INSERT INTO `t_user_red_packet` VALUES ('7', '3', '9', null, '2020-04-17 12:49:33', null);
INSERT INTO `t_user_red_packet` VALUES ('8', '3', '8', null, '2020-04-17 12:49:33', null);
INSERT INTO `t_user_red_packet` VALUES ('9', '3', '6', null, '2020-04-17 12:49:33', null);
INSERT INTO `t_user_red_packet` VALUES ('10', '3', '7', null, '2020-04-17 12:49:34', null);
