
create database randommenu;
use randommenu;


/*
 Navicat Premium Data Transfer

 Source Server         : localMysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : mp

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 13/03/2022 21:23:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for restaurant
-- ----------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant` (
  `Id` bigint(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `distance` varchar(256) DEFAULT NULL,
  `menu` varchar(2000) DEFAULT NULL,
  `totalPrice` decimal(10,2) DEFAULT NULL,
  `averagePrice` decimal(10,2) DEFAULT NULL,
  `personNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of restaurant
-- ----------------------------
BEGIN;
INSERT INTO `restaurant` VALUES (00000000001, '亿家小厨', '炒菜', '300', '1. 魔芋烧鸭\n2. 千锅羊杂\n3. 乐山辣子鸡\n4. 鱼香肉丝\n5. 麻辣鸭血\n6. 椒盐排条\n7. 番茄炒蛋\n8. 麻辣豆腐\n9. 上汤娃娃菜\n10. 蒜泥空心菜\n11. 紫菜蛋汤\n', 324.00, 27.00, 12);
INSERT INTO `restaurant` VALUES (00000000002, '滋补烩面', '面馆', '100', '', 12.00, 22.00, 10);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localMysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : mp

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 13/03/2022 21:22:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `Id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `rid` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '黑椒牛仔骨', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (2, '跳水翘嘴鱼', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (3, '红烧牛肉', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (4, '双椒鱼头', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (5, '双椒牛蛙', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (6, '红烧肥肠', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (7, '魔芋烧鸭', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (8, '酸菜黑鱼片', '肉', 48.00, 1);
INSERT INTO `menu` VALUES (9, '梅菜扣肉', '肉', 48.00, 1);
INSERT INTO `menu` VALUES (10, '金金针肥牛锅仔', '肉', 48.00, 1);
INSERT INTO `menu` VALUES (11, '千锅肥肠', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (12, '黑椒牛仔骨', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (13, '千锅牛蛙', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (14, '千锅千页豆腐', '素', 28.00, 1);
INSERT INTO `menu` VALUES (15, '千锅手撕包菜', '素', 26.00, 1);
INSERT INTO `menu` VALUES (16, '葱爆肥牛', '肉', 38.00, 1);
INSERT INTO `menu` VALUES (17, '乐山辣子鸡', '肉', 32.00, 1);
INSERT INTO `menu` VALUES (18, '酸辣鸡杂', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (19, '千煸四季豆', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (20, '剁剁椒臭豆腐', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (21, '宫保鸡于', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (22, '鱼香肉丝', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (23, '农家小炒肉', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (24, '川味回锅肉', '肉', 26.00, 1);
INSERT INTO `menu` VALUES (25, '麻辣鸭血', '肉', 18.00, 1);
INSERT INTO `menu` VALUES (26, '麻辣豆腐', '素', 16.00, 1);
INSERT INTO `menu` VALUES (27, '羊肉锅仔', '肉', 88.00, 1);
INSERT INTO `menu` VALUES (28, '牛肉锅仔', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (29, '羊杂锅仔', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (30, '咸鸡锅仔', '肉', 56.00, 1);
INSERT INTO `menu` VALUES (31, '咸鸱锅仔', '肉', 52.00, 1);
INSERT INTO `menu` VALUES (32, '金牌蒜香骨', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (33, '清炒虾仁', '肉', 68.00, 1);
INSERT INTO `menu` VALUES (34, '响油鳝丝', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (35, '清蒸上海香肠', '肉', 38.00, 1);
INSERT INTO `menu` VALUES (36, '蚝油牛肉', '肉', 38.00, 1);
INSERT INTO `menu` VALUES (37, '酱爆猪肝', '肉', 32.00, 1);
INSERT INTO `menu` VALUES (38, '荠菜双菇虾仁', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (39, '蚝油双菇', '素', 28.00, 1);
INSERT INTO `menu` VALUES (40, '上汤西蓝花', '素', 28.00, 1);
INSERT INTO `menu` VALUES (41, '上汤娃娃菜', '素', 26.00, 1);
INSERT INTO `menu` VALUES (42, '香菇油面筋', '素', 26.00, 1);
INSERT INTO `menu` VALUES (43, '大煮干丝', '肉', 26.00, 1);
INSERT INTO `menu` VALUES (44, '虾仁蒸水蛋', '肉', 26.00, 1);
INSERT INTO `menu` VALUES (45, '重庆毛血旺', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (46, '水煮牛肉', '肉', 48.00, 1);
INSERT INTO `menu` VALUES (47, '水煮鱼片', '肉', 46.00, 1);
INSERT INTO `menu` VALUES (48, '水煮肉片', '肉', 32.00, 1);
INSERT INTO `menu` VALUES (49, '椒盐排条', '肉', 32.00, 1);
INSERT INTO `menu` VALUES (50, '外婆菜炒蛋', '蛋', 28.00, 1);
INSERT INTO `menu` VALUES (51, '木耳肉片', '肉', 26.00, 1);
INSERT INTO `menu` VALUES (52, '黄瓜肉片', '肉', 26.00, 1);
INSERT INTO `menu` VALUES (53, '青椒肉丝', '肉', 26.00, 1);
INSERT INTO `menu` VALUES (54, '烂糊肉丝', '肉', 26.00, 1);
INSERT INTO `menu` VALUES (55, '芹菜肉丝', '肉', 24.00, 1);
INSERT INTO `menu` VALUES (56, '腐竹炒肉', '肉', 24.00, 1);
INSERT INTO `menu` VALUES (57, '番茄炒蛋', '蛋', 22.00, 1);
INSERT INTO `menu` VALUES (58, '尖椒鸡蛋', '蛋', 22.00, 1);
INSERT INTO `menu` VALUES (59, '韭菜千张', '素', 18.00, 1);
INSERT INTO `menu` VALUES (60, '韭菜炒蛋', '蛋', 18.00, 1);
INSERT INTO `menu` VALUES (61, '酸辣白菜', '素', 22.00, 1);
INSERT INTO `menu` VALUES (62, '酸辣藕片', '素', 22.00, 1);
INSERT INTO `menu` VALUES (63, '蒜泥生菜', '素', 18.00, 1);
INSERT INTO `menu` VALUES (64, '清炒青菜', '素', 18.00, 1);
INSERT INTO `menu` VALUES (65, '蒜泥空心菜', '素', 18.00, 1);
INSERT INTO `menu` VALUES (66, '蒜泥菠菜', '素', 18.00, 1);
INSERT INTO `menu` VALUES (67, '海朋友', '素', 68.00, 1);
INSERT INTO `menu` VALUES (68, '河朋友', '肉', 58.00, 1);
INSERT INTO `menu` VALUES (69, '红烧蒂鱼', '肉', 48.00, 1);
INSERT INTO `menu` VALUES (70, '清蒸鲈鱼', '肉', 38.00, 1);
INSERT INTO `menu` VALUES (71, '香拌牛肉', '肉', 46.00, 1);
INSERT INTO `menu` VALUES (72, '香拌猪互朵', '肉', 38.00, 1);
INSERT INTO `menu` VALUES (73, '香拌猪头肉', '肉', 36.00, 1);
INSERT INTO `menu` VALUES (74, '口水鸡', '肉', 28.00, 1);
INSERT INTO `menu` VALUES (75, '金针菇拌牛百叶', '素', 22.00, 1);
INSERT INTO `menu` VALUES (76, '剁椒皮蛋', '蛋', 18.00, 1);
INSERT INTO `menu` VALUES (77, '皮蛋豆腐', '素', 18.00, 1);
INSERT INTO `menu` VALUES (78, '刀拍黄瓜', '素', 18.00, 1);
INSERT INTO `menu` VALUES (79, '盐水花生', '素', 16.00, 1);
INSERT INTO `menu` VALUES (80, '花生米', '素', 14.00, 1);
INSERT INTO `menu` VALUES (81, '香菜肉未豆腐羹', '汤', 22.00, 1);
INSERT INTO `menu` VALUES (82, '肉沫粉汤', '汤', 18.00, 1);
INSERT INTO `menu` VALUES (83, '酸辣汤', '汤', 18.00, 1);
INSERT INTO `menu` VALUES (84, '番茄蛋汤', '汤', 16.00, 1);
INSERT INTO `menu` VALUES (85, '紫菜蛋汤', '汤', 16.00, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

