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

 Date: 23/07/2019 17:59:42
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
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '', 1, 'layui-icon-set', 1, 1, '2018-11-27 14:52:10', '2018-11-27 15:11:15', 0, NULL, '');
INSERT INTO `sys_menu` VALUES (23, 1, '用户管理', 'views/user/index.html', 2, 'layui-icon-username', 1, 1, '2018-11-27 15:10:32', '2018-12-12 15:39:18', 0, 'user', 'sys:user:list');
INSERT INTO `sys_menu` VALUES (24, 1, '角色管理', 'views/role/index.html', 2, 'layui-icon-face-surprised', 1, 1, '2018-11-27 15:16:59', '2018-12-12 15:40:03', 0, 'role', 'sys:role:list');
INSERT INTO `sys_menu` VALUES (25, 1, '菜单管理', 'views/menu/index.html', 2, 'layui-icon-template', 1, 1, '2018-11-27 15:17:59', '2018-12-12 15:37:35', 0, 'menu', 'sys:menu:list');
INSERT INTO `sys_menu` VALUES (26, 1, '资源管理', 'views/resource/index.html', 2, 'layui-icon-read', 1, 1, '2018-11-27 15:18:31', '2018-12-12 15:35:38', 0, 'resource', 'sys:resource:list');
INSERT INTO `sys_menu` VALUES (27, 26, '刷新资源', '', 3, 'layui-icon-refresh-3', 1, 1, '2018-11-27 15:19:15', '2018-12-12 15:35:14', 0, NULL, 'sys:resource:refresh');
INSERT INTO `sys_menu` VALUES (28, 25, '添加', '', 3, 'layui-icon-add-circle-fine', 1, 1, '2018-11-27 15:20:06', '2018-12-12 15:45:47', 0, NULL, 'sys:menu:add');
INSERT INTO `sys_menu` VALUES (29, 25, '修改', '', 3, 'layui-icon-senior', 1, 1, '2018-11-27 15:20:27', '2018-12-12 15:36:51', 0, NULL, 'sys:menu:edit');
INSERT INTO `sys_menu` VALUES (30, 25, '删除', '', 3, 'layui-icon-close', 1, 1, '2018-11-27 15:21:14', '2018-12-12 15:35:49', 0, NULL, 'sys:menu:delete');
INSERT INTO `sys_menu` VALUES (31, 24, '添加', '', 3, 'layui-icon-add-circle-fine', 1, 1, '2018-11-27 15:20:06', '2018-12-12 15:38:07', 0, NULL, 'sys:role:add');
INSERT INTO `sys_menu` VALUES (32, 24, '修改', '', 3, 'layui-icon-senior', 1, 1, '2018-11-27 15:20:27', '2018-12-12 15:44:19', 0, NULL, 'sys:role:edit');
INSERT INTO `sys_menu` VALUES (33, 24, '删除', '', 3, 'layui-icon-close', 1, 1, '2018-11-27 15:21:14', '2018-12-12 15:36:07', 0, NULL, 'sys:role:delete');
INSERT INTO `sys_menu` VALUES (34, 23, '添加', '', 3, 'layui-icon-add-circle-fine', 1, 1, '2018-11-27 15:20:06', '2018-12-12 15:44:04', 0, NULL, 'sys:user:add');
INSERT INTO `sys_menu` VALUES (35, 23, '修改', '', 3, 'layui-icon-senior', 1, 1, '2018-11-27 15:20:27', '2018-12-12 15:39:36', 0, NULL, 'sys:user:edit');
INSERT INTO `sys_menu` VALUES (36, 23, '重置密码', '', 3, 'layui-icon-fire', 1, 1, '2018-11-27 15:21:14', '2018-12-12 15:38:48', 0, NULL, 'sys:user:resetpwd');
INSERT INTO `sys_menu` VALUES (42, 24, '菜单授权', NULL, 3, 'layui-icon-auz', 1, 1, '2018-12-08 23:58:42', '2018-12-12 15:41:52', 0, NULL, 'sys:role:perm');

-- ----------------------------
-- Table structure for sys_menu_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_resource`;
CREATE TABLE `sys_menu_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单ID',
  `resource_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu_resource
-- ----------------------------
INSERT INTO `sys_menu_resource` VALUES (70, 27, 'f45f1b577d72dcd86b84c6f033682b53');
INSERT INTO `sys_menu_resource` VALUES (71, 26, '829a851334028a6e47b59f8dea0cf7cb');
INSERT INTO `sys_menu_resource` VALUES (72, 30, 'f15f7b01ffe7166b05c3984c9b967837');
INSERT INTO `sys_menu_resource` VALUES (73, 33, '6692d9d95184977f82d3252de2f5eac7');
INSERT INTO `sys_menu_resource` VALUES (74, 29, 'a11e2191656cb199bea1defb17758411');
INSERT INTO `sys_menu_resource` VALUES (75, 29, '6fd51f02b724c137a08c28587f48d7f3');
INSERT INTO `sys_menu_resource` VALUES (76, 29, '2c654f1264fc85ac80516245672f3c47');
INSERT INTO `sys_menu_resource` VALUES (77, 29, 'a5529264d2645996c83bba2e961d0ec3');
INSERT INTO `sys_menu_resource` VALUES (80, 25, '6d1170346960aa8922b9b4d08a5bf71b');
INSERT INTO `sys_menu_resource` VALUES (81, 25, '30218613e987e464b13e0c0b8721aec5');
INSERT INTO `sys_menu_resource` VALUES (83, 31, 'd82de0a17f2c63106f98eb2f88d166e9');
INSERT INTO `sys_menu_resource` VALUES (85, 36, '7baa5b852bc92715d7aa503c0a0d8925');
INSERT INTO `sys_menu_resource` VALUES (87, 23, '579e469e8ac850de1ca0adc54d01acba');
INSERT INTO `sys_menu_resource` VALUES (88, 23, 'b4770c0fe93fce7e829463328c800f20');
INSERT INTO `sys_menu_resource` VALUES (89, 35, '30386fd7b8a4feb9c59861e63537acde');
INSERT INTO `sys_menu_resource` VALUES (90, 35, '8a3b4dc05867f5946235ba5fbc492b76');
INSERT INTO `sys_menu_resource` VALUES (91, 24, '04972e9f8e65b0364d9862687666da36');
INSERT INTO `sys_menu_resource` VALUES (93, 42, 'a826bca352908155da4ca6702edfa2ed');
INSERT INTO `sys_menu_resource` VALUES (94, 42, '30218613e987e464b13e0c0b8721aec5');
INSERT INTO `sys_menu_resource` VALUES (95, 34, 'a71cb59835c613f39bd936deb20cdd27');
INSERT INTO `sys_menu_resource` VALUES (96, 34, 'd9d6f7163b313b950710a637682354d1');
INSERT INTO `sys_menu_resource` VALUES (97, 32, 'eaee955f405f6b96beab5136bfa3e29b');
INSERT INTO `sys_menu_resource` VALUES (98, 32, 'd9d6f7163b313b950710a637682354d1');
INSERT INTO `sys_menu_resource` VALUES (99, 28, '8cb1442c7814f65ce0d796e1ef93c715');
INSERT INTO `sys_menu_resource` VALUES (100, 28, 'a5529264d2645996c83bba2e961d0ec3');
INSERT INTO `sys_menu_resource` VALUES (101, 28, '2c654f1264fc85ac80516245672f3c47');

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
INSERT INTO `sys_resource` VALUES ('04972e9f8e65b0364d9862687666da36', '查询所有角色(分页)', '/roles', 'GET', 3, '2019-07-17 17:08:26', 'GET:/roles');
INSERT INTO `sys_resource` VALUES ('29c4c75326ecf3a82f815c43b0085b2f', '修改账户信息', '/account/info', 'PUT', 1, '2019-07-17 17:08:26', 'PUT:/account/info');
INSERT INTO `sys_resource` VALUES ('2c654f1264fc85ac80516245672f3c47', '查询父级菜单(下拉框)', '/menus/combos', 'GET', 3, '2019-07-17 17:08:26', 'GET:/menus/combos');
INSERT INTO `sys_resource` VALUES ('30218613e987e464b13e0c0b8721aec5', '查询所有菜单', '/menus', 'GET', 3, '2019-07-17 17:08:26', 'GET:/menus');
INSERT INTO `sys_resource` VALUES ('30386fd7b8a4feb9c59861e63537acde', '修改用户', '/users/{id}', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/users/{id}');
INSERT INTO `sys_resource` VALUES ('3ae42391ca3abe20c5cca35f4427cf9c', '获取账户按钮', '/account/buttons/aliases', 'GET', 1, '2019-07-17 17:08:26', 'GET:/account/buttons/aliases');
INSERT INTO `sys_resource` VALUES ('579e469e8ac850de1ca0adc54d01acba', '查询所有用户', '/users', 'GET', 3, '2019-07-17 17:08:26', 'GET:/users');
INSERT INTO `sys_resource` VALUES ('6692d9d95184977f82d3252de2f5eac7', '删除角色', '/roles/{id}', 'DELETE', 3, '2019-07-17 17:08:26', 'DELETE:/roles/{id}');
INSERT INTO `sys_resource` VALUES ('6ab0f8a49671e489f11a1bef2fcaf102', '清除Token', '/account/token', 'DELETE', 1, '2019-07-17 17:08:26', 'DELETE:/account/token');
INSERT INTO `sys_resource` VALUES ('6d1170346960aa8922b9b4d08a5bf71b', '设置菜单状态', '/menus/{id}/status', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/menus/{id}/status');
INSERT INTO `sys_resource` VALUES ('6fd51f02b724c137a08c28587f48d7f3', '查询单个菜单', '/menus/{id}', 'GET', 3, '2019-07-17 17:08:26', 'GET:/menus/{id}');
INSERT INTO `sys_resource` VALUES ('7baa5b852bc92715d7aa503c0a0d8925', '重置用户密码', '/users/{id}/password', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/users/{id}/password');
INSERT INTO `sys_resource` VALUES ('829a851334028a6e47b59f8dea0cf7cb', '查询所有资源(分页)', '/resources', 'GET', 3, '2019-07-17 17:08:26', 'GET:/resources');
INSERT INTO `sys_resource` VALUES ('842e33410b5a97b6c797e4782c97a90e', '获取Token', '/account/token', 'POST', 2, '2019-07-17 17:08:26', 'POST:/account/token');
INSERT INTO `sys_resource` VALUES ('8a3b4dc05867f5946235ba5fbc492b76', '查询单个用户', '/users/{id}', 'GET', 3, '2019-07-17 17:08:26', 'GET:/users/{id}');
INSERT INTO `sys_resource` VALUES ('8cb1442c7814f65ce0d796e1ef93c715', '添加菜单', '/menus', 'POST', 3, '2019-07-17 17:08:26', 'POST:/menus');
INSERT INTO `sys_resource` VALUES ('982803fc834e82cbb2ac1b93f2a47690', '查询单个角色', '/roles/{id}', 'GET', 3, '2019-07-17 17:08:26', 'GET:/roles/{id}');
INSERT INTO `sys_resource` VALUES ('a11e2191656cb199bea1defb17758411', '修改菜单', '/menus/{id}', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/menus/{id}');
INSERT INTO `sys_resource` VALUES ('a5529264d2645996c83bba2e961d0ec3', '查询所有资源', '/resources/resources', 'GET', 3, '2019-07-17 17:08:26', 'GET:/resources/resources');
INSERT INTO `sys_resource` VALUES ('a71cb59835c613f39bd936deb20cdd27', '创建用户', '/users', 'POST', 3, '2019-07-17 17:08:26', 'POST:/users');
INSERT INTO `sys_resource` VALUES ('a826bca352908155da4ca6702edfa2ed', '修改角色菜单', '/roles/{id}/menus', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/roles/{id}/menus');
INSERT INTO `sys_resource` VALUES ('b4770c0fe93fce7e829463328c800f20', '设置用户状态', '/users/{id}/status', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/users/{id}/status');
INSERT INTO `sys_resource` VALUES ('c2db9729dcd4a7d703e45411bb445dfd', '修改密码', '/account/password', 'PUT', 1, '2019-07-17 17:08:26', 'PUT:/account/password');
INSERT INTO `sys_resource` VALUES ('d81bffa6ffd70cc443703820b5a95e8d', '获取账户菜单', '/account/menus', 'GET', 1, '2019-07-17 17:08:26', 'GET:/account/menus');
INSERT INTO `sys_resource` VALUES ('d82de0a17f2c63106f98eb2f88d166e9', '添加角色', '/roles', 'POST', 3, '2019-07-17 17:08:26', 'POST:/roles');
INSERT INTO `sys_resource` VALUES ('d9d6f7163b313b950710a637682354d1', '查询所有角色', '/roles/roles', 'GET', 3, '2019-07-17 17:08:26', 'GET:/roles/roles');
INSERT INTO `sys_resource` VALUES ('e78940daf86b9ac5563d539e8802429c', '获取账户详情', '/account/info', 'GET', 1, '2019-07-17 17:08:26', 'GET:/account/info');
INSERT INTO `sys_resource` VALUES ('eaee955f405f6b96beab5136bfa3e29b', '修改角色', '/roles/{id}', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/roles/{id}');
INSERT INTO `sys_resource` VALUES ('f15f7b01ffe7166b05c3984c9b967837', '删除菜单', '/menus/{id}', 'DELETE', 3, '2019-07-17 17:08:26', 'DELETE:/menus/{id}');
INSERT INTO `sys_resource` VALUES ('f45f1b577d72dcd86b84c6f033682b53', '刷新资源', '/resources', 'PUT', 3, '2019-07-17 17:08:26', 'PUT:/resources');

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 290 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (245, 2, 1);
INSERT INTO `sys_role_menu` VALUES (246, 2, 26);
INSERT INTO `sys_role_menu` VALUES (247, 2, 27);
INSERT INTO `sys_role_menu` VALUES (262, 1, 1);
INSERT INTO `sys_role_menu` VALUES (263, 1, 23);
INSERT INTO `sys_role_menu` VALUES (264, 1, 34);
INSERT INTO `sys_role_menu` VALUES (265, 1, 35);
INSERT INTO `sys_role_menu` VALUES (266, 1, 36);
INSERT INTO `sys_role_menu` VALUES (267, 1, 24);
INSERT INTO `sys_role_menu` VALUES (268, 1, 31);
INSERT INTO `sys_role_menu` VALUES (269, 1, 32);
INSERT INTO `sys_role_menu` VALUES (270, 1, 33);
INSERT INTO `sys_role_menu` VALUES (271, 1, 42);
INSERT INTO `sys_role_menu` VALUES (272, 1, 25);
INSERT INTO `sys_role_menu` VALUES (273, 1, 28);
INSERT INTO `sys_role_menu` VALUES (274, 1, 29);
INSERT INTO `sys_role_menu` VALUES (275, 1, 30);
INSERT INTO `sys_role_menu` VALUES (276, 1, 26);
INSERT INTO `sys_role_menu` VALUES (277, 1, 27);

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'Crown', 'caratacus@qq.com', '13712345678', 0, 1, '2018-11-05 17:19:05', '2019-07-17 17:07:24', 'crown', '$apr1$crown$WQ2TEXVPUJ8l6N6gm0CGv.', '127.0.0.1');
INSERT INTO `sys_user` VALUES (18, 'crown1', '11@qq.com', '13718867899', 0, 1, '2018-11-19 18:56:19', '2018-12-12 15:28:18', 'crown1', '$apr1$crown1$NsepppGmlSjqtwPTlaLb1/', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_user` VALUES (19, 'crown2', '13878929833@163.com', '13878929833', 1, 18, '2018-12-10 15:25:57', '2018-12-10 15:25:57', 'crown2', '$apr1$crown2$R/8LgZ.REDrXB3jlpyglI0', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (24, 18, 2);
INSERT INTO `sys_user_role` VALUES (49, 1, 1);
INSERT INTO `sys_user_role` VALUES (50, 19, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (2, '1', '1', '2019-07-22 11:09:46', 2);
INSERT INTO `task` VALUES (3, '2', '2', '2019-07-22 11:10:41', 1);
INSERT INTO `task` VALUES (4, '3', '3', '2019-07-22 11:12:02', 1);
INSERT INTO `task` VALUES (5, '4', '4', '2019-07-22 11:12:07', 1);
INSERT INTO `task` VALUES (6, '5', '5', '2019-07-22 11:12:12', 1);
INSERT INTO `task` VALUES (7, '6', '6', '2019-07-22 11:12:15', 1);
INSERT INTO `task` VALUES (8, '7', '7', '2019-07-22 11:12:18', 1);
INSERT INTO `task` VALUES (9, '8', '8', '2019-07-22 11:12:20', 1);
INSERT INTO `task` VALUES (10, '9', '9', '2019-07-22 11:12:23', 1);
INSERT INTO `task` VALUES (11, '10', '10', '2019-07-03 11:12:28', 1);
INSERT INTO `task` VALUES (12, '11', '11', '2019-07-22 11:13:59', 1);
INSERT INTO `task` VALUES (13, '12', '12', '2019-07-22 11:17:14', 1);
INSERT INTO `task` VALUES (14, '14', '14', '2019-07-22 14:04:37', 4);
INSERT INTO `task` VALUES (15, '15', '15', '2019-07-22 14:22:32', 1);

SET FOREIGN_KEY_CHECKS = 1;
