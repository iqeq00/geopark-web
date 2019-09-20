/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : zigong

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-09-20 21:32:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for biospecimen
-- ----------------------------
DROP TABLE IF EXISTS `biospecimen`;
CREATE TABLE `biospecimen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `specimennumber` varchar(256) NOT NULL COMMENT '标本编号',
  `specimenname` varchar(256) NOT NULL COMMENT '标本名称',
  `hallnumber` varchar(256) DEFAULT NULL COMMENT '馆内编号',
  `latin` varchar(256) DEFAULT NULL COMMENT '拉丁学名',
  `specimentype` varchar(256) DEFAULT NULL COMMENT '标本类型',
  `collectionposition` varchar(256) DEFAULT NULL COMMENT '采集位置',
  `collectiontime` varchar(256) DEFAULT NULL COMMENT '采集时间',
  `collectionhuman` varchar(256) DEFAULT NULL COMMENT '采集人',
  `collectionnumber` varchar(256) DEFAULT NULL COMMENT '收藏数量',
  `savestate` varchar(256) DEFAULT NULL COMMENT '保存状态',
  `featuredescription` text COMMENT '特征描述',
  `note` text COMMENT '附注',
  `img` text COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='生物标本';

-- ----------------------------
-- Records of biospecimen
-- ----------------------------

-- ----------------------------
-- Table structure for commentary
-- ----------------------------
DROP TABLE IF EXISTS `commentary`;
CREATE TABLE `commentary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) DEFAULT NULL COMMENT '编号',
  `type` varchar(256) DEFAULT NULL COMMENT '类型',
  `position` varchar(256) DEFAULT NULL COMMENT '位置',
  `coordinate` varchar(256) DEFAULT NULL COMMENT '坐标',
  `constructiontime` varchar(256) DEFAULT NULL COMMENT '建设时间',
  `content` text COMMENT '内容',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='标示解说系统';

-- ----------------------------
-- Records of commentary
-- ----------------------------

-- ----------------------------
-- Table structure for displayboard
-- ----------------------------
DROP TABLE IF EXISTS `displayboard`;
CREATE TABLE `displayboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `boardnumber` varchar(256) NOT NULL COMMENT '展板编号',
  `hallname` varchar(256) NOT NULL COMMENT '展厅名称',
  `boardcontent` varchar(256) DEFAULT NULL COMMENT '展板内容',
  `makingtime` varchar(256) DEFAULT NULL COMMENT '制作时间',
  `constructionunit` varchar(256) DEFAULT NULL COMMENT '设计施工单位',
  `contentauther` text COMMENT '内容作者',
  `note` text COMMENT '附注',
  `img` text COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='展板';

-- ----------------------------
-- Records of displayboard
-- ----------------------------

-- ----------------------------
-- Table structure for earthquake
-- ----------------------------
DROP TABLE IF EXISTS `earthquake`;
CREATE TABLE `earthquake` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `disasternumber` varchar(256) DEFAULT NULL COMMENT '灾害点编号',
  `disastername` varchar(256) DEFAULT NULL COMMENT '灾害点名称',
  `type` varchar(256) DEFAULT NULL COMMENT '类型',
  `position` varchar(256) DEFAULT NULL COMMENT '地理位置',
  `coordinate` varchar(256) DEFAULT NULL COMMENT '坐标',
  `scale` varchar(256) DEFAULT NULL COMMENT '规模',
  `stability` varchar(256) DEFAULT NULL COMMENT '稳定性',
  `dangerous` varchar(256) DEFAULT NULL COMMENT '危险性',
  `description` text COMMENT '特征描述',
  `factor` varchar(256) DEFAULT NULL COMMENT '诱发因素',
  `threat` varchar(256) DEFAULT NULL COMMENT '威胁对象',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地灾信息';

-- ----------------------------
-- Records of earthquake
-- ----------------------------

-- ----------------------------
-- Table structure for ecosystem
-- ----------------------------
DROP TABLE IF EXISTS `ecosystem`;
CREATE TABLE `ecosystem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `type` varchar(256) NOT NULL COMMENT '公园地貌类型',
  `averagetempera` varchar(256) DEFAULT NULL COMMENT '公园年平均气温高',
  `toptempera` varchar(256) DEFAULT NULL COMMENT '公园年最高气温',
  `bottomtempera` varchar(256) DEFAULT NULL COMMENT '公园年最低气温',
  `averagerain` text COMMENT '公园年平均降水',
  `plantcover` text COMMENT '植被、绿地',
  `animal` text COMMENT '珍稀动物',
  `plant` text COMMENT '珍稀植物',
  `water` text COMMENT '水资源概况',
  `climate` text COMMENT '气候特征',
  `disaster` text COMMENT '公园内灾害情',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='生态环境状况';

-- ----------------------------
-- Records of ecosystem
-- ----------------------------
INSERT INTO `ecosystem` VALUES ('1', '1', '主要地貌类型有低山、丘陵、坪坝、沟谷 ', '17.8～18.2', '40', '-2.8', '年降水量在 1000～1200 毫米之间，主要集中在夏秋两季，占全年降水量的 80%左右。其中夏季降水量占全年的 56.5%；秋季多阴雨，降水量占全年的 23.1%', '自贡地质公园的植被类型属川东盆地亚热带偏湿性常绿阔叶林，森林以人工松林为主，部分区域有成片针阔混交林。自然植被由亚热带常绿阔叶林、低山常绿针叶林、竹林组成。由于开发历史悠久，原始植被已基本消失，仅在公园范围内的荣县桫椤自然保护区内保存了一片小面积的天然植被。据调查，在公园范围内，有高等植物 77 科 163 属 314种，其中乔木 48 科 129 种，灌木 23 科 79 种，藤本 21 种，竹类 13 种，蕨类 30 种，草本42 种。国家重点保护的野生植物有桫椤、银杏、楠木、油樟、香樟、苏铁、红豆树、厚朴、任豆、红椿、川黄檗、水杉等 18 种。 ', '自贡地质公园内野生动物资源丰富，其中脊椎动物有 5 纲 23 目 58 科 145种。哺乳纲有 3 目 8 科 22 种，如貉、黄鼬、大灵猫、小灵猫等。鸟纲 11 目 27 科 75 种，如巷鹭、绿头鸭、鸢等。爬行纲 3 目 6 科 11 种，有蹼壁虎、北草蜥、赤练蛇等。鱼纲 5 目 14科 31 种，有白鲟、翘嘴江鲵等。两栖纲 1 目 3 科 6 种，有大蟾蜍、泽蛙等。无脊椎动物有环节动物、软体动物、节肢动物甲壳类、蛛类和昆虫类等。其中，野生动物以蛇、蛙、鸟类等的野生动物种群数量居多，主要分布在森林较多的丘陵地区。', '无', '自贡地质公园地面水主要由江水补给，河流发育，形成径流汇入沱江和岷江，均属长江水系。多年平均径流深度为 404 毫米，正常年径流量 17.18 亿立方米。径流年内分配为：11 月至次年 3 月为枯水期，4 月和 10 月为平水期，5 月至 9 月为丰水期。枯水期和平水期水含量占全年总水量的 20%。 ', '无', '无', '无');

-- ----------------------------
-- Table structure for exchangeexhibition
-- ----------------------------
DROP TABLE IF EXISTS `exchangeexhibition`;
CREATE TABLE `exchangeexhibition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `position` varchar(256) NOT NULL COMMENT '地点',
  `time` varchar(256) NOT NULL COMMENT '时间',
  `exhibitionobject` text COMMENT '互展对象',
  `exhibitioncontent` text COMMENT '互展内容',
  `exhibitionhuman` varchar(256) NOT NULL COMMENT '主要互展人员',
  `note` text COMMENT '备注',
  `img` text COMMENT '照片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='交流互展';

-- ----------------------------
-- Records of exchangeexhibition
-- ----------------------------
INSERT INTO `exchangeexhibition` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '15674831259661.jpg', '2019-09-03 10:54:57', '2019-09-03 11:58:53', null);
INSERT INTO `exchangeexhibition` VALUES ('2', '1', '发动机拉克丝积分', '2018-06-12', '发撒打发', '范德萨', '放大算法', '', '15674913075601.jpg', '2019-09-03 14:15:11', '2019-09-03 14:15:11', null);
INSERT INTO `exchangeexhibition` VALUES ('3', '2', '1', '1', '1', '1', '1', '1', '156758325476647.jpg,156758326266948.jpg,156758327323349.jpg,15676460641770.jpg,15676460641770.jpg,', '2019-09-04 15:48:08', '2019-09-05 09:14:37', null);
INSERT INTO `exchangeexhibition` VALUES ('4', '1', '1', '1', '1', '1', '1', '1', 'http://www.geopark.com/exchange/156775219319614.jpg,http://www.geopark.com/exchange/156775220986116.jpg,http://www.geopark.com/exchange/156775220985415.jpg,http://www.geopark.com/exchange/156775236896817.jpg,http://www.geopark.com/exchange/156775236900418.jpg,http://www.geopark.com/exchange/156775237561419.jpg', '2019-09-06 14:52:24', '2019-09-06 14:52:55', null);

-- ----------------------------
-- Table structure for fincestat
-- ----------------------------
DROP TABLE IF EXISTS `fincestat`;
CREATE TABLE `fincestat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `time` varchar(256) DEFAULT NULL COMMENT '时间',
  `income` double(15,2) DEFAULT NULL COMMENT '收入',
  `incomesource` text COMMENT '收入来源说明',
  `expenditure` double(15,2) DEFAULT NULL COMMENT '支出',
  `expenditureproject` text COMMENT '支出项目说明',
  `balance` double(15,2) DEFAULT NULL COMMENT '结余',
  `balancematter` text COMMENT '结余情况说明',
  `note` text COMMENT '备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='财务统计';

-- ----------------------------
-- Records of fincestat
-- ----------------------------

-- ----------------------------
-- Table structure for geolandscape
-- ----------------------------
DROP TABLE IF EXISTS `geolandscape`;
CREATE TABLE `geolandscape` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `unitenumber` varchar(256) NOT NULL COMMENT '地质遗迹统一编号',
  `originalnumber` varchar(256) NOT NULL COMMENT '原编号',
  `gname` varchar(256) DEFAULT NULL COMMENT '地质遗迹名称',
  `originalname` varchar(256) DEFAULT NULL COMMENT '地质遗迹原名称',
  `type` varchar(256) DEFAULT NULL COMMENT '地质遗迹类型',
  `position` varchar(256) DEFAULT NULL COMMENT '地质遗迹地理位置',
  `traffic` varchar(256) DEFAULT NULL COMMENT '地质遗迹交通状况',
  `lat` double(12,2) DEFAULT NULL COMMENT '经度',
  `lng` double(12,2) DEFAULT NULL COMMENT '纬度',
  `altitude` varchar(256) DEFAULT NULL COMMENT '海拔高度',
  `background` varchar(256) DEFAULT NULL COMMENT '地质遗迹地质背景',
  `feature` text COMMENT '地质遗迹特征',
  `evaluation` varchar(256) DEFAULT NULL COMMENT '评价级别',
  `protection` varchar(256) DEFAULT NULL COMMENT '保护级别',
  `value` varchar(256) DEFAULT NULL COMMENT '观赏价值',
  `causes` varchar(256) DEFAULT NULL COMMENT '遗迹成因类型',
  `note` varchar(256) DEFAULT NULL COMMENT '备注',
  `img` text COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地质遗迹景观';

-- ----------------------------
-- Records of geolandscape
-- ----------------------------
INSERT INTO `geolandscape` VALUES ('1', '1', '无', '无', '威远河风景河段', '无', '风景河段', '大安区新民镇詹家村', '发撒打发', '104.75', '29.44', '无', '无', '位于大安区新民镇詹家村，东经104°44′45.11″，北纬29°26′16.78″。河流蜿蜒曲折，从258°方向流来，在350m的范围内发生近180°拐弯，延247°方向流去。河水清澈，水质良好，水深2-6m，河底可见大量砾石，直径约10-60cm，水中不时可见鱼群。河两岸为沙溪庙组二段（J2s2）黄灰色块状砂岩。河水最终汇入釜溪河，河水滋润了两岸人民，两岸农作物茂盛，渔民常在河边捕鱼，借助这有利地势，在此修建两个大坝，已工作90余年，为防洪灌溉作出了重要贡献。', '省级以下', '省级以下', '无', '水体景观大类', '威远河风景河段', '/images/geolandscape/15689743704800.jpg');
INSERT INTO `geolandscape` VALUES ('2', '1', 'ZG1004', 'ZG1004', '范家湾层型剖面', '无', '地方性标准剖面', '大安区新民乡柏杨村', '无', '104.76', '29.42', '无', '无', '该剖面位于大安区新民乡柏杨村，东经104°45′21.22″，北纬29°25′24.47″。岩性为沙溪庙组二段（J2s2）黄灰色厚块状砂岩与紫红色泥岩互层，黄灰色砂岩发育平行层理，单层厚度可达4m，岩石发育竖直节理，地貌上形成陡壁，紫红色泥岩破碎，剖面上可见厚度3.5m，其中夹数层黄灰色粉砂岩与砂岩，夹层厚约10-23cm，夹层与泥岩界面混杂，界面凹凸不平，局部甚至弯曲严重，夹层延伸一定长度后尖灭。', '无', '省级以下', '无', '地质剖面', '范家湾层型剖面', '/images/geolandscape/15689756050762.jpg,/images/geolandscape/15689756050761.jpg');

-- ----------------------------
-- Table structure for geological
-- ----------------------------
DROP TABLE IF EXISTS `geological`;
CREATE TABLE `geological` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `position` text COMMENT '大地构造位置',
  `stratum` text COMMENT '地层',
  `magmatic` text COMMENT '岩浆岩',
  `metamorphic` text COMMENT '变质岩',
  `geostructure` text COMMENT '地质构造',
  `mineral` text COMMENT '矿产',
  `evolutionary` text COMMENT '地质发展演化',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地质背景';

-- ----------------------------
-- Records of geological
-- ----------------------------
INSERT INTO `geological` VALUES ('1', '1', '', '公园所在区域出露地层为中生界和新生界。其中：三叠系下、中统及上统普遍遭受不同程度剥蚀或沉积缺失；上侏罗统上部广泛被剥蚀；下白垩统部分有缺失；新近系和下更新统全部沉积缺失。\n公园出露最老的地层为三叠系，包括下统嘉陵江组，中统雷口坡组及上统须家河组。侏罗系在区内分布最广，自下而上有下统自流井组（包括珍珠冲段、东岳庙段、马鞍山段、大安寨段），中统新田沟组、沙溪庙组，上统遂宁组、蓬莱镇组。白垩系仅出露在南西一带，下统窝头山组，上统三合组。新生界有始新统的柳嘉组和第四系，柳嘉组残存于宜宾柳嘉镇一带；第四系主要分布于长江及其支流沿岸。公园内主要的含盐矿地层为三叠系嘉陵江组和雷口坡组；主要的恐龙化石赋存地层为沙溪庙组。\n（一）三叠系（T）\n三叠系主要分布于公园北侧，由一套海相碳酸盐岩与陆相的碎屑岩及含煤层系组成。\n（1）下三叠统：岩石地层为嘉陵江组（T1j），可划分为4个岩性段，总厚314.6～614.5m。\n一段（T1j1）：浅灰色中－薄层状灰岩，偶夹暗紫、浅黄色钙质页岩，西南部夹岩屑凝灰岩。该组含岩盐、卤水和天然气等矿产。厚106～158m。\n二段（T1j2）：绿黄、暗紫色页岩夹少许灰岩，西南部夹少量粉砂岩。厚51～75m。\n三段（T1j3）：灰色中－薄层状灰岩，白云质灰岩，局部夹生物碎屑灰岩。厚100～120m。\n四段（T1j4）：浅灰色中层状白云岩夹角砾状白云岩。富产膏盐，是区内岩盐、黑卤的重要含矿层位。与上覆雷口坡组（T2l）底部“绿豆岩”呈整合接触，但厚度变化较大，厚76～200m。\n其中一、三段以灰岩为主，二、四段以白云岩、岩溶角砾岩为主。二、四段，尤以四段中富产膏盐，是区内岩盐、黑卤的重要含矿层位。\n（2）中三叠统：岩石地层为雷口坡组（T2l），可划分为4个岩性段，总厚0～288m。\n一段（T2l1）：灰色薄－中厚层状含泥质白云岩夹紫红、黄绿、黑色白云质泥岩，其底为灰绿色“绿豆岩”，夹膏岩层。厚37～55m。该段底部的“绿豆岩”是区内嘉陵江组与雷口坡组区分的良好标志层，K2O含量6.25～8.72%。\n二段（T2l2）：黄色薄层状泥质白云岩夹黄绿、紫红色粉砂岩，夹膏岩层。厚70～110m。\n三段（T2l3）：灰色中－薄层状灰岩，白云岩，局部夹白云质灰岩。厚319m。\n四段（T2l4）：灰色厚层状含泥质白云岩。厚57～76m。与上覆须家河组呈假整合接触。\n本组中一、三段的碳酸盐岩中产黑卤水，属沉积变质卤水。\n（3）上三叠统：岩石地层为须家河组（T3xj）。本组岩性、厚度均变化较大。砂岩及裂隙中含淋滤变质卤水，为黄卤。该组还含有煤层。沉积环境为河湖、沼泽相。厚532～764m。\n须家河组一段（T3xj1）\n灰－灰黑色泥岩、灰质页岩含煤线夹中层或块状长石石英砂岩。产：Pterophyllumptilim，Neocalamitescarrerei，Otozamites sp.，Taeniopterisrhizomoides，Toditesdenticulata；Darwinulapraecipua；Modiolus cf. frugi；Anyuanestheria? sp.等。厚434.6～ 512.8m。\n须家河组二段（T3xj2）\n灰黄、浅灰色块状细粒长石石英砂岩，及灰、灰黑色泥岩、炭质页岩、煤线或煤层及菱铁矿，底部砂岩含菱铁矿结核。产：Podozamitessp.，Equisetum cf. sarrani；Darwinula sp.；Unionites? sp.等。厚19.2～272.4m。与上覆侏罗系自流井组珍珠冲段底部呈整合接触。\n（二）侏罗系（J）\n公园内侏罗系发育较齐全，分布广泛，为一套陆相红色碎屑岩，厚1212.8～3436.4m。自下而上分为下-中统自流井组，中统新田沟组、沙溪庙组；上统遂宁组、蓬莱镇组。\n（1）下-中侏罗统：岩石地层为自流井组（J1-2z），岩相、岩性稳定，化石丰富，属浅水湖相沉积。厚146.4～383.2m，整合覆于须家河组之上，可分为珍珠冲段、东岳庙段、马鞍山段、大安寨段四个岩性段。\n珍珠冲段（J1-2zz）：为一套杂色泥岩、粉砂岩，向上逐渐递变为暗紫色、紫红色泥岩、砂质泥岩夹灰色、灰绿色薄层或透镜状细粒长石石英砂岩。厚59.5～121.5m。\n东岳庙段（J1-2zdy）：由灰、深灰、绿灰色薄－中厚层状介壳灰岩、泥质灰岩、粉砂岩、微粒石英砂岩和介屑微粒砂岩组成，夹紫红色泥岩。厚4.3～10.7m，由南往北厚度加大，介壳灰岩层数有所增加，化石含量和种类增多。产Lepidotessp.，Ceratodus sp.及蛇颈龙类等脊椎动物化石。\n马鞍山段（J1-2zm）：岩性变化不大，以紫红色泥岩为主，夹少量黄灰色、黄绿色粉砂岩、细－微粒石英砂岩和岩屑石英砂岩，厚82.1～145m。本段产有瓣腮类、脊椎动物化石等。\n大安寨段（J1-2zd）：紫红色、暗紫红色泥岩、深灰色、灰白色中层石灰岩及浅绿色、浅黄色薄层状泥灰岩互层，偶夹灰白色薄层石灰质白云岩，厚0～44.2m。泥岩具钙质网纹，灰岩富含瓣腮类化石。上覆新田沟组（J2x）呈假整合接触。\n（2）中侏罗统：\n新田沟组（J2xt）：本组岩性为一套灰黄、黄灰色中层至块状中细粒石英砂岩夹杂色泥页岩，偶见黄色砂岩，底具砾岩。厚度0～40m。与上覆沙溪庙组一段（J2s1）呈假整合接触。\n沙溪庙组（J2s）分为二段。\n沙溪庙组一段（J2s1）：为一套暗紫色、紫红色泥岩夹2～3层灰、黄灰色厚层块状中细粒长石石英砂岩或岩屑长石砂岩。区内厚度109.3～215.4m，顶部以“叶肢介页岩”与上覆上沙溪庙组呈整合接触。该组泥岩比较稳定，砂岩有一定的变化，常夹砂岩透镜体，盛产脊椎动物化石。著名的大山铺蜀龙动物群即产于该组下部砂岩层中。\n沙溪庙组二段（J2s2）：暗紫色、紫红色泥岩与黄绿色、黄紫色长石石英砂岩不等厚互层，组成9～16个沉积韵律，每个韵律变化都很大。区内厚度665.3～872.4,。砂岩中交错层理发育，底面常见冲刷构造和泥砾、砾石等河床滞留沉积物。与上覆遂宁组（J3sn）整合接触。该组产Mamenchisaurus，Yangchuanosaurus、Szechuanosaurus，Stegosaurus，Plesiosaur。\n（3）上侏罗统\n遂宁组（J3sn）：该组岩性以鲜红色、棕红色钙质泥岩为主，夹少量灰白色、灰绿色粉细粒钙质石英砂岩，由下而上颜色变暗。砂岩层厚薄不一，偶夹薄层泥灰岩及钙质透镜体。厚192～253.4m。与上覆蓬莱镇组（J3p）整合接触。该组产介形类、叶肢介类化石。\n蓬莱镇组（J3p）：岩性为泥岩、砂质泥岩、长石石英砂岩，厚度140～350m。可进一步划分为两段。\n蓬莱镇组一段（J3p1）\n由红色泥岩组成，夹中－薄层状长石石英砂岩。底部偶见透镜状砂砾岩。顶部灰色、灰绿色页岩的“仓山页岩”为区域性标志层。厚140～260.4m。\n蓬莱镇组二段（J3p2）\n为棕红色钙质泥岩与长石石英砂岩组成不等厚互层。厚0～102.2m。与上覆下白垩统窝头山组（K1w）呈假整合接触。\n（三）白垩系（K）\n区内白垩系主要分布于南西部，为砖红色泥岩，划分为下统窝头山组，上统三合组。\n（1）下白垩统\n窝头山组（K1w）分为二段。\n窝头山组一段（K1w1）：砖红色厚层块状铁泥质不等粒长石石英砂岩，底为含砾砂岩或砾岩扁豆体，下部夹少许泥岩，顶为厚2～5m砖红色泥岩。与上覆二段呈整合接触。厚100.3～209.1m。\n窝头山组二段（K1w2）：砖红色块状—巨块状不等粒泥质长石砂岩。普遍具大型斜层理及平行层理，局部夹少许泥岩透镜体。与下伏窝头山组一段呈整合接触。厚100.3～209.1m。\n（2）上白垩统\n三合组（K2s）分为二段。\n三合组一段（K2s1）：砖红色薄-厚层不等粒泥质岩屑长石砂岩与泥岩不等厚互层。有时泥岩呈透镜体，偶见膨润土化。含较丰富的古生物化石，主要有瓣鳃、介形、轮藻等。厚161.1～197.3m。与上下地层均呈整合接触。\n三合组二段（K2s2）：砖红色厚层块状细粒岩屑长石砂岩、长石粉砂岩夹少许泥岩及泥岩透镜体。产丰富的介形类化石。与下伏三合组一段呈整合接触。厚503m。\n（四）古近系（E）\n柳嘉组（E1-2lj）：浅砖红色巨块状中粒泥钙质长石石英砂岩，巨型斜层理发育，顶部夹泥岩。与下伏三合组二段整合接触。厚＞88m。\n（五）第四系（Q）\n区内河流阶地出露范围狭小，主要发育于河流凸岸，呈长轴平行于河谷的串珠状。一般发育阶地3-4级，除Ⅰ级阶地属上叠阶地外，其它皆属基座阶地，并与下伏前第四系呈不整合接触，区内河流阶地堆积物均属流水冲积成因。一般各级阶地堆积物从下往上均具有河床相砾石层-河漫滩相砂泥层的二元结构，其厚度与河流大小呈正比关系，主要河流（岷江）阶地堆积物的厚度较大，一般8～15m，最厚达22m；次要河流（涪江、沱江）的厚度较小，一般3～8m，最大15m。区内第四系除缺失下更新统外，有中更新统（Q2al）、上更新统（Q3al）、全新统Ⅰ级阶地（Q41+2al）、全新统现代河漫滩（Q43al）。\n', '', '', '', '', '');

-- ----------------------------
-- Table structure for geospecimen
-- ----------------------------
DROP TABLE IF EXISTS `geospecimen`;
CREATE TABLE `geospecimen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `specimennumber` varchar(256) DEFAULT NULL COMMENT '标本编号',
  `specimenname` varchar(256) DEFAULT NULL COMMENT '标本名称',
  `fieldnumber` varchar(256) DEFAULT NULL COMMENT '野外编号',
  `hallnumber` varchar(256) DEFAULT NULL COMMENT '馆内编号',
  `englishlatin` varchar(256) DEFAULT NULL COMMENT '英文或拉丁学名',
  `specimentype` varchar(256) DEFAULT NULL COMMENT '标本类型',
  `collectionposition` varchar(256) DEFAULT NULL COMMENT '采集位置',
  `collectiontime` varchar(256) DEFAULT NULL COMMENT '采集时间',
  `collectionhuman` varchar(256) DEFAULT NULL COMMENT '采集人',
  `identificationhuman` varchar(256) DEFAULT NULL COMMENT '鉴定人',
  `collectionnumber` varchar(256) DEFAULT NULL COMMENT '收藏数量',
  `savestate` varchar(256) DEFAULT NULL COMMENT '保存状态',
  `featuredescription` text COMMENT '特征描述',
  `note` text COMMENT '备注',
  `img` text COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地质标本';

-- ----------------------------
-- Records of geospecimen
-- ----------------------------
INSERT INTO `geospecimen` VALUES ('1', '1', 'fkjdsakljf', '富士达', 'fas', '范德萨', 'fdsfsdf', 'fdsafdas', 'fdsaffer', '2018-06-03', '范德萨', '富士达', '254', '法撒旦', '发生的纷纷热风', '范德萨额', 'http://www.geopark.com/production/15677565882520.jpg');

-- ----------------------------
-- Table structure for gueststat
-- ----------------------------
DROP TABLE IF EXISTS `gueststat`;
CREATE TABLE `gueststat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `time` varchar(256) DEFAULT NULL COMMENT '时间',
  `touristsnumber` double(15,6) DEFAULT NULL COMMENT '游客人数 单位',
  `touristssource` text COMMENT '游客来源',
  `note` text COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='游客统计';

-- ----------------------------
-- Records of gueststat
-- ----------------------------
INSERT INTO `gueststat` VALUES ('1', '1', '2012', '63.400000', '无', '1', '2019-09-20 15:41:43', '2019-09-20 17:58:21', null);
INSERT INTO `gueststat` VALUES ('2', '1', '2013', '64.900000', '无', '', '2019-09-20 17:58:58', '2019-09-20 17:59:05', null);
INSERT INTO `gueststat` VALUES ('3', '1', '2014', '88.800000', '无', '', '2019-09-20 17:59:27', '2019-09-20 17:59:27', null);
INSERT INTO `gueststat` VALUES ('4', '1', '2015', '302.800000', '无', '', '2019-09-20 17:59:49', '2019-09-20 17:59:49', null);

-- ----------------------------
-- Table structure for humanlandscape
-- ----------------------------
DROP TABLE IF EXISTS `humanlandscape`;
CREATE TABLE `humanlandscape` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `humanitnumber` varchar(256) NOT NULL COMMENT '人文景观编号',
  `hname` varchar(256) DEFAULT NULL COMMENT '景观名称',
  `position` varchar(256) DEFAULT NULL COMMENT '地理位置',
  `traffic` varchar(256) DEFAULT NULL COMMENT '交通状况',
  `lat` double(12,2) DEFAULT NULL COMMENT '经度',
  `lng` double(12,2) DEFAULT NULL COMMENT '纬度',
  `altitude` varchar(256) DEFAULT NULL COMMENT '海拔高度',
  `feature` text COMMENT '景观特色',
  `level` varchar(256) DEFAULT NULL COMMENT '文物保护单位',
  `approvedtime` varchar(256) DEFAULT NULL COMMENT '批准时间',
  `status` text COMMENT '保护现状',
  `img` text COMMENT '照片',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='人文景观';

-- ----------------------------
-- Records of humanlandscape
-- ----------------------------
INSERT INTO `humanlandscape` VALUES ('1', '1', 'ZG1008', '青龙水库', '大安区大山铺镇和团结镇之间', '无', '104.83', '29.42', '无', '位于自贡市东北部，大安区大山铺镇和团结镇之间，东经104°49′51.87″，北纬29°25′27.83″。建于1954年，占地4km2，集雨面积10多平方公里，库容面积600多亩，库容水量206万立方米。整个水库大体呈“U”字型，水库水质清澈，水库两岸长着成片浮萍，清风吹过水面泛起点点涟漪。这里的生态环境良好，可以看见野鸭和白鹭，每当阳光洒下湖面和周围的动植物形成独特而美丽的画卷，是一处休闲娱乐的好去处。', '', '无', '无', '/images/humanlandscape/15689758846393.jpg', null, null, null);

-- ----------------------------
-- Table structure for humenexhibit
-- ----------------------------
DROP TABLE IF EXISTS `humenexhibit`;
CREATE TABLE `humenexhibit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `specimennumber` varchar(256) NOT NULL COMMENT '标本编号',
  `specimenname` varchar(256) NOT NULL COMMENT '标本名称',
  `hallnumber` varchar(256) DEFAULT NULL COMMENT '馆内编号',
  `specimentype` varchar(256) DEFAULT NULL COMMENT '标本类型',
  `specimensource` varchar(256) DEFAULT NULL COMMENT '标本来源',
  `collectionnumber` varchar(256) DEFAULT NULL COMMENT '收藏数量',
  `savestate` varchar(256) DEFAULT NULL COMMENT '保存状态',
  `featuredescription` text COMMENT '特征描述',
  `note` text COMMENT '附注',
  `img` text COMMENT '照片',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='人文展品';

-- ----------------------------
-- Records of humenexhibit
-- ----------------------------

-- ----------------------------
-- Table structure for legal
-- ----------------------------
DROP TABLE IF EXISTS `legal`;
CREATE TABLE `legal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) NOT NULL COMMENT '文件编号',
  `filename` varchar(256) NOT NULL COMMENT '文件名称',
  `publishtime` varchar(256) NOT NULL COMMENT '发布时间',
  `unit` varchar(256) DEFAULT NULL COMMENT '发布单位',
  `time` varchar(256) DEFAULT NULL COMMENT '规划期限',
  `keyword` varchar(256) DEFAULT NULL COMMENT '关键字',
  `summary` varchar(256) DEFAULT NULL COMMENT '摘要',
  `note` text COMMENT '备注',
  `url` text COMMENT '存储地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公园管理法律法规';

-- ----------------------------
-- Records of legal
-- ----------------------------
INSERT INTO `legal` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1111', '/files/legal/15689712045831.jpg,/files/legal/15689712080282.png');

-- ----------------------------
-- Table structure for managementagency
-- ----------------------------
DROP TABLE IF EXISTS `managementagency`;
CREATE TABLE `managementagency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `managename` varchar(256) DEFAULT NULL COMMENT '管理机构（科室）名称',
  `level` varchar(256) DEFAULT NULL COMMENT '管理机构级别',
  `maincharge` varchar(256) DEFAULT NULL COMMENT '主要负责人姓名',
  `secondarycharge` varchar(256) DEFAULT NULL COMMENT '次要负责人姓名',
  `job` varchar(256) DEFAULT NULL COMMENT '负责人职务',
  `number` varchar(256) DEFAULT NULL COMMENT '管理机构设置人数',
  `list` varchar(256) DEFAULT NULL COMMENT '机构工作人员',
  `responsibility` varchar(256) DEFAULT NULL COMMENT '机构职责与分工',
  `phone` varchar(256) DEFAULT NULL COMMENT '负责人联系电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理机构';

-- ----------------------------
-- Records of managementagency
-- ----------------------------
INSERT INTO `managementagency` VALUES ('1', '1', '管理处', '无', '陶宏', '王文伟', '管理处主任', '4', '陶宏、王文伟、孙莉、王玲玲', '保护地质遗迹资源，开发地学科普教育，推动旅游经济发展；负责地质公园建设管理，地质遗迹保护、利用，组织开展地质公园研究、考察、科学普及、宣传教育等活动', '无');
INSERT INTO `managementagency` VALUES ('2', '1', '盐业历史博物馆', '无', '程龙刚', '无', '副馆长', '16', '', '22', '无');
INSERT INTO `managementagency` VALUES ('3', '1', '恐龙馆', '无', '李健', '无', '馆长', '30', null, '无', '无');
INSERT INTO `managementagency` VALUES ('4', '1', '燊海井', '无', '无', '无', '无', '0', null, '', '无');

-- ----------------------------
-- Table structure for manageperson
-- ----------------------------
DROP TABLE IF EXISTS `manageperson`;
CREATE TABLE `manageperson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `management_id` int(10) NOT NULL COMMENT '管理机构ID',
  `name` varchar(256) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(256) DEFAULT NULL COMMENT '性别',
  `nation` varchar(256) DEFAULT NULL COMMENT '民族',
  `birth` varchar(256) DEFAULT NULL COMMENT '出生年月',
  `college` varchar(256) DEFAULT NULL COMMENT '毕业院校',
  `subject` varchar(256) DEFAULT NULL COMMENT '专业',
  `degree` varchar(256) DEFAULT NULL COMMENT '学历学位',
  `position` varchar(256) DEFAULT NULL COMMENT '职务职称',
  `job` varchar(256) DEFAULT NULL COMMENT '工作内容',
  `img` text COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理人员';

-- ----------------------------
-- Records of manageperson
-- ----------------------------
INSERT INTO `manageperson` VALUES ('1', '1', '陶宏', '男', '汉族', '1963.11', '四川省教育学院', '化学教育', '无', '副研究员', '地质公园管理', '/images/geolandscape/15689650367790.jpg');
INSERT INTO `manageperson` VALUES ('2', '1', '王文伟', '男', '汉族', '1983.04', '成都理工大学', '第四纪地质学', '硕士研究生', '文博馆员', '地质公园管理', '/images/geolandscape/15689651894001.jpg');
INSERT INTO `manageperson` VALUES ('3', '1', '孙莉', '女', '汉族', '1983.09', '中国地质大学（北京）', '自然地理学', '硕士研究生', '业务科长、文博馆员', '公园管理、遗迹保护及评价、环境教育', '/images/geolandscape/15689672480172.jpg');

-- ----------------------------
-- Table structure for mineralright
-- ----------------------------
DROP TABLE IF EXISTS `mineralright`;
CREATE TABLE `mineralright` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) NOT NULL COMMENT '编号',
  `type` varchar(256) DEFAULT NULL COMMENT '类型',
  `license` varchar(256) DEFAULT NULL COMMENT '许可证号',
  `mineralhumanname` varchar(256) DEFAULT NULL COMMENT '矿权人名称',
  `mineralname` varchar(256) DEFAULT NULL COMMENT '矿权名称',
  `mineralspecies` varchar(256) DEFAULT NULL COMMENT '主要矿种',
  `position` varchar(256) DEFAULT NULL COMMENT '位置',
  `area` varchar(256) DEFAULT NULL COMMENT '面积',
  `lat` double(12,2) DEFAULT NULL COMMENT '经度',
  `lng` double(12,2) DEFAULT NULL COMMENT '纬度',
  `validity` varchar(256) DEFAULT NULL COMMENT '有效期',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='矿权设置情况';

-- ----------------------------
-- Records of mineralright
-- ----------------------------
INSERT INTO `mineralright` VALUES ('2', '1', 'k1', '矿井', 'fdsag34234213fdsa', '幅度萨芬', '发色认为', '飞洒发', '盐井', '5平方公里', '36.25', '115.36', '2010-12-10', '1.范德萨打发撒旦萨芬         \n2.幅度萨芬发生的第三方\n3.附近的卢卡斯金佛i啊');

-- ----------------------------
-- Table structure for museum
-- ----------------------------
DROP TABLE IF EXISTS `museum`;
CREATE TABLE `museum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `museumname` varchar(256) DEFAULT NULL COMMENT '博物馆名称',
  `area` varchar(256) DEFAULT NULL COMMENT '面积',
  `buildtime` varchar(256) DEFAULT NULL COMMENT '建馆时间',
  `museummechanism` varchar(256) DEFAULT NULL COMMENT '博物馆管理机构设置',
  `museumpartition` text COMMENT '博物馆分区与布展情况',
  `exhibitsoverview` text COMMENT '馆藏展品概况',
  `position` varchar(256) DEFAULT NULL COMMENT '地址',
  `contact` varchar(256) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(256) DEFAULT NULL COMMENT 'E-MAIL',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='博物馆基本情况';

-- ----------------------------
-- Records of museum
-- ----------------------------

-- ----------------------------
-- Table structure for naturallandscape
-- ----------------------------
DROP TABLE IF EXISTS `naturallandscape`;
CREATE TABLE `naturallandscape` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `naturalnumber` varchar(256) NOT NULL COMMENT '自然景观编号',
  `nname` varchar(256) DEFAULT NULL COMMENT '景观名称',
  `position` varchar(256) DEFAULT NULL COMMENT '地理位置',
  `traffic` varchar(256) DEFAULT NULL COMMENT '交通状况',
  `lat` double(12,2) DEFAULT NULL COMMENT '经度',
  `lng` double(12,2) DEFAULT NULL COMMENT '纬度',
  `altitude` varchar(256) DEFAULT NULL COMMENT '海拔高度',
  `feature` text COMMENT '景观特色',
  `level` varchar(256) DEFAULT NULL COMMENT '文物保护单位',
  `approvedtime` varchar(256) DEFAULT NULL COMMENT '批准时间',
  `status` text COMMENT '保护现状',
  `img` text COMMENT '照片',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='自然景观';

-- ----------------------------
-- Records of naturallandscape
-- ----------------------------
INSERT INTO `naturallandscape` VALUES ('1', '1', 'ZG1016', '尖山风景区', '', '', null, null, '', '', '', '无', '', '', null, null, null);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_locale` varchar(1) DEFAULT NULL COMMENT '本地文章',
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `lettername` varchar(256) DEFAULT NULL COMMENT '通讯稿名称',
  `releasetime` varchar(256) NOT NULL COMMENT '发布时间',
  `auther` varchar(256) DEFAULT NULL COMMENT '作者',
  `content` text COMMENT '正文',
  `releasewebsite` varchar(256) DEFAULT NULL COMMENT '发布的网站',
  `contentsummary` text COMMENT '内容摘要',
  `note` varchar(256) DEFAULT NULL COMMENT '备注',
  `deleted_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='新闻通讯';

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for overlapping
-- ----------------------------
DROP TABLE IF EXISTS `overlapping`;
CREATE TABLE `overlapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `othername` varchar(256) DEFAULT NULL COMMENT '其他景区名称',
  `othertype` varchar(256) DEFAULT NULL COMMENT '其他景区类型',
  `othersupervisor` varchar(256) DEFAULT NULL COMMENT '其他景区主管部门',
  `othermatter` text COMMENT '其他景区开发建设情况',
  `overposition` varchar(256) DEFAULT NULL COMMENT '重叠区域位置',
  `overarea` varchar(256) DEFAULT NULL COMMENT '重叠区域面积',
  `overinstruction` text COMMENT '重叠区管理情况说明',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='与其他景区重叠情况';

-- ----------------------------
-- Records of overlapping
-- ----------------------------

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(12) NOT NULL COMMENT '编码',
  `name` varchar(191) NOT NULL COMMENT '名称',
  `rank` varchar(191) DEFAULT NULL COMMENT '级别',
  `position` varchar(191) DEFAULT NULL COMMENT '位置',
  `district` varchar(191) DEFAULT NULL COMMENT '行政区',
  `zip` varchar(6) DEFAULT NULL COMMENT '邮政编码',
  `lng` varchar(191) DEFAULT NULL COMMENT '经度',
  `lat` varchar(191) DEFAULT NULL COMMENT '纬度',
  `area` varchar(191) DEFAULT NULL COMMENT '面积',
  `type` varchar(191) DEFAULT NULL COMMENT '公园类型',
  `divide` text COMMENT '保护区划分情况',
  `create_date` varchar(191) DEFAULT NULL COMMENT '建立时间',
  `characteristic` text COMMENT '公园地质遗迹景观特色',
  `significance` text COMMENT '重要意义',
  `ratifier` varchar(191) DEFAULT NULL COMMENT '批准单位',
  `status_quo` text COMMENT '保护现状',
  `historical_type` text COMMENT '主要地质遗迹类型',
  `master_department` varchar(191) DEFAULT NULL COMMENT '公园主管部门',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公园概况';

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES ('1', '1', '自贡联合国教科文组织世界地质公园', 'AAAAA', '四川省自贡市', '自贡', '456122', '无', '无', '1630.46km2', '地质遗迹', '保护区总面积约361.03km2，占调查区面积约40.15%。', '2001年3月', '自贡', '自贡', '国土资源部', null, null, '自贡管理局', null, null, null);

-- ----------------------------
-- Table structure for parkinfo
-- ----------------------------
DROP TABLE IF EXISTS `parkinfo`;
CREATE TABLE `parkinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `org_code` varchar(50) NOT NULL COMMENT '组织机构代码',
  `legal_person` varchar(50) NOT NULL COMMENT '法人代表',
  `tenure` varchar(256) DEFAULT NULL COMMENT '在任年限',
  `security_supervisor` varchar(256) DEFAULT NULL COMMENT '公园安全责任人',
  `mobile` varchar(256) DEFAULT NULL COMMENT '安全责任人联',
  `staffer` varchar(256) DEFAULT NULL COMMENT '在编职工',
  `website` varchar(256) DEFAULT NULL COMMENT '公园网站地址',
  `contact` varchar(256) DEFAULT NULL COMMENT '公园联系电话',
  `fax` varchar(256) DEFAULT NULL COMMENT '传真',
  `supervisor` varchar(256) DEFAULT NULL COMMENT '上级主管',
  `fund_provider` varchar(256) DEFAULT NULL COMMENT '经费来源',
  `mail` varchar(256) DEFAULT NULL COMMENT '邮箱',
  `remark` text COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公园信息管理';

-- ----------------------------
-- Records of parkinfo
-- ----------------------------
INSERT INTO `parkinfo` VALUES ('1', '1', '12510200560713156T', '陶宏', '', '孙莉', '+86-0979-8421539', '', 'https://www.ziggeopark.com/', '+86-0979-8421539', '9998564', '中华人民共和国自然资源部', '财政补助收支统管、全额保障', 'ziggeopark@foxmail.com ', '自贡市自流井区解放路安全巷63号 643000', '2019-08-29 14:52:38', '2019-09-20 15:15:17', null);

-- ----------------------------
-- Table structure for parklibrary
-- ----------------------------
DROP TABLE IF EXISTS `parklibrary`;
CREATE TABLE `parklibrary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(50) DEFAULT NULL COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `birth` varchar(50) DEFAULT NULL COMMENT '出生年月',
  `subject_direction` varchar(256) DEFAULT NULL COMMENT '学科方向',
  `relationship` varchar(256) DEFAULT NULL COMMENT '聘用关系',
  `img` text COMMENT '照片',
  `remark` text COMMENT '备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公园专家库与导游库';

-- ----------------------------
-- Records of parklibrary
-- ----------------------------
INSERT INTO `parklibrary` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '/images/parklibrary/15689861279750.jpg', '22', null, null, null);

-- ----------------------------
-- Table structure for parkmeeting
-- ----------------------------
DROP TABLE IF EXISTS `parkmeeting`;
CREATE TABLE `parkmeeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `title` varchar(256) NOT NULL COMMENT '会议名称',
  `address` varchar(256) DEFAULT NULL COMMENT '地点',
  `start_at` varchar(256) DEFAULT NULL COMMENT '时间',
  `delegate` varchar(256) DEFAULT NULL COMMENT '参会代表',
  `img` text COMMENT '照片',
  `remark` text COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地质公园会议';

-- ----------------------------
-- Records of parkmeeting
-- ----------------------------
INSERT INTO `parkmeeting` VALUES ('1', '1', '11', '11', '11', '11', 'http://www.geopark.com/parkmeeting/15686235457172.jpg,http://www.geopark.com/parkmeeting/15686235511483.jpg', '11', '2019-09-16 16:45:59', '2019-09-16 16:45:59', null);

-- ----------------------------
-- Table structure for parkoption
-- ----------------------------
DROP TABLE IF EXISTS `parkoption`;
CREATE TABLE `parkoption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `project` varchar(256) DEFAULT NULL COMMENT '项目名称',
  `client` varchar(256) DEFAULT NULL COMMENT '委托方',
  `fund_provider` varchar(256) DEFAULT NULL COMMENT '资金来源',
  `actualizer` varchar(256) DEFAULT NULL COMMENT '项目实施单位',
  `amount` double(15,2) NOT NULL COMMENT '项目合同金额',
  `cycle` varchar(256) DEFAULT NULL COMMENT '项目周期',
  `man` varchar(256) DEFAULT NULL COMMENT '项目负责姓名',
  `contact` varchar(256) DEFAULT NULL COMMENT '项目负责联系',
  `progress` varchar(256) DEFAULT NULL COMMENT '项目进度情况',
  `pay` varchar(256) DEFAULT NULL COMMENT '付款情况',
  `remark` text COMMENT '备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公园项目管理';

-- ----------------------------
-- Records of parkoption
-- ----------------------------

-- ----------------------------
-- Table structure for parkrelation
-- ----------------------------
DROP TABLE IF EXISTS `parkrelation`;
CREATE TABLE `parkrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `park_name` varchar(256) NOT NULL COMMENT '姊妹公园名称',
  `address` varchar(256) DEFAULT NULL COMMENT '地点',
  `conclusion_at` varchar(256) DEFAULT NULL COMMENT '缔结时间',
  `delegate` varchar(256) DEFAULT NULL COMMENT '双方代表',
  `remark` text COMMENT '备注',
  `img` text COMMENT '照片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='缔结姊妹公园';

-- ----------------------------
-- Records of parkrelation
-- ----------------------------
INSERT INTO `parkrelation` VALUES ('1', '1', '111', '111', '111', '111', '1111', 'http://www.geopark.com/parkrelation/15686248370360.jpg', null, '2019-09-16 17:10:21', null);

-- ----------------------------
-- Table structure for parktopic
-- ----------------------------
DROP TABLE IF EXISTS `parktopic`;
CREATE TABLE `parktopic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `reportnumber` varchar(256) NOT NULL COMMENT '报告编号',
  `reportname` varchar(256) DEFAULT NULL COMMENT '报告名称',
  `achievementtype` varchar(256) DEFAULT NULL COMMENT '成果类型',
  `auther` varchar(256) DEFAULT NULL COMMENT '作者',
  `carrytime` varchar(256) DEFAULT NULL COMMENT '完成时间',
  `carryunit` varchar(256) DEFAULT NULL COMMENT '完成单位',
  `organizer` varchar(256) DEFAULT NULL COMMENT '主管单位',
  `theme` varchar(256) DEFAULT NULL COMMENT '主题词',
  `achievementsummary` text COMMENT '成果摘要',
  `parkcollect` text COMMENT '公园收藏情况',
  `note` text COMMENT '备注',
  `img` text COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公园专题研究';

-- ----------------------------
-- Records of parktopic
-- ----------------------------
INSERT INTO `parktopic` VALUES ('1', '1', '023465467', '放大发', '放大算法撒地方', '幅度萨芬', '热尔为', '飞洒地方撒旦', '范德萨', '发撒打发是', '范德萨热舞日前', '范德萨发生er', 'er发射点发生妨到', null);

-- ----------------------------
-- Table structure for picdocs
-- ----------------------------
DROP TABLE IF EXISTS `picdocs`;
CREATE TABLE `picdocs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) NOT NULL COMMENT '文件编号',
  `docname` varchar(256) NOT NULL COMMENT '文件名称',
  `publishtime` varchar(256) NOT NULL COMMENT '发布时间',
  `unit` varchar(256) DEFAULT NULL COMMENT '发布单位',
  `url` text COMMENT '存储地址',
  `note` text COMMENT '文件描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文件资料';

-- ----------------------------
-- Records of picdocs
-- ----------------------------
INSERT INTO `picdocs` VALUES ('1', '1', '11', '11', '11', '11', '/images/picdocs/15689640464980.jpg,/images/picdocs/15689640608942.jpg', '1111');

-- ----------------------------
-- Table structure for planning
-- ----------------------------
DROP TABLE IF EXISTS `planning`;
CREATE TABLE `planning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) NOT NULL COMMENT '文件编号',
  `filename` varchar(256) NOT NULL COMMENT '文件名称',
  `publishtime` varchar(256) NOT NULL COMMENT '发布时间',
  `unit` varchar(256) DEFAULT NULL COMMENT '发布单位',
  `time` varchar(256) DEFAULT NULL COMMENT '规划期限',
  `keyword` varchar(256) DEFAULT NULL COMMENT '关键字',
  `summary` varchar(256) DEFAULT NULL COMMENT '摘要',
  `url` text COMMENT '文件地址',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公园规划';

-- ----------------------------
-- Records of planning
-- ----------------------------
INSERT INTO `planning` VALUES ('1', '1', '11', '11', '11', null, '11', '11', '11', '/files/planning/156896048333312.txt', '111');

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '公园ID',
  `promotionname` varchar(256) DEFAULT NULL COMMENT '推介会名称',
  `position` varchar(256) DEFAULT NULL COMMENT '地点',
  `time` varchar(256) DEFAULT NULL COMMENT '时间',
  `representative` varchar(256) DEFAULT NULL COMMENT '参加代表',
  `promotioncontent` text COMMENT '推介内容',
  `note` text COMMENT '备注',
  `img` text COMMENT '照片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品推介';

-- ----------------------------
-- Records of production
-- ----------------------------
INSERT INTO `production` VALUES ('12', '1', '1', '1', '1', '1', '<img src=\"/images/production/15687961926702.jpg\" alt=\"QQ截图20190902163816.jpg\">', '', '/images/production/15687961784440.jpg,/images/production/15687961837111.jpg', '2019-09-18 16:43:19', '2019-09-18 16:43:19', null);
INSERT INTO `production` VALUES ('13', '1', '22', '22', '222', '22', '<img src=\"/images/production/15687984858151.jpg\" alt=\"1567475456952_WY4Ry2LBS3sWw9b5MzL5e14g.png\">', '22', '/images/production/15687984806260.jpg', '2019-09-18 17:21:41', '2019-09-18 17:21:41', null);

-- ----------------------------
-- Table structure for researchpaper
-- ----------------------------
DROP TABLE IF EXISTS `researchpaper`;
CREATE TABLE `researchpaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `achievementnumber` varchar(256) DEFAULT NULL COMMENT '成果编号',
  `papernumber` varchar(256) DEFAULT NULL COMMENT '论文编号',
  `author` varchar(256) DEFAULT NULL COMMENT '作者',
  `year` varchar(50) DEFAULT NULL COMMENT '年份',
  `heading` varchar(256) DEFAULT NULL COMMENT '名称',
  `periodical` varchar(256) DEFAULT NULL COMMENT '期刊',
  `volume` varchar(256) DEFAULT NULL COMMENT '卷期',
  `pagenumber` varchar(256) DEFAULT NULL COMMENT '页码',
  `summary` text COMMENT '摘要',
  `collect` varchar(256) DEFAULT NULL COMMENT '收集情况',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='相关科研论文';

-- ----------------------------
-- Records of researchpaper
-- ----------------------------

-- ----------------------------
-- Table structure for sampling
-- ----------------------------
DROP TABLE IF EXISTS `sampling`;
CREATE TABLE `sampling` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `samplenumber` varchar(256) DEFAULT NULL COMMENT '样品编号',
  `sampletype` varchar(256) DEFAULT NULL COMMENT '样品类型',
  `sampleposition` varchar(256) DEFAULT NULL COMMENT '采样位置',
  `coordinate` varchar(256) DEFAULT NULL COMMENT '坐标',
  `code` varchar(256) DEFAULT NULL COMMENT '地质代号',
  `research` varchar(256) DEFAULT NULL COMMENT '野外定名',
  `achievement` text COMMENT '测试成果',
  `note` text COMMENT '备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='采样信息';

-- ----------------------------
-- Records of sampling
-- ----------------------------

-- ----------------------------
-- Table structure for scienceactivity
-- ----------------------------
DROP TABLE IF EXISTS `scienceactivity`;
CREATE TABLE `scienceactivity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `activityname` varchar(256) DEFAULT NULL COMMENT '活动名称',
  `time` varchar(256) DEFAULT NULL COMMENT '时间',
  `position` varchar(256) DEFAULT NULL COMMENT '地点',
  `scienceobject` varchar(256) DEFAULT NULL COMMENT '科普对象',
  `sciencecontent` varchar(256) DEFAULT NULL COMMENT '科普内容',
  `sciencestaff` varchar(256) DEFAULT NULL COMMENT '科普工作人员',
  `note` text COMMENT '备注',
  `img` text COMMENT '照片',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='科普活动';

-- ----------------------------
-- Records of scienceactivity
-- ----------------------------

-- ----------------------------
-- Table structure for sciencework
-- ----------------------------
DROP TABLE IF EXISTS `sciencework`;
CREATE TABLE `sciencework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园编号',
  `itemnumber` varchar(256) NOT NULL COMMENT '作品编号',
  `scienceitem` varchar(256) DEFAULT NULL COMMENT '科普作品名称',
  `masses` varchar(256) DEFAULT NULL COMMENT '受众群体',
  `auther` varchar(256) DEFAULT NULL COMMENT '作者',
  `carrytime` varchar(256) DEFAULT NULL COMMENT '完成时间',
  `carryunit` varchar(256) DEFAULT NULL COMMENT '完成单位',
  `publishing` varchar(256) DEFAULT NULL COMMENT '是否出版',
  `note` text COMMENT '备注',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='科普作品';

-- ----------------------------
-- Records of sciencework
-- ----------------------------

-- ----------------------------
-- Table structure for socialeconomy
-- ----------------------------
DROP TABLE IF EXISTS `socialeconomy`;
CREATE TABLE `socialeconomy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL,
  `ethnic` varchar(256) NOT NULL COMMENT '公园内人口民族情况',
  `areaethnic` varchar(256) DEFAULT NULL COMMENT '公园所在区域人口民族情况',
  `economic` varchar(256) DEFAULT NULL COMMENT '公园内经济发展情况',
  `areaeconomic` varchar(256) DEFAULT NULL COMMENT '公园所在区域',
  `develop` varchar(256) DEFAULT NULL COMMENT '经济发展情况公园对于社区及区域经济可持续发展的贡献情况',
  `note` text COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='社会经济概况';

-- ----------------------------
-- Records of socialeconomy
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_name` varchar(32) NOT NULL COMMENT '菜单名称',
  `path` varchar(64) DEFAULT NULL COMMENT '路径',
  `menu_type` smallint(2) NOT NULL COMMENT '类型:0:目录,1:菜单,2:按钮',
  `icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `create_uid` int(11) NOT NULL COMMENT '创建者ID',
  `update_uid` int(11) NOT NULL COMMENT '修改者ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` smallint(2) NOT NULL COMMENT '状态 0：禁用 1：正常',
  `router` varchar(64) DEFAULT NULL COMMENT '路由',
  `alias` varchar(64) DEFAULT NULL COMMENT '别名',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', '', '1', 'layui-icon-set', '1', '1', '2019-08-22 16:35:28', '2019-09-20 16:46:54', '0', '', '', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', 'user.html', '2', 'layui-icon-user', '1', '1', '2019-08-22 16:49:14', '2019-09-20 16:47:13', '0', 'user', 'sys:user:page', '1');
INSERT INTO `sys_menu` VALUES ('3', '2', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-08-22 16:53:54', '2019-09-16 16:44:47', '0', '', 'sys:user:add', '0');
INSERT INTO `sys_menu` VALUES ('4', '2', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-08-22 16:56:41', '2019-09-16 16:44:57', '0', '', 'sys:user:edit', '0');
INSERT INTO `sys_menu` VALUES ('5', '2', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-08-22 16:58:46', '2019-08-22 17:08:27', '0', '', 'sys:user:delete', '0');
INSERT INTO `sys_menu` VALUES ('6', '2', '重置密码', '', '3', 'layui-icon-password', '1', '1', '2019-08-22 17:10:37', '2019-08-22 17:10:37', '0', '', 'sys:user:password', '0');
INSERT INTO `sys_menu` VALUES ('7', '1', '角色管理', 'role.html', '2', 'layui-icon-face-surprised', '1', '1', '2019-08-22 17:20:57', '2019-09-20 16:42:18', '0', 'role', 'sys:role:page', '0');
INSERT INTO `sys_menu` VALUES ('8', '7', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-08-22 17:25:47', '2019-08-22 17:25:47', '0', '', 'sys:role:add', '0');
INSERT INTO `sys_menu` VALUES ('9', '7', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-08-22 17:26:20', '2019-08-22 17:26:20', '0', '', 'sys:role:edit', '0');
INSERT INTO `sys_menu` VALUES ('10', '7', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-08-22 17:26:55', '2019-08-22 17:26:55', '0', '', 'sys:role:delete', '0');
INSERT INTO `sys_menu` VALUES ('11', '7', '授权', '', '3', 'layui-icon-auz', '1', '1', '2019-08-22 17:31:15', '2019-08-22 17:31:15', '0', '', 'sys:role:authority', '0');
INSERT INTO `sys_menu` VALUES ('12', '1', '菜单管理', 'menu.html', '2', 'layui-icon-template', '1', '1', '2019-08-22 17:35:34', '2019-09-20 16:47:41', '0', 'menu', 'sys:menu:list', '3');
INSERT INTO `sys_menu` VALUES ('13', '12', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-08-22 17:37:47', '2019-08-22 17:39:06', '0', '', 'sys:menu:add', '0');
INSERT INTO `sys_menu` VALUES ('14', '12', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-08-22 17:41:04', '2019-08-23 14:11:19', '0', '', 'sys:menu:edit', '0');
INSERT INTO `sys_menu` VALUES ('15', '12', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-08-22 17:42:04', '2019-08-22 17:42:04', '0', '', 'sys:menu:delete', '0');
INSERT INTO `sys_menu` VALUES ('16', '1', '资源管理', 'resource.html', '2', 'layui-icon-read', '1', '1', '2019-08-22 17:44:23', '2019-09-20 16:47:50', '0', 'resource', 'sys:resource:page', '4');
INSERT INTO `sys_menu` VALUES ('17', '16', '刷新', '', '3', 'layui-icon-refresh', '1', '1', '2019-08-22 17:46:10', '2019-08-22 17:46:10', '0', '', 'sys:resource:refresh', '0');
INSERT INTO `sys_menu` VALUES ('18', '1', '任务管理', 'task.html', '2', 'layui-icon-flag', '1', '1', '2019-08-23 10:15:08', '2019-09-20 18:54:48', '1', 'task', 'sys:task:page', '5');
INSERT INTO `sys_menu` VALUES ('19', '18', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-08-23 10:16:23', '2019-09-20 18:54:49', '1', '', 'sys:task:add', '0');
INSERT INTO `sys_menu` VALUES ('20', '18', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-08-23 10:17:21', '2019-09-20 18:54:50', '1', '', 'sys:task:edit', '0');
INSERT INTO `sys_menu` VALUES ('21', '18', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-08-23 10:17:56', '2019-09-20 18:54:51', '1', '', 'sys:task:delete', '0');
INSERT INTO `sys_menu` VALUES ('22', '0', '地质公园管理', '', '1', 'layui-icon-layouts', '1', '1', '2019-08-26 15:48:30', '2019-09-20 16:49:56', '0', '', '', '2');
INSERT INTO `sys_menu` VALUES ('23', '22', '地质公园基本情况', 'baseInfo-park.html', '2', 'layui-icon-home', '1', '1', '2019-08-26 15:58:48', '2019-09-20 17:50:32', '0', 'baseInfo-park', 'park:page', '1');
INSERT INTO `sys_menu` VALUES ('24', '22', '公园环境状况', 'baseInfo-ecosystem.html', '2', 'layui-icon-water', '1', '1', '2019-08-27 17:03:00', '2019-09-20 16:49:17', '0', 'ecosystem', 'ecosystem:page', '7');
INSERT INTO `sys_menu` VALUES ('25', '31', '公园区域地质背景', 'baseInfo-geological.html', '2', 'layui-icon-picture-fine', '1', '1', '2019-08-27 17:07:04', '2019-09-20 16:51:00', '0', 'geological', 'geological:page', '1');
INSERT INTO `sys_menu` VALUES ('26', '22', '社会经济状况', 'baseInfo-socialeconomy.html', '2', '', '1', '1', '2019-08-27 17:08:24', '2019-09-20 16:59:55', '1', 'socialeconomy', 'socialeconomy:page', '0');
INSERT INTO `sys_menu` VALUES ('27', '0', '矿权管理', '', '1', 'layui-icon-util', '1', '1', '2019-08-28 14:37:21', '2019-09-20 16:57:34', '1', '', '', '0');
INSERT INTO `sys_menu` VALUES ('28', '27', '矿权信息管理', 'base-mineralright.html', '2', '', '1', '1', '2019-08-28 14:40:45', '2019-08-28 14:40:45', '0', 'mineralright', 'mineralright:page', '0');
INSERT INTO `sys_menu` VALUES ('29', '0', '科研研究与学术交流数据', '', '1', 'layui-icon-read', '1', '1', '2019-08-28 16:05:06', '2019-09-20 16:57:23', '0', '', '', '5');
INSERT INTO `sys_menu` VALUES ('30', '0', '博物馆展数据', '', '1', 'layui-icon-template', '1', '1', '2019-08-29 10:06:26', '2019-09-20 16:54:57', '0', '', '', '4');
INSERT INTO `sys_menu` VALUES ('31', '0', '地质公园地质遗迹数据', '', '1', 'layui-icon-component', '1', '1', '2019-08-29 10:07:19', '2019-09-20 16:53:45', '0', '', '', '3');
INSERT INTO `sys_menu` VALUES ('32', '22', '地质公园管理现状', 'pkmanage-parkinfo.html', '2', 'layui-icon-website', '1', '1', '2019-08-29 11:55:39', '2019-09-20 17:50:47', '0', 'pkmanage-parkinfo', 'parkinfo:page', '2');
INSERT INTO `sys_menu` VALUES ('33', '32', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-08-29 11:56:56', '2019-08-29 14:43:04', '0', '', 'parkinfo:add', '0');
INSERT INTO `sys_menu` VALUES ('34', '32', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-08-29 11:57:29', '2019-08-29 15:28:32', '0', '', 'parkinfo:edit', '0');
INSERT INTO `sys_menu` VALUES ('35', '32', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-08-29 11:58:07', '2019-08-29 11:58:07', '0', '', 'parkinfo:delete', '0');
INSERT INTO `sys_menu` VALUES ('36', '29', '相关科研论文', 'science-researchpaper.html', '2', '', '1', '1', '2019-08-29 13:41:32', '2019-09-20 16:56:50', '0', 'researchpaper', 'researchpaper:page', '1');
INSERT INTO `sys_menu` VALUES ('37', '29', '公园专题研究', 'science-parktopic.html', '2', '', '1', '1', '2019-08-29 15:57:48', '2019-09-20 16:56:56', '0', 'parktopic', 'parktopic:page', '2');
INSERT INTO `sys_menu` VALUES ('38', '29', '科普活动', 'science-scienceactivity.html', '2', '', '1', '1', '2019-08-29 17:09:43', '2019-09-20 16:57:03', '0', 'scienceactivity', 'scienceactivity:page', '3');
INSERT INTO `sys_menu` VALUES ('39', '29', '科普作品', 'science-sciencework.html', '2', '', '1', '1', '2019-08-29 17:46:20', '2019-09-20 16:57:09', '0', 'sciencework', 'sciencework:page', '4');
INSERT INTO `sys_menu` VALUES ('40', '0', '交流活动管理', '', '1', 'layui-icon-water', '1', '1', '2019-09-02 10:41:53', '2019-09-20 16:57:41', '1', '', '', '0');
INSERT INTO `sys_menu` VALUES ('41', '40', '交流互展', 'data-exchangeexhibition.html', '2', 'layui-icon-top', '1', '1', '2019-09-02 10:44:04', '2019-09-20 16:57:43', '1', 'exchangeexhibition', 'exchangeexhibition:page', '0');
INSERT INTO `sys_menu` VALUES ('42', '41', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-09-02 10:45:45', '2019-09-20 16:57:44', '1', '', 'exchangeexhibition:add', '0');
INSERT INTO `sys_menu` VALUES ('43', '41', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-09-02 10:48:35', '2019-09-20 16:57:44', '1', '', 'exchangeexhibition:edit', '0');
INSERT INTO `sys_menu` VALUES ('44', '41', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-09-02 10:49:28', '2019-09-20 16:57:45', '1', '', 'exchangeexhibition:delete', '0');
INSERT INTO `sys_menu` VALUES ('45', '29', '专家与导游库', 'science-parklibrary.html', '2', '', '1', '1', '2019-09-02 12:38:40', '2019-09-20 16:55:48', '0', 'parklibrary', 'parklibrary:page', '5');
INSERT INTO `sys_menu` VALUES ('46', '30', '博物馆基本情况', 'museum-baseInfo.html', '2', '', '1', '1', '2019-09-02 16:58:10', '2019-09-20 16:54:23', '0', 'museum-baseInfo', 'museum:page', '1');
INSERT INTO `sys_menu` VALUES ('47', '30', '地质标本', 'museum-geospecimen.html', '2', '', '1', '1', '2019-09-02 16:59:25', '2019-09-20 16:54:31', '0', 'geospecimen', 'geospecimen:page', '2');
INSERT INTO `sys_menu` VALUES ('48', '30', '生物标本', 'museum-biospecimen.html', '2', '', '1', '1', '2019-09-02 17:00:13', '2019-09-20 16:54:37', '0', 'biospecimen', 'biospecimen:page', '3');
INSERT INTO `sys_menu` VALUES ('49', '30', '人文展品', 'museum-humenexhibit.html', '2', '', '1', '1', '2019-09-02 17:01:41', '2019-09-20 16:54:46', '0', 'humenexhibit', 'humenexhibit:page', '4');
INSERT INTO `sys_menu` VALUES ('50', '30', '展板', 'museum-displayboard.html', '2', '', '1', '1', '2019-09-02 17:02:30', '2019-09-20 16:54:51', '0', 'displayboard', 'displayboard:page', '5');
INSERT INTO `sys_menu` VALUES ('51', '22', '管理机构基本情况', 'pkmanage-managementagency.html', '2', '', '1', '1', '2019-09-03 17:20:39', '2019-09-20 16:48:42', '0', 'managementagency', 'managementagency:page', '3');
INSERT INTO `sys_menu` VALUES ('52', '22', '公园相关法规文件', 'pkmanage-legal.html', '2', '', '1', '1', '2019-09-03 17:41:11', '2019-09-20 16:49:02', '0', 'legal', 'legal:page', '5');
INSERT INTO `sys_menu` VALUES ('53', '31', '公园地质遗迹景点', 'pkmanage-geolandscape.html', '2', '', '1', '1', '2019-09-04 16:56:43', '2019-09-20 16:51:34', '0', 'geolandscape', 'geolandscape:page', '2');
INSERT INTO `sys_menu` VALUES ('54', '31', '地质公园内人文景观', 'pkmanage-humanlandscape.html', '2', '', '1', '1', '2019-09-04 16:57:42', '2019-09-20 16:52:02', '0', 'humanlandscape', 'humanlandscape:page', '3');
INSERT INTO `sys_menu` VALUES ('55', '31', '地质灾害信息', 'pkmanage-earthquake.html', '2', '', '1', '1', '2019-09-04 16:58:56', '2019-09-20 16:52:53', '0', 'earthquake', 'earthquake:page', '5');
INSERT INTO `sys_menu` VALUES ('56', '31', '与其他景区重叠情况', 'pkmanage-overlapping.html', '2', '', '1', '1', '2019-09-04 17:00:27', '2019-09-20 17:05:09', '1', 'overlapping', 'overlapping:page', '0');
INSERT INTO `sys_menu` VALUES ('57', '31', '标示解说系统', 'pkmanage-commentary.html', '2', '', '1', '1', '2019-09-04 17:01:24', '2019-09-20 17:04:51', '1', 'commentary', 'commentary:page', '0');
INSERT INTO `sys_menu` VALUES ('58', '31', '采样信息', 'pkmanage-sampling.html', '2', '', '1', '1', '2019-09-04 17:02:28', '2019-09-20 16:53:03', '0', 'sampling', 'sampling:page', '6');
INSERT INTO `sys_menu` VALUES ('59', '40', '产品推介', 'data-production.html', '2', 'layui-icon-cart-simple', '1', '1', '2019-09-04 17:18:02', '2019-09-20 16:57:46', '1', 'production', 'production:page', '0');
INSERT INTO `sys_menu` VALUES ('60', '59', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-09-04 17:42:49', '2019-09-20 16:57:46', '1', '', 'production:add', '0');
INSERT INTO `sys_menu` VALUES ('61', '59', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-09-04 17:43:35', '2019-09-20 16:57:47', '1', '', 'production:edit', '0');
INSERT INTO `sys_menu` VALUES ('62', '59', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-09-04 17:44:07', '2019-09-20 16:57:47', '1', '', 'production:delete', '0');
INSERT INTO `sys_menu` VALUES ('63', '40', '会议管理', 'data-parkmeeting.html', '2', 'layui-icon-home', '1', '1', '2019-09-16 16:11:05', '2019-09-20 16:57:50', '1', 'parkmeeting', 'parkmeeting:page', '0');
INSERT INTO `sys_menu` VALUES ('64', '63', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-09-16 16:16:48', '2019-09-20 16:57:51', '1', '', 'parkmeeting:add', '0');
INSERT INTO `sys_menu` VALUES ('65', '63', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-09-16 16:17:40', '2019-09-20 16:57:51', '1', '', 'parkmeeting:edit', '0');
INSERT INTO `sys_menu` VALUES ('66', '63', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-09-16 16:18:11', '2019-09-20 16:57:51', '1', '', 'parkmeeting:delete', '0');
INSERT INTO `sys_menu` VALUES ('67', '40', '缔结姊妹公园', 'data-parkrelation.html', '2', 'layui-icon-login-wechat', '1', '1', '2019-09-16 17:04:06', '2019-09-20 16:57:52', '1', 'parkrelation', 'parkrelation:page', '0');
INSERT INTO `sys_menu` VALUES ('68', '67', '添加', '', '3', 'layui-icon-add-circle-fine', '1', '1', '2019-09-16 17:05:12', '2019-09-20 16:57:54', '1', '', 'parkrelation:add', '0');
INSERT INTO `sys_menu` VALUES ('69', '67', '编辑', '', '3', 'layui-icon-edit', '1', '1', '2019-09-16 17:05:57', '2019-09-20 16:57:54', '1', '', 'parkrelation:edit', '0');
INSERT INTO `sys_menu` VALUES ('70', '67', '删除', '', '3', 'layui-icon-delete', '1', '1', '2019-09-16 17:06:33', '2019-09-20 16:57:55', '1', '', 'parkrelation:delete', '0');
INSERT INTO `sys_menu` VALUES ('71', '22', '管理机构人员', 'pkmanage-manageperson.html', '2', '', '1', '1', '2019-09-18 10:22:08', '2019-09-20 16:48:51', '0', 'manageperson', 'manageperson:page', '4');
INSERT INTO `sys_menu` VALUES ('72', '31', '地质公园内自然景观', 'pkmanage-naturallandscape.html', '2', '', '1', '1', '2019-09-19 15:55:46', '2019-09-20 16:52:30', '0', 'naturallandscape', 'naturallandscape:page', '4');
INSERT INTO `sys_menu` VALUES ('73', '22', '公园规划概况', 'pkmanage-planning.html', '2', 'layui-icon-unlink', '1', '1', '2019-09-20 10:09:01', '2019-09-20 16:49:09', '0', 'planning', 'planning:page', '6');
INSERT INTO `sys_menu` VALUES ('74', '0', '影（音）像制品数据', '', '1', 'layui-icon-file', '1', '1', '2019-09-20 14:53:30', '2019-09-20 16:58:40', '0', '', '', '6');
INSERT INTO `sys_menu` VALUES ('75', '74', '其他图片资料', 'file-picdocs.html', '2', 'layui-icon-picture-fine', '1', '1', '2019-09-20 14:55:47', '2019-09-20 16:59:02', '0', 'picdocs', 'picdocs:page', '2');
INSERT INTO `sys_menu` VALUES ('76', '74', '公园相关影像资料', 'file-vediodocs.html', '2', 'layui-icon-camera', '1', '1', '2019-09-20 15:12:57', '2019-09-20 16:59:20', '0', 'vediodocs', 'vediodocs:page', '1');
INSERT INTO `sys_menu` VALUES ('77', '22', '公园游客统计', 'pkmanage-gueststat.html', '2', 'layui-icon-username', '1', '1', '2019-09-20 15:41:17', '2019-09-20 16:49:27', '0', 'gueststat', 'gueststat:page', '8');

-- ----------------------------
-- Table structure for sys_menu_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_resource`;
CREATE TABLE `sys_menu_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  `resource_id` varchar(32) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=442 DEFAULT CHARSET=utf8mb4 COMMENT='菜单资源关系表';

-- ----------------------------
-- Records of sys_menu_resource
-- ----------------------------
INSERT INTO `sys_menu_resource` VALUES ('5', '5', '3dca30c2118ff6158ffa88191003128e');
INSERT INTO `sys_menu_resource` VALUES ('6', '6', 'd245ace645ea40e898178ee13c24297f');
INSERT INTO `sys_menu_resource` VALUES ('8', '8', '46a5d7a79e6ba91e6709f3361a2edd81');
INSERT INTO `sys_menu_resource` VALUES ('9', '9', 'b7b1c22076c0d28c8d0fe4c0b09b6a6e');
INSERT INTO `sys_menu_resource` VALUES ('10', '10', 'ddf4e3fd39264da50eec54cfd02731f4');
INSERT INTO `sys_menu_resource` VALUES ('11', '11', '24bf74d47e8322146e38f0c68333f90c');
INSERT INTO `sys_menu_resource` VALUES ('12', '11', 'f880f8a35613b38182612a061291f8a5');
INSERT INTO `sys_menu_resource` VALUES ('15', '13', '3a62355efcfa84646b390d508efea9b6');
INSERT INTO `sys_menu_resource` VALUES ('16', '13', 'd83a249e0e0ed84806ecba2fd8c7148d');
INSERT INTO `sys_menu_resource` VALUES ('17', '13', 'd8544217f479cfb39559e4b94f413aaa');
INSERT INTO `sys_menu_resource` VALUES ('21', '15', '15da52a5f4f4a6eac3b0d6f046f040c9');
INSERT INTO `sys_menu_resource` VALUES ('23', '17', '7025c7532d2a58d3de4dde7c66d363f3');
INSERT INTO `sys_menu_resource` VALUES ('25', '19', '9141e80baac708a8863498ff7a41d276');
INSERT INTO `sys_menu_resource` VALUES ('26', '20', '1adec59980b460bb8db5198953608b87');
INSERT INTO `sys_menu_resource` VALUES ('27', '21', '71d5f2e10db38eaebdaa44fa89cb1163');
INSERT INTO `sys_menu_resource` VALUES ('28', '14', '37687195b63b44e0d22436080de117bc');
INSERT INTO `sys_menu_resource` VALUES ('29', '14', 'd83a249e0e0ed84806ecba2fd8c7148d');
INSERT INTO `sys_menu_resource` VALUES ('30', '14', 'd8544217f479cfb39559e4b94f413aaa');
INSERT INTO `sys_menu_resource` VALUES ('31', '14', '375edb54e85dc981c8df62c76f3782ed');
INSERT INTO `sys_menu_resource` VALUES ('63', '26', 'fdbe8e0f7ae93c33c165fdbc68fdb719');
INSERT INTO `sys_menu_resource` VALUES ('64', '26', 'd4dcfc78a6b0f5f84ede3740b391825f');
INSERT INTO `sys_menu_resource` VALUES ('65', '26', '0584acbf717e9848bfbd5cb2e149754a');
INSERT INTO `sys_menu_resource` VALUES ('66', '26', 'c7e7ed1fdcc753f9fb5aab85bc639da6');
INSERT INTO `sys_menu_resource` VALUES ('71', '28', '2caca33f4fa40079ba1d86d9961634a5');
INSERT INTO `sys_menu_resource` VALUES ('72', '28', 'abb48abd102deb57718e6210fd5b55f9');
INSERT INTO `sys_menu_resource` VALUES ('73', '28', 'd260fc5e4c10a4fbd1661acb739c6119');
INSERT INTO `sys_menu_resource` VALUES ('74', '28', 'fd1c22d987d0c74044917917a85acfdc');
INSERT INTO `sys_menu_resource` VALUES ('78', '35', '1e1146393b91b9a02a11284eea132962');
INSERT INTO `sys_menu_resource` VALUES ('85', '33', 'eed40b7746f536ba707e8c7b3bc3d600');
INSERT INTO `sys_menu_resource` VALUES ('88', '34', '85b2608158865a37dd2c4cdd8c91f387');
INSERT INTO `sys_menu_resource` VALUES ('103', '42', 'b74d54f1f4be2958369a704a50f6900a');
INSERT INTO `sys_menu_resource` VALUES ('104', '43', '2b46448ef3c969f64046c9ed8e294b41');
INSERT INTO `sys_menu_resource` VALUES ('105', '44', 'ef0c2202d21ea0a946a1aa1fc96b1099');
INSERT INTO `sys_menu_resource` VALUES ('138', '41', '034fe06c0ce7f3ad0db70e0ccf313dcc');
INSERT INTO `sys_menu_resource` VALUES ('139', '41', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('162', '56', 'c83ae91d496426d8dc8c8d265f959cd0');
INSERT INTO `sys_menu_resource` VALUES ('163', '56', 'af63a08383a750461f23208b6d99bfc1');
INSERT INTO `sys_menu_resource` VALUES ('164', '56', '3e5a0b5a1156439cd32a82b7dfedc865');
INSERT INTO `sys_menu_resource` VALUES ('165', '56', '166654543c708f5e91eab662095bd764');
INSERT INTO `sys_menu_resource` VALUES ('166', '57', '16ec009eee72f9a3146f3ed6e6e3bccd');
INSERT INTO `sys_menu_resource` VALUES ('167', '57', '4f53b04b850f87536c19f6cb16f2ba32');
INSERT INTO `sys_menu_resource` VALUES ('168', '57', 'cc88c5473c49ef83cad40ab279db16bf');
INSERT INTO `sys_menu_resource` VALUES ('169', '57', 'f86b169919bf24ce08507f2dcea7de8f');
INSERT INTO `sys_menu_resource` VALUES ('175', '59', '82d143f7b01b3cb8cf2617a9efb7a8b8');
INSERT INTO `sys_menu_resource` VALUES ('176', '59', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('177', '60', '4684b8f300152ee482a2fbd95a070a8e');
INSERT INTO `sys_menu_resource` VALUES ('178', '61', '30f1ef71d284550e5f7144f2b0a79ad5');
INSERT INTO `sys_menu_resource` VALUES ('179', '62', 'eb0766e055b34846e6f0e8a003dc0f51');
INSERT INTO `sys_menu_resource` VALUES ('180', '63', '80e9634eadbb61b2d2c8e3b8477aa313');
INSERT INTO `sys_menu_resource` VALUES ('181', '63', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('182', '64', '566f824387a06feea407439bd6f4be8f');
INSERT INTO `sys_menu_resource` VALUES ('183', '65', 'a114f29b98a6faa95ac89139008f0e8c');
INSERT INTO `sys_menu_resource` VALUES ('184', '66', '442504feccde8320f201a26b363f2db9');
INSERT INTO `sys_menu_resource` VALUES ('189', '3', '9be8e0df48c8ba879e5b079c73662ee4');
INSERT INTO `sys_menu_resource` VALUES ('190', '3', '179887b5bd6e42be960b83982a684b10');
INSERT INTO `sys_menu_resource` VALUES ('191', '3', '6c3514540b1e2e1589a9c9566273c7c7');
INSERT INTO `sys_menu_resource` VALUES ('192', '4', '54522abbe7d3a2a40e7edbc9339acc50');
INSERT INTO `sys_menu_resource` VALUES ('193', '4', '179887b5bd6e42be960b83982a684b10');
INSERT INTO `sys_menu_resource` VALUES ('194', '4', '6c3514540b1e2e1589a9c9566273c7c7');
INSERT INTO `sys_menu_resource` VALUES ('195', '67', '49a3211ef7ddd065888fc6ad093bff6f');
INSERT INTO `sys_menu_resource` VALUES ('196', '67', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('197', '68', 'd1cee74a3c8ecc212ec1fbfffd7d4b7a');
INSERT INTO `sys_menu_resource` VALUES ('198', '69', '4f431508eaf3ae2b72c87ecde3334212');
INSERT INTO `sys_menu_resource` VALUES ('199', '70', '1c42a29f7a1a0fb0c6c3e213ebd9d6e4');
INSERT INTO `sys_menu_resource` VALUES ('283', '7', 'a2cf21f89380c679e13e76a46e63de18');
INSERT INTO `sys_menu_resource` VALUES ('291', '2', 'fad1ecbafb22f1ac0f63486d71393745');
INSERT INTO `sys_menu_resource` VALUES ('292', '2', '49764a50d0e0f74790ced2586b03bff8');
INSERT INTO `sys_menu_resource` VALUES ('295', '12', 'f880f8a35613b38182612a061291f8a5');
INSERT INTO `sys_menu_resource` VALUES ('296', '12', 'de8b6406105c3ea1c71de78e0870595e');
INSERT INTO `sys_menu_resource` VALUES ('297', '16', '47aad34069f0e8713b6df562b4b2029f');
INSERT INTO `sys_menu_resource` VALUES ('298', '18', '512082c7c24e77c5496977206d823f48');
INSERT INTO `sys_menu_resource` VALUES ('304', '51', 'de2199682fdb8768d3dada69bf282f63');
INSERT INTO `sys_menu_resource` VALUES ('305', '51', '86047dad161b62bae784f2f77cb44cb8');
INSERT INTO `sys_menu_resource` VALUES ('306', '51', '039bec1c73824aebd6dac61de133f336');
INSERT INTO `sys_menu_resource` VALUES ('307', '51', '36113bab48568e5885a8f34bcc91bb11');
INSERT INTO `sys_menu_resource` VALUES ('308', '71', 'dfdff4d1f7e710eb21962c2f6df810b4');
INSERT INTO `sys_menu_resource` VALUES ('309', '71', 'd6119390317deda395c1487d401dd47f');
INSERT INTO `sys_menu_resource` VALUES ('310', '71', '4b67b670f546e7a11310a70c1383d795');
INSERT INTO `sys_menu_resource` VALUES ('311', '71', '36c191be2786a1dfd730b649d9f9d88f');
INSERT INTO `sys_menu_resource` VALUES ('312', '71', '6847ea5e1845717af3d32125277a5eea');
INSERT INTO `sys_menu_resource` VALUES ('313', '52', 'ffdbcf5be43ec6452a9b568c833f8f0a');
INSERT INTO `sys_menu_resource` VALUES ('314', '52', 'fcefc2a889894309e8eaff8f5762240a');
INSERT INTO `sys_menu_resource` VALUES ('315', '52', 'e6785c61264683eaa3e7b6bcd5190f69');
INSERT INTO `sys_menu_resource` VALUES ('316', '52', '98c864bdce956341baa4f83cf8a74ddc');
INSERT INTO `sys_menu_resource` VALUES ('317', '73', '0401dbc5d8eaad57931edbf0ee36a10c');
INSERT INTO `sys_menu_resource` VALUES ('318', '73', '4f59f04de013a04c9c4a2459382da5e9');
INSERT INTO `sys_menu_resource` VALUES ('319', '73', '65bbd93b69d8dd2d5cade59dc0ccd8e6');
INSERT INTO `sys_menu_resource` VALUES ('320', '73', '956578f7a1e6fe0239b03232faa0dfda');
INSERT INTO `sys_menu_resource` VALUES ('321', '73', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('322', '24', 'f8afb5ec48a65cb7c9cd7e9372118748');
INSERT INTO `sys_menu_resource` VALUES ('323', '24', 'd431b135887822c5c012561c96f1ec84');
INSERT INTO `sys_menu_resource` VALUES ('324', '24', 'a36d86152fb3241feef81a9ccee6faed');
INSERT INTO `sys_menu_resource` VALUES ('325', '24', 'bc90809c5084a45eda6ece88e426d0b8');
INSERT INTO `sys_menu_resource` VALUES ('326', '77', '5cc53e1d69c9023759841eb2c41f9bfd');
INSERT INTO `sys_menu_resource` VALUES ('327', '77', '9c649f2b5cc9a0948958033038e6786b');
INSERT INTO `sys_menu_resource` VALUES ('328', '77', 'de16f2ea5e499ebcb81154efec1d2df4');
INSERT INTO `sys_menu_resource` VALUES ('329', '77', 'af29194331dabc32c641585380ff714f');
INSERT INTO `sys_menu_resource` VALUES ('330', '77', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('331', '25', '4eac907c193cfa96ada396cdbfbacb31');
INSERT INTO `sys_menu_resource` VALUES ('332', '25', '222549de7b85d74ff912e4e258670af6');
INSERT INTO `sys_menu_resource` VALUES ('333', '25', '8690f1577b8abe64aa841cb763a32b47');
INSERT INTO `sys_menu_resource` VALUES ('334', '25', 'ea1ff9435f36746204efc424f2386a3e');
INSERT INTO `sys_menu_resource` VALUES ('335', '53', '2410dac6fb2e4396e28d720f19bc7c45');
INSERT INTO `sys_menu_resource` VALUES ('336', '53', '7ad036add7309273ab46935c955cd547');
INSERT INTO `sys_menu_resource` VALUES ('337', '53', 'd289b64ef206771d89ed2670d93049b9');
INSERT INTO `sys_menu_resource` VALUES ('338', '53', 'e113d9ae14c1ba583228d0974ccdfab1');
INSERT INTO `sys_menu_resource` VALUES ('339', '54', 'b5bd54c21e5412a49f4f656c8f33f77b');
INSERT INTO `sys_menu_resource` VALUES ('340', '54', '328f29a3ed6b6f792f994aeb1c4abab5');
INSERT INTO `sys_menu_resource` VALUES ('341', '54', '262bfee5cd0edf4d5cd47fa1f9380cb4');
INSERT INTO `sys_menu_resource` VALUES ('342', '54', '07d648ddf63c20317df4f5cbf7786a48');
INSERT INTO `sys_menu_resource` VALUES ('343', '72', 'e78b1e45561db580a21ebe962414aaa9');
INSERT INTO `sys_menu_resource` VALUES ('344', '72', 'dcd22be9d250bc20abed2b5390259a3f');
INSERT INTO `sys_menu_resource` VALUES ('345', '72', 'b42c4411f27e50bafc6094b31b323996');
INSERT INTO `sys_menu_resource` VALUES ('346', '72', '1edadc539135c5dc8ea6dd767b51133a');
INSERT INTO `sys_menu_resource` VALUES ('347', '55', '0a9c4972fbf5b50eb76d78cd40c8c269');
INSERT INTO `sys_menu_resource` VALUES ('348', '55', '46947be1849f0a3fb065d4c4bb9e8ed4');
INSERT INTO `sys_menu_resource` VALUES ('349', '55', '9d47323a8cf271afa3794a41d01ebd8d');
INSERT INTO `sys_menu_resource` VALUES ('350', '55', 'f4912e9c64d9c95d761a642caac77a3c');
INSERT INTO `sys_menu_resource` VALUES ('351', '58', '664f3db603c5855b208fc969984e1603');
INSERT INTO `sys_menu_resource` VALUES ('352', '58', '6f64396b3c7a68b40194169e09380fd0');
INSERT INTO `sys_menu_resource` VALUES ('353', '58', '7f4c9278a2d5d361b584e8db2c0f9d64');
INSERT INTO `sys_menu_resource` VALUES ('354', '58', 'f084f47ab2ec0ce7d2846ca0465f9926');
INSERT INTO `sys_menu_resource` VALUES ('355', '46', '33b8bec21288534e35fbccdfac9f1494');
INSERT INTO `sys_menu_resource` VALUES ('356', '46', '6588452dd7adc2cf0b3a634c7eaba578');
INSERT INTO `sys_menu_resource` VALUES ('357', '46', '9513d9c346dc6afdbcef07fad075ca96');
INSERT INTO `sys_menu_resource` VALUES ('358', '46', 'e94e936ee35513a5cbaa0b670a806677');
INSERT INTO `sys_menu_resource` VALUES ('359', '47', '61ffa059261d938164f12a0feae60779');
INSERT INTO `sys_menu_resource` VALUES ('360', '47', '6594f272facd4b263779a5898408d6f5');
INSERT INTO `sys_menu_resource` VALUES ('361', '47', '6e8bb84dfd74bd76918cbc7b7b97e241');
INSERT INTO `sys_menu_resource` VALUES ('362', '47', 'cd6de4b154e91389697aaa16f9e70f03');
INSERT INTO `sys_menu_resource` VALUES ('363', '48', 'e8294671c0aeae7195fc3c43e2457436');
INSERT INTO `sys_menu_resource` VALUES ('364', '48', 'a0a1a4a566471fe2a2556bd873a3f036');
INSERT INTO `sys_menu_resource` VALUES ('365', '48', '49b2accbfba5ff13f7f1f9b368c310ec');
INSERT INTO `sys_menu_resource` VALUES ('366', '48', '3a3445306b2ef32a0c5976a4d3e91f64');
INSERT INTO `sys_menu_resource` VALUES ('367', '49', 'd374ba0bb7e6ed122a2c04cbdb759b81');
INSERT INTO `sys_menu_resource` VALUES ('368', '49', 'b799b91c2cb5d49953a7308c93aef3e6');
INSERT INTO `sys_menu_resource` VALUES ('369', '49', '71ff8d6843b1023eaa48a6a0113b9307');
INSERT INTO `sys_menu_resource` VALUES ('370', '49', '6aa7aabe9b977d40b24dc5af059f2782');
INSERT INTO `sys_menu_resource` VALUES ('371', '50', 'd7b1e397718a5e2bb30ee16d81fe8839');
INSERT INTO `sys_menu_resource` VALUES ('372', '50', 'ca6fc80fa67b8178d040d951efed929e');
INSERT INTO `sys_menu_resource` VALUES ('373', '50', '72331b4d9d6a4d884f54d75b7ebc3b0b');
INSERT INTO `sys_menu_resource` VALUES ('374', '50', 'ab34bcc1abb35eb4c7926c4f8e88bfa0');
INSERT INTO `sys_menu_resource` VALUES ('391', '45', 'fe7a8147c0721226e5de8e3e8f6ebf93');
INSERT INTO `sys_menu_resource` VALUES ('392', '45', 'e39c62db55dba9e58d9f996096e97c63');
INSERT INTO `sys_menu_resource` VALUES ('393', '45', 'abe8fd7846f776abf7f9a52778a48cf0');
INSERT INTO `sys_menu_resource` VALUES ('394', '45', '104e2c82415429f04455f1d079890c96');
INSERT INTO `sys_menu_resource` VALUES ('411', '36', '0b3acbd943d2bdf421984f80a96c9739');
INSERT INTO `sys_menu_resource` VALUES ('412', '36', '4cc53717ed7201af2526a716f0071287');
INSERT INTO `sys_menu_resource` VALUES ('413', '36', '68655ee2d14ea4f555d8c6bd91004381');
INSERT INTO `sys_menu_resource` VALUES ('414', '36', 'cf2f5e841d1fa963c3a511c4ea23c6b8');
INSERT INTO `sys_menu_resource` VALUES ('415', '37', 'c360a16bbc9b4c5a8378d48bb1fa4ffd');
INSERT INTO `sys_menu_resource` VALUES ('416', '37', '8069b90f45605898c6b48c513785194e');
INSERT INTO `sys_menu_resource` VALUES ('417', '37', '729f78186228a271d4035747eb4ad465');
INSERT INTO `sys_menu_resource` VALUES ('418', '37', '22c8d4ad02ae696458f3de13053e4dbc');
INSERT INTO `sys_menu_resource` VALUES ('419', '38', '93541f9d26ff3e388f53744d70679dd4');
INSERT INTO `sys_menu_resource` VALUES ('420', '38', '544a69d536f460d511a271ac2468cafc');
INSERT INTO `sys_menu_resource` VALUES ('421', '38', '0ef17c27ae7717cc75b3940ad4958c29');
INSERT INTO `sys_menu_resource` VALUES ('422', '38', 'dd00babb9be667747337654d68354531');
INSERT INTO `sys_menu_resource` VALUES ('423', '39', '099a483818e8ec192f966b6bc6bacd0a');
INSERT INTO `sys_menu_resource` VALUES ('424', '39', '8cb83a749812f5d14d518d080fa12773');
INSERT INTO `sys_menu_resource` VALUES ('425', '39', 'a9301ba0ce8390ecd756fb60b0487496');
INSERT INTO `sys_menu_resource` VALUES ('426', '39', 'b9766aef2e0a38ab87f640ca592c3569');
INSERT INTO `sys_menu_resource` VALUES ('427', '75', 'd3ec728a0d9d66b8351cd0278962a384');
INSERT INTO `sys_menu_resource` VALUES ('428', '75', '7e5982583c9805792c523b32ca5ef88b');
INSERT INTO `sys_menu_resource` VALUES ('429', '75', '3e97140625dc7fc53c2c7bbb0d01813c');
INSERT INTO `sys_menu_resource` VALUES ('430', '75', '151d826eafc7b5174de85dd7df216b98');
INSERT INTO `sys_menu_resource` VALUES ('431', '75', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('432', '76', 'cf644f767183f7940a094d82fd075ed5');
INSERT INTO `sys_menu_resource` VALUES ('433', '76', '0b2af0dd22363820966999f84a845ea2');
INSERT INTO `sys_menu_resource` VALUES ('434', '76', '7d5889685e76e54b05e5f88169fd5e20');
INSERT INTO `sys_menu_resource` VALUES ('435', '76', '82ae5ea4f71f8e9f4ff625dbc8d28819');
INSERT INTO `sys_menu_resource` VALUES ('436', '76', 'b0b5dc6a4d472e5160e289eee92ad5d4');
INSERT INTO `sys_menu_resource` VALUES ('437', '23', '21b182bd4b864b88d6424717673c2fdd');
INSERT INTO `sys_menu_resource` VALUES ('438', '23', '35497ac6603e18992159e83005be0d64');
INSERT INTO `sys_menu_resource` VALUES ('439', '23', '9964cc368380f9bd7c782855389068d2');
INSERT INTO `sys_menu_resource` VALUES ('440', '32', '43083dba76bdf1e10b51a95974f30141');
INSERT INTO `sys_menu_resource` VALUES ('441', '32', 'b0b5dc6a4d472e5160e289eee92ad5d4');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` varchar(32) NOT NULL,
  `resource_name` varchar(32) NOT NULL COMMENT '资源名称',
  `mapping` varchar(64) NOT NULL COMMENT '路径映射',
  `method` varchar(6) NOT NULL COMMENT '请求方式',
  `auth_type` smallint(2) NOT NULL COMMENT '权限认证类型',
  `update_time` datetime DEFAULT NULL,
  `perm` varchar(68) NOT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('034fe06c0ce7f3ad0db70e0ccf313dcc', '交流互展查询(分页)', '/exchangeexhibition/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/exchangeexhibition/page');
INSERT INTO `sys_resource` VALUES ('039bec1c73824aebd6dac61de133f336', '管理机构编辑', '/managementagency/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/managementagency/{id}');
INSERT INTO `sys_resource` VALUES ('0401dbc5d8eaad57931edbf0ee36a10c', '公园规划查询(分页)', '/planning/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/planning/page');
INSERT INTO `sys_resource` VALUES ('0584acbf717e9848bfbd5cb2e149754a', '社会经济状况添加', '/socialeconomy', 'POST', '1', '2019-09-20 21:22:39', 'POST:/socialeconomy');
INSERT INTO `sys_resource` VALUES ('06031eda73fcffa209c91c414a6b4766', 'openApi自然景观列表', '/openApi/naturallandscapeList', 'GET', '2', '2019-09-20 21:22:39', 'GET:/openApi/naturallandscapeList');
INSERT INTO `sys_resource` VALUES ('07d648ddf63c20317df4f5cbf7786a48', '人文景观删除', '/humanlandscape/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/humanlandscape/{id}');
INSERT INTO `sys_resource` VALUES ('099a483818e8ec192f966b6bc6bacd0a', '科普作品添加', '/sciencework', 'POST', '1', '2019-09-20 21:22:39', 'POST:/sciencework');
INSERT INTO `sys_resource` VALUES ('0a9c4972fbf5b50eb76d78cd40c8c269', '地灾信息查询(分页)', '/earthquake/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/earthquake/page');
INSERT INTO `sys_resource` VALUES ('0b2af0dd22363820966999f84a845ea2', '影像资料添加', '/vediodocs', 'POST', '3', '2019-09-20 21:22:39', 'POST:/vediodocs');
INSERT INTO `sys_resource` VALUES ('0b3acbd943d2bdf421984f80a96c9739', '科研论文删除', '/researchpaper/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/researchpaper/{id}');
INSERT INTO `sys_resource` VALUES ('0ef17c27ae7717cc75b3940ad4958c29', '科普活动查询(分页)', '/scienceactivity/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/scienceactivity/page');
INSERT INTO `sys_resource` VALUES ('104e2c82415429f04455f1d079890c96', '专家导游编辑', '/parklibrary/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/parklibrary/{id}');
INSERT INTO `sys_resource` VALUES ('151d826eafc7b5174de85dd7df216b98', '图片资料删除', '/picdocs/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/picdocs/{id}');
INSERT INTO `sys_resource` VALUES ('15da52a5f4f4a6eac3b0d6f046f040c9', '菜单删除', '/menu/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/menu/{id}');
INSERT INTO `sys_resource` VALUES ('166654543c708f5e91eab662095bd764', '重叠情况删除', '/overlapping/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/overlapping/{id}');
INSERT INTO `sys_resource` VALUES ('16ec009eee72f9a3146f3ed6e6e3bccd', '标示解说添加', '/commentary', 'POST', '1', '2019-09-20 21:22:39', 'POST:/commentary');
INSERT INTO `sys_resource` VALUES ('179887b5bd6e42be960b83982a684b10', '角色查询(所有)', '/role/list', 'GET', '3', '2019-09-20 21:22:39', 'GET:/role/list');
INSERT INTO `sys_resource` VALUES ('1adec59980b460bb8db5198953608b87', '任务编辑', '/task/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/task/{id}');
INSERT INTO `sys_resource` VALUES ('1c42a29f7a1a0fb0c6c3e213ebd9d6e4', '缔结姊妹公园删除', '/parkrelation/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/parkrelation/{id}');
INSERT INTO `sys_resource` VALUES ('1e1146393b91b9a02a11284eea132962', '公园信息删除', '/parkinfo/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/parkinfo/{id}');
INSERT INTO `sys_resource` VALUES ('1edadc539135c5dc8ea6dd767b51133a', '自然景观编辑', '/naturallandscape/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/naturallandscape/{id}');
INSERT INTO `sys_resource` VALUES ('21b182bd4b864b88d6424717673c2fdd', '公园查询(分页)', '/park/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/park/page');
INSERT INTO `sys_resource` VALUES ('222549de7b85d74ff912e4e258670af6', '地质背景编辑', '/geological/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/geological/{id}');
INSERT INTO `sys_resource` VALUES ('22c8d4ad02ae696458f3de13053e4dbc', '专题研究查询(分页)', '/parktopic/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/parktopic/page');
INSERT INTO `sys_resource` VALUES ('2410dac6fb2e4396e28d720f19bc7c45', '地质遗迹景观删除', '/geolandscape/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/geolandscape/{id}');
INSERT INTO `sys_resource` VALUES ('24bf74d47e8322146e38f0c68333f90c', '角色授权', '/role/{id}/menu', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/role/{id}/menu');
INSERT INTO `sys_resource` VALUES ('262bfee5cd0edf4d5cd47fa1f9380cb4', '人文景观编辑', '/humanlandscape/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/humanlandscape/{id}');
INSERT INTO `sys_resource` VALUES ('2b46448ef3c969f64046c9ed8e294b41', '交流互展编辑', '/exchangeexhibition/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/exchangeexhibition/{id}');
INSERT INTO `sys_resource` VALUES ('2caca33f4fa40079ba1d86d9961634a5', '矿权情况查询(分页)', '/mineralright/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/mineralright/page');
INSERT INTO `sys_resource` VALUES ('30928c0d0e2e7a454426990767919239', '事务测试', '/tasktransaction', 'POST', '1', '2019-08-29 09:41:56', 'POST:/tasktransaction');
INSERT INTO `sys_resource` VALUES ('30f1ef71d284550e5f7144f2b0a79ad5', '产品推介编辑', '/production/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/production/{id}');
INSERT INTO `sys_resource` VALUES ('328f29a3ed6b6f792f994aeb1c4abab5', '人文景观查询(分页)', '/humanlandscape/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/humanlandscape/page');
INSERT INTO `sys_resource` VALUES ('33b8bec21288534e35fbccdfac9f1494', '博物馆基本情况删除', '/museum/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/museum/{id}');
INSERT INTO `sys_resource` VALUES ('35497ac6603e18992159e83005be0d64', '公园编辑', '/park/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/park/{id}');
INSERT INTO `sys_resource` VALUES ('36113bab48568e5885a8f34bcc91bb11', '管理机构添加', '/managementagency', 'POST', '1', '2019-09-20 21:22:39', 'POST:/managementagency');
INSERT INTO `sys_resource` VALUES ('36c191be2786a1dfd730b649d9f9d88f', '管理人员编辑', '/manageperson/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/manageperson/{id}');
INSERT INTO `sys_resource` VALUES ('375edb54e85dc981c8df62c76f3782ed', '菜单详情', '/menu/{id}', 'GET', '3', '2019-09-20 21:22:39', 'GET:/menu/{id}');
INSERT INTO `sys_resource` VALUES ('37687195b63b44e0d22436080de117bc', '菜单编辑', '/menu/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/menu/{id}');
INSERT INTO `sys_resource` VALUES ('3a3445306b2ef32a0c5976a4d3e91f64', '生物标本编辑', '/biospecimen/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/biospecimen/{id}');
INSERT INTO `sys_resource` VALUES ('3a62355efcfa84646b390d508efea9b6', '菜单添加', '/menu', 'POST', '3', '2019-09-20 21:22:39', 'POST:/menu');
INSERT INTO `sys_resource` VALUES ('3dca30c2118ff6158ffa88191003128e', '用户删除', '/user/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/user/{id}');
INSERT INTO `sys_resource` VALUES ('3e5a0b5a1156439cd32a82b7dfedc865', '重叠情况添加', '/overlapping', 'POST', '1', '2019-09-20 21:22:39', 'POST:/overlapping');
INSERT INTO `sys_resource` VALUES ('3e97140625dc7fc53c2c7bbb0d01813c', '图片资料查询(分页)', '/picdocs/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/picdocs/page');
INSERT INTO `sys_resource` VALUES ('43083dba76bdf1e10b51a95974f30141', '公园信息查询(分页)', '/parkinfo/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/parkinfo/page');
INSERT INTO `sys_resource` VALUES ('442504feccde8320f201a26b363f2db9', '会议删除', '/parkmeeting/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/parkmeeting/{id}');
INSERT INTO `sys_resource` VALUES ('4684b8f300152ee482a2fbd95a070a8e', '产品推介添加', '/production', 'POST', '3', '2019-09-20 21:22:39', 'POST:/production');
INSERT INTO `sys_resource` VALUES ('46947be1849f0a3fb065d4c4bb9e8ed4', '地灾信息编辑', '/earthquake/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/earthquake/{id}');
INSERT INTO `sys_resource` VALUES ('46a5d7a79e6ba91e6709f3361a2edd81', '角色添加', '/role', 'POST', '3', '2019-09-20 21:22:39', 'POST:/role');
INSERT INTO `sys_resource` VALUES ('47aad34069f0e8713b6df562b4b2029f', '资源查询(分页)', '/resource/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/resource/page');
INSERT INTO `sys_resource` VALUES ('49764a50d0e0f74790ced2586b03bff8', '用户状态设置', '/user/{id}/status', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/user/{id}/status');
INSERT INTO `sys_resource` VALUES ('49a3211ef7ddd065888fc6ad093bff6f', '缔结姊妹公园查询(分页)', '/parkrelation/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/parkrelation/page');
INSERT INTO `sys_resource` VALUES ('49b2accbfba5ff13f7f1f9b368c310ec', '生物标本删除', '/biospecimen/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/biospecimen/{id}');
INSERT INTO `sys_resource` VALUES ('4aa3a9dc3d7612e3eeab0eed6cf5fd75', 'openApi地质遗迹景观详情', '/openApi/geolandscapeInfo', 'GET', '2', '2019-09-20 21:22:39', 'GET:/openApi/geolandscapeInfo');
INSERT INTO `sys_resource` VALUES ('4b67b670f546e7a11310a70c1383d795', '管理人员添加', '/manageperson', 'POST', '1', '2019-09-20 21:22:39', 'POST:/manageperson');
INSERT INTO `sys_resource` VALUES ('4cc53717ed7201af2526a716f0071287', '科研论文查询(分页)', '/researchpaper/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/researchpaper/page');
INSERT INTO `sys_resource` VALUES ('4eac907c193cfa96ada396cdbfbacb31', '地质背景删除', '/geological/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/geological/{id}');
INSERT INTO `sys_resource` VALUES ('4f431508eaf3ae2b72c87ecde3334212', '缔结姊妹公园编辑', '/parkrelation/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/parkrelation/{id}');
INSERT INTO `sys_resource` VALUES ('4f53b04b850f87536c19f6cb16f2ba32', '标示解说删除', '/commentary/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/commentary/{id}');
INSERT INTO `sys_resource` VALUES ('4f59f04de013a04c9c4a2459382da5e9', '公园规划删除', '/planning/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/planning/{id}');
INSERT INTO `sys_resource` VALUES ('512082c7c24e77c5496977206d823f48', '任务查询(分页)', '/task/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/task/page');
INSERT INTO `sys_resource` VALUES ('544a69d536f460d511a271ac2468cafc', '科普活动添加', '/scienceactivity', 'POST', '1', '2019-09-20 21:22:39', 'POST:/scienceactivity');
INSERT INTO `sys_resource` VALUES ('54522abbe7d3a2a40e7edbc9339acc50', '用户编辑', '/user/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/user/{id}');
INSERT INTO `sys_resource` VALUES ('55295a3ce5c98c008672159097f20813', '上传图片', '/upload/img', 'POST', '1', '2019-09-20 21:22:39', 'POST:/upload/img');
INSERT INTO `sys_resource` VALUES ('566f824387a06feea407439bd6f4be8f', '会议添加', '/parkmeeting', 'POST', '3', '2019-09-20 21:22:39', 'POST:/parkmeeting');
INSERT INTO `sys_resource` VALUES ('5a1196055f5773be65b2669ea37f3978', 'openApi人文景观详情', '/openApi/humanlandscapeInfo', 'GET', '2', '2019-09-20 21:22:39', 'GET:/openApi/humanlandscapeInfo');
INSERT INTO `sys_resource` VALUES ('5cc53e1d69c9023759841eb2c41f9bfd', '游客统计删除', '/gueststat/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/gueststat/{id}');
INSERT INTO `sys_resource` VALUES ('61ffa059261d938164f12a0feae60779', '地质标本编辑', '/geospecimen/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/geospecimen/{id}');
INSERT INTO `sys_resource` VALUES ('6588452dd7adc2cf0b3a634c7eaba578', '博物馆基本情况查询(分页)', '/museum/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/museum/page');
INSERT INTO `sys_resource` VALUES ('6594f272facd4b263779a5898408d6f5', '地质标本添加', '/geospecimen', 'POST', '1', '2019-09-20 21:22:39', 'POST:/geospecimen');
INSERT INTO `sys_resource` VALUES ('65bbd93b69d8dd2d5cade59dc0ccd8e6', '公园规划编辑', '/planning/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/planning/{id}');
INSERT INTO `sys_resource` VALUES ('664f3db603c5855b208fc969984e1603', '采样信息添加', '/sampling', 'POST', '1', '2019-09-20 21:22:39', 'POST:/sampling');
INSERT INTO `sys_resource` VALUES ('6847ea5e1845717af3d32125277a5eea', '管理机构查询(列表)', '/managementagency/list', 'GET', '3', '2019-09-20 21:22:39', 'GET:/managementagency/list');
INSERT INTO `sys_resource` VALUES ('68655ee2d14ea4f555d8c6bd91004381', '科研论文编辑', '/researchpaper/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/researchpaper/{id}');
INSERT INTO `sys_resource` VALUES ('6aa7aabe9b977d40b24dc5af059f2782', '人文展品编辑', '/humenexhibit/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/humenexhibit/{id}');
INSERT INTO `sys_resource` VALUES ('6ab0f8a49671e489f11a1bef2fcaf102', '账户清除', '/account/token', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/account/token');
INSERT INTO `sys_resource` VALUES ('6c3514540b1e2e1589a9c9566273c7c7', '用户详情', '/user/{id}', 'GET', '3', '2019-09-20 21:22:39', 'GET:/user/{id}');
INSERT INTO `sys_resource` VALUES ('6e8bb84dfd74bd76918cbc7b7b97e241', '地质标本删除', '/geospecimen/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/geospecimen/{id}');
INSERT INTO `sys_resource` VALUES ('6f64396b3c7a68b40194169e09380fd0', '采样信息删除', '/sampling/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/sampling/{id}');
INSERT INTO `sys_resource` VALUES ('7025c7532d2a58d3de4dde7c66d363f3', '资源刷新', '/resource', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/resource');
INSERT INTO `sys_resource` VALUES ('71d5f2e10db38eaebdaa44fa89cb1163', '任务删除', '/task/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/task/{id}');
INSERT INTO `sys_resource` VALUES ('71ff8d6843b1023eaa48a6a0113b9307', '人文展品添加', '/humenexhibit', 'POST', '1', '2019-09-20 21:22:39', 'POST:/humenexhibit');
INSERT INTO `sys_resource` VALUES ('72331b4d9d6a4d884f54d75b7ebc3b0b', '展板添加', '/displayboard', 'POST', '1', '2019-09-20 21:22:39', 'POST:/displayboard');
INSERT INTO `sys_resource` VALUES ('729f78186228a271d4035747eb4ad465', '专题研究添加', '/parktopic', 'POST', '1', '2019-09-20 21:22:39', 'POST:/parktopic');
INSERT INTO `sys_resource` VALUES ('7ad036add7309273ab46935c955cd547', '地质遗迹景观查询(分页)', '/geolandscape/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/geolandscape/page');
INSERT INTO `sys_resource` VALUES ('7d5889685e76e54b05e5f88169fd5e20', '影像资料编辑', '/vediodocs/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/vediodocs/{id}');
INSERT INTO `sys_resource` VALUES ('7e5982583c9805792c523b32ca5ef88b', '图片资料添加', '/picdocs', 'POST', '3', '2019-09-20 21:22:39', 'POST:/picdocs');
INSERT INTO `sys_resource` VALUES ('7f4c9278a2d5d361b584e8db2c0f9d64', '采样信息编辑', '/sampling/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/sampling/{id}');
INSERT INTO `sys_resource` VALUES ('8069b90f45605898c6b48c513785194e', '专题研究编辑', '/parktopic/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/parktopic/{id}');
INSERT INTO `sys_resource` VALUES ('80e9634eadbb61b2d2c8e3b8477aa313', '会议查询(分页)', '/parkmeeting/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/parkmeeting/page');
INSERT INTO `sys_resource` VALUES ('82ae5ea4f71f8e9f4ff625dbc8d28819', '影像资料查询(分页)', '/vediodocs/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/vediodocs/page');
INSERT INTO `sys_resource` VALUES ('82d143f7b01b3cb8cf2617a9efb7a8b8', '产品推介查询(分页)', '/production/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/production/page');
INSERT INTO `sys_resource` VALUES ('842e33410b5a97b6c797e4782c97a90e', '账户获取', '/account/token', 'POST', '2', '2019-09-20 21:22:39', 'POST:/account/token');
INSERT INTO `sys_resource` VALUES ('85b2608158865a37dd2c4cdd8c91f387', '公园信息编辑', '/parkinfo/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/parkinfo/{id}');
INSERT INTO `sys_resource` VALUES ('86047dad161b62bae784f2f77cb44cb8', '管理机构删除', '/managementagency/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/managementagency/{id}');
INSERT INTO `sys_resource` VALUES ('8690f1577b8abe64aa841cb763a32b47', '地质背景添加', '/geological', 'POST', '1', '2019-09-20 21:22:39', 'POST:/geological');
INSERT INTO `sys_resource` VALUES ('8b98b499b8e85136a0cbb44fee38385a', '上传文件', '/upload/file', 'POST', '1', '2019-09-20 21:22:39', 'POST:/upload/file');
INSERT INTO `sys_resource` VALUES ('8cb83a749812f5d14d518d080fa12773', '科普作品查询(分页)', '/sciencework/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/sciencework/page');
INSERT INTO `sys_resource` VALUES ('8f0edeb755b80546b041872d0c867874', 'openApi地质遗迹景观列表', '/openApi/geolandscapeList', 'GET', '2', '2019-09-20 21:22:39', 'GET:/openApi/geolandscapeList');
INSERT INTO `sys_resource` VALUES ('9141e80baac708a8863498ff7a41d276', '任务添加', '/task', 'POST', '1', '2019-09-20 21:22:39', 'POST:/task');
INSERT INTO `sys_resource` VALUES ('93541f9d26ff3e388f53744d70679dd4', '科普活动删除', '/scienceactivity/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/scienceactivity/{id}');
INSERT INTO `sys_resource` VALUES ('9513d9c346dc6afdbcef07fad075ca96', '博物馆基本情况编辑', '/museum/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/museum/{id}');
INSERT INTO `sys_resource` VALUES ('956578f7a1e6fe0239b03232faa0dfda', '公园规划添加', '/planning', 'POST', '3', '2019-09-20 21:22:39', 'POST:/planning');
INSERT INTO `sys_resource` VALUES ('98c864bdce956341baa4f83cf8a74ddc', '法律法规查询(分页)', '/legal/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/legal/page');
INSERT INTO `sys_resource` VALUES ('9964cc368380f9bd7c782855389068d2', '公园添加', '/park', 'POST', '1', '2019-09-20 21:22:39', 'POST:/park');
INSERT INTO `sys_resource` VALUES ('9be8e0df48c8ba879e5b079c73662ee4', '用户添加', '/user', 'POST', '3', '2019-09-20 21:22:39', 'POST:/user');
INSERT INTO `sys_resource` VALUES ('9c649f2b5cc9a0948958033038e6786b', '游客统计编辑', '/gueststat/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/gueststat/{id}');
INSERT INTO `sys_resource` VALUES ('9d47323a8cf271afa3794a41d01ebd8d', '地灾信息删除', '/earthquake/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/earthquake/{id}');
INSERT INTO `sys_resource` VALUES ('a0a1a4a566471fe2a2556bd873a3f036', '生物标本添加', '/biospecimen', 'POST', '1', '2019-09-20 21:22:39', 'POST:/biospecimen');
INSERT INTO `sys_resource` VALUES ('a114f29b98a6faa95ac89139008f0e8c', '会议编辑', '/parkmeeting/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/parkmeeting/{id}');
INSERT INTO `sys_resource` VALUES ('a2cf21f89380c679e13e76a46e63de18', '角色查询(分页)', '/role/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/role/page');
INSERT INTO `sys_resource` VALUES ('a36d86152fb3241feef81a9ccee6faed', '生态环境查询', '/ecosystem/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/ecosystem/page');
INSERT INTO `sys_resource` VALUES ('a9301ba0ce8390ecd756fb60b0487496', '科普作品编辑', '/sciencework/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/sciencework/{id}');
INSERT INTO `sys_resource` VALUES ('ab34bcc1abb35eb4c7926c4f8e88bfa0', '展板查询(分页)', '/displayboard/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/displayboard/page');
INSERT INTO `sys_resource` VALUES ('abb48abd102deb57718e6210fd5b55f9', '矿权情况编辑', '/mineralright/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/mineralright/{id}');
INSERT INTO `sys_resource` VALUES ('abe8fd7846f776abf7f9a52778a48cf0', '专家导游删除', '/parklibrary/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/parklibrary/{id}');
INSERT INTO `sys_resource` VALUES ('af29194331dabc32c641585380ff714f', '游客统计查询(分页)', '/gueststat/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/gueststat/page');
INSERT INTO `sys_resource` VALUES ('af63a08383a750461f23208b6d99bfc1', '重叠情况编辑', '/overlapping/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/overlapping/{id}');
INSERT INTO `sys_resource` VALUES ('b0b5dc6a4d472e5160e289eee92ad5d4', '公园查询(列表)', '/park/list', 'GET', '3', '2019-09-20 21:22:39', 'GET:/park/list');
INSERT INTO `sys_resource` VALUES ('b42c4411f27e50bafc6094b31b323996', '自然景观删除', '/naturallandscape/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/naturallandscape/{id}');
INSERT INTO `sys_resource` VALUES ('b4a89208a3f348ad68f57a0ca16c94ec', '公园删除', '/park/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/park/{id}');
INSERT INTO `sys_resource` VALUES ('b5bd54c21e5412a49f4f656c8f33f77b', '人文景观添加', '/humanlandscape', 'POST', '1', '2019-09-20 21:22:39', 'POST:/humanlandscape');
INSERT INTO `sys_resource` VALUES ('b74d54f1f4be2958369a704a50f6900a', '交流互展添加', '/exchangeexhibition', 'POST', '3', '2019-09-20 21:22:39', 'POST:/exchangeexhibition');
INSERT INTO `sys_resource` VALUES ('b799b91c2cb5d49953a7308c93aef3e6', '人文展品删除', '/humenexhibit/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/humenexhibit/{id}');
INSERT INTO `sys_resource` VALUES ('b7b1c22076c0d28c8d0fe4c0b09b6a6e', '角色编辑', '/role/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/role/{id}');
INSERT INTO `sys_resource` VALUES ('b9766aef2e0a38ab87f640ca592c3569', '科普作品删除', '/sciencework/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/sciencework/{id}');
INSERT INTO `sys_resource` VALUES ('bb72308d143b0fc7a397e2756fbc8d6f', 'openApi人文景观列表', '/openApi/humanlandscapeList', 'GET', '2', '2019-09-20 21:22:39', 'GET:/openApi/humanlandscapeList');
INSERT INTO `sys_resource` VALUES ('bc90809c5084a45eda6ece88e426d0b8', '生态环境删除', '/ecosystem/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/ecosystem/{id}');
INSERT INTO `sys_resource` VALUES ('c2db9729dcd4a7d703e45411bb445dfd', '账户密码修改', '/account/password', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/account/password');
INSERT INTO `sys_resource` VALUES ('c360a16bbc9b4c5a8378d48bb1fa4ffd', '专题研究删除', '/parktopic/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/parktopic/{id}');
INSERT INTO `sys_resource` VALUES ('c7e7ed1fdcc753f9fb5aab85bc639da6', '社会经济状况编辑', '/socialeconomy/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/socialeconomy/{id}');
INSERT INTO `sys_resource` VALUES ('c83ae91d496426d8dc8c8d265f959cd0', '重叠情况查询(分页)', '/overlapping/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/overlapping/page');
INSERT INTO `sys_resource` VALUES ('ca6fc80fa67b8178d040d951efed929e', '展板删除', '/displayboard/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/displayboard/{id}');
INSERT INTO `sys_resource` VALUES ('cc88c5473c49ef83cad40ab279db16bf', '标示解说查询(分页)', '/commentary/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/commentary/page');
INSERT INTO `sys_resource` VALUES ('cd6de4b154e91389697aaa16f9e70f03', '地质标本查询(分页)', '/geospecimen/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/geospecimen/page');
INSERT INTO `sys_resource` VALUES ('cf2f5e841d1fa963c3a511c4ea23c6b8', '科研论文添加', '/researchpaper', 'POST', '1', '2019-09-20 21:22:39', 'POST:/researchpaper');
INSERT INTO `sys_resource` VALUES ('cf644f767183f7940a094d82fd075ed5', '影像资料删除', '/vediodocs/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/vediodocs/{id}');
INSERT INTO `sys_resource` VALUES ('d1cee74a3c8ecc212ec1fbfffd7d4b7a', '缔结姊妹公园添加', '/parkrelation', 'POST', '3', '2019-09-20 21:22:39', 'POST:/parkrelation');
INSERT INTO `sys_resource` VALUES ('d245ace645ea40e898178ee13c24297f', '用户密码重置', '/user/{id}/password', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/user/{id}/password');
INSERT INTO `sys_resource` VALUES ('d260fc5e4c10a4fbd1661acb739c6119', '矿权情况删除', '/mineralright/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/mineralright/{id}');
INSERT INTO `sys_resource` VALUES ('d289b64ef206771d89ed2670d93049b9', '地质遗迹景观添加', '/geolandscape', 'POST', '1', '2019-09-20 21:22:39', 'POST:/geolandscape');
INSERT INTO `sys_resource` VALUES ('d374ba0bb7e6ed122a2c04cbdb759b81', '人文展品查询(分页)', '/humenexhibit/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/humenexhibit/page');
INSERT INTO `sys_resource` VALUES ('d3ec728a0d9d66b8351cd0278962a384', '图片资料编辑', '/picdocs/{id}', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/picdocs/{id}');
INSERT INTO `sys_resource` VALUES ('d431b135887822c5c012561c96f1ec84', '生态环境编辑', '/ecosystem/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/ecosystem/{id}');
INSERT INTO `sys_resource` VALUES ('d4dcfc78a6b0f5f84ede3740b391825f', '社会经济状况删除', '/socialeconomy/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/socialeconomy/{id}');
INSERT INTO `sys_resource` VALUES ('d6119390317deda395c1487d401dd47f', '管理人员删除', '/manageperson/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/manageperson/{id}');
INSERT INTO `sys_resource` VALUES ('d7b1e397718a5e2bb30ee16d81fe8839', '展板编辑', '/displayboard/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/displayboard/{id}');
INSERT INTO `sys_resource` VALUES ('d81bffa6ffd70cc443703820b5a95e8d', '账户菜单', '/account/menus', 'GET', '1', '2019-09-20 21:22:39', 'GET:/account/menus');
INSERT INTO `sys_resource` VALUES ('d83a249e0e0ed84806ecba2fd8c7148d', '菜单父级查询(下拉框)', '/menu/combos', 'GET', '3', '2019-09-20 21:22:39', 'GET:/menu/combos');
INSERT INTO `sys_resource` VALUES ('d8544217f479cfb39559e4b94f413aaa', '资源查询(所有)', '/resource/list', 'GET', '3', '2019-09-20 21:22:39', 'GET:/resource/list');
INSERT INTO `sys_resource` VALUES ('dcd22be9d250bc20abed2b5390259a3f', '自然景观查询(分页)', '/naturallandscape/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/naturallandscape/page');
INSERT INTO `sys_resource` VALUES ('dd00babb9be667747337654d68354531', '科普活动编辑', '/scienceactivity/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/scienceactivity/{id}');
INSERT INTO `sys_resource` VALUES ('ddf4e3fd39264da50eec54cfd02731f4', '角色删除', '/role/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/role/{id}');
INSERT INTO `sys_resource` VALUES ('de16f2ea5e499ebcb81154efec1d2df4', '游客统计添加', '/gueststat', 'POST', '3', '2019-09-20 21:22:39', 'POST:/gueststat');
INSERT INTO `sys_resource` VALUES ('de2199682fdb8768d3dada69bf282f63', '管理机构查询(分页)', '/managementagency/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/managementagency/page');
INSERT INTO `sys_resource` VALUES ('de8b6406105c3ea1c71de78e0870595e', '菜单状态设置', '/menu/{id}/status', 'PUT', '3', '2019-09-20 21:22:39', 'PUT:/menu/{id}/status');
INSERT INTO `sys_resource` VALUES ('dfdff4d1f7e710eb21962c2f6df810b4', '管理人员查询(分页)', '/manageperson/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/manageperson/page');
INSERT INTO `sys_resource` VALUES ('e113d9ae14c1ba583228d0974ccdfab1', '地质遗迹景观编辑', '/geolandscape/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/geolandscape/{id}');
INSERT INTO `sys_resource` VALUES ('e39c62db55dba9e58d9f996096e97c63', '专家导游添加', '/parklibrary', 'POST', '1', '2019-09-20 21:22:39', 'POST:/parklibrary');
INSERT INTO `sys_resource` VALUES ('e6785c61264683eaa3e7b6bcd5190f69', '法律法规添加', '/legal', 'POST', '1', '2019-09-20 21:22:39', 'POST:/legal');
INSERT INTO `sys_resource` VALUES ('e78940daf86b9ac5563d539e8802429c', '账户详情', '/account/info', 'GET', '1', '2019-09-20 21:22:39', 'GET:/account/info');
INSERT INTO `sys_resource` VALUES ('e78b1e45561db580a21ebe962414aaa9', '自然景观添加', '/naturallandscape', 'POST', '1', '2019-09-20 21:22:39', 'POST:/naturallandscape');
INSERT INTO `sys_resource` VALUES ('e8294671c0aeae7195fc3c43e2457436', '生物标本查询(分页)', '/biospecimen/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/biospecimen/page');
INSERT INTO `sys_resource` VALUES ('e94e936ee35513a5cbaa0b670a806677', '博物馆基本情况添加', '/museum', 'POST', '1', '2019-09-20 21:22:39', 'POST:/museum');
INSERT INTO `sys_resource` VALUES ('ea1ff9435f36746204efc424f2386a3e', '地质背景查询(分页)', '/geological/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/geological/page');
INSERT INTO `sys_resource` VALUES ('eb0766e055b34846e6f0e8a003dc0f51', '产品推介删除', '/production/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/production/{id}');
INSERT INTO `sys_resource` VALUES ('eed40b7746f536ba707e8c7b3bc3d600', '公园信息添加', '/parkinfo', 'POST', '3', '2019-09-20 21:22:39', 'POST:/parkinfo');
INSERT INTO `sys_resource` VALUES ('ef0c2202d21ea0a946a1aa1fc96b1099', '交流互展删除', '/exchangeexhibition/{id}', 'DELETE', '3', '2019-09-20 21:22:39', 'DELETE:/exchangeexhibition/{id}');
INSERT INTO `sys_resource` VALUES ('f084f47ab2ec0ce7d2846ca0465f9926', '采样信息查询(分页)', '/sampling/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/sampling/page');
INSERT INTO `sys_resource` VALUES ('f4912e9c64d9c95d761a642caac77a3c', '地灾信息添加', '/earthquake', 'POST', '1', '2019-09-20 21:22:39', 'POST:/earthquake');
INSERT INTO `sys_resource` VALUES ('f4b369788d0d337b34bfe8e763168124', 'openApi自然景观详情', '/openApi/naturallandscapeInfo', 'GET', '2', '2019-09-20 21:22:39', 'GET:/openApi/naturallandscapeInfo');
INSERT INTO `sys_resource` VALUES ('f86b169919bf24ce08507f2dcea7de8f', '标示解说编辑', '/commentary/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/commentary/{id}');
INSERT INTO `sys_resource` VALUES ('f880f8a35613b38182612a061291f8a5', '菜单查询(所有)', '/menu/list', 'GET', '3', '2019-09-20 21:22:39', 'GET:/menu/list');
INSERT INTO `sys_resource` VALUES ('f8afb5ec48a65cb7c9cd7e9372118748', '生态环境添加', '/ecosystem', 'POST', '1', '2019-09-20 21:22:39', 'POST:/ecosystem');
INSERT INTO `sys_resource` VALUES ('fad1ecbafb22f1ac0f63486d71393745', '用户查询(分页)', '/user/page', 'GET', '3', '2019-09-20 21:22:39', 'GET:/user/page');
INSERT INTO `sys_resource` VALUES ('fcefc2a889894309e8eaff8f5762240a', '法律法规编辑', '/legal/{id}', 'PUT', '1', '2019-09-20 21:22:39', 'PUT:/legal/{id}');
INSERT INTO `sys_resource` VALUES ('fd1c22d987d0c74044917917a85acfdc', '矿权情况添加', '/mineralright', 'POST', '1', '2019-09-20 21:22:39', 'POST:/mineralright');
INSERT INTO `sys_resource` VALUES ('fdbe8e0f7ae93c33c165fdbc68fdb719', '社会经济状况查询(分页)', '/socialeconomy/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/socialeconomy/page');
INSERT INTO `sys_resource` VALUES ('fe7a8147c0721226e5de8e3e8f6ebf93', '专家导游查询(分页)', '/parklibrary/page', 'GET', '1', '2019-09-20 21:22:39', 'GET:/parklibrary/page');
INSERT INTO `sys_resource` VALUES ('ffdbcf5be43ec6452a9b568c833f8f0a', '法律法规删除', '/legal/{id}', 'DELETE', '1', '2019-09-20 21:22:39', 'DELETE:/legal/{id}');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `create_uid` int(11) NOT NULL COMMENT '创建者ID',
  `update_uid` int(11) NOT NULL COMMENT '修改者ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '1', '1', '2018-11-12 15:59:43', '2018-11-12 15:59:47', '超级管理员');
INSERT INTO `sys_role` VALUES ('2', '普通管理员', '1', '1', '2018-11-12 16:00:17', '2018-11-12 16:00:19', '普通管理员');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1527 DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关系表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1395', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('1396', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('1397', '1', '8');
INSERT INTO `sys_role_menu` VALUES ('1398', '1', '9');
INSERT INTO `sys_role_menu` VALUES ('1399', '1', '10');
INSERT INTO `sys_role_menu` VALUES ('1400', '1', '11');
INSERT INTO `sys_role_menu` VALUES ('1401', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('1402', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('1403', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('1404', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('1405', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('1406', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('1407', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('1408', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('1409', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('1410', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('1411', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('1412', '1', '18');
INSERT INTO `sys_role_menu` VALUES ('1413', '1', '19');
INSERT INTO `sys_role_menu` VALUES ('1414', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('1415', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('1416', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('1417', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('1418', '1', '23');
INSERT INTO `sys_role_menu` VALUES ('1419', '1', '32');
INSERT INTO `sys_role_menu` VALUES ('1420', '1', '33');
INSERT INTO `sys_role_menu` VALUES ('1421', '1', '34');
INSERT INTO `sys_role_menu` VALUES ('1422', '1', '35');
INSERT INTO `sys_role_menu` VALUES ('1423', '1', '51');
INSERT INTO `sys_role_menu` VALUES ('1424', '1', '71');
INSERT INTO `sys_role_menu` VALUES ('1425', '1', '52');
INSERT INTO `sys_role_menu` VALUES ('1426', '1', '73');
INSERT INTO `sys_role_menu` VALUES ('1427', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('1428', '1', '77');
INSERT INTO `sys_role_menu` VALUES ('1429', '1', '31');
INSERT INTO `sys_role_menu` VALUES ('1430', '1', '56');
INSERT INTO `sys_role_menu` VALUES ('1431', '1', '57');
INSERT INTO `sys_role_menu` VALUES ('1432', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('1433', '1', '53');
INSERT INTO `sys_role_menu` VALUES ('1434', '1', '54');
INSERT INTO `sys_role_menu` VALUES ('1435', '1', '72');
INSERT INTO `sys_role_menu` VALUES ('1436', '1', '55');
INSERT INTO `sys_role_menu` VALUES ('1437', '1', '58');
INSERT INTO `sys_role_menu` VALUES ('1438', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('1439', '1', '46');
INSERT INTO `sys_role_menu` VALUES ('1440', '1', '47');
INSERT INTO `sys_role_menu` VALUES ('1441', '1', '48');
INSERT INTO `sys_role_menu` VALUES ('1442', '1', '49');
INSERT INTO `sys_role_menu` VALUES ('1443', '1', '50');
INSERT INTO `sys_role_menu` VALUES ('1444', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('1445', '1', '36');
INSERT INTO `sys_role_menu` VALUES ('1446', '1', '37');
INSERT INTO `sys_role_menu` VALUES ('1447', '1', '38');
INSERT INTO `sys_role_menu` VALUES ('1448', '1', '39');
INSERT INTO `sys_role_menu` VALUES ('1449', '1', '45');
INSERT INTO `sys_role_menu` VALUES ('1450', '1', '74');
INSERT INTO `sys_role_menu` VALUES ('1451', '1', '76');
INSERT INTO `sys_role_menu` VALUES ('1452', '1', '75');
INSERT INTO `sys_role_menu` VALUES ('1490', '2', '22');
INSERT INTO `sys_role_menu` VALUES ('1491', '2', '26');
INSERT INTO `sys_role_menu` VALUES ('1492', '2', '23');
INSERT INTO `sys_role_menu` VALUES ('1493', '2', '32');
INSERT INTO `sys_role_menu` VALUES ('1494', '2', '33');
INSERT INTO `sys_role_menu` VALUES ('1495', '2', '34');
INSERT INTO `sys_role_menu` VALUES ('1496', '2', '35');
INSERT INTO `sys_role_menu` VALUES ('1497', '2', '51');
INSERT INTO `sys_role_menu` VALUES ('1498', '2', '71');
INSERT INTO `sys_role_menu` VALUES ('1499', '2', '52');
INSERT INTO `sys_role_menu` VALUES ('1500', '2', '73');
INSERT INTO `sys_role_menu` VALUES ('1501', '2', '24');
INSERT INTO `sys_role_menu` VALUES ('1502', '2', '77');
INSERT INTO `sys_role_menu` VALUES ('1503', '2', '31');
INSERT INTO `sys_role_menu` VALUES ('1504', '2', '56');
INSERT INTO `sys_role_menu` VALUES ('1505', '2', '57');
INSERT INTO `sys_role_menu` VALUES ('1506', '2', '25');
INSERT INTO `sys_role_menu` VALUES ('1507', '2', '53');
INSERT INTO `sys_role_menu` VALUES ('1508', '2', '54');
INSERT INTO `sys_role_menu` VALUES ('1509', '2', '72');
INSERT INTO `sys_role_menu` VALUES ('1510', '2', '55');
INSERT INTO `sys_role_menu` VALUES ('1511', '2', '58');
INSERT INTO `sys_role_menu` VALUES ('1512', '2', '30');
INSERT INTO `sys_role_menu` VALUES ('1513', '2', '46');
INSERT INTO `sys_role_menu` VALUES ('1514', '2', '47');
INSERT INTO `sys_role_menu` VALUES ('1515', '2', '48');
INSERT INTO `sys_role_menu` VALUES ('1516', '2', '49');
INSERT INTO `sys_role_menu` VALUES ('1517', '2', '50');
INSERT INTO `sys_role_menu` VALUES ('1518', '2', '29');
INSERT INTO `sys_role_menu` VALUES ('1519', '2', '36');
INSERT INTO `sys_role_menu` VALUES ('1520', '2', '37');
INSERT INTO `sys_role_menu` VALUES ('1521', '2', '38');
INSERT INTO `sys_role_menu` VALUES ('1522', '2', '39');
INSERT INTO `sys_role_menu` VALUES ('1523', '2', '45');
INSERT INTO `sys_role_menu` VALUES ('1524', '2', '74');
INSERT INTO `sys_role_menu` VALUES ('1525', '2', '76');
INSERT INTO `sys_role_menu` VALUES ('1526', '2', '75');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` varchar(32) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色资源关系表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) NOT NULL COMMENT '用户名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `status` smallint(2) NOT NULL COMMENT '状态 0：禁用 1：正常',
  `create_uid` int(11) NOT NULL COMMENT '创建者ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `login_name` varchar(16) NOT NULL COMMENT '登陆名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `ip` varchar(32) DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '超级管理员', 'root@163.com', '13866668888', '0', '1', '2019-08-23 10:56:12', '2019-09-20 21:23:09', 'admin', '$apr1$admin$Sl27Fb32LUppR7w2Ovw4V/', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('2', '阿大', '8888@163.com', '13888888888', '0', '1', '2019-08-23 10:57:17', '2019-08-23 10:57:17', 'lichee', '$apr1$lichee$2XUDSi4pQtv7EUyYcswB91', '127.0.0.1');
INSERT INTO `sys_user` VALUES ('3', '李勇', '946509621@qq.com', '17723321245', '0', '1', '2019-09-17 17:31:06', '2019-09-18 17:59:54', 'liyong', '$apr1$liyong$f4uNIOJAUPQKwkBTU.QyD/', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户角色关系表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '3', '2');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `task_name` varchar(100) DEFAULT NULL COMMENT '名字',
  `task_note` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `status` smallint(1) NOT NULL COMMENT '状态：\r\n1. 任务未开始\r\n2. 任务进行中\r\n3. 任务完成\r\n4. 任务失败',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('2', '任务名称', '任务描述', '2019-07-22 11:09:46', '2');
INSERT INTO `task` VALUES ('3', '任务名称', '任务描述', '2019-07-22 11:10:41', '1');
INSERT INTO `task` VALUES ('4', '任务名称', '任务描述', '2019-07-22 11:12:02', '1');
INSERT INTO `task` VALUES ('5', '任务名称', '任务描述', '2019-07-22 11:12:07', '1');
INSERT INTO `task` VALUES ('6', '任务名称', '任务描述', '2019-07-22 11:12:12', '1');
INSERT INTO `task` VALUES ('7', '任务名称', '任务描述', '2019-07-22 11:12:15', '1');
INSERT INTO `task` VALUES ('8', '任务名称', '任务描述', '2019-07-22 11:12:18', '1');
INSERT INTO `task` VALUES ('9', '任务名称', '任务描述', '2019-07-22 11:12:20', '1');
INSERT INTO `task` VALUES ('10', '任务名称', '任务描述', '2019-07-22 11:12:23', '1');
INSERT INTO `task` VALUES ('11', '任务名称', '任务描述', '2019-07-03 11:12:28', '1');
INSERT INTO `task` VALUES ('12', '任务名称', '任务描述', '2019-07-22 11:13:59', '1');
INSERT INTO `task` VALUES ('13', '任务名称', '任务描述', '2019-07-22 11:17:14', '1');
INSERT INTO `task` VALUES ('14', '任务名称', '任务描述', '2019-07-22 14:04:37', '4');
INSERT INTO `task` VALUES ('15', '任务名称', '任务描述', '2019-07-22 14:22:32', '1');
INSERT INTO `task` VALUES ('17', '任务名称', '任务描述', '2019-07-24 15:30:32', '1');
INSERT INTO `task` VALUES ('18', '任务名称', '任务描述', '2019-07-24 15:31:01', '1');
INSERT INTO `task` VALUES ('19', '任务名称', '任务描述', '2019-07-24 15:31:19', '1');
INSERT INTO `task` VALUES ('20', '任务名称', '任务描述', '2019-07-24 15:36:31', '1');
INSERT INTO `task` VALUES ('21', '任务名称', '任务描述', '2019-07-24 15:40:57', '1');
INSERT INTO `task` VALUES ('22', '任务名称', '任务描述', '2019-07-24 15:41:03', '1');
INSERT INTO `task` VALUES ('23', '任务名称', '任务描述', '2019-07-24 15:46:14', '1');
INSERT INTO `task` VALUES ('24', '任务名称', '任务描述', '2019-07-24 15:46:41', '1');
INSERT INTO `task` VALUES ('25', '任务名称', '任务描述', '2019-07-24 15:51:14', '1');
INSERT INTO `task` VALUES ('26', '任务名称', '任务描述', '2019-07-24 16:06:24', '1');
INSERT INTO `task` VALUES ('27', '任务名称', '任务描述', '2019-07-24 16:06:28', '1');
INSERT INTO `task` VALUES ('28', '任务名称', '任务描述', '2019-07-24 16:08:10', '1');
INSERT INTO `task` VALUES ('29', '任务名称', '任务描述', '2019-07-24 16:09:37', '1');
INSERT INTO `task` VALUES ('30', '任务名称', '任务描述', '2019-07-24 16:10:41', '1');
INSERT INTO `task` VALUES ('33', '任务名称', '任务描述', '2019-07-24 16:12:02', '1');
INSERT INTO `task` VALUES ('35', '任务名称', '任务描述', '2019-07-24 16:18:50', '1');
INSERT INTO `task` VALUES ('36', '任务名称', '任务描述', '2019-07-24 16:19:35', '1');
INSERT INTO `task` VALUES ('37', '任务名称', '任务描述', '2019-07-24 16:23:58', '1');
INSERT INTO `task` VALUES ('38', '任务名称', '任务描述', '2019-07-24 16:24:13', '1');
INSERT INTO `task` VALUES ('39', '任务名称', '任务描述', '2019-07-24 17:02:18', '1');
INSERT INTO `task` VALUES ('41', '任务名称', '任务描述', '2019-07-24 17:02:42', '1');
INSERT INTO `task` VALUES ('42', '任务名称', '任务描述', '2019-07-25 18:01:48', '1');
INSERT INTO `task` VALUES ('43', '任务名称', '任务描述', '2019-07-25 18:02:48', '1');
INSERT INTO `task` VALUES ('44', '任务名称', '任务描述', '2019-08-14 17:14:36', '2');
INSERT INTO `task` VALUES ('45', '任务名称11', '任务描述11', '2019-08-26 11:56:53', '2');
INSERT INTO `task` VALUES ('49', '任务名称22', '任务描述22', '2019-08-26 15:12:54', '1');

-- ----------------------------
-- Table structure for vediodocs
-- ----------------------------
DROP TABLE IF EXISTS `vediodocs`;
CREATE TABLE `vediodocs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_id` int(10) NOT NULL COMMENT '地质公园ID',
  `number` varchar(256) NOT NULL COMMENT '文件编号',
  `docname` varchar(256) NOT NULL COMMENT '文件名称',
  `publishtime` varchar(256) NOT NULL COMMENT '发布时间',
  `unit` varchar(256) DEFAULT NULL COMMENT '发布单位',
  `url` text COMMENT '存储地址',
  `note` text COMMENT '文件描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='影像资料';

-- ----------------------------
-- Records of vediodocs
-- ----------------------------
INSERT INTO `vediodocs` VALUES ('1', '1', '1', '1', '1', '1', '/files/vediodocs/15689637354910.sql,/files/vediodocs/15689637396431.txt', '11111');
