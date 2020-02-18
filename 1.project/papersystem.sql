/*
 Navicat MySQL Data Transfer

 Source Server         : myconnection
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : papersystem

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 22/04/2018 10:46:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'ordinary',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1661765936', 'Horizonal', '123456', '普通管理员', '15814521145');
INSERT INTO `admin` VALUES ('2810054549', 'linmusen', '4567', '超级管理员', '18523456456');
INSERT INTO `admin` VALUES ('3519299469', '才哥', '1234567', '普通管理员', '15814513332');
INSERT INTO `admin` VALUES ('5263062109', 'lixiong', '123456', '普通管理员', '15814513345');
INSERT INTO `admin` VALUES ('7449681090', 'Horizon', '123456', '超级管理员', '15814513940');

-- ----------------------------
-- Table structure for newspaper
-- ----------------------------
DROP TABLE IF EXISTS `newspaper`;
CREATE TABLE `newspaper`  (
  `paper_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `paper_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `publisher` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `publish_number` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `publish_date` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `paper_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `storage_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`paper_id`) USING BTREE,
  INDEX `category_id`(`category`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of newspaper
-- ----------------------------
INSERT INTO `newspaper` VALUES ('0640056700', '流行前线', '时尚娱乐', '时尚周刊社', 2.8, '第一版第9期', '每周六', NULL, 2500);
INSERT INTO `newspaper` VALUES ('0958080218', '北方文化', '文化艺术', '张家口出版社', 10, '第1卷第10期', '月中旬', NULL, 3000);
INSERT INTO `newspaper` VALUES ('1117888077', '十九大', '党报党刊', '人民日报', 2.2, '第10期', '每周日', 'D:\\Program Files\\eclipse-workspace\\papersystem\\img\\2.jpg', 1497);
INSERT INTO `newspaper` VALUES ('1275993430', '文化艺术', '北方文化', '张家口出版社', 4.5, '第1卷第1期', '月中旬', NULL, 2000);
INSERT INTO `newspaper` VALUES ('1394709390', '流行前线', '时尚娱乐', '时尚周刊社', 2.1, '第一版第6期', '每周六', NULL, 4000);
INSERT INTO `newspaper` VALUES ('2135118937', '军政月刊', '文化艺术', '张家口出版社', 14.5, '第1卷第6期', '月中旬', NULL, 2000);
INSERT INTO `newspaper` VALUES ('2285267766', '文化艺术', '北方文化', '张家口出版社', 3.4, '第1卷第2期', '月中旬', NULL, 2000);
INSERT INTO `newspaper` VALUES ('3620045508', '十九大', '党报党刊', '人民日报', 1.5, '第2期', '每周日', 'C:\\Users\\Administrator\\Desktop\\学习笔记\\javaweb设计模式\\图片1.jpg', 500);
INSERT INTO `newspaper` VALUES ('4621758592', '军政月刊', '国际军事', '重庆出版社', 12.5, '第8期', '月刊', NULL, 14000);
INSERT INTO `newspaper` VALUES ('4869138900', '北方文化', '文化艺术', '张家口出版社', 4.5, '第1卷第1期', '月中旬', NULL, 2000);
INSERT INTO `newspaper` VALUES ('5450972215', '北方文化', '文化艺术', '张家口出版社', 3.1, '第2卷第1期', '月中旬', NULL, 2000);
INSERT INTO `newspaper` VALUES ('6308233433', '十九大', '党报党刊', '人民日报', 2, '第2期', '每周日', NULL, 2000);
INSERT INTO `newspaper` VALUES ('6446240327', '北方文化', '文化艺术', '张家口出版社', 3.5, '第1卷第4期', '月中旬', NULL, 4000);
INSERT INTO `newspaper` VALUES ('6491979613', '十九大', '党报党刊', '人民日报', 3.3, '第5期', NULL, NULL, 3000);
INSERT INTO `newspaper` VALUES ('6524331539', '军政月刊', '国际军事', '重庆出版社', 2.5, '第5期', '月刊', NULL, 1000);
INSERT INTO `newspaper` VALUES ('7458912254', '流行前线', '时尚娱乐', '时尚周刊社', 2.2, '第一版第5期', '每周六', 'C:\\Users\\Administrator\\Desktop\\学习笔记\\javaweb设计模式\\图片1.jpg', 5000);
INSERT INTO `newspaper` VALUES ('7574013860', '北方文化', '文化艺术', '张家口出版社', 3, '第1卷第1期', '月中旬', NULL, 3000);
INSERT INTO `newspaper` VALUES ('7837069661', '流行前线', '时尚娱乐', '时尚周刊社', 12.5, '第一版第2期', '每周六', NULL, 2000);
INSERT INTO `newspaper` VALUES ('8018244244', '北方文化', '文化艺术', '张家口出版社', 3.2, '第1卷第2期', '月中旬', NULL, 3000);
INSERT INTO `newspaper` VALUES ('8492054144', '北方文化', '文化艺术', '张家口出版社', 3.4, '第1卷第2期', '月中旬', NULL, 2000);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `paper_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`, `paper_id`) USING BTREE,
  INDEX `paper_id`(`paper_id`) USING BTREE,
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_id` FOREIGN KEY (`paper_id`) REFERENCES `newspaper` (`paper_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('1521528031234', '0640056700', 50);
INSERT INTO `order_item` VALUES ('1521528034561', '1117888077', 3);
INSERT INTO `order_item` VALUES ('1521528034561', '4869138900', 2);
INSERT INTO `order_item` VALUES ('1521528035356', '0640056700', 2);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `receiver` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` double DEFAULT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未审核',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1521528031234', '5778310169', '六木', '15814532145', '广东省广州市海珠区仲恺路500号', 104, '2018-03-21 23:28:40', '已审核');
INSERT INTO `orders` VALUES ('1521528034561', '5778310169', '六木', '15814532145', '广东省广州市海珠区仲恺路500号', 15.6, '2018-03-20 22:21:11', '已审核');
INSERT INTO `orders` VALUES ('1521528035356', '0086685312', '李雄二号', '15814532121', '广东省广州市海珠区仲恺路500号', 5.6, '2018-03-20 15:14:22', '已审核');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `job` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0086685312', 'lixiong', '123456', '15814522886', '男', 18, '学生', '14124343@qq.com');
INSERT INTO `user` VALUES ('123123', '张三', '5645', '16549848942', '男', 18, '学生', '23234234@qq.com');
INSERT INTO `user` VALUES ('2', 'jerry', '234', '16515441231', '男', 21, '学生', '1155822@qq.com');
INSERT INTO `user` VALUES ('2891915419', 'zhangsan', '123456', '17878785654', '女', 22, '学生', '1481283@163.com');
INSERT INTO `user` VALUES ('4', 'sam', '567', '188888888', '男', 22, '学生', '15654483@qq.com');
INSERT INTO `user` VALUES ('5159713847', 'linyanbin', '1230', '15814513941', '男', 21, '程序猿', '1456123151@qq.com');
INSERT INTO `user` VALUES ('5615', '王五', '5645', '18945451', '男', 22, '中国好基友', '784515151@qq.com');
INSERT INTO `user` VALUES ('5778310169', '六木', '000000', '15814513444', '男', 22, '老司机', '15564411@qq.com');
INSERT INTO `user` VALUES ('6', '刘宇才', 'wocai', '15814523960', '男', 22, '中国好基友', '215456445@qq.com');
INSERT INTO `user` VALUES ('6892517017', 'James', '456', '15814331121', '男', 33, 'NBA篮球运动员', '1545465464@163.com');
INSERT INTO `user` VALUES ('7', '林文基', 'jige', '15814551511', '男', 22, '中国好基友', '211748484@qq.com');
INSERT INTO `user` VALUES ('7828327484', '季老', '1234', '18712133424', '男', 22, '按摩师', '1883434322@qq.com');
INSERT INTO `user` VALUES ('8', '李志斌', 'feizai', '15815456454', '男', 21, '大学生', '199999212@qq.com');
INSERT INTO `user` VALUES ('8877923412', 'tom123', '123', '15814661241', '男', 18, '学生', '8888888@qq.cpm');
INSERT INTO `user` VALUES ('9943134402', 'oop', '9999', '15814512321', '男', 22, '学生', '2184454545@163.com');
INSERT INTO `user` VALUES ('a123123', '大司马', 'asddd', '185551884', '男', 22, '小学生', NULL);
INSERT INTO `user` VALUES ('dsdsd', '李四', '5645', '15616511', '男', 28, '老油条', '77777@163.com');
INSERT INTO `user` VALUES ('q212d', '刘六', 'asddd', '18945451', '男', 30, '副总统', '88888@163.com');

SET FOREIGN_KEY_CHECKS = 1;
