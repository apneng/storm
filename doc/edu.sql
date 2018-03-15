/*
Navicat MySQL Data Transfer

Source Server         : df
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : yankon

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-03-15 10:04:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empid` varchar(50) NOT NULL,
  `ename` varchar(25) DEFAULT NULL,
  `egender` int(11) DEFAULT NULL COMMENT '性别：0-女， 1-男',
  `eage` int(11) DEFAULT NULL,
  `ephone` varchar(25) DEFAULT NULL,
  `deptid` varchar(50) DEFAULT NULL COMMENT '部门id',
  `ebirthday` date DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
Navicat MySQL Data Transfer

Source Server         : df
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : yankon

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-03-15 10:05:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptid` varchar(50) NOT NULL,
  `dname` varchar(50) NOT NULL,
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
Navicat MySQL Data Transfer

Source Server         : df
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : yankon

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-03-15 10:05:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '用户ID',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `username` varchar(255) NOT NULL COMMENT '用户昵称',
  `role` varchar(255) DEFAULT NULL COMMENT '用户身份',
  `status` int(1) DEFAULT NULL COMMENT '用户状态',
  `regTime` datetime DEFAULT NULL COMMENT '注册时间',
  `regIp` varchar(255) DEFAULT NULL COMMENT '注册IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

