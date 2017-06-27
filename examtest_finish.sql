/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : examtest

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-07-15 08:47:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` varchar(30) NOT NULL,
  `password` varchar(30) default NULL,
  `name` varchar(30) default NULL,
  `sex` varchar(10) default NULL,
  `academy` varchar(50) default NULL,
  `profession` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2010205620', '12536', '赵云', '男', '信息工程', '计算机科学与技术104');
INSERT INTO `t_student` VALUES ('2010508484', '2634', '张三', '男', '信息工程', '计算机科学与技术102');
INSERT INTO `t_student` VALUES ('2011204565', '126421', '王虎', '男', '信息工程', '软件工程112');
INSERT INTO `t_student` VALUES ('2011205959', '12562', '李琦', '女', '信息工程', '软件工程114');
INSERT INTO `t_student` VALUES ('2011421015', '1252', '李爽', '男', '信息工程', '计算机科学与技术112');
INSERT INTO `t_student` VALUES ('2011489456', '45653', '刘丽', '女', '信息工程', '软件工程113');
INSERT INTO `t_student` VALUES ('2012501459', '3532', '李伟', '男', '信息工程', '计算机科学与技术111');
INSERT INTO `t_student` VALUES ('2013254665', '12533', '刘丽丽', '女', '信息工程', '软件工程133');
INSERT INTO `t_student` VALUES ('2014000111', '1234', '李四', '女', '信息工程', '计算机科学与技术144');
INSERT INTO `t_student` VALUES ('2014012666', '12342', '马力', '男', '信息工程', '软件工程142');
INSERT INTO `t_student` VALUES ('2014111222', '1234', '王悦', '男', '信息工程', '计算机科学与技术144');
INSERT INTO `t_student` VALUES ('2014555221', '12345', '张琪', '女', '外语学院', '英语144');
INSERT INTO `t_student` VALUES ('2014555555', '2014555555', '李成', '男', '信息工程', '信息工程145');
INSERT INTO `t_student` VALUES ('2014560902', '3446467', '刘伟', '男', '信息工程', '计算机科学与技术144');
INSERT INTO `t_student` VALUES ('2014789456', '3432', '张鑫', '男', '信息工程', '软件工程144');
INSERT INTO `t_student` VALUES ('2015504865', '211223', '王青', '男', '信息工程', '计算机科学与技术152');
INSERT INTO `t_student` VALUES ('2015620022', '325', '王茜', '女', '外语学院', '英语152');
INSERT INTO `t_student` VALUES ('2015651232', '123', '杨丽', '女', '外语学院', '英语151');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` varchar(30) NOT NULL,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `academy` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('2000000000', '王莉', '000000', '信息工程学院');
INSERT INTO `t_teacher` VALUES ('2009032443', '李艳芳', '123456', '信息工程学院');
INSERT INTO `t_teacher` VALUES ('2014111111', '张嘉', '111111', '信息工程学院');
INSERT INTO `t_teacher` VALUES ('2014123456', '李广', '123456', '信息工程学院');
