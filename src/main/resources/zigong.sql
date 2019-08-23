/*
 Navicat Premium Data Transfer

 Source Server         : mysql16
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 172.16.254.16:3306
 Source Schema         : zigong

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 23/08/2019 17:16:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for biospecimen
-- ----------------------------
DROP TABLE IF EXISTS `biospecimen`;
CREATE TABLE `biospecimen`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `specimennumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标本编号',
  `specimenname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标本名称',
  `hallnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '馆内编号',
  `latin` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拉丁学名',
  `specimentype` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标本类型',
  `collectionposition` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集位置',
  `collectiontime` date NULL DEFAULT NULL COMMENT '采集时间',
  `collectionhuman` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集人',
  `collectionnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收藏数量',
  `savestate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保存状态',
  `featuredescription` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '特征描述',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '附注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '生物标本' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for commentary
-- ----------------------------
DROP TABLE IF EXISTS `commentary`;
CREATE TABLE `commentary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `type` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置',
  `coordinate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐标',
  `constructiontime` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建设时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标示解说系统' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for displayboard
-- ----------------------------
DROP TABLE IF EXISTS `displayboard`;
CREATE TABLE `displayboard`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `boardnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '展板编号',
  `hallname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '展厅名称',
  `boardcontent` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展板内容',
  `makingtime` date NULL DEFAULT NULL COMMENT '制作时间',
  `constructionunit` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计施工单位',
  `contentauther` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容作者',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '附注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '展板' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for earthquake
-- ----------------------------
DROP TABLE IF EXISTS `earthquake`;
CREATE TABLE `earthquake`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `disasternumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '灾害点编号',
  `disastername` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '灾害点名称',
  `type` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理位置',
  `coordinate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐标',
  `scale` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规模',
  `stability` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '稳定性',
  `dangerous` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '危险性',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '特征描述',
  `factor` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '诱发因素',
  `threat` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '威胁对象',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地灾信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ecosystem
-- ----------------------------
DROP TABLE IF EXISTS `ecosystem`;
CREATE TABLE `ecosystem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `type` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公园地貌类型',
  `averagetempera` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园年平均气温高',
  `toptempera` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园年最高气温',
  `bottomtempera` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园年最低气温',
  `averagerain` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公园年平均降水',
  `plantcover` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '植被、绿地',
  `animal` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '珍稀动物',
  `plant` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '珍稀植物',
  `water` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '水资源概况',
  `climate` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '气候特征',
  `disaster` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公园内灾害情',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '生态环境状况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exchangeexhibition
-- ----------------------------
DROP TABLE IF EXISTS `exchangeexhibition`;
CREATE TABLE `exchangeexhibition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地点',
  `time` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间',
  `exhibitionobject` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '互展对象',
  `exhibitioncontent` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '互展内容',
  `exhibitionhuman` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主要互展人员',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '交流互展' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fincestat
-- ----------------------------
DROP TABLE IF EXISTS `fincestat`;
CREATE TABLE `fincestat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `time` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `income` double(15, 2) NULL DEFAULT NULL COMMENT '收入',
  `incomesource` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '收入来源说明',
  `expenditure` double(15, 2) NULL DEFAULT NULL COMMENT '支出',
  `expenditureproject` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '支出项目说明',
  `balance` double(15, 2) NULL DEFAULT NULL COMMENT '结余',
  `balancematter` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '结余情况说明',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '财务统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for geolandscape
-- ----------------------------
DROP TABLE IF EXISTS `geolandscape`;
CREATE TABLE `geolandscape`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `time` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `income` double(15, 2) NULL DEFAULT NULL COMMENT '收入',
  `incomesource` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '收入来源说明',
  `expenditure` double(15, 2) NULL DEFAULT NULL COMMENT '支出',
  `expenditureproject` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '支出项目说明',
  `balance` double(15, 2) NULL DEFAULT NULL COMMENT '结余',
  `balancematter` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '结余情况说明',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地质遗迹景点' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for geological
-- ----------------------------
DROP TABLE IF EXISTS `geological`;
CREATE TABLE `geological`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `position` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '大地构造位置',
  `stratum` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '地层',
  `magmatic` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '岩浆岩',
  `metamorphic` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '变质岩',
  `geostructure` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '地质构造',
  `mineral` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '矿产',
  `evolutionary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '地质发展演化',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地质背景' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for geospecimen
-- ----------------------------
DROP TABLE IF EXISTS `geospecimen`;
CREATE TABLE `geospecimen`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `specimennumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标本编号',
  `specimenname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标本名称',
  `fieldnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '野外编号',
  `hallnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '馆内编号',
  `englishlatin` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文或拉丁学名',
  `specimentype` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标本类型',
  `collectionposition` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集位置',
  `collectiontime` date NULL DEFAULT NULL COMMENT '采集时间',
  `collectionhuman` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集人',
  `identificationhuman` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鉴定人',
  `collectionnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收藏数量',
  `savestate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保存状态',
  `featuredescription` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '特征描述',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地质标本' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gueststat
-- ----------------------------
DROP TABLE IF EXISTS `gueststat`;
CREATE TABLE `gueststat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `time` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `touristsnumber` double(15, 6) NULL DEFAULT NULL COMMENT '游客人数 单位',
  `touristssource` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '游客来源',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游客统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for humanlandscape
-- ----------------------------
DROP TABLE IF EXISTS `humanlandscape`;
CREATE TABLE `humanlandscape`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `humanitnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '人文景观编号',
  `h_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景观名称',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理位置',
  `traffic` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交通状况',
  `lat` double(12, 2) NULL DEFAULT NULL COMMENT '经度',
  `lng` double(12, 2) NULL DEFAULT NULL COMMENT '纬度',
  `altitude` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '海拔高度',
  `feature` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '景观特色',
  `level` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文物保护单位',
  `approvedtime` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准时间',
  `status` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '保护现状',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人文景观' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for humenexhibit
-- ----------------------------
DROP TABLE IF EXISTS `humenexhibit`;
CREATE TABLE `humenexhibit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `specimennumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标本编号',
  `specimenname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标本名称',
  `hallnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '馆内编号',
  `specimentype` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标本类型',
  `specimensource` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标本来源',
  `collectionnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收藏数量',
  `savestate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保存状态',
  `featuredescription` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '特征描述',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '附注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人文展品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for legal
-- ----------------------------
DROP TABLE IF EXISTS `legal`;
CREATE TABLE `legal`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件编号',
  `filename` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `unit` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布单位',
  `time` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规划期限',
  `keyword` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `summary` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公园管理法律法规' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for managementagency
-- ----------------------------
DROP TABLE IF EXISTS `managementagency`;
CREATE TABLE `managementagency`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `managename` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理机构（科室）名称',
  `level` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理机构级别',
  `maincharge` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要负责人姓名',
  `secondarycharge` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '次要负责人姓名',
  `job` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人职务',
  `number` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理机构设置人数',
  `list` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构工作人员',
  `responsibility` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构职责与分工',
  `phone` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人联系电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理机构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mineralright
-- ----------------------------
DROP TABLE IF EXISTS `mineralright`;
CREATE TABLE `mineralright`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `type` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `license` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '许可证号',
  `mineralhumanname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '矿权人名称',
  `mineralname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '矿权名称',
  `mineralspecies` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要矿种',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置',
  `area` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面积',
  `lat` double(12, 2) NULL DEFAULT NULL COMMENT '经度',
  `lng` double(12, 2) NULL DEFAULT NULL COMMENT '纬度',
  `validity` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效期',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '矿权设置情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for museum
-- ----------------------------
DROP TABLE IF EXISTS `museum`;
CREATE TABLE `museum`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `museumname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博物馆名称',
  `area` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面积',
  `buildtime` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建馆时间',
  `museummechanism` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博物馆管理机构设置',
  `museumpartition` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博物馆分区与布展情况',
  `exhibitsoverview` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '馆藏展品概况',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `contact` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'E-MAIL',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博物馆基本情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_locale` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本地文章',
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `lettername` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通讯稿名称',
  `releasetime` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布时间',
  `auther` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '正文',
  `releasewebsite` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布的网站',
  `contentsummary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容摘要',
  `note` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻通讯' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for overlapping
-- ----------------------------
DROP TABLE IF EXISTS `overlapping`;
CREATE TABLE `overlapping`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `othername` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他景区名称',
  `othertype` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他景区类型',
  `othersupervisor` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他景区主管部门',
  `othermatter` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '其他景区开发建设情况',
  `overposition` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重叠区域位置',
  `overarea` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重叠区域面积',
  `overinstruction` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '重叠区管理情况说明',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '与其他景区重叠情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码',
  `name` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `rank` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '级别',
  `position` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置',
  `district` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区',
  `zip` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `lng` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `area` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面积',
  `type` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园类型',
  `divide` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '保护区划分情况',
  `create` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建立时间',
  `characteristic` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公园地质遗迹景观特色',
  `significance` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '重要意义',
  `ratifier` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准单位',
  `status_quo` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '保护现状',
  `historical_type` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '主要地质遗迹类型',
  `master` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园主管部门',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公园概况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parkinfo
-- ----------------------------
DROP TABLE IF EXISTS `parkinfo`;
CREATE TABLE `parkinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `org_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织机构代码',
  `legal_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '法人代表',
  `tenure` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '在任年限',
  `security_supervisor` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园安全责任人',
  `mobile` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安全责任人联',
  `staffer` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '在编职工',
  `website` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园网站地址',
  `contact` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园联系电话',
  `fax` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `supervisor` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级主管',
  `fund_provider` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经费来源',
  `mail` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公园信息管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parklibrary
-- ----------------------------
DROP TABLE IF EXISTS `parklibrary`;
CREATE TABLE `parklibrary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birth` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生年月',
  `subject_direction` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学科方向',
  `relationship` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聘用关系',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公园专家库与导游库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parkmeeting
-- ----------------------------
DROP TABLE IF EXISTS `parkmeeting`;
CREATE TABLE `parkmeeting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `title` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会议名称',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `start_at` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `delegate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参会代表',
  `img` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '照片',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地质公园会议' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parkoption
-- ----------------------------
DROP TABLE IF EXISTS `parkoption`;
CREATE TABLE `parkoption`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `project` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `client` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '委托方',
  `fund_provider` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资金来源',
  `actualizer` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目实施单位',
  `amount` double(15, 2) NOT NULL COMMENT '项目合同金额',
  `cycle` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目周期',
  `man` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目负责姓名',
  `contact` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目负责联系',
  `progress` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目进度情况',
  `pay` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '付款情况',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公园项目管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parkrelation
-- ----------------------------
DROP TABLE IF EXISTS `parkrelation`;
CREATE TABLE `parkrelation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `park_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姊妹公园名称',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `conclusion_at` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缔结时间',
  `delegate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '双方代表',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `img` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '照片',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '缔结姊妹公园' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parktopic
-- ----------------------------
DROP TABLE IF EXISTS `parktopic`;
CREATE TABLE `parktopic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `reportnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报告编号',
  `reportname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告名称',
  `achievementtype` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果类型',
  `auther` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `carrytime` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '完成时间',
  `carryunit` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '完成单位',
  `organizer` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主管单位',
  `theme` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主题词',
  `achievementsummary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '成果摘要',
  `parkcollect` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公园收藏情况',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公园专题研究' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `promotionname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推介会名称',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `time` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `representative` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参加代表',
  `promotioncontent` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '推介内容',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品推介' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for researchpaper
-- ----------------------------
DROP TABLE IF EXISTS `researchpaper`;
CREATE TABLE `researchpaper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `activityname` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `time` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `position` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `scienceobject` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科普对象',
  `sciencecontent` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科普内容',
  `sciencestaff` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科普工作人员',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '科普活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sampling
-- ----------------------------
DROP TABLE IF EXISTS `sampling`;
CREATE TABLE `sampling`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `samplenumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样品编号',
  `sampletype` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样品类型',
  `sampleposition` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采样位置',
  `coordinate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐标',
  `code` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地质代号',
  `research` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '野外定名',
  `achievement` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '测试成果',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采样信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sciencework
-- ----------------------------
DROP TABLE IF EXISTS `sciencework`;
CREATE TABLE `sciencework`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `itemnumber` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作品编号',
  `scienceitem` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科普作品名称',
  `masses` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '受众群体',
  `auther` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `carrytime` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '完成时间',
  `carryunit` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '完成单位',
  `publishing` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否出版',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `deleted_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '科普作品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for socialeconomy
-- ----------------------------
DROP TABLE IF EXISTS `socialeconomy`;
CREATE TABLE `socialeconomy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL,
  `ethnic` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公园内人口民族情况',
  `areaethnic` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园所在区域人口民族情况',
  `economic` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园内经济发展情况',
  `areaeconomic` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公园所在区域',
  `develop` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济发展情况公园对于社区及区域经济可持续发展的贡献情况',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '社会经济概况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径',
  `menu_type` smallint(2) NOT NULL COMMENT '类型:0:目录,1:菜单,2:按钮',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `create_uid` int(11) NOT NULL COMMENT '创建者ID',
  `update_uid` int(11) NOT NULL COMMENT '修改者ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `status` smallint(2) NOT NULL COMMENT '状态 0：禁用 1：正常',
  `router` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由',
  `alias` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '别名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '', 1, 'layui-icon-set', 1, 1, '2019-08-22 16:35:28', '2019-08-22 16:35:28', 0, '', '');
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 'user.html', 2, 'layui-icon-user', 1, 1, '2019-08-22 16:49:14', '2019-08-22 17:05:52', 0, 'user', 'sys:user:page');
INSERT INTO `sys_menu` VALUES (3, 2, '添加', '', 3, 'layui-icon-add-circle-fine', 1, 1, '2019-08-22 16:53:54', '2019-08-22 17:07:03', 0, '', 'sys:user:add');
INSERT INTO `sys_menu` VALUES (4, 2, '编辑', '', 3, 'layui-icon-edit', 1, 1, '2019-08-22 16:56:41', '2019-08-22 17:08:18', 0, '', 'sys:user:edit');
INSERT INTO `sys_menu` VALUES (5, 2, '删除', '', 3, 'layui-icon-delete', 1, 1, '2019-08-22 16:58:46', '2019-08-22 17:08:27', 0, '', 'sys:user:delete');
INSERT INTO `sys_menu` VALUES (6, 2, '重置密码', '', 3, 'layui-icon-password', 1, 1, '2019-08-22 17:10:37', '2019-08-22 17:10:37', 0, '', 'sys:user:password');
INSERT INTO `sys_menu` VALUES (7, 1, '角色管理', 'role.html', 2, 'layui-icon-face-surprised', 1, 1, '2019-08-22 17:20:57', '2019-08-22 17:20:57', 0, 'role', 'sys:role:page');
INSERT INTO `sys_menu` VALUES (8, 7, '添加', '', 3, 'layui-icon-add-circle-fine', 1, 1, '2019-08-22 17:25:47', '2019-08-22 17:25:47', 0, '', 'sys:role:add');
INSERT INTO `sys_menu` VALUES (9, 7, '编辑', '', 3, 'layui-icon-edit', 1, 1, '2019-08-22 17:26:20', '2019-08-22 17:26:20', 0, '', 'sys:role:edit');
INSERT INTO `sys_menu` VALUES (10, 7, '删除', '', 3, 'layui-icon-delete', 1, 1, '2019-08-22 17:26:55', '2019-08-22 17:26:55', 0, '', 'sys:role:delete');
INSERT INTO `sys_menu` VALUES (11, 7, '授权', '', 3, 'layui-icon-auz', 1, 1, '2019-08-22 17:31:15', '2019-08-22 17:31:15', 0, '', 'sys:role:authority');
INSERT INTO `sys_menu` VALUES (12, 1, '菜单管理', 'menu.html', 2, 'layui-icon-template', 1, 1, '2019-08-22 17:35:34', '2019-08-22 17:35:34', 0, 'menu', 'sys:menu:list');
INSERT INTO `sys_menu` VALUES (13, 12, '添加', '', 3, 'layui-icon-add-circle-fine', 1, 1, '2019-08-22 17:37:47', '2019-08-22 17:39:06', 0, '', 'sys:menu:add');
INSERT INTO `sys_menu` VALUES (14, 12, '编辑', '', 3, 'layui-icon-edit', 1, 1, '2019-08-22 17:41:04', '2019-08-23 14:11:19', 0, '', 'sys:menu:edit');
INSERT INTO `sys_menu` VALUES (15, 12, '删除', '', 3, 'layui-icon-delete', 1, 1, '2019-08-22 17:42:04', '2019-08-22 17:42:04', 0, '', 'sys:menu:delete');
INSERT INTO `sys_menu` VALUES (16, 1, '资源管理', 'resource.html', 2, 'layui-icon-read', 1, 1, '2019-08-22 17:44:23', '2019-08-22 17:44:23', 0, 'resource', 'sys:resource:page');
INSERT INTO `sys_menu` VALUES (17, 16, '刷新', '', 3, 'layui-icon-refresh', 1, 1, '2019-08-22 17:46:10', '2019-08-22 17:46:10', 0, '', 'sys:resource:refresh');
INSERT INTO `sys_menu` VALUES (18, 1, '任务管理', 'task.html', 2, 'layui-icon-flag', 1, 1, '2019-08-23 10:15:08', '2019-08-23 10:15:08', 0, 'task', 'sys:task:page');
INSERT INTO `sys_menu` VALUES (19, 18, '添加', '', 3, 'layui-icon-add-circle-fine', 1, 1, '2019-08-23 10:16:23', '2019-08-23 10:16:23', 0, '', 'sys:task:add');
INSERT INTO `sys_menu` VALUES (20, 18, '编辑', '', 3, 'layui-icon-edit', 1, 1, '2019-08-23 10:17:21', '2019-08-23 10:17:21', 0, '', 'sys:task:edit');
INSERT INTO `sys_menu` VALUES (21, 18, '删除', '', 3, 'layui-icon-delete', 1, 1, '2019-08-23 10:17:56', '2019-08-23 10:17:56', 0, '', 'sys:task:delete');

-- ----------------------------
-- Table structure for sys_menu_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_resource`;
CREATE TABLE `sys_menu_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单ID',
  `resource_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu_resource
-- ----------------------------
INSERT INTO `sys_menu_resource` VALUES (1, 2, 'fad1ecbafb22f1ac0f63486d71393745');
INSERT INTO `sys_menu_resource` VALUES (2, 2, '49764a50d0e0f74790ced2586b03bff8');
INSERT INTO `sys_menu_resource` VALUES (3, 3, '9be8e0df48c8ba879e5b079c73662ee4');
INSERT INTO `sys_menu_resource` VALUES (4, 4, '54522abbe7d3a2a40e7edbc9339acc50');
INSERT INTO `sys_menu_resource` VALUES (5, 5, '3dca30c2118ff6158ffa88191003128e');
INSERT INTO `sys_menu_resource` VALUES (6, 6, 'd245ace645ea40e898178ee13c24297f');
INSERT INTO `sys_menu_resource` VALUES (7, 7, 'a2cf21f89380c679e13e76a46e63de18');
INSERT INTO `sys_menu_resource` VALUES (8, 8, '46a5d7a79e6ba91e6709f3361a2edd81');
INSERT INTO `sys_menu_resource` VALUES (9, 9, 'b7b1c22076c0d28c8d0fe4c0b09b6a6e');
INSERT INTO `sys_menu_resource` VALUES (10, 10, 'ddf4e3fd39264da50eec54cfd02731f4');
INSERT INTO `sys_menu_resource` VALUES (11, 11, '24bf74d47e8322146e38f0c68333f90c');
INSERT INTO `sys_menu_resource` VALUES (12, 11, 'f880f8a35613b38182612a061291f8a5');
INSERT INTO `sys_menu_resource` VALUES (13, 12, 'f880f8a35613b38182612a061291f8a5');
INSERT INTO `sys_menu_resource` VALUES (14, 12, 'de8b6406105c3ea1c71de78e0870595e');
INSERT INTO `sys_menu_resource` VALUES (15, 13, '3a62355efcfa84646b390d508efea9b6');
INSERT INTO `sys_menu_resource` VALUES (16, 13, 'd83a249e0e0ed84806ecba2fd8c7148d');
INSERT INTO `sys_menu_resource` VALUES (17, 13, 'd8544217f479cfb39559e4b94f413aaa');
INSERT INTO `sys_menu_resource` VALUES (21, 15, '15da52a5f4f4a6eac3b0d6f046f040c9');
INSERT INTO `sys_menu_resource` VALUES (22, 16, '47aad34069f0e8713b6df562b4b2029f');
INSERT INTO `sys_menu_resource` VALUES (23, 17, '7025c7532d2a58d3de4dde7c66d363f3');
INSERT INTO `sys_menu_resource` VALUES (24, 18, '512082c7c24e77c5496977206d823f48');
INSERT INTO `sys_menu_resource` VALUES (25, 19, '9141e80baac708a8863498ff7a41d276');
INSERT INTO `sys_menu_resource` VALUES (26, 20, '1adec59980b460bb8db5198953608b87');
INSERT INTO `sys_menu_resource` VALUES (27, 21, '71d5f2e10db38eaebdaa44fa89cb1163');
INSERT INTO `sys_menu_resource` VALUES (28, 14, '37687195b63b44e0d22436080de117bc');
INSERT INTO `sys_menu_resource` VALUES (29, 14, 'd83a249e0e0ed84806ecba2fd8c7148d');
INSERT INTO `sys_menu_resource` VALUES (30, 14, 'd8544217f479cfb39559e4b94f413aaa');
INSERT INTO `sys_menu_resource` VALUES (31, 14, '375edb54e85dc981c8df62c76f3782ed');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源名称',
  `mapping` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '路径映射',
  `method` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求方式',
  `auth_type` smallint(2) NOT NULL COMMENT '权限认证类型',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `perm` varchar(68) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('15da52a5f4f4a6eac3b0d6f046f040c9', '菜单删除', '/menu/{id}', 'DELETE', 3, '2019-08-23 14:11:53', 'DELETE:/menu/{id}');
INSERT INTO `sys_resource` VALUES ('179887b5bd6e42be960b83982a684b10', '角色查询(所有)', '/role/list', 'GET', 3, '2019-08-23 14:11:53', 'GET:/role/list');
INSERT INTO `sys_resource` VALUES ('1adec59980b460bb8db5198953608b87', '任务编辑', '/task/{id}', 'PUT', 1, '2019-08-23 14:11:53', 'PUT:/task/{id}');
INSERT INTO `sys_resource` VALUES ('24bf74d47e8322146e38f0c68333f90c', '角色授权', '/role/{id}/menu', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/role/{id}/menu');
INSERT INTO `sys_resource` VALUES ('375edb54e85dc981c8df62c76f3782ed', '菜单详情', '/menu/{id}', 'GET', 3, '2019-08-23 14:11:53', 'GET:/menu/{id}');
INSERT INTO `sys_resource` VALUES ('37687195b63b44e0d22436080de117bc', '菜单编辑', '/menu/{id}', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/menu/{id}');
INSERT INTO `sys_resource` VALUES ('3a62355efcfa84646b390d508efea9b6', '菜单添加', '/menu', 'POST', 3, '2019-08-23 14:11:53', 'POST:/menu');
INSERT INTO `sys_resource` VALUES ('3dca30c2118ff6158ffa88191003128e', '用户删除', '/user/{id}', 'DELETE', 3, '2019-08-23 14:11:53', 'DELETE:/user/{id}');
INSERT INTO `sys_resource` VALUES ('46a5d7a79e6ba91e6709f3361a2edd81', '角色添加', '/role', 'POST', 3, '2019-08-23 14:11:53', 'POST:/role');
INSERT INTO `sys_resource` VALUES ('47aad34069f0e8713b6df562b4b2029f', '资源查询(分页)', '/resource/page', 'GET', 3, '2019-08-23 14:11:53', 'GET:/resource/page');
INSERT INTO `sys_resource` VALUES ('49764a50d0e0f74790ced2586b03bff8', '用户状态设置', '/user/{id}/status', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/user/{id}/status');
INSERT INTO `sys_resource` VALUES ('512082c7c24e77c5496977206d823f48', '任务查询(分页)', '/task/page', 'GET', 1, '2019-08-23 14:11:53', 'GET:/task/page');
INSERT INTO `sys_resource` VALUES ('54522abbe7d3a2a40e7edbc9339acc50', '用户编辑', '/user/{id}', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/user/{id}');
INSERT INTO `sys_resource` VALUES ('6ab0f8a49671e489f11a1bef2fcaf102', '账户清除', '/account/token', 'DELETE', 1, '2019-08-23 14:11:53', 'DELETE:/account/token');
INSERT INTO `sys_resource` VALUES ('6c3514540b1e2e1589a9c9566273c7c7', '用户详情', '/user/{id}', 'GET', 3, '2019-08-23 14:11:53', 'GET:/user/{id}');
INSERT INTO `sys_resource` VALUES ('7025c7532d2a58d3de4dde7c66d363f3', '资源刷新', '/resource', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/resource');
INSERT INTO `sys_resource` VALUES ('71d5f2e10db38eaebdaa44fa89cb1163', '任务删除', '/task/{id}', 'DELETE', 1, '2019-08-23 14:11:53', 'DELETE:/task/{id}');
INSERT INTO `sys_resource` VALUES ('842e33410b5a97b6c797e4782c97a90e', '账户获取', '/account/token', 'POST', 2, '2019-08-23 14:11:53', 'POST:/account/token');
INSERT INTO `sys_resource` VALUES ('9141e80baac708a8863498ff7a41d276', '任务添加', '/task', 'POST', 1, '2019-08-23 14:11:53', 'POST:/task');
INSERT INTO `sys_resource` VALUES ('9be8e0df48c8ba879e5b079c73662ee4', '用户添加', '/user', 'POST', 3, '2019-08-23 14:11:53', 'POST:/user');
INSERT INTO `sys_resource` VALUES ('a2cf21f89380c679e13e76a46e63de18', '角色查询(分页)', '/role/page', 'GET', 3, '2019-08-23 14:11:53', 'GET:/role/page');
INSERT INTO `sys_resource` VALUES ('b7b1c22076c0d28c8d0fe4c0b09b6a6e', '角色编辑', '/role/{id}', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/role/{id}');
INSERT INTO `sys_resource` VALUES ('c2db9729dcd4a7d703e45411bb445dfd', '账户密码修改', '/account/password', 'PUT', 1, '2019-08-23 14:11:53', 'PUT:/account/password');
INSERT INTO `sys_resource` VALUES ('d245ace645ea40e898178ee13c24297f', '用户密码重置', '/user/{id}/password', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/user/{id}/password');
INSERT INTO `sys_resource` VALUES ('d81bffa6ffd70cc443703820b5a95e8d', '账户菜单', '/account/menus', 'GET', 1, '2019-08-23 14:11:53', 'GET:/account/menus');
INSERT INTO `sys_resource` VALUES ('d83a249e0e0ed84806ecba2fd8c7148d', '菜单父级查询(下拉框)', '/menu/combos', 'GET', 3, '2019-08-23 14:11:53', 'GET:/menu/combos');
INSERT INTO `sys_resource` VALUES ('d8544217f479cfb39559e4b94f413aaa', '资源查询(所有)', '/resource/list', 'GET', 3, '2019-08-23 14:11:53', 'GET:/resource/list');
INSERT INTO `sys_resource` VALUES ('ddf4e3fd39264da50eec54cfd02731f4', '角色删除', '/role/{id}', 'DELETE', 3, '2019-08-23 14:11:53', 'DELETE:/role/{id}');
INSERT INTO `sys_resource` VALUES ('de8b6406105c3ea1c71de78e0870595e', '菜单状态设置', '/menu/{id}/status', 'PUT', 3, '2019-08-23 14:11:53', 'PUT:/menu/{id}/status');
INSERT INTO `sys_resource` VALUES ('e78940daf86b9ac5563d539e8802429c', '账户详情', '/account/info', 'GET', 1, '2019-08-23 14:11:53', 'GET:/account/info');
INSERT INTO `sys_resource` VALUES ('f880f8a35613b38182612a061291f8a5', '菜单查询(所有)', '/menu/list', 'GET', 3, '2019-08-23 14:11:53', 'GET:/menu/list');
INSERT INTO `sys_resource` VALUES ('fad1ecbafb22f1ac0f63486d71393745', '用户查询(分页)', '/user/page', 'GET', 3, '2019-08-23 14:11:53', 'GET:/user/page');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `create_uid` int(11) NOT NULL COMMENT '创建者ID',
  `update_uid` int(11) NOT NULL COMMENT '修改者ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 1, 1, '2018-11-12 15:59:43', '2018-11-12 15:59:47', '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通管理员', 1, 1, '2018-11-12 16:00:17', '2018-11-12 16:00:19', '普通管理员');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (3, 1, 3);
INSERT INTO `sys_role_menu` VALUES (4, 1, 4);
INSERT INTO `sys_role_menu` VALUES (5, 1, 5);
INSERT INTO `sys_role_menu` VALUES (6, 1, 6);
INSERT INTO `sys_role_menu` VALUES (7, 1, 7);
INSERT INTO `sys_role_menu` VALUES (8, 1, 8);
INSERT INTO `sys_role_menu` VALUES (9, 1, 9);
INSERT INTO `sys_role_menu` VALUES (10, 1, 10);
INSERT INTO `sys_role_menu` VALUES (11, 1, 11);
INSERT INTO `sys_role_menu` VALUES (12, 1, 12);
INSERT INTO `sys_role_menu` VALUES (13, 1, 13);
INSERT INTO `sys_role_menu` VALUES (14, 1, 14);
INSERT INTO `sys_role_menu` VALUES (15, 1, 15);
INSERT INTO `sys_role_menu` VALUES (16, 1, 16);
INSERT INTO `sys_role_menu` VALUES (17, 1, 17);
INSERT INTO `sys_role_menu` VALUES (18, 1, 18);
INSERT INTO `sys_role_menu` VALUES (19, 1, 19);
INSERT INTO `sys_role_menu` VALUES (20, 1, 20);
INSERT INTO `sys_role_menu` VALUES (21, 1, 21);
INSERT INTO `sys_role_menu` VALUES (22, 2, 1);
INSERT INTO `sys_role_menu` VALUES (23, 2, 18);
INSERT INTO `sys_role_menu` VALUES (24, 2, 19);
INSERT INTO `sys_role_menu` VALUES (25, 2, 20);
INSERT INTO `sys_role_menu` VALUES (26, 2, 21);

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机',
  `status` smallint(2) NOT NULL COMMENT '状态 0：禁用 1：正常',
  `create_uid` int(11) NOT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `login_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登陆名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '超级管理员', 'root@163.com', '13866668888', 0, 1, '2019-08-23 10:56:12', '2019-08-23 10:56:12', 'admin', '$apr1$admin$Sl27Fb32LUppR7w2Ovw4V/', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_user` VALUES (2, '阿大', '8888@163.com', '13888888888', 0, 1, '2019-08-23 10:57:17', '2019-08-23 10:57:17', 'lichee', '$apr1$lichee$2XUDSi4pQtv7EUyYcswB91', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 2);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名字',
  `task_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `status` smallint(1) NOT NULL COMMENT '状态：\r\n1. 任务未开始\r\n2. 任务进行中\r\n3. 任务完成\r\n4. 任务失败',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (2, '任务名称', '任务描述', '2019-07-22 11:09:46', 2);
INSERT INTO `task` VALUES (3, '任务名称', '任务描述', '2019-07-22 11:10:41', 1);
INSERT INTO `task` VALUES (4, '任务名称', '任务描述', '2019-07-22 11:12:02', 1);
INSERT INTO `task` VALUES (5, '任务名称', '任务描述', '2019-07-22 11:12:07', 1);
INSERT INTO `task` VALUES (6, '任务名称', '任务描述', '2019-07-22 11:12:12', 1);
INSERT INTO `task` VALUES (7, '任务名称', '任务描述', '2019-07-22 11:12:15', 1);
INSERT INTO `task` VALUES (8, '任务名称', '任务描述', '2019-07-22 11:12:18', 1);
INSERT INTO `task` VALUES (9, '任务名称', '任务描述', '2019-07-22 11:12:20', 1);
INSERT INTO `task` VALUES (10, '任务名称', '任务描述', '2019-07-22 11:12:23', 1);
INSERT INTO `task` VALUES (11, '任务名称', '任务描述', '2019-07-03 11:12:28', 1);
INSERT INTO `task` VALUES (12, '任务名称', '任务描述', '2019-07-22 11:13:59', 1);
INSERT INTO `task` VALUES (13, '任务名称', '任务描述', '2019-07-22 11:17:14', 1);
INSERT INTO `task` VALUES (14, '任务名称', '任务描述', '2019-07-22 14:04:37', 4);
INSERT INTO `task` VALUES (15, '任务名称', '任务描述', '2019-07-22 14:22:32', 1);
INSERT INTO `task` VALUES (17, '任务名称', '任务描述', '2019-07-24 15:30:32', 1);
INSERT INTO `task` VALUES (18, '任务名称', '任务描述', '2019-07-24 15:31:01', 1);
INSERT INTO `task` VALUES (19, '任务名称', '任务描述', '2019-07-24 15:31:19', 1);
INSERT INTO `task` VALUES (20, '任务名称', '任务描述', '2019-07-24 15:36:31', 1);
INSERT INTO `task` VALUES (21, '任务名称', '任务描述', '2019-07-24 15:40:57', 1);
INSERT INTO `task` VALUES (22, '任务名称', '任务描述', '2019-07-24 15:41:03', 1);
INSERT INTO `task` VALUES (23, '任务名称', '任务描述', '2019-07-24 15:46:14', 1);
INSERT INTO `task` VALUES (24, '任务名称', '任务描述', '2019-07-24 15:46:41', 1);
INSERT INTO `task` VALUES (25, '任务名称', '任务描述', '2019-07-24 15:51:14', 1);
INSERT INTO `task` VALUES (26, '任务名称', '任务描述', '2019-07-24 16:06:24', 1);
INSERT INTO `task` VALUES (27, '任务名称', '任务描述', '2019-07-24 16:06:28', 1);
INSERT INTO `task` VALUES (28, '任务名称', '任务描述', '2019-07-24 16:08:10', 1);
INSERT INTO `task` VALUES (29, '任务名称', '任务描述', '2019-07-24 16:09:37', 1);
INSERT INTO `task` VALUES (30, '任务名称', '任务描述', '2019-07-24 16:10:41', 1);
INSERT INTO `task` VALUES (33, '任务名称', '任务描述', '2019-07-24 16:12:02', 1);
INSERT INTO `task` VALUES (35, '任务名称', '任务描述', '2019-07-24 16:18:50', 1);
INSERT INTO `task` VALUES (36, '任务名称', '任务描述', '2019-07-24 16:19:35', 1);
INSERT INTO `task` VALUES (37, '任务名称', '任务描述', '2019-07-24 16:23:58', 1);
INSERT INTO `task` VALUES (38, '任务名称', '任务描述', '2019-07-24 16:24:13', 1);
INSERT INTO `task` VALUES (39, '任务名称', '任务描述', '2019-07-24 17:02:18', 1);
INSERT INTO `task` VALUES (41, '任务名称', '任务描述', '2019-07-24 17:02:42', 1);
INSERT INTO `task` VALUES (42, '任务名称', '任务描述', '2019-07-25 18:01:48', 1);
INSERT INTO `task` VALUES (43, '任务名称', '任务描述', '2019-07-25 18:02:48', 1);
INSERT INTO `task` VALUES (44, '任务名称', '任务描述', '2019-08-14 17:14:36', 2);

SET FOREIGN_KEY_CHECKS = 1;
