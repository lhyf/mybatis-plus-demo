/*
 Navicat Premium Data Transfer

 Source Server         : 本机Mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 127.0.0.1:3306
 Source Schema         : mybatis-plus-demo

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 08/03/2020 18:03:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int(1) NULL DEFAULT NULL COMMENT '1-男 0-女',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `version` int(11) UNSIGNED NULL DEFAULT 1 COMMENT '乐观锁版本',
  `deleted` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '1:已删除 0:未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zhangsan', '654321', '张三', 1, 20, 'zhangsan@163.com', 2, 1);
INSERT INTO `t_user` VALUES (2, 'lisi', '123456', '李四', 1, 19, 'lisi@163.com', 1, 0);
INSERT INTO `t_user` VALUES (3, 'wangwu', '123456', '王五', 1, 20, 'wangwu@outlook.com', 1, 0);
INSERT INTO `t_user` VALUES (4, 'zhaoliu', '123456', '赵六', 1, 21, 'zhaoliu@outlook.com', 1, 0);
INSERT INTO `t_user` VALUES (5, 'xiaoqing', '123', '小青', 0, NULL, 'xiaoqing@163.com', 1, 0);
INSERT INTO `t_user` VALUES (6, 'xiaohong', '123', '小红', 0, NULL, 'xiaohong@163.com', 1, 0);
INSERT INTO `t_user` VALUES (7, 'xiaobai', 'abc123', '小白', 0, 20, 'xiaobai@outlook.com', 1, 0);
INSERT INTO `t_user` VALUES (9, 'xiaozao', '123', '小皂', 0, NULL, 'xiaozao@163.com', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
