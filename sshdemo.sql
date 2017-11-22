/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50539
Source Host           : 127.0.0.1:3306
Source Database       : sshdemo

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2017-11-22 14:47:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_menuinfo
-- ----------------------------
DROP TABLE IF EXISTS `db_menuinfo`;
CREATE TABLE `db_menuinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menuDesc` longtext COLLATE utf8_unicode_ci,
  `menuName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `menuUrl` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderNum` int(11) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_menuinfo
-- ----------------------------
INSERT INTO `db_menuinfo` VALUES ('1', '', '', '用户管理系统', '', '1', '0');
INSERT INTO `db_menuinfo` VALUES ('2', '', '', '物品管理系统', '', '0', '0');
INSERT INTO `db_menuinfo` VALUES ('3', '', '', '用户管理', '', '0', '1');
INSERT INTO `db_menuinfo` VALUES ('4', '', '', '用户添加', 'userinfo/add', '0', '3');
INSERT INTO `db_menuinfo` VALUES ('5', '', '', '用户列表', 'userinfo/list', '1', '3');
INSERT INTO `db_menuinfo` VALUES ('6', '', '', '项目管理', '', '1', '1');
INSERT INTO `db_menuinfo` VALUES ('7', '', '', '项目添加', 'project/add', '0', '6');
INSERT INTO `db_menuinfo` VALUES ('8', '', '', '项目列表', 'project/list', '1', '6');
INSERT INTO `db_menuinfo` VALUES ('9', '', '', '历史项目', 'project/hislist', '2', '6');
INSERT INTO `db_menuinfo` VALUES ('10', '', '', '菜单列表', '/kc/userinfo/user/list.do', '2', '7');
INSERT INTO `db_menuinfo` VALUES ('11', '', '', '药品管理', '', '2', '1');
INSERT INTO `db_menuinfo` VALUES ('12', '', '', '类别列表', '/kc/medicines/medicinesType/list.do', '0', '11');
INSERT INTO `db_menuinfo` VALUES ('13', '', '', '药品添加', '/kc/medicines/medicines/new.do', '1', '11');
INSERT INTO `db_menuinfo` VALUES ('14', '', '', '药品列表', '/kc/medicines/medicines/list.do', '2', '11');
INSERT INTO `db_menuinfo` VALUES ('15', '', '', '预警管理', '/kc/medicines/safety/list.do', '3', '11');
INSERT INTO `db_menuinfo` VALUES ('16', '', '', '处方管理', '', '3', '1');
INSERT INTO `db_menuinfo` VALUES ('17', '', '', '处方列表', '/kc/prescription/prescription/list.do', '0', '16');
INSERT INTO `db_menuinfo` VALUES ('18', '', '', '处方详细', '/kc/prescription/prescription/detail.do', '1', '16');
INSERT INTO `db_menuinfo` VALUES ('19', '', '', '仓库管理', '', '4', '1');
INSERT INTO `db_menuinfo` VALUES ('20', '', '', '入库单添加', '/kc/store/input/new.do', '0', '19');
INSERT INTO `db_menuinfo` VALUES ('21', '', '', '入库单列表', '/kc/store/input/list.do', '1', '19');
INSERT INTO `db_menuinfo` VALUES ('22', '', '', '转运单添加', '/kc/store/transport/new.do', '2', '19');
INSERT INTO `db_menuinfo` VALUES ('23', '', '', '转运单列表', '/kc/store/transport/list.do', '3', '19');
INSERT INTO `db_menuinfo` VALUES ('24', '', '', '报表管理', '', '5', '1');
INSERT INTO `db_menuinfo` VALUES ('25', '', '', '医生模块', '', '0', '2');
INSERT INTO `db_menuinfo` VALUES ('26', '', '', '获取病人信息', '/yl/doctor/patient/list.do', '0', '25');
INSERT INTO `db_menuinfo` VALUES ('27', '', '', '开处方', '/yl/doctor/prescription/new.do', '1', '25');
INSERT INTO `db_menuinfo` VALUES ('28', '', '', '查看收入', '/yl/doctor/earning/list.do', '2', '25');
INSERT INTO `db_menuinfo` VALUES ('29', '', '', '药房模块', '', '1', '2');
INSERT INTO `db_menuinfo` VALUES ('30', '', '', '处方抓药', '/yl/buymedicine/buymedicine/new.do', '0', '29');
INSERT INTO `db_menuinfo` VALUES ('31', '', '', '前台模块', '', '2', '2');
INSERT INTO `db_menuinfo` VALUES ('32', '', '', '直接挂号', '/yl/foreground/patient/reg.do', '0', '31');
INSERT INTO `db_menuinfo` VALUES ('33', '', '', '确认收费', '/yl/foreground/charge/confirm.do', '1', '31');
INSERT INTO `db_menuinfo` VALUES ('34', '', '', '确认抓药', '/yl/foreground/buymedicine/confirm.do', '2', '31');
INSERT INTO `db_menuinfo` VALUES ('35', '', '', '管理模块', '', '3', '2');
INSERT INTO `db_menuinfo` VALUES ('36', '', '', '基本设置', '/yl/manager/setting/basic.do', '0', '35');
INSERT INTO `db_menuinfo` VALUES ('37', '', '', '医生管理', '/yl/manager/doctor/list.do', '1', '35');

-- ----------------------------
-- Table structure for db_project
-- ----------------------------
DROP TABLE IF EXISTS `db_project`;
CREATE TABLE `db_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `proName` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `statusVal` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_project
-- ----------------------------
INSERT INTO `db_project` VALUES ('1', '保险后台管理系统,SSH', 'XX保险后台管理系统', '0');
INSERT INTO `db_project` VALUES ('2', '后台报表系统', 'XX银行后台报表系统', '2');
INSERT INTO `db_project` VALUES ('3', '自助贷款系统', 'XX银行自助贷款系统', '1');
INSERT INTO `db_project` VALUES ('4', '自助点单系统', 'XXKTV自助点单系统', '3');
INSERT INTO `db_project` VALUES ('5', '自助收费系统', 'XXKTV自助收费系统', '2');

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `statusVal` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('2', '用户2', '222', '1');
INSERT INTO `db_user` VALUES ('3', '用户3', '333', '1');
INSERT INTO `db_user` VALUES ('9', '用户9', '999', '1');
INSERT INTO `db_user` VALUES ('10', 'zjr', '000', '1');
INSERT INTO `db_user` VALUES ('11', 'zjr1', '111', '1');
INSERT INTO `db_user` VALUES ('12', 'zjr2', '222', '1');
INSERT INTO `db_user` VALUES ('14', 'zjr4', '444', '1');
INSERT INTO `db_user` VALUES ('17', 'zjr7', '777', '1');
INSERT INTO `db_user` VALUES ('21', 'zjr21', '111', '5');
INSERT INTO `db_user` VALUES ('22', 'zjr22', '222', '5');
INSERT INTO `db_user` VALUES ('23', '\"few\"', '\"321\"', '1');
INSERT INTO `db_user` VALUES ('24', '\"few\"', '\"321\"', '1');
INSERT INTO `db_user` VALUES ('25', '5324', '5555', '1');
INSERT INTO `db_user` VALUES ('27', '4632262436', '243652345', '1');
INSERT INTO `db_user` VALUES ('28', '514514325', '31241324', '1');
INSERT INTO `db_user` VALUES ('29', '12414141', '1414214', '1');
INSERT INTO `db_user` VALUES ('30', '4324', 'fff', '1');
INSERT INTO `db_user` VALUES ('31', '打发adf', '4444', '1');
INSERT INTO `db_user` VALUES ('32', '345135', '513515', '1');
INSERT INTO `db_user` VALUES ('34', '213', '2131', '1');
INSERT INTO `db_user` VALUES ('35', '213', '55555', '1');
