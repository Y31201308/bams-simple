/*
MySQL Data Transfer
Source Host: localhost
Source Database: pinhuba_bams_simple
Target Host: localhost
Target Database: pinhuba_bams_simple
Date: 2015/4/21 21:00:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for hrm_department
-- ----------------------------
CREATE TABLE `hrm_department` (
  `dep_id` int(11) NOT NULL auto_increment,
  `hrm_dep_id` varchar(50) NOT NULL,
  `hrm_dep_code` varchar(50) default NULL,
  `hrm_dep_name` varchar(100) default NULL,
  `hrm_dep_engname` varchar(100) default NULL,
  `hrm_dep_upid` varchar(50) default NULL,
  `hrm_emp_id` varchar(50) default NULL,
  `hrm_dep_desc` varchar(500) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  `hrm_dep_showrow` int(11) NOT NULL default '99',
  PRIMARY KEY  (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hrm_employee
-- ----------------------------
CREATE TABLE `hrm_employee` (
  `hrm_employee_id` varchar(50) NOT NULL,
  `hrm_employee_name` varchar(100) default NULL,
  `hrm_employee_engname` varchar(100) default NULL,
  `hrm_employee_simple` varchar(100) default NULL,
  `hrm_employee_code` varchar(50) default NULL COMMENT '员工工号|1|2|2|0',
  `hrm_employee_pattern_id` varchar(20) default NULL COMMENT '用工形式',
  `hrm_employee_birthday` varchar(20) default NULL COMMENT '生日',
  `hrm_employee_sex` varchar(20) default NULL COMMENT '性别',
  `hrm_employee_marriage` varchar(20) default NULL COMMENT '婚姻状况',
  `hrm_employee_politics` varchar(20) default NULL,
  `hrm_employee_nationality` varchar(20) default NULL,
  `hrm_employee_blood_type` varchar(20) default NULL,
  `hrm_employee_height` varchar(20) default NULL,
  `hrm_employee_weight` varchar(20) default NULL,
  `hrm_employee_image_info_id` int(11) default NULL,
  `hrm_employee_school` varchar(100) default NULL,
  `hrm_employee_professional` varchar(100) default NULL,
  `hrm_employee_degree` varchar(20) default NULL,
  `hrm_employee_identitycard` varchar(20) default NULL,
  `hrm_employee_hometown` varchar(200) default NULL,
  `hrm_employee_house_phone` varchar(50) default NULL,
  `hrm_employee_house_address` varchar(200) default NULL,
  `hrm_employee_mobile_tele` varchar(50) default NULL,
  `hrm_employee_work_tele` varchar(50) default NULL,
  `hrm_employee_in_time` varchar(20) default NULL,
  `hrm_employee_depid` int(11) default NULL,
  `hrm_employee_workareaid` int(11) default NULL,
  `hrm_employee_post_id` int(11) default NULL,
  `hrm_employee_squad_id` int(11) default NULL,
  `hrm_employee_email` varchar(100) default NULL,
  `hrm_employee_urgent_preson` varchar(200) default NULL,
  `hrm_employee_urgent_phone` varchar(200) default NULL,
  `hrm_employee_adderss` varchar(200) default NULL,
  `hrm_employee_appendid` varchar(5000) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  `hrm_employee_work_time` varchar(20) default NULL,
  `hrm_part_post` varchar(100) default NULL,
  `hrm_employee_status` int(11) default NULL,
  `hrm_other_attachmen` varchar(500) default NULL,
  `hrm_employee_active` int(11) default NULL,
  PRIMARY KEY  (`hrm_employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hrm_post
-- ----------------------------
CREATE TABLE `hrm_post` (
  `post_id` int(11) NOT NULL auto_increment,
  `hrm_post_id` varchar(50) default NULL,
  `hrm_post_name` varchar(100) default NULL,
  `hrm_post_engname` varchar(100) default NULL,
  `hrm_post_upid` varchar(50) default NULL,
  `hrm_post_mang` varchar(50) default NULL,
  `hrm_post_desc` varchar(500) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  `hrm_post_showrow` int(11) NOT NULL default '99',
  PRIMARY KEY  (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_attachment_info
-- ----------------------------
CREATE TABLE `sys_attachment_info` (
  `attachment_id` int(11) NOT NULL auto_increment,
  `attachment_filename` varchar(500) default NULL,
  `attachment_name` varchar(100) default NULL,
  `attachment_rename` varchar(100) default NULL,
  `attachment_description` varchar(500) default NULL,
  `attachment_remark` varchar(500) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  PRIMARY KEY  (`attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_column_control
-- ----------------------------
CREATE TABLE `sys_column_control` (
  `column_control_id` int(11) NOT NULL auto_increment,
  `column_code` varchar(100) default NULL,
  `column_name` varchar(100) default NULL,
  `is_show` int(11) default '0',
  `table_name` varchar(50) default NULL,
  `isshow_simple` int(11) default NULL,
  `isshow_advanced` int(11) default NULL,
  `column_strcount` int(11) default '0',
  `priority` int(11) default NULL,
  PRIMARY KEY  (`column_control_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_exception
-- ----------------------------
CREATE TABLE `sys_exception` (
  `exception_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `exception_date` datetime default NULL,
  `exception_msg` text,
  `exception_class` varchar(200) default NULL,
  `exception_context` longtext,
  `process_name` varchar(50) default NULL,
  `process_date` varchar(20) default NULL,
  `process_context` longtext,
  `exception_status` int(11) default NULL,
  PRIMARY KEY  (`exception_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_image_info
-- ----------------------------
CREATE TABLE `sys_image_info` (
  `image_info_id` int(11) NOT NULL auto_increment,
  `image_info_filename` varchar(500) default NULL,
  `image_info_filepath` varchar(500) default NULL,
  `image_info_name` varchar(100) default NULL,
  `image_info_rename` varchar(100) default NULL,
  `image_info_description` varchar(500) default NULL,
  `image_info_remark` varchar(200) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  PRIMARY KEY  (`image_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_library_info
-- ----------------------------
CREATE TABLE `sys_library_info` (
  `library_id` int(11) NOT NULL auto_increment,
  `library_info_code` varchar(20) default NULL,
  `library_info_name` varchar(50) default NULL,
  `library_info_engname` varchar(100) default NULL,
  `library_info_upcode` varchar(20) default NULL,
  `library_info_isvalid` int(11) default '1',
  `library_info_desc` varchar(500) default NULL,
  PRIMARY KEY  (`library_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_method_help
-- ----------------------------
CREATE TABLE `sys_method_help` (
  `help_id` int(11) NOT NULL auto_increment,
  `help_img` varchar(255) default NULL,
  `help_desc` varchar(255) default NULL,
  `method_id` varchar(10) default NULL,
  PRIMARY KEY  (`help_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_method_info
-- ----------------------------
CREATE TABLE `sys_method_info` (
  `method_info_id` varchar(20) NOT NULL,
  `method_info_name` varchar(20) default NULL,
  `method_info_engname` varchar(50) default NULL,
  `method_uri` varchar(500) default NULL,
  `method_no` int(11) default NULL,
  `image_src` varchar(100) default NULL,
  `method_level` int(11) default NULL,
  `level_unit` varchar(20) default NULL,
  `is_action` int(11) default '1',
  `method_sign` varchar(20) default NULL,
  `method_msg` varchar(1000) default NULL,
  `method_pages` varchar(1000) default NULL,
  PRIMARY KEY  (`method_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
CREATE TABLE `sys_param` (
  `param_id` int(11) NOT NULL auto_increment,
  `param_index` varchar(50) default NULL,
  `param_title` varchar(100) default NULL,
  `param_value` varchar(50) default NULL,
  `param_remark` varchar(500) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  `param_type` int(11) default NULL,
  `param_type_value` varchar(500) default NULL,
  PRIMARY KEY  (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(100) default NULL,
  `role_desc` varchar(500) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_bind
-- ----------------------------
CREATE TABLE `sys_role_bind` (
  `bind_id` int(11) NOT NULL auto_increment,
  `bind_type` int(11) default NULL,
  `role_id` int(11) default NULL,
  `bind_value` varchar(100) default NULL,
  PRIMARY KEY  (`bind_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_detail
-- ----------------------------
CREATE TABLE `sys_role_detail` (
  `role_detail_id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `method_id` varchar(10) default NULL,
  PRIMARY KEY  (`role_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_group
-- ----------------------------
CREATE TABLE `sys_user_group` (
  `group_id` int(11) NOT NULL auto_increment,
  `group_name` varchar(100) default NULL,
  `group_decp` varchar(500) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmode_date` datetime default NULL,
  PRIMARY KEY  (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_group_detail
-- ----------------------------
CREATE TABLE `sys_user_group_detail` (
  `group_detail_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `group_id` int(11) default NULL,
  PRIMARY KEY  (`group_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
CREATE TABLE `sys_user_info` (
  `user_id` int(11) NOT NULL auto_increment,
  `hrm_employee_id` varchar(50) default NULL,
  `user_name` varchar(100) default NULL,
  `userpassword` varchar(100) default NULL,
  `user_action` int(11) default NULL,
  `record_id` varchar(50) default NULL,
  `record_date` datetime default NULL,
  `lastmodi_id` varchar(50) default NULL,
  `lastmodi_date` datetime default NULL,
  `user_type` int(11) default '1',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_methods
-- ----------------------------
CREATE TABLE `sys_user_methods` (
  `user_method_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `user_method_detail` longtext,
  PRIMARY KEY  (`user_method_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `hrm_department` VALUES ('56', '01', '000001', '总经办', 'ZJB', '00', '182014052421104440246', '', '51', '2013-05-21 15:27:11', '182013052121033133083', '2014-10-05 14:11:20', '1');
INSERT INTO `hrm_department` VALUES ('57', '0101', '', '开发一部', '', '01', null, '', '182013072730085454643', '2013-07-27 13:14:48', '182013052121033133083', '2015-03-15 16:19:17', '1');
INSERT INTO `hrm_department` VALUES ('59', '0103', '', '财务部', '', '01', null, '', '182013072730085454643', '2013-07-27 13:19:41', '182013052121033133083', '2015-03-14 16:15:24', '3');
INSERT INTO `hrm_department` VALUES ('60', '0104', '', '市场部', '', '01', null, '', '182013072730085454643', '2013-07-27 13:23:44', '182013072730085454643', '2013-07-27 13:23:44', '4');
INSERT INTO `hrm_department` VALUES ('61', '0105', '', '研发部', '', '01', null, '', '182013072730085454643', '2013-07-27 13:25:21', '182013072730085454643', '2013-07-27 13:25:21', '6');
INSERT INTO `hrm_department` VALUES ('62', '0106', '', '运维部', '', '01', null, '', '182013072730085454643', '2013-07-27 13:27:06', '182013052121033133083', '2014-07-07 10:12:44', '5');
INSERT INTO `hrm_department` VALUES ('63', '0107', '', '开发三部', '', '01', null, '', '182013072730085454643', '2013-07-27 13:28:42', '182013072730085454643', '2013-07-27 13:28:42', '7');
INSERT INTO `hrm_department` VALUES ('64', '010301', '', '开发四部', '', '0103', null, '', '182013072730085454643', '2013-07-27 13:28:58', '182013072730085454643', '2013-07-27 13:56:14', '1');
INSERT INTO `hrm_department` VALUES ('65', '010101', '', '开发一组', '', '0101', null, '', '182013072730085454643', '2013-07-27 13:41:25', '182013072730085454643', '2013-07-27 13:41:25', '1');
INSERT INTO `hrm_department` VALUES ('66', '010102', '', '开发二组', '', '0101', null, '', '182013072730085454643', '2013-07-28 15:13:08', '182013072730085454643', '2013-07-28 15:13:08', '2');
INSERT INTO `hrm_department` VALUES ('67', '010103', '', '开发三组', '', '0101', null, '', '182013072730085454643', '2013-07-28 15:13:21', '182013072730085454643', '2013-07-28 15:13:21', '3');
INSERT INTO `hrm_department` VALUES ('68', '010104', '', '开发四组', '', '0101', null, '', '182013072730085454643', '2013-07-28 15:13:31', '182013072730085454643', '2013-07-28 15:13:31', '4');
INSERT INTO `hrm_department` VALUES ('69', '0108', '', '证券投资部', '', '01', null, '', '182013052121033133083', '2013-09-20 10:34:04', '182013052121033133083', '2013-09-20 10:34:04', '8');
INSERT INTO `hrm_department` VALUES ('70', '0109', '', '电子工程部', '', '01', null, '', '182013052121033133083', '2013-09-20 10:47:31', '182013052121033133083', '2013-09-20 10:47:31', '9');
INSERT INTO `hrm_department` VALUES ('71', '0110', '', '市场服务部', '', '01', null, '', '182013052121033133083', '2013-09-20 11:24:19', '182013052121033133083', '2014-03-28 16:27:29', '10');
INSERT INTO `hrm_department` VALUES ('72', '010501', '', '研发一部', '', '0105', null, '', '182013052121033133083', '2013-09-20 11:26:33', '182013052121033133083', '2013-09-20 11:26:33', '1');
INSERT INTO `hrm_department` VALUES ('73', '0111', '', '电子商务部', '', '01', null, '', '182013052121033133083', '2013-09-20 11:46:19', '182013052121033133083', '2013-09-20 11:46:19', '11');
INSERT INTO `hrm_department` VALUES ('75', '01010301', '', '三组第一小组', '', '010103', null, '', '182013072730085454643', '2013-10-28 22:49:43', '182013052121033133083', '2014-08-10 17:02:50', '1');
INSERT INTO `hrm_department` VALUES ('76', '02', '', '造价部', '', '00', null, '', '182013052121033133083', '2014-04-13 18:34:32', '182013052121033133083', '2014-04-13 18:34:32', '2');
INSERT INTO `hrm_department` VALUES ('77', '0201', '', '报价部', '', '02', null, '', '182013052121033133083', '2014-04-13 18:34:55', '182013052121033133083', '2014-04-13 18:34:55', '1');
INSERT INTO `hrm_department` VALUES ('78', '03', '', '品互网络', '', '00', null, '', '182013052121033133083', '2015-03-16 08:31:29', '182013052121033133083', '2015-03-16 08:31:29', '3');
INSERT INTO `hrm_department` VALUES ('79', '0301', '', '开发一部', '', '03', null, '', '182013052121033133083', '2015-03-16 08:31:43', '182013052121033133083', '2015-03-16 08:31:43', '1');
INSERT INTO `hrm_department` VALUES ('80', '0302', '', '开发二部', '', '03', null, '', '182013052121033133083', '2015-03-16 08:31:57', '182013052121033133083', '2015-03-16 08:31:57', '2');
INSERT INTO `hrm_employee` VALUES ('182013052121033133083', '狄晓靖', 'DXJ', 'DXJ', '000005', '2142', '1990-05-21', '1', '2146', '2197', '2208', '2202', '', '', '85', '', '', '2265', '237273788356789876', '江苏宜兴', '0510-807167483', '江苏宜兴红塔新苑15栋507', '18061563967', '', '2013-05-21', '76', '15', '23', null, '', '小丁', '18061563967', '江苏宜兴红塔新苑15栋507', '', '51', '2013-05-21 15:31:33', '182013052121033133083', '2015-03-15 22:46:48', '2013-05-21', '25,', '2', '5', '1');
INSERT INTO `hrm_employee` VALUES ('182013072730040551054', '李四', '', 'LS', '123456', '2142', '1988-06-03', '1', '2145', '2197', '2208', '2202', '', '', '47', '', '', '2265', '123', '', '', '', '', '', '2013-07-27', '65', '15', '26', null, '', '', '', '', '', '182013072730085454643', '2013-07-27 16:05:50', '182013072730085454643', '2014-03-14 09:44:52', '2013-07-27', '', null, '', '1');
INSERT INTO `hrm_employee` VALUES ('182013072730085454643', '张三', '', 'ZS', '123', '2142', '2013-01-27', '1', '2145', '2197', '2208', '2202', '', '', '57', '', '', '2265', '123', '', '', '', '', '', '2013-07-08', '56', '15', '0', null, '', '', '', '', '', '182013052121033133083', '2013-07-27 08:54:54', '182013072931083905862', '2014-05-24 00:31:45', '2013-08-30', '', '2', '454', '1');
INSERT INTO `hrm_employee` VALUES ('182013072931083905862', '王五', '', 'WW', '1234', '2142', '2008-09-01', '1', '2145', '2197', '2208', '2202', '', '', '0', '', '', '2265', '23256532565', '', '', '江苏无锡', '123456', '123456', '2010-09-01', '60', '15', null, null, '', '', '', '', '', '182013072730085454643', '2013-07-29 08:39:00', '182013052121033133083', '2014-09-06 19:09:14', '2013-09-19', '', '1', '', '1');
INSERT INTO `hrm_employee` VALUES ('18201401285024208188', '马六', '', 'ML', '1233', '2142', '1989-01-28', '1', '2145', '2197', '2208', '2202', '', '', '51', '', '', '2265', '123', '', '', '', '', '', '2014-01-28', '65', '15', null, null, '', '', '', '', '', '182013072730085454643', '2014-01-28 14:42:08', '182013052121033133083', '2014-03-14 10:35:58', '2014-01-28', '', '2', '', '1');
INSERT INTO `hrm_employee` VALUES ('182014032913033222840', '小七', '', 'XQ', '111', '2142', '2009-03-29', '1', '2145', '2197', '2208', '2202', '', '', '55', '', '', '2265', '123', '', '', '', '', '', '2014-03-29', '62', '15', '26', null, '', '', '', '', '', '182013052121033133083', '2014-03-29 15:32:22', '182013072931083905862', '2014-05-24 01:23:08', '2014-03-29', '', '2', '305', '1');
INSERT INTO `hrm_employee` VALUES ('182014052421084820990', '蒋超', '', 'JC', '员工编号', '2142', '1988-06-03', '1', '2145', '2197', '2208', '2202', '', '', '0', '', '', '2265', '320282198806030695', '', '', '', '', '', '2014-03-24', '57', '15', '25', null, '', '', '', '', '', '182013052121033133083', '2014-05-24 20:48:20', '182013052121033133083', '2014-08-08 13:22:12', '2014-05-24', '', '2', '', '1');
INSERT INTO `hrm_employee` VALUES ('182014052421102129560', '张艳', '', 'ZY', '员工编号2', '2142', '1988-09-25', '2', '2145', '2197', '2208', '2202', '', '', '0', '', '', '2265', '320282198896929101', '', '', '', '', '', '2014-02-24', '59', '15', '0', null, '', '', '', '', '', '182014052421084820990', '2014-05-24 22:21:29', '182014052421084820990', '2014-05-24 22:21:29', '2014-05-24', '', '2', '', '1');
INSERT INTO `hrm_employee` VALUES ('182014052421104440246', '张亮', '', 'ZL', '员工编号3', '2142', '1989-05-24', '1', '2145', '2197', '2208', '2202', '', '', '0', '', '', '2265', '321123123123123123', '', '', '', '', '', '2014-05-24', '56', '15', '0', null, '', '', '', '', '', '182013072931083905862', '2014-05-24 22:44:40', '182013072931083905862', '2014-05-24 22:44:40', '2014-05-24', '', '2', '', '1');
INSERT INTO `hrm_post` VALUES ('23', '01', '董事长', '', '00', null, '', '182013052121033133083', '2013-07-27 15:58:18', '182013052121033133083', '2013-07-27 15:58:18', '1');
INSERT INTO `hrm_post` VALUES ('24', '0107', '总经理', '', '01', null, '', '182013052121033133083', '2013-07-27 15:58:40', '182013072730040551054', '2014-05-24 16:06:43', '7');
INSERT INTO `hrm_post` VALUES ('25', '0102', '财务总监', '', '01', null, '', '182013072730085454643', '2013-07-27 15:58:57', '182013072730040551054', '2014-05-24 16:06:33', '3');
INSERT INTO `hrm_post` VALUES ('26', '0103', '销售总监', '', '01', null, '', '182013072730085454643', '2013-07-27 15:59:08', '182013052121033133083', '2015-03-16 08:34:05', '2');
INSERT INTO `hrm_post` VALUES ('27', '0104', '销售员', '', '01', null, '', '182013052121033133083', '2013-09-20 09:59:50', '182013052121033133083', '2013-09-20 09:59:50', '5');
INSERT INTO `hrm_post` VALUES ('28', '0105', '研发工程师', '', '01', null, '', '182013072730085454643', '2013-09-20 11:29:06', '182013072730085454643', '2013-09-20 11:29:06', '6');
INSERT INTO `hrm_post` VALUES ('29', '010501', '一级研发工程师', '', '0105', null, '', '182013052121033133083', '2013-09-20 11:34:31', '182013052121033133083', '2013-09-20 11:34:31', '1');
INSERT INTO `hrm_post` VALUES ('30', '010502', '二级研发工程师', '', '0105', null, '', '182013052121033133083', '2013-09-20 11:48:56', '182013052121033133083', '2013-09-20 11:48:56', '2');
INSERT INTO `hrm_post` VALUES ('31', '010503', '二级研发工程师', '', '0105', null, '', '182013052121033133083', '2013-09-20 11:55:14', '182013052121033133083', '2013-09-20 11:55:14', '3');
INSERT INTO `hrm_post` VALUES ('32', '010401', '初级销售员', '', '0104', null, '', '182013052121033133083', '2013-09-20 12:01:25', '182013052121033133083', '2013-09-20 12:01:25', '1');
INSERT INTO `hrm_post` VALUES ('33', '0106', '人事经理', '', '01', null, '', '182013052121033133083', '2013-09-20 12:05:24', '182013052121033133083', '2013-09-20 12:05:24', '4');
INSERT INTO `sys_attachment_info` VALUES ('5', 'QzovQmFtc0Rvd25sb2Fkcy9maWxlL3BlcnNvbjUyL0JBTVPmiYvlhoxfMjAxNTAzMTQyMTM0MDkxNDIuZG9jeA@3@3', 'BAMS手册.docx', 'BAMS手册_20150314213409142.docx', null, null, '182013052121033133083', '2015-03-15 22:46:48', '182013052121033133083', '2015-03-15 22:46:48');
INSERT INTO `sys_column_control` VALUES ('1', 'primaryKey', 'I D', '2', '人员列表', '2', '2', '0', '1');
INSERT INTO `sys_column_control` VALUES ('2', 'hrmEmployeeName', '员工姓名', '1', '人员列表', '1', '1', '25', '2');
INSERT INTO `sys_column_control` VALUES ('7', 'hrmEmployeeInTime', '入职日期', '1', '人员列表', '1', '1', '0', '3');
INSERT INTO `sys_column_control` VALUES ('8', 'hrmEmployeeCode', '员工编码', '1', '人员列表', '1', '1', '0', '4');
INSERT INTO `sys_column_control` VALUES ('9', 'hrmEmployeeSex', '性别', '1', '人员列表', '2', '1', '0', '5');
INSERT INTO `sys_column_control` VALUES ('10', 'primaryKey', '功能编号', '1', '系统功能列表', '1', '1', '0', '1');
INSERT INTO `sys_column_control` VALUES ('11', 'methodInfoName', '功能名称', '1', '系统功能列表', '1', '1', '25', '2');
INSERT INTO `sys_column_control` VALUES ('12', 'methodUri', '跳转路径', '1', '系统功能列表', '2', '2', '25', '3');
INSERT INTO `sys_column_control` VALUES ('13', 'methodNo', '显示顺序', '1', '系统功能列表', '2', '2', '0', '4');
INSERT INTO `sys_column_control` VALUES ('14', 'methodLevel', '等级', '1', '系统功能列表', '2', '1', '0', '5');
INSERT INTO `sys_column_control` VALUES ('15', 'upSysMethodInfo.methodInfoName', '上级功能', '1', '系统功能列表', '2', '2', '25', '6');
INSERT INTO `sys_column_control` VALUES ('16', 'isAction', '状态', '1', '系统功能列表', '2', '1', '0', '7');
INSERT INTO `sys_column_control` VALUES ('17', 'primaryKey', '机构ID', '2', '部门列表', '2', '2', '0', '1');
INSERT INTO `sys_column_control` VALUES ('18', 'hrmDepCode', '机构编码', '1', '部门列表', '1', '1', '0', '2');
INSERT INTO `sys_column_control` VALUES ('19', 'hrmDepName', '机构名称', '1', '部门列表', '1', '1', '0', '3');
INSERT INTO `sys_column_control` VALUES ('20', 'hrmDepEngname', '机构英文名称', '1', '部门列表', '1', '1', '0', '4');
INSERT INTO `sys_column_control` VALUES ('21', 'employee.hrmEmployeeName', '机构经理', '1', '部门列表', '2', '2', '0', '5');
INSERT INTO `sys_column_control` VALUES ('22', 'libraryInfoCode', '业务编码', '1', '业务字典列表', '1', '1', '0', '1');
INSERT INTO `sys_column_control` VALUES ('23', 'libraryInfoName', '业务名称', '1', '业务字典列表', '1', '1', '20', '2');
INSERT INTO `sys_column_control` VALUES ('24', 'libraryInfoUpcode', '所属编码', '1', '业务字典列表', '2', '2', '0', '3');
INSERT INTO `sys_column_control` VALUES ('26', 'libraryInfoIsvalid', '是否有效', '1', '业务字典列表', '2', '2', '0', '5');
INSERT INTO `sys_column_control` VALUES ('76', 'parentDepartment.hrmDepName', '上级机构', '1', '部门列表', '2', '2', '0', '6');
INSERT INTO `sys_column_control` VALUES ('94', 'employee.hrmEmployeeName', '姓名', '1', '用户管理', '1', '1', '0', '1');
INSERT INTO `sys_column_control` VALUES ('95', 'employee.hrmDepartment.hrmDepName', '部门名称', '1', '用户管理', '2', '2', '0', '2');
INSERT INTO `sys_column_control` VALUES ('96', 'userName', '用户名', '1', '用户管理', '1', '1', '0', '3');
INSERT INTO `sys_column_control` VALUES ('97', 'userpassword', '密码', '1', '用户管理', '2', '2', '0', '4');
INSERT INTO `sys_column_control` VALUES ('98', 'userAction', '是否有效', '1', '用户管理', '2', '1', '0', '5');
INSERT INTO `sys_column_control` VALUES ('99', 'groupName', '组名称', '1', '人员编组', '1', '2', '20', '1');
INSERT INTO `sys_column_control` VALUES ('100', 'groupDecp', '描述', '1', '人员编组', '2', '2', '40', '2');
INSERT INTO `sys_column_control` VALUES ('102', 'roleName', '角色名称', '1', '角色列表', '1', '2', '20', '1');
INSERT INTO `sys_column_control` VALUES ('103', 'roleDesc', '角色描述', '1', '角色列表', '2', '2', '20', '2');
INSERT INTO `sys_column_control` VALUES ('104', 'detailCount', '权限数', '1', '角色列表', '2', '2', '0', '3');
INSERT INTO `sys_column_control` VALUES ('105', 'bindUserCount', '绑定用户', '1', '角色列表', '2', '2', '0', '4');
INSERT INTO `sys_column_control` VALUES ('106', 'bindGroupCount', '绑定组', '1', '角色列表', '2', '2', '0', '5');
INSERT INTO `sys_column_control` VALUES ('107', 'bindDeptCount', '绑定部门', '1', '角色列表', '2', '2', '0', '6');
INSERT INTO `sys_column_control` VALUES ('108', 'bindPostCount', '绑定岗位', '1', '角色列表', '2', '2', '0', '7');
INSERT INTO `sys_column_control` VALUES ('109', 'hrmPostName', '岗位名称', '1', '工作岗位', '1', '1', '10', '1');
INSERT INTO `sys_column_control` VALUES ('110', 'hrmPostEngname', '英文名称', '1', '工作岗位', '1', '1', '20', '2');
INSERT INTO `sys_column_control` VALUES ('111', 'hrmUpPost.hrmPostName', '上级岗位', '1', '工作岗位', '2', '2', '0', '4');
INSERT INTO `sys_column_control` VALUES ('112', 'mangerEmployee.hrmEmployeeName', '负责人', '1', '工作岗位', '2', '2', '0', '3');
INSERT INTO `sys_column_control` VALUES ('113', 'hrmPostDesc', '岗位描述', '1', '工作岗位', '2', '2', '25', '5');
INSERT INTO `sys_column_control` VALUES ('114', 'employeeName', '姓名', '1', '权限设置', '1', '1', '0', '1');
INSERT INTO `sys_column_control` VALUES ('115', 'employeeRole', '用户角色数', '1', '权限设置', '2', '2', '0', '2');
INSERT INTO `sys_column_control` VALUES ('116', 'deptName', '部门', '1', '权限设置', '2', '2', '20', '3');
INSERT INTO `sys_column_control` VALUES ('117', 'deptRole', '部门角色数', '1', '权限设置', '2', '2', '0', '4');
INSERT INTO `sys_column_control` VALUES ('118', 'mainPostName', '主岗位', '1', '权限设置', '2', '2', '0', '5');
INSERT INTO `sys_column_control` VALUES ('119', 'mainPostRole', '主岗位角色数', '1', '权限设置', '2', '2', '0', '6');
INSERT INTO `sys_column_control` VALUES ('120', 'partPostName', '兼职岗位', '1', '权限设置', '2', '2', '20', '7');
INSERT INTO `sys_column_control` VALUES ('121', 'partPostRole', '兼职岗位角色数', '1', '权限设置', '2', '2', '20', '8');
INSERT INTO `sys_column_control` VALUES ('122', 'groupName', '所在组', '1', '权限设置', '2', '2', '20', '9');
INSERT INTO `sys_column_control` VALUES ('123', 'groupRole', '所在组角色数', '1', '权限设置', '2', '2', '20', '10');
INSERT INTO `sys_column_control` VALUES ('124', 'userMethods', '权限数', '1', '权限设置', '2', '2', '0', '11');
INSERT INTO `sys_column_control` VALUES ('180', 'paramIndex', '参数标识', '1', '运行参数', '1', '1', '0', '1');
INSERT INTO `sys_column_control` VALUES ('181', 'paramTitle', '名称', '1', '运行参数', '1', '1', '0', '2');
INSERT INTO `sys_column_control` VALUES ('182', 'paramValue', '参数值', '1', '运行参数', '2', '2', '0', '3');
INSERT INTO `sys_column_control` VALUES ('183', 'paramRemark', '参数说明', '1', '运行参数', '2', '2', '30', '4');
INSERT INTO `sys_column_control` VALUES ('184', 'paramType', '参数类型', '1', '运行参数', '2', '1', '0', '5');
INSERT INTO `sys_column_control` VALUES ('185', 'hrmEmployee.hrmEmployeeName', '操作人员', '1', '操作日志', '1', '1', '0', '1');
INSERT INTO `sys_column_control` VALUES ('186', 'logDate', '操作时间', '1', '操作日志', '2', '1', '0', '2');
INSERT INTO `sys_column_control` VALUES ('187', 'requestAddr', '访问地址', '1', '操作日志', '2', '2', '0', '3');
INSERT INTO `sys_column_control` VALUES ('188', 'logDetail', '执行操作', '1', '操作日志', '2', '2', '0', '4');
INSERT INTO `sys_column_control` VALUES ('195', 'userInfo.userName', '用户名称', '1', '异常管理', '1', '1', '0', '1');
INSERT INTO `sys_column_control` VALUES ('197', 'exceptionClass', '异常类型', '1', '异常管理', '1', '1', '30', '3');
INSERT INTO `sys_column_control` VALUES ('198', 'exceptionMsg', '异常消息', '1', '异常管理', '1', '1', '30', '4');
INSERT INTO `sys_column_control` VALUES ('199', 'exceptionDate', '异常日期', '1', '异常管理', '2', '1', '0', '5');
INSERT INTO `sys_column_control` VALUES ('200', 'exceptionStatus', '异常状态', '1', '异常管理', '2', '1', '0', '6');
INSERT INTO `sys_image_info` VALUES ('11', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvMl8yMDEzMDkyMDIyNTE1NDk3OS5qcGc@3', null, '2.jpg', null, null, null, '182013052121033133083', '2013-09-20 22:51:58', '182013052121033133083', '2013-09-20 22:51:58');
INSERT INTO `sys_image_info` VALUES ('12', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvM18yMDEzMDkyMDIyNTE1NTAwOC5qcGc@3', null, '3.jpg', null, null, null, '182013052121033133083', '2013-09-20 22:51:58', '182013052121033133083', '2013-09-20 22:51:58');
INSERT INTO `sys_image_info` VALUES ('13', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvMTBfMjAxMzA5MjAyMjUyNTIyNTMuanBn', null, '10.jpg', null, null, null, '182013072730085454643', '2013-09-20 22:52:53', '182013072730085454643', '2013-09-20 22:52:53');
INSERT INTO `sys_image_info` VALUES ('14', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvMTJfMjAxMzA5MjAyMjUyNTIyNjMuanBn', null, '12.jpg', null, null, null, '182013072730085454643', '2013-09-20 22:52:53', '182013072730085454643', '2013-09-20 22:52:53');
INSERT INTO `sys_image_info` VALUES ('15', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvMTFfMjAxMzA5MjAyMjUyNTIyNTYuanBn', null, '11.jpg', null, null, null, '182013072730085454643', '2013-09-20 22:52:53', '182013072730085454643', '2013-09-20 22:52:53');
INSERT INTO `sys_image_info` VALUES ('16', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvOV8yMDEzMDkyMDIyNTI1MjI0Mi5qcGc@3', null, '9.jpg', null, null, null, '182013072730085454643', '2013-09-20 22:52:53', '182013072730085454643', '2013-09-20 22:52:53');
INSERT INTO `sys_image_info` VALUES ('17', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9wb3dlZF8yMDE0MDEyMzE2NTg1OTU4NS5qcGc@3', null, 'powed.jpg', null, null, null, '182013052121033133083', '2014-01-23 16:59:01', '182013052121033133083', '2014-01-23 16:59:01');
INSERT INTO `sys_image_info` VALUES ('18', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9sb2dpbl8wMDBfMjAxNDAxMjMyMzIyNDI2MDAucG5n', null, 'login_000.png', null, null, null, '182013072730085454643', '2014-01-23 23:23:05', '182013072730085454643', '2014-01-23 23:23:05');
INSERT INTO `sys_image_info` VALUES ('29', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvdW50aXRsZWRfMjAxNDAzMTMyMzE2MDk4MjAuYm1w', null, 'untitled.bmp', 'untitled_20140313231609820.bmp', null, null, '182013072730085454643', '2014-03-13 23:16:11', '182013072730085454643', '2014-03-13 23:16:11');
INSERT INTO `sys_image_info` VALUES ('30', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvUVHNvMasMjAxNDAzMTIwODQ2NThfMjAxNDAzMTMyMzE2MDk4MTcuanBn', null, 'QQ图片20140312084658.jpg', 'QQ图片20140312084658_20140313231609817.jpg', null, null, '182013072730085454643', '2014-03-13 23:16:11', '182013072730085454643', '2014-03-13 23:16:11');
INSERT INTO `sys_image_info` VALUES ('31', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvdW50aXRsZWRfMjAxNDAzMTMyMzIyNDM2MjQuYm1w', null, 'untitled.bmp', 'untitled_20140313232243624.bmp', null, null, '182013072730085454643', '2014-03-13 23:23:28', '182013072730085454643', '2014-03-13 23:23:28');
INSERT INTO `sys_image_info` VALUES ('47', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTQvdW50aXRsZWRfMjAxNDAzMTQwOTQ0NTAwODkuanBn', null, 'untitled.jpg', 'untitled_20140314094450089.jpg', null, null, '182013072730085454643', '2014-03-14 09:44:52', '182013072730085454643', '2014-03-14 09:44:52');
INSERT INTO `sys_image_info` VALUES ('51', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvdW50aXRsZWRfMjAxNDAzMTQxMDM1NTU3NjguanBn', 'C:/BamsDownloads/image/comp18/person52/untitled_20140314103555768.jpg', 'untitled.jpg', 'untitled_20140314103555768.jpg', null, null, '182013052121033133083', '2014-03-14 10:35:58', '182013052121033133083', '2014-03-14 10:35:58');
INSERT INTO `sys_image_info` VALUES ('55', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvZmUwZTk4NmU5NTdjMTIxZl8yMDE0MDMyOTE1MzMyNjg3MC5qcGc@3', 'C:/BamsDownloads/image/comp18/person52/fe0e986e957c121f_20140329153326870.jpg', 'fe0e986e957c121f.jpg', 'fe0e986e957c121f_20140329153326870.jpg', null, null, '182013052121033133083', '2014-03-29 15:33:51', '182013052121033133083', '2014-03-29 15:33:51');
INSERT INTO `sys_image_info` VALUES ('57', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvdW50aXRsZWRfMjAxNDAzMTQwOTQ1NTM1NTYuanBn', 'C:/BamsDownloads/image/comp18/person52/untitled_20140314094553556.jpg', 'untitled.jpg', '', null, null, '182013072931083905862', '2014-05-24 00:31:46', '182013072931083905862', '2014-05-24 00:31:46');
INSERT INTO `sys_image_info` VALUES ('59', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS90aWUwMDJfMjAxNDAxMjYxMDM5MjkyODAuZ2lm', null, 'tie002.gif', null, null, null, '182013052121033133083', '2014-05-25 07:58:09', '182013052121033133083', '2014-05-25 07:58:09');
INSERT INTO `sys_image_info` VALUES ('61', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvUVHNvMasMjAxNDA3MDExNDI5MTVfMjAxNDA3MDExNDI5MjA0MjMuanBn', 'C:/BamsDownloads/image/comp18/person52/QQ图片20140701142915_20140701142920423.jpg', 'QQ图片20140701142915.jpg', 'QQ图片20140701142915_20140701142920423.jpg', null, null, '182013052121033133083', '2014-07-01 14:29:22', '182013052121033133083', '2014-07-01 14:29:22');
INSERT INTO `sys_image_info` VALUES ('62', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvMV8yMDE0MDcwNDEzMTQwMjQ4Ny5wbmc@3', 'C:/BamsDownloads/image/comp18/person52/1_20140704131402487.png', '1.png', '1_20140704131402487.png', null, null, '182013052121033133083', '2014-07-04 13:14:04', '182013052121033133083', '2014-07-04 13:14:04');
INSERT INTO `sys_image_info` VALUES ('63', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvMl8yMDE0MDcwNDEzMTQwMjUxMy5wbmc@3', 'C:/BamsDownloads/image/comp18/person52/2_20140704131402513.png', '2.png', '2_20140704131402513.png', null, null, '182013052121033133083', '2014-07-04 13:14:04', '182013052121033133083', '2014-07-04 13:14:04');
INSERT INTO `sys_image_info` VALUES ('64', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvNF8yMDE0MDcwNDEzMTQwMjUxNi5wbmc@3', 'C:/BamsDownloads/image/comp18/person52/4_20140704131402516.png', '4.png', '4_20140704131402516.png', null, null, '182013052121033133083', '2014-07-04 13:14:04', '182013052121033133083', '2014-07-04 13:14:04');
INSERT INTO `sys_image_info` VALUES ('67', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvbG9nbzFfMjAxNDA3MTkxMDE1MTQ0NDkucG5n', 'C:/BamsDownloads/image/comp18/person52/logo1_20140719101514449.png', 'logo1.png', 'logo1_20140719101514449.png', null, null, '182013052121033133083', '2014-07-19 10:15:15', '182013052121033133083', '2014-07-19 10:15:15');
INSERT INTO `sys_image_info` VALUES ('68', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvbG9nbzFfMjAxNDA3MTkxMDE1MTQ0NDkucG5n', 'C:/BamsDownloads/image/comp18/person52/logo1_20140719101514449.png', 'logo1.png', 'logo1_20140719101514449.png', null, null, '182013052121033133083', '2014-07-19 10:15:44', '182013052121033133083', '2014-07-19 10:15:44');
INSERT INTO `sys_image_info` VALUES ('69', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvUVHNvMasMjAxNDA4MDgxMzI1NTlfMjAxNDA4MjIxNDU1NDA3NjMuanBn', 'C:/BamsDownloads/image/comp18/person52/QQ图片20140808132559_20140822145540763.jpg', 'QQ图片20140808132559.jpg', 'QQ图片20140808132559_20140822145540763.jpg', null, null, '182013052121033133083', '2014-08-22 14:55:42', '182013052121033133083', '2014-08-22 14:55:42');
INSERT INTO `sys_image_info` VALUES ('71', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvbG9nbzJfMjAxNTAxMTYwOTI5MDEwODQucG5n', 'C:/BamsDownloads/image/comp18/person52/logo2_20150116092901084.png', 'logo2.png', 'logo2_20150116092901084.png', null, null, '182013052121033133083', '2015-01-16 09:29:02', '182013052121033133083', '2015-01-16 09:29:02');
INSERT INTO `sys_image_info` VALUES ('72', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvbG9nbzJfMjAxNTAxMTYwOTI5MDEwODQucG5n', 'C:/BamsDownloads/image/comp18/person52/logo2_20150116092901084.png', 'logo2.png', 'logo2_20150116092901084.png', null, null, '182013052121033133083', '2015-01-16 09:42:27', '182013052121033133083', '2015-01-16 09:42:27');
INSERT INTO `sys_image_info` VALUES ('73', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvc3lzbG9naW5fMjAxNTAxMTYxMTE5MDkwNDcucG5n', 'C:/BamsDownloads/image/comp18/person52/syslogin_20150116111909047.png', 'syslogin.png', 'syslogin_20150116111909047.png', null, null, '182013052121033133083', '2015-01-16 11:19:10', '182013052121033133083', '2015-01-16 11:19:10');
INSERT INTO `sys_image_info` VALUES ('74', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvc3lzbG9naW5fMjAxNTAxMTYxMTE5MDkwNDcucG5n', 'C:/BamsDownloads/image/comp18/person52/syslogin_20150116111909047.png', 'syslogin.png', 'syslogin_20150116111909047.png', null, null, '182013052121033133083', '2015-01-16 11:24:46', '182013052121033133083', '2015-01-16 11:24:46');
INSERT INTO `sys_image_info` VALUES ('75', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvc3lzbG9naW5fMjAxNTAxMTYxMTE5MDkwNDcucG5n', 'C:/BamsDownloads/image/comp18/person52/syslogin_20150116111909047.png', 'syslogin.png', 'syslogin_20150116111909047.png', null, null, '182013052121033133083', '2015-01-16 11:25:01', '182013052121033133083', '2015-01-16 11:25:01');
INSERT INTO `sys_image_info` VALUES ('76', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvc3lzbG9naW5fMjAxNTAxMTYxMTE5MDkwNDcucG5n', 'C:/BamsDownloads/image/comp18/person52/syslogin_20150116111909047.png', 'syslogin.png', 'syslogin_20150116111909047.png', null, null, '182013052121033133083', '2015-01-16 12:26:23', '182013052121033133083', '2015-01-16 12:26:23');
INSERT INTO `sys_image_info` VALUES ('77', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvbG9naW5fdGl0bGVfMjAxNTAyMDcxMDE3NDAxMDEucG5n', 'C:/BamsDownloads/image/comp18/person52/login_title_20150207101740101.png', 'login_title.png', 'login_title_20150207101740101.png', null, null, '182013052121033133083', '2015-02-07 10:17:41', '182013052121033133083', '2015-02-07 10:17:41');
INSERT INTO `sys_image_info` VALUES ('78', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9jb21wMTgvcGVyc29uNTIvbG9naW5fdGl0bGVfNTBfMjAxNTAyMDcxMDE4NTU4NjQucG5n', 'C:/BamsDownloads/image/comp18/person52/login_title_50_20150207101855864.png', 'login_title_50.png', 'login_title_50_20150207101855864.png', null, null, '182013052121033133083', '2015-02-07 10:18:58', '182013052121033133083', '2015-02-07 10:18:58');
INSERT INTO `sys_image_info` VALUES ('85', 'QzovQmFtc0Rvd25sb2Fkcy9pbWFnZS9wZXJzb241Mi9qYXZhX2xvZ28tNF8yMDE1MDMxNDIxMzMzOTMyNS5wbmc@3', 'C:/BamsDownloads/image/person52/java_logo-4_20150314213339325.png', 'java_logo-4.png', 'java_logo-4_20150314213339325.png', null, null, '182013052121033133083', '2015-03-15 22:46:48', '182013052121033133083', '2015-03-15 22:46:48');
INSERT INTO `sys_library_info` VALUES ('2141', '01', '用工形式', 'PATTERN', '00', '1', '用于人员用工形式');
INSERT INTO `sys_library_info` VALUES ('2142', '0101', '合同工', '', '01', '1', '');
INSERT INTO `sys_library_info` VALUES ('2143', '0102', '劳务工', '', '01', '1', '');
INSERT INTO `sys_library_info` VALUES ('2144', '02', '婚姻状况', 'MARRIAGE', '00', '1', '人员婚姻状况');
INSERT INTO `sys_library_info` VALUES ('2145', '0201', '未婚', '', '02', '1', '');
INSERT INTO `sys_library_info` VALUES ('2146', '0202', '已婚', '', '02', '1', '');
INSERT INTO `sys_library_info` VALUES ('2196', '18', '政治面貌', '', '00', '1', '');
INSERT INTO `sys_library_info` VALUES ('2197', '1801', '群众', '', '18', '1', '');
INSERT INTO `sys_library_info` VALUES ('2198', '1802', '团员', '', '18', '1', '');
INSERT INTO `sys_library_info` VALUES ('2199', '1803', '预备党员', '', '18', '1', '');
INSERT INTO `sys_library_info` VALUES ('2200', '1804', '党员', '', '18', '1', '');
INSERT INTO `sys_library_info` VALUES ('2201', '19', '血型', '', '00', '1', '');
INSERT INTO `sys_library_info` VALUES ('2202', '1901', 'A 型', '', '19', '1', '');
INSERT INTO `sys_library_info` VALUES ('2203', '1902', 'B 型', '', '19', '1', '');
INSERT INTO `sys_library_info` VALUES ('2204', '1903', 'AB 型', '', '19', '1', '');
INSERT INTO `sys_library_info` VALUES ('2205', '1904', 'O 型', '', '19', '1', '');
INSERT INTO `sys_library_info` VALUES ('2206', '1905', 'HR型', '', '19', '1', '');
INSERT INTO `sys_library_info` VALUES ('2207', '20', '民族', '', '00', '1', '');
INSERT INTO `sys_library_info` VALUES ('2208', '2001', '汉族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2209', '2002', '回族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2210', '2003', '畲族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2211', '2004', '塔塔尔族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2212', '2005', '阿昌族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2213', '2006', '哈萨克族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2214', '2007', '土家族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2215', '2008', '景颇族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2216', '2009', '哈尼族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2217', '2010', '土族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2218', '2011', '白族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2219', '2012', '维吾尔族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2220', '2013', '保安族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2221', '2014', '赫哲族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2222', '2015', '乌孜别克族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2223', '2016', '基诺族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2224', '2017', '布依族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2225', '2018', '拉祜族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2226', '2019', '锡伯族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2227', '2020', '黎族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2228', '2021', '东乡族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2229', '2022', '蒙古族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2230', '2023', '仫佬族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2231', '2024', '达斡尔族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2232', '2025', '藏族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2233', '2026', '毛南族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2234', '2027', '裕固族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2235', '2028', '俄罗斯族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2236', '2029', '德昂族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2237', '2030', '僳僳族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2238', '2031', '瑶族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2239', '2032', '朝鲜族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2240', '2033', '布朗族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2241', '2034', '满族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2242', '2035', '彝族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2243', '2036', '门巴族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2244', '2037', '侗族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2245', '2038', '苗族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2246', '2039', '佤族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2247', '2040', '羌族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2248', '2041', '独龙族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2249', '2042', '怒族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2250', '2043', '珞巴族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2251', '2044', '普米族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2252', '2045', '傣族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2253', '2046', '纳西族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2254', '2047', '高山族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2255', '2048', '壮族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2256', '2049', '额伦春族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2257', '2050', '塔吉克族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2258', '2051', '京族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2259', '2052', '仡佬族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2260', '2053', '鄂温克族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2261', '2054', '撒拉族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2262', '2055', '柯尔克孜族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2263', '2056', '水族', '', '20', '1', '');
INSERT INTO `sys_library_info` VALUES ('2264', '21', '学历', '', '00', '1', '');
INSERT INTO `sys_library_info` VALUES ('2265', '2101', '小学', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2266', '2102', '初中', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2267', '2103', '高中', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2268', '2104', '中专', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2269', '2105', '大专', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2270', '2106', '本科', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2271', '2107', '硕士', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2272', '2108', '博士', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2273', '2109', '博士后', '', '21', '1', '');
INSERT INTO `sys_library_info` VALUES ('2342', '33', '前端新闻类别', '', '00', '1', '');
INSERT INTO `sys_library_info` VALUES ('2343', '3301', '通知公告', '', '33', '1', '');
INSERT INTO `sys_library_info` VALUES ('2345', '3302', '申报指南', '', '33', '1', '');
INSERT INTO `sys_library_info` VALUES ('2347', '3303', '在线帮助', '', '33', '1', '');
INSERT INTO `sys_library_info` VALUES ('2349', '3304', '工作动态', '', '33', '1', '');
INSERT INTO `sys_library_info` VALUES ('2351', '3305', '相关链接', '', '33', '1', '');
INSERT INTO `sys_method_help` VALUES ('1', 'zyjj.png', '表示‘重要/紧急’的日程。', '00020302');
INSERT INTO `sys_method_help` VALUES ('2', 'zybjj.png', '表示‘重要/不紧急’的日程。', '00020302');
INSERT INTO `sys_method_help` VALUES ('3', 'bzyjj.png', '表示‘不重要/紧急’的日程。', '00020302');
INSERT INTO `sys_method_help` VALUES ('4', 'bzybjj.png', '表示‘不重要/不紧急’的日程。', '00020302');
INSERT INTO `sys_method_help` VALUES ('5', '', '该功能设置用户的特殊权限，不影响用户所绑定角色设置', '00080201');
INSERT INTO `sys_method_help` VALUES ('6', '', '修改角色设置请进入‘角色管理’功能', '00080201');
INSERT INTO `sys_method_help` VALUES ('7', 'zyjj.png', '删除或设置为无效将影响业务流程', '00080502');
INSERT INTO `sys_method_help` VALUES ('14', 'rowset.png', '这里显示系统内所有的人员信息，双击记录可以查看该人员的详细信息。', '020203');
INSERT INTO `sys_method_help` VALUES ('16', 'zybjj.png', '人员如果需要登录系统、使用系统功能，还需要两步设置。首先在系统设置-用户设置中，为相应的人员分配账号。然后在权限设置中，给人员设置权限。', '020203');
INSERT INTO `sys_method_help` VALUES ('17', 'zybjj.png', '点击左侧组织机构树，可以快速查询到对应机构下面的人员信息。', '020203');
INSERT INTO `sys_method_help` VALUES ('18', 'zybjj.png', '点击右上角“高级查询”，可以使用各种条件进行组合查询。', '020203');
INSERT INTO `sys_method_help` VALUES ('19', 'rowedit.png', '点击编辑图标，可以对人员信息进行编辑。', '020203');
INSERT INTO `sys_method_help` VALUES ('20', 'seta.png', '人员不能删除，只能设置为“离职”', '020203');
INSERT INTO `sys_method_help` VALUES ('21', 'setpym.png', '设置拼音码，例如人员姓名“张三”，拼音码为“ZS”；人员姓名“李四”，拼音码为“LS”', '020203');
INSERT INTO `sys_method_info` VALUES ('01', '系统设置', '', '', '2', '1.png', '-1', '-1', '1', 'xitong', '', '');
INSERT INTO `sys_method_info` VALUES ('0102', '权限设置', null, null, '2', 'transmit.png', '1', '01', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('010201', '设置权限', null, 'system_set/premmset.jsp', '1', 'szqx.png', '2', '0102', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('010202', '查询权限', null, 'system_set/premmquery.jsp', '2', 'cxqx.png', '2', '0102', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('0104', '角色管理', null, null, '4', 'page_user_light.gif', '1', '01', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('010401', '创建角色', null, 'system_set/roleset_add.jsp', '1', 'cjjs.png', '2', '0104', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('010402', '角色查询', null, 'system_set/roleset.jsp', '2', 'jscx.png', '2', '0104', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('0107', '系统管理', null, null, '7', 'hcard.png', '1', '01', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('010701', '功能目录', '', 'system_set/sys_method.jsp', '1', 'rich_text_align_center.png', '2', '0107', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('010702', '业务字典', '', 'system_set/sys_library.jsp', '2', 'sjzd.png', '2', '0107', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('010703', '运行参数', '', 'system_set/parammanger.jsp', '3', 'cog_edit.png', '2', '0107', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('010704', '列表管理', '', 'system_set/column_control.jsp', '4', 'application_cascade.png', '2', '0107', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('010707', '系统异常', '', 'system_set/sys_exception.jsp', '7', 'cancel.png', '2', '0107', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('010710', '操作提示', '', 'system_set/method_help.jsp', '10', 'ckgzxm.png', '2', '0107', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('010711', '代码生成', null, 'code_create/code_create.jsp', '11', 'ast_order.gif', '2', '0107', '1', null, '', null);
INSERT INTO `sys_method_info` VALUES ('010712', '参数设置', null, 'system_set/paramset.jsp', '3', 'cssz.png', '2', '0107', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('02', '人力资源', '', '', '1', '3.png', '-1', '-1', '1', 'renli', '公司人力资源部门管理员工、日常考核进行管理', '');
INSERT INTO `sys_method_info` VALUES ('0201', '组织机构', null, null, '1', 'rosette.png', '1', '02', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('020101', '新增机构', '', 'hrm/department_add.jsp', '1', 'xzjg.png', '2', '0201', '1', null, '', null);
INSERT INTO `sys_method_info` VALUES ('020102', '机构查看', '', 'hrm/department_view.jsp', '2', 'jggl.png', '2', '0201', '1', '', '', null);
INSERT INTO `sys_method_info` VALUES ('020103', '机构管理', null, 'hrm/department.jsp', '3', 'jggl.png', '2', '0201', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('0202', '人事管理', '', '', '3', 'web-.gif', '1', '02', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('020201', '新增人员', '', 'hrm/employee_add.jsp', '1', 'xzry.png', '2', '0202', '1', '', '', 'employee_add.jsp');
INSERT INTO `sys_method_info` VALUES ('020202', '人员查询', '', 'hrm/employee_query.jsp', '2', 'rygl.png', '2', '0202', '1', '', '', null);
INSERT INTO `sys_method_info` VALUES ('020203', '人员管理', '', 'hrm/employee.jsp', '3', 'rygl.png', '2', '0202', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('020204', '人员岗位设置', '', 'hrm/employee_post.jsp', '4', 'rygwsz.png', '2', '0202', '1', '', '', null);
INSERT INTO `sys_method_info` VALUES ('0203', '工作岗位', '', '', '2', 'webcam.png', '1', '02', '1', '', '', '');
INSERT INTO `sys_method_info` VALUES ('020301', '新增岗位', '', 'hrm/post_add.jsp', '1', 'xzgw.png', '2', '0203', '1', null, '', null);
INSERT INTO `sys_method_info` VALUES ('020302', '岗位查询', null, 'hrm/post_query.jsp', '2', null, '2', '0203', '2', null, null, null);
INSERT INTO `sys_method_info` VALUES ('020303', '岗位管理', null, 'hrm/post_manger.jsp', '3', 'gwgl.png', '2', '0203', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('0204', '用户管理', null, null, '4', 'page_user.gif', '1', '02', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('020401', '用户设置', null, 'system_set/user_manger.jsp', '1', 'yhsz.png', '2', '0204', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('020402', '登录名密码', null, 'system_set/userset.jsp', '2', 'dlmmm.png', '2', '0204', '1', null, null, null);
INSERT INTO `sys_method_info` VALUES ('020403', '用户编组', '', 'system_set/user_group_manger.jsp', '3', 'yhbz.png', '2', '0204', '1', '', '', '');
INSERT INTO `sys_param` VALUES ('1', 'bams.user.PwdLen', '添加用户时密码最短长度', '6', '控制用户添加时的密码长度', '-1', '2010-03-11 13:49:24', '182013052121033133083', '2015-03-15 23:37:24', '2', '6-18');
INSERT INTO `sys_param` VALUES ('3', 'bams.user.initPwd', '添加用户初始密码', '111111', '添加用户时默认密码，应配合初始密码长度应用', '-1', '2010-03-11 14:30:26', '182013052121033133083', '2015-03-14 21:41:50', '1', '6');
INSERT INTO `sys_param` VALUES ('4', 'bams.grid.pageSize', '页面表格中默认显示的记录行数', '50', '控制页面表格显示的默认行数', '-1', '2010-03-11 14:31:48', '182013052121033133083', '2015-03-14 21:41:50', '3', '10,20,30,50,80');
INSERT INTO `sys_param` VALUES ('5', 'bams.grid.imgViewCk', '使用表格的图形视图时默认是否显示详细信息', '是', '视图显示时是否默认选中显示图片详细信息', '-1', '2010-03-11 14:34:36', '182013052121033133083', '2015-03-15 00:16:58', '3', '是,否');
INSERT INTO `sys_role` VALUES ('3', '管理员', '		', '51', '2015-03-14 21:37:21', '182013052121033133083', '2015-04-21 20:54:07');
INSERT INTO `sys_role_bind` VALUES ('15', '1', '3', '52');
INSERT INTO `sys_role_detail` VALUES ('972', '3', '02');
INSERT INTO `sys_role_detail` VALUES ('973', '3', '0201');
INSERT INTO `sys_role_detail` VALUES ('974', '3', '020101');
INSERT INTO `sys_role_detail` VALUES ('975', '3', '020102');
INSERT INTO `sys_role_detail` VALUES ('976', '3', '020103');
INSERT INTO `sys_role_detail` VALUES ('977', '3', '0202');
INSERT INTO `sys_role_detail` VALUES ('978', '3', '020201');
INSERT INTO `sys_role_detail` VALUES ('979', '3', '020202');
INSERT INTO `sys_role_detail` VALUES ('980', '3', '020203');
INSERT INTO `sys_role_detail` VALUES ('981', '3', '020204');
INSERT INTO `sys_role_detail` VALUES ('982', '3', '0203');
INSERT INTO `sys_role_detail` VALUES ('983', '3', '020301');
INSERT INTO `sys_role_detail` VALUES ('984', '3', '020303');
INSERT INTO `sys_role_detail` VALUES ('985', '3', '0204');
INSERT INTO `sys_role_detail` VALUES ('986', '3', '020401');
INSERT INTO `sys_role_detail` VALUES ('987', '3', '020402');
INSERT INTO `sys_role_detail` VALUES ('988', '3', '020403');
INSERT INTO `sys_role_detail` VALUES ('989', '3', '01');
INSERT INTO `sys_role_detail` VALUES ('990', '3', '0102');
INSERT INTO `sys_role_detail` VALUES ('991', '3', '010201');
INSERT INTO `sys_role_detail` VALUES ('992', '3', '010202');
INSERT INTO `sys_role_detail` VALUES ('993', '3', '0104');
INSERT INTO `sys_role_detail` VALUES ('994', '3', '010401');
INSERT INTO `sys_role_detail` VALUES ('995', '3', '010402');
INSERT INTO `sys_role_detail` VALUES ('996', '3', '0107');
INSERT INTO `sys_role_detail` VALUES ('997', '3', '010701');
INSERT INTO `sys_role_detail` VALUES ('998', '3', '010702');
INSERT INTO `sys_role_detail` VALUES ('999', '3', '010703');
INSERT INTO `sys_role_detail` VALUES ('1000', '3', '010704');
INSERT INTO `sys_role_detail` VALUES ('1001', '3', '010707');
INSERT INTO `sys_role_detail` VALUES ('1002', '3', '010710');
INSERT INTO `sys_role_detail` VALUES ('1003', '3', '010711');
INSERT INTO `sys_role_detail` VALUES ('1004', '3', '010712');
INSERT INTO `sys_user_group` VALUES ('9', '组名称', '', '182013052121033133083', '2015-03-16 00:04:47', '182013052121033133083', '2015-03-16 00:04:47');
INSERT INTO `sys_user_group_detail` VALUES ('53', '55', '9');
INSERT INTO `sys_user_group_detail` VALUES ('54', '59', '9');
INSERT INTO `sys_user_group_detail` VALUES ('55', '56', '9');
INSERT INTO `sys_user_group_detail` VALUES ('56', '60', '9');
INSERT INTO `sys_user_group_detail` VALUES ('57', '52', '9');
INSERT INTO `sys_user_group_detail` VALUES ('58', '57', '9');
INSERT INTO `sys_user_group_detail` VALUES ('59', '61', '9');
INSERT INTO `sys_user_group_detail` VALUES ('60', '54', '9');
INSERT INTO `sys_user_group_detail` VALUES ('61', '58', '9');
INSERT INTO `sys_user_info` VALUES ('51', '-1', 'systemadmin', 'MTExMTEx', '1', '-1', '2013-05-21 15:22:10', '51', '2013-05-21 15:23:24', '3');
INSERT INTO `sys_user_info` VALUES ('52', '182013052121033133083', 'dxj', 'MTExMTEx', '1', '51', '2013-05-21 15:32:41', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('54', '182013072730085454643', 'zhangs', 'MTExMTEx', '1', '182013052121033133083', '2013-08-29 22:18:57', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('55', '182013072931083905862', 'wangwu', 'MTExMTEx', '1', '182013052121033133083', '2013-09-01 15:22:21', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('56', '182013072730040551054', 'lisi', 'MTExMTEx', '1', '182013052121033133083', '2013-09-01 15:22:21', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('57', '18201401285024208188', 'maliu', 'MTExMTEx', '1', '182013072730085454643', '2014-01-28 14:45:42', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('58', '182014052421084820990', 'jiangc', 'MTExMTEx', '1', '182013052121033133083', '2014-05-24 20:48:40', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('59', '182014052421102129560', 'zhangyan', 'MTExMTEx', '1', '182014052421084820990', '2014-05-24 22:21:45', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('60', '182014052421104440246', 'zhangl', 'MTExMTEx', '1', '182013072931083905862', '2014-05-24 22:44:55', '182013052121033133083', '2015-03-14 21:38:11', '1');
INSERT INTO `sys_user_info` VALUES ('61', '182014032913033222840', 'xiaoqi', 'MTExMTEx', '1', '182013052121033133083', '2015-03-15 22:47:35', '182013052121033133083', '2015-03-15 22:47:35', '1');
INSERT INTO `sys_user_methods` VALUES ('1', '52', '');
INSERT INTO `sys_user_methods` VALUES ('2', '53', '00,0001,000101,00010103,00010104,000102,00010201,00010202,000103,00010301,00010302,000104,00010402,00010401,0002,000201,00020104,00020102,00020107,000202,00020201,00020203,00020202,000203,00020301,00020302,00020303,000204,00020401,00020408,00020409,00020407,00020402,00020403,00020404,00020405,00020406,0003,000301,00030101,00030102,00030103,00030104,000302,00030201,00030202,00030203,00030204,000303,00030304,00030301,00030302,00030303,000304,00030402,00030404,00030405,00030406,000305,00030502,00030501,0004,000401,00040101,00040102,00040104,00040103,00040105,000402,00040204,00040203,00040201,00040202,00040205,000403,00040302,00040303,000404,000405,000406,0005,000501,000502,000503,000504,000505,000507,000506,000508,000509,0006,000601,00060105,00060101,00060102,00060106,000602,00060201,00060203,00060204,00060205,00060206,000603,00060307,00060301,00060302,00060304,00060306,00060308,00060309,000604,00060402,00060403,00060401,00060404,00060405,00060406,0008,000803,00080301,00080302,00080303,000804,00080401,00080402,000805,00080501,00080502,000806,00080601,000801,00080101,00080102,00080104,00080103,000802,00080201,00080202,000807,00080701,00080705,00080710,00080711,00080702,00080714,00080706,00080709,00080712,00080713,00080703,00080704,00080708,00080707,00080715,00080716,00080721,00080717,00080718,00080722,00080720,02,0201,020101,020103,0202,020201,020203,020204,020205,0203,020301,020303,0204,020401,020403,0205,020501,020502,');
INSERT INTO `sys_user_methods` VALUES ('3', '54', '02,0201,020101,020102,020103,0202,020201,020202,020203,020204,0203,020301,020303,0204,020401,020402,020403,00,0002,000201,000202,0004,000401,000402,0007,000701,000702,000703,000704,000707,000710,000711,000712,');
INSERT INTO `sys_user_methods` VALUES ('4', '55', '00,0001,000102,00010201,00010202,000103,00010301,00010302,000104,00010401,00010402,0002,000202,00020201,00020202,00020203,000203,00020301,00020302,00020303,0003,000301,00030101,00030102,00030103,00030104,000302,00030201,00030202,00030203,00030204,000303,00030301,00030302,00030303,00030304,000304,00030402,00030404,00030405,00030406,000305,00030501,00030502,0004,000401,00040101,00040102,00040103,00040104,00040105,000402,00040201,00040202,00040203,00040204,00040205,000403,00040302,00040303,000404,000405,000406,0005,000503,000504,000505,000506,000507,000508,000509,0006,000601,00060101,00060102,00060105,00060106,000602,00060201,00060203,00060204,00060205,00060206,000604,00060401,00060402,00060403,00060404,00060405,00060406,0007,000701,000702,000703,000704,0008,000801,00080101,00080102,00080103,00080104,00080105,000802,00080201,00080202,000803,00080301,00080302,00080303,000804,00080401,00080402,000805,00080502,00080503,00080504,00080505,00080506,00080507,000806,00080601,000807,00080703,00080704,00080705,00080706,00080707,00080708,00080709,00080710,00080711,00080712,00080713,00080714,00080715,00080716,02,0201,020101,020102,020103,0202,020201,020202,020203,020204,020205,0203,020301,020303,0204,020401,020403,0205,020501,020502,020503,');
INSERT INTO `sys_user_methods` VALUES ('5', '56', '00,0001,000102,00010201,00010202,000103,00010301,00010302,000104,00010401,00010402,0002,000202,00020201,00020202,00020203,000203,00020301,00020302,00020303,0003,000301,00030101,00030102,00030103,00030104,000302,00030201,00030202,00030203,00030204,000303,00030301,00030302,00030303,00030304,000304,00030402,00030404,00030405,00030406,000305,00030501,00030502,0004,000401,00040101,00040102,00040103,00040104,00040105,000402,00040201,00040202,00040203,00040204,00040205,000403,00040302,00040303,000404,000405,000406,0005,000503,000504,000505,000506,000507,000508,000509,0006,000601,00060101,00060102,00060105,00060106,000602,00060201,00060203,00060204,00060205,00060206,000604,00060401,00060402,00060403,00060404,00060405,00060406,0007,000701,000702,000703,000704,0008,000801,00080101,00080102,00080103,00080104,00080105,000802,00080201,00080202,000803,00080301,00080302,00080303,000804,00080401,00080402,000805,00080502,00080503,00080504,00080505,00080506,00080507,000806,00080601,000807,00080703,00080704,00080705,00080706,00080707,00080708,00080709,00080710,00080711,00080712,00080713,00080714,00080715,00080716,000808,00080801,00080802,');
INSERT INTO `sys_user_methods` VALUES ('6', '57', '00,0001,000102,00010201,00010202,000103,00010301,00010302,000104,00010401,00010402,0002,000202,00020201,00020202,00020203,000203,00020301,00020302,00020303,0003,000301,00030101,00030102,00030103,00030104,000302,00030201,00030202,00030203,00030204,000303,00030301,00030302,00030303,00030304,000304,00030402,00030404,00030405,00030406,000305,00030501,00030502,0004,000401,00040101,00040102,00040103,00040104,00040105,000402,00040201,00040202,00040203,00040204,00040205,000403,00040302,00040303,000404,000405,000406,0005,000501,00050101,00050102,00050103,000503,000504,000505,000506,000507,000508,000509,0006,000601,00060101,00060102,00060105,00060106,000602,00060201,00060203,00060204,00060205,00060206,000604,00060401,00060402,00060403,00060404,00060405,00060406,0008,000801,00080101,00080102,00080103,00080104,000802,00080201,00080202,000803,00080301,00080302,00080303,000804,00080401,00080402,000805,00080502,00080503,00080504,00080505,00080506,000806,00080601,000807,00080703,00080704,00080705,00080706,00080707,00080708,00080709,00080710,00080711,00080712,00080713,00080714,00080721,');
INSERT INTO `sys_user_methods` VALUES ('7', '58', '00,0001,000102,00010201,00010202,000103,00010301,00010302,000104,00010401,00010402,0002,000202,00020201,00020202,00020203,000203,00020301,00020302,00020303,0003,000301,00030101,00030102,00030103,00030104,000302,00030201,00030202,00030203,00030204,000303,00030301,00030302,00030303,00030304,000304,00030402,00030404,00030405,00030406,000305,00030501,00030502,0004,000401,00040101,00040102,00040103,00040104,00040105,000402,00040201,00040202,00040203,00040204,00040205,000403,00040302,00040303,000404,000405,000406,0005,000503,000504,000505,000506,000507,000508,000509,0006,000601,00060101,00060102,00060105,00060106,000602,00060201,00060203,00060204,00060205,00060206,000604,00060401,00060402,00060403,00060404,00060405,00060406,0007,000701,000702,000703,000704,0008,000801,00080101,00080102,00080103,00080104,00080105,000802,00080201,00080202,000803,00080301,00080302,00080303,000804,00080401,00080402,000805,00080502,00080503,00080504,00080505,00080506,000806,00080601,000807,00080703,00080704,00080705,00080706,00080707,00080708,00080709,00080710,00080711,00080712,00080713,00080714,000808,00080801,00080802,02,0201,020101,020102,020103,0202,020201,020202,020203,020204,020205,0203,020301,020303,0204,020401,020403,');
INSERT INTO `sys_user_methods` VALUES ('8', '59', '00,0001,000102,00010201,00010202,000103,00010301,00010302,000104,00010401,00010402,0002,000202,00020201,00020202,00020203,000203,00020301,00020302,00020303,0003,000301,00030101,00030102,00030103,00030104,000302,00030201,00030202,00030203,00030204,000303,00030301,00030302,00030303,00030304,000304,00030402,00030404,00030405,00030406,000305,00030501,00030502,0004,000401,00040101,00040102,00040103,00040104,00040105,000402,00040201,00040202,00040203,00040204,00040205,000403,00040302,00040303,000404,000405,000406,0005,000501,00050101,00050102,00050103,000503,000504,000505,000506,000507,000508,000509,0006,000601,00060101,00060102,00060105,00060106,000602,00060201,00060203,00060204,00060205,00060206,000604,00060401,00060402,00060403,00060404,00060405,00060406,0008,000801,00080101,00080102,00080103,00080104,00080105,000802,00080201,00080202,000803,00080301,00080302,00080303,000804,00080401,00080402,000805,00080502,00080503,00080504,00080505,00080506,000806,00080601,000807,00080703,00080704,00080705,00080706,00080707,00080708,00080709,00080710,00080711,00080712,00080713,00080714,02,0201,020101,020102,020103,0202,020201,020202,020203,020204,020205,0203,020301,020303,0204,020401,020403,03,0301,');
INSERT INTO `sys_user_methods` VALUES ('9', '60', '00,0001,000102,00010201,00010202,000103,00010301,00010302,000104,00010401,00010402,0002,000202,00020201,00020202,00020203,000203,00020301,00020302,00020303,0003,000301,00030101,00030102,00030103,00030104,000302,00030201,00030202,00030203,00030204,000303,00030301,00030302,00030303,00030304,000304,00030402,00030404,00030405,00030406,000305,00030501,00030502,0004,000401,00040101,00040102,00040103,00040104,00040105,000402,00040201,00040202,00040203,00040204,00040205,000403,00040302,00040303,000404,000405,000406,0005,000501,00050101,00050102,00050103,000503,000504,000505,000506,000507,000508,000509,0006,000601,00060101,00060102,00060105,00060106,000602,00060201,00060203,00060204,00060205,00060206,000604,00060401,00060402,00060403,00060404,00060405,00060406,0008,000801,00080101,00080102,00080103,00080104,00080105,000802,00080201,00080202,000803,00080301,00080302,00080303,000804,00080401,00080402,000805,00080502,00080503,00080504,00080505,00080506,000806,00080601,000807,00080703,00080704,00080705,00080706,00080707,00080708,00080709,00080710,00080711,00080712,00080713,00080714,02,0201,020101,020102,020103,0202,020201,020202,020203,020204,020205,0203,020301,020303,0204,020401,020403,');
INSERT INTO `sys_user_methods` VALUES ('10', '61', null);
