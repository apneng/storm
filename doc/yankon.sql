/*
Navicat MySQL Data Transfer

Source Server         : ggy
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : yankon

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-10-29 23:15:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptid` int(11) NOT NULL,
  `dname` varchar(50) NOT NULL,
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '人事部');
INSERT INTO `dept` VALUES ('2', '开发部');
INSERT INTO `dept` VALUES ('3', '研发部');
INSERT INTO `dept` VALUES ('4', '行政部');
INSERT INTO `dept` VALUES ('5', '业务部');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(25) NOT NULL,
  `egender` int(11) NOT NULL,
  `eage` int(11) NOT NULL,
  `ephone` varchar(25) NOT NULL,
  `deptid` int(11) NOT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1007', '张三', '1', '23', '12345678909', '2');
INSERT INTO `emp` VALUES ('1008', '王二', '1', '23', '12345423123', '3');
INSERT INTO `emp` VALUES ('1009', '李四', '0', '43', '12345678909', '1');
