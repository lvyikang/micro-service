#测试表
#DROP TABLE IF EXISTS `student`;  # 删除原表，IF EXISTS ：防止报错
CREATE TABLE `student` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '学生表主键',
    `name` VARCHAR(80) DEFAULT NULL COMMENT '姓名',
    `classes` VARCHAR(80) DEFAULT NULL COMMENT '班级',
    `gender` VARCHAR(20) DEFAULT NULL COMMENT '性别：男M/女F',
    `age` SMALLINT DEFAULT NULL COMMENT '年龄',
    `school` VARCHAR(200) NOT NULL DEFAULT '全国第一中学' COMMENT '学校',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 DEFAULT COLLATE = utf8mb4_0900_ai_ci COMMENT='学生表';
SELECT * FROM student;


INSERT INTO `student` (`id`, `name`, `classes`, `gender`, `age`, `school`, `create_time`, `update_time`) VALUES('1','李四','九年一班','F','15','全国第一中学','2022-12-16 15:36:36','2022-12-16 15:36:36');
INSERT INTO `student` (`id`, `name`, `classes`, `gender`, `age`, `school`, `create_time`, `update_time`) VALUES('2','张三','九年二班','M','16','全国第一中学','2022-12-16 15:37:30','2022-12-16 15:37:33');
INSERT INTO `student` (`id`, `name`, `classes`, `gender`, `age`, `school`, `create_time`, `update_time`) VALUES('3','哈哈','九年二班','M','16','全国第一中学','2022-12-16 15:39:41','2022-12-16 15:39:44');
SELECT * FROM student;