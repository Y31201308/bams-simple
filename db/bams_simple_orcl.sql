------------------------------------------
-- Export file for user BAMS2           --
-- Created by JC on 2015/4/21, 21:26:12 --
------------------------------------------

spool bams_simple_orcl.log

prompt
prompt Creating table HRM_DEPARTMENT
prompt =============================
prompt
create table HRM_DEPARTMENT
(
  DEP_ID          NUMBER(11) not null,
  HRM_DEP_ID      NVARCHAR2(50) not null,
  HRM_DEP_CODE    NVARCHAR2(50),
  HRM_DEP_NAME    NVARCHAR2(100),
  HRM_DEP_ENGNAME NVARCHAR2(100),
  HRM_DEP_UPID    NVARCHAR2(50),
  HRM_EMP_ID      NVARCHAR2(50),
  HRM_DEP_DESC    NVARCHAR2(500),
  RECORD_ID       NVARCHAR2(50),
  RECORD_DATE     NVARCHAR2(20),
  LASTMODI_ID     NVARCHAR2(50),
  LASTMODI_DATE   NVARCHAR2(20),
  HRM_DEP_SHOWROW NUMBER(11) not null
)
;
alter table HRM_DEPARTMENT
  add primary key (DEP_ID);

prompt
prompt Creating table HRM_EMPLOYEE
prompt ===========================
prompt
create table HRM_EMPLOYEE
(
  HRM_EMPLOYEE_ID            NVARCHAR2(50) not null,
  HRM_EMPLOYEE_NAME          NVARCHAR2(100),
  HRM_EMPLOYEE_ENGNAME       NVARCHAR2(100),
  HRM_EMPLOYEE_SIMPLE        NVARCHAR2(100),
  HRM_EMPLOYEE_CODE          NVARCHAR2(50),
  HRM_EMPLOYEE_PATTERN_ID    NVARCHAR2(20),
  HRM_EMPLOYEE_BIRTHDAY      NVARCHAR2(20),
  HRM_EMPLOYEE_SEX           NVARCHAR2(20),
  HRM_EMPLOYEE_MARRIAGE      NVARCHAR2(20),
  HRM_EMPLOYEE_POLITICS      NVARCHAR2(20),
  HRM_EMPLOYEE_NATIONALITY   NVARCHAR2(20),
  HRM_EMPLOYEE_BLOOD_TYPE    NVARCHAR2(20),
  HRM_EMPLOYEE_HEIGHT        NVARCHAR2(20),
  HRM_EMPLOYEE_WEIGHT        NVARCHAR2(20),
  HRM_EMPLOYEE_IMAGE_INFO_ID NUMBER(11),
  HRM_EMPLOYEE_SCHOOL        NVARCHAR2(100),
  HRM_EMPLOYEE_PROFESSIONAL  NVARCHAR2(100),
  HRM_EMPLOYEE_DEGREE        NVARCHAR2(20),
  HRM_EMPLOYEE_IDENTITYCARD  NVARCHAR2(20),
  HRM_EMPLOYEE_HOMETOWN      NVARCHAR2(200),
  HRM_EMPLOYEE_HOUSE_PHONE   NVARCHAR2(50),
  HRM_EMPLOYEE_HOUSE_ADDRESS NVARCHAR2(200),
  HRM_EMPLOYEE_MOBILE_TELE   NVARCHAR2(50),
  HRM_EMPLOYEE_WORK_TELE     NVARCHAR2(50),
  HRM_EMPLOYEE_IN_TIME       NVARCHAR2(20),
  HRM_EMPLOYEE_DEPID         NUMBER(11),
  HRM_EMPLOYEE_WORKAREAID    NUMBER(11),
  HRM_EMPLOYEE_POST_ID       NUMBER(11),
  HRM_EMPLOYEE_SQUAD_ID      NUMBER(11),
  HRM_EMPLOYEE_EMAIL         NVARCHAR2(100),
  HRM_EMPLOYEE_URGENT_PRESON NVARCHAR2(200),
  HRM_EMPLOYEE_URGENT_PHONE  NVARCHAR2(200),
  HRM_EMPLOYEE_ADDERSS       NVARCHAR2(200),
  HRM_EMPLOYEE_APPENDID      NCLOB,
  RECORD_ID                  NVARCHAR2(50),
  RECORD_DATE                VARCHAR2(20),
  LASTMODI_ID                NVARCHAR2(50),
  LASTMODI_DATE              VARCHAR2(20),
  HRM_EMPLOYEE_WORK_TIME     NVARCHAR2(20),
  HRM_PART_POST              NVARCHAR2(100),
  HRM_EMPLOYEE_STATUS        NUMBER(11),
  HRM_OTHER_ATTACHMEN        NVARCHAR2(500),
  HRM_EMPLOYEE_ACTIVE        NUMBER(11)
)
;
comment on column HRM_EMPLOYEE.HRM_EMPLOYEE_CODE
  is '员工工号|1|2|2|0';
comment on column HRM_EMPLOYEE.HRM_EMPLOYEE_PATTERN_ID
  is '用工形式';
comment on column HRM_EMPLOYEE.HRM_EMPLOYEE_BIRTHDAY
  is '生日';
comment on column HRM_EMPLOYEE.HRM_EMPLOYEE_SEX
  is '性别';
comment on column HRM_EMPLOYEE.HRM_EMPLOYEE_MARRIAGE
  is '婚姻状况';
alter table HRM_EMPLOYEE
  add primary key (HRM_EMPLOYEE_ID);

prompt
prompt Creating table HRM_POST
prompt =======================
prompt
create table HRM_POST
(
  POST_ID          NUMBER(11) not null,
  HRM_POST_ID      NVARCHAR2(50),
  HRM_POST_NAME    NVARCHAR2(100),
  HRM_POST_ENGNAME NVARCHAR2(100),
  HRM_POST_UPID    NVARCHAR2(50),
  HRM_POST_MANG    NVARCHAR2(50),
  HRM_POST_DESC    NVARCHAR2(500),
  RECORD_ID        NVARCHAR2(50),
  RECORD_DATE      NVARCHAR2(20),
  LASTMODI_ID      NVARCHAR2(50),
  LASTMODI_DATE    NVARCHAR2(20),
  HRM_POST_SHOWROW NUMBER(11) not null
)
;
alter table HRM_POST
  add primary key (POST_ID);

prompt
prompt Creating table SYS_ATTACHMENT_INFO
prompt ==================================
prompt
create table SYS_ATTACHMENT_INFO
(
  ATTACHMENT_ID          NUMBER(11) not null,
  ATTACHMENT_FILENAME    NVARCHAR2(500),
  ATTACHMENT_NAME        NVARCHAR2(100),
  ATTACHMENT_RENAME      NVARCHAR2(100),
  ATTACHMENT_DESCRIPTION NVARCHAR2(500),
  ATTACHMENT_REMARK      NVARCHAR2(500),
  RECORD_ID              NVARCHAR2(50),
  RECORD_DATE            NVARCHAR2(20),
  LASTMODI_ID            NVARCHAR2(50),
  LASTMODI_DATE          NVARCHAR2(20)
)
;
alter table SYS_ATTACHMENT_INFO
  add primary key (ATTACHMENT_ID);

prompt
prompt Creating table SYS_COLUMN_CONTROL
prompt =================================
prompt
create table SYS_COLUMN_CONTROL
(
  COLUMN_CONTROL_ID NUMBER(11) not null,
  COLUMN_CODE       NVARCHAR2(100),
  COLUMN_NAME       NVARCHAR2(100),
  IS_SHOW           NUMBER(11),
  TABLE_NAME        NVARCHAR2(50),
  ISSHOW_SIMPLE     NUMBER(11),
  ISSHOW_ADVANCED   NUMBER(11),
  COLUMN_STRCOUNT   NUMBER(11),
  PRIORITY          NUMBER(11)
)
;
alter table SYS_COLUMN_CONTROL
  add primary key (COLUMN_CONTROL_ID);

prompt
prompt Creating table SYS_EXCEPTION
prompt ============================
prompt
create table SYS_EXCEPTION
(
  EXCEPTION_ID      NUMBER(11) not null,
  USER_ID           NUMBER(11),
  EXCEPTION_DATE    NVARCHAR2(20),
  EXCEPTION_MSG     NCLOB,
  EXCEPTION_CLASS   NVARCHAR2(200),
  EXCEPTION_CONTEXT NCLOB,
  PROCESS_NAME      NVARCHAR2(50),
  PROCESS_DATE      NVARCHAR2(20),
  PROCESS_CONTEXT   NCLOB,
  EXCEPTION_STATUS  NUMBER(11)
)
;
alter table SYS_EXCEPTION
  add primary key (EXCEPTION_ID);

prompt
prompt Creating table SYS_IMAGE_INFO
prompt =============================
prompt
create table SYS_IMAGE_INFO
(
  IMAGE_INFO_ID          NUMBER(11) not null,
  IMAGE_INFO_FILENAME    NVARCHAR2(500),
  IMAGE_INFO_FILEPATH    NVARCHAR2(500),
  IMAGE_INFO_NAME        NVARCHAR2(100),
  IMAGE_INFO_RENAME      NVARCHAR2(100),
  IMAGE_INFO_DESCRIPTION NVARCHAR2(500),
  IMAGE_INFO_REMARK      NVARCHAR2(200),
  RECORD_ID              NVARCHAR2(50),
  RECORD_DATE            NVARCHAR2(20),
  LASTMODI_ID            NVARCHAR2(50),
  LASTMODI_DATE          NVARCHAR2(20)
)
;
alter table SYS_IMAGE_INFO
  add primary key (IMAGE_INFO_ID);

prompt
prompt Creating table SYS_LIBRARY_INFO
prompt ===============================
prompt
create table SYS_LIBRARY_INFO
(
  LIBRARY_ID           NUMBER(11) not null,
  LIBRARY_INFO_CODE    NVARCHAR2(20),
  LIBRARY_INFO_NAME    NVARCHAR2(50),
  LIBRARY_INFO_ENGNAME NVARCHAR2(100),
  LIBRARY_INFO_UPCODE  NVARCHAR2(20),
  LIBRARY_INFO_ISVALID NUMBER(11),
  LIBRARY_INFO_DESC    NVARCHAR2(500)
)
;
alter table SYS_LIBRARY_INFO
  add primary key (LIBRARY_ID);

prompt
prompt Creating table SYS_METHOD_HELP
prompt ==============================
prompt
create table SYS_METHOD_HELP
(
  HELP_ID   NUMBER(11) not null,
  HELP_IMG  NVARCHAR2(255),
  HELP_DESC NVARCHAR2(255),
  METHOD_ID NVARCHAR2(10)
)
;
alter table SYS_METHOD_HELP
  add primary key (HELP_ID);

prompt
prompt Creating table SYS_METHOD_INFO
prompt ==============================
prompt
create table SYS_METHOD_INFO
(
  METHOD_INFO_ID      NVARCHAR2(20) not null,
  METHOD_INFO_NAME    NVARCHAR2(20),
  METHOD_INFO_ENGNAME NVARCHAR2(50),
  METHOD_URI          NVARCHAR2(500),
  METHOD_NO           NUMBER(11),
  IMAGE_SRC           NVARCHAR2(100),
  METHOD_LEVEL        NUMBER(11),
  LEVEL_UNIT          NVARCHAR2(10),
  IS_ACTION           NUMBER(11),
  METHOD_SIGN         NVARCHAR2(20),
  METHOD_MSG          NVARCHAR2(1000),
  METHOD_PAGES        NVARCHAR2(1000)
)
;
alter table SYS_METHOD_INFO
  add primary key (METHOD_INFO_ID);

prompt
prompt Creating table SYS_PARAM
prompt ========================
prompt
create table SYS_PARAM
(
  PARAM_ID         NUMBER(11) not null,
  PARAM_INDEX      NVARCHAR2(50),
  PARAM_TITLE      NVARCHAR2(100),
  PARAM_VALUE      NVARCHAR2(50),
  PARAM_REMARK     NVARCHAR2(500),
  RECORD_ID        NVARCHAR2(50),
  RECORD_DATE      NVARCHAR2(20),
  LASTMODI_ID      NVARCHAR2(50),
  LASTMODI_DATE    NVARCHAR2(20),
  PARAM_TYPE       NUMBER(11),
  PARAM_TYPE_VALUE NVARCHAR2(500)
)
;
alter table SYS_PARAM
  add primary key (PARAM_ID);

prompt
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table SYS_ROLE
(
  ROLE_ID       NUMBER(11) not null,
  ROLE_NAME     NVARCHAR2(100),
  ROLE_DESC     NVARCHAR2(500),
  RECORD_ID     NVARCHAR2(50),
  RECORD_DATE   NVARCHAR2(20),
  LASTMODI_ID   NVARCHAR2(50),
  LASTMODI_DATE NVARCHAR2(20)
)
;
alter table SYS_ROLE
  add primary key (ROLE_ID);

prompt
prompt Creating table SYS_ROLE_BIND
prompt ============================
prompt
create table SYS_ROLE_BIND
(
  BIND_ID    NUMBER(11) not null,
  BIND_TYPE  NUMBER(11),
  ROLE_ID    NUMBER(11),
  BIND_VALUE NVARCHAR2(100)
)
;
alter table SYS_ROLE_BIND
  add primary key (BIND_ID);

prompt
prompt Creating table SYS_ROLE_DETAIL
prompt ==============================
prompt
create table SYS_ROLE_DETAIL
(
  ROLE_DETAIL_ID NUMBER(11) not null,
  ROLE_ID        NUMBER(11),
  METHOD_ID      NVARCHAR2(10)
)
;
alter table SYS_ROLE_DETAIL
  add primary key (ROLE_DETAIL_ID);

prompt
prompt Creating table SYS_USER_GROUP
prompt =============================
prompt
create table SYS_USER_GROUP
(
  GROUP_ID      NUMBER(11) not null,
  GROUP_NAME    NVARCHAR2(100),
  GROUP_DECP    NVARCHAR2(500),
  RECORD_ID     NVARCHAR2(50),
  RECORD_DATE   NVARCHAR2(20),
  LASTMODI_ID   NVARCHAR2(50),
  LASTMODE_DATE NVARCHAR2(20)
)
;
alter table SYS_USER_GROUP
  add primary key (GROUP_ID);

prompt
prompt Creating table SYS_USER_GROUP_DETAIL
prompt ====================================
prompt
create table SYS_USER_GROUP_DETAIL
(
  GROUP_DETAIL_ID NUMBER(11) not null,
  USER_ID         NUMBER(11),
  GROUP_ID        NUMBER(11)
)
;
alter table SYS_USER_GROUP_DETAIL
  add primary key (GROUP_DETAIL_ID);

prompt
prompt Creating table SYS_USER_INFO
prompt ============================
prompt
create table SYS_USER_INFO
(
  USER_ID         NUMBER(11) not null,
  HRM_EMPLOYEE_ID NVARCHAR2(50),
  USER_NAME       NVARCHAR2(100),
  USERPASSWORD    NVARCHAR2(100),
  USER_ACTION     NUMBER(11),
  RECORD_ID       NVARCHAR2(50),
  RECORD_DATE     NVARCHAR2(20),
  LASTMODI_ID     NVARCHAR2(50),
  LASTMODI_DATE   NVARCHAR2(20),
  USER_TYPE       NUMBER(11)
)
;
alter table SYS_USER_INFO
  add primary key (USER_ID);

prompt
prompt Creating table SYS_USER_METHODS
prompt ===============================
prompt
create table SYS_USER_METHODS
(
  USER_METHOD_ID     NUMBER(11) not null,
  USER_ID            NUMBER(11),
  USER_METHOD_DETAIL NCLOB
)
;
alter table SYS_USER_METHODS
  add primary key (USER_METHOD_ID);

prompt
prompt Creating sequence HRM_DEP_ID
prompt ============================
prompt
create sequence HRM_DEP_ID
minvalue 1
maxvalue 999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence HRM_POST_ID
prompt =============================
prompt
create sequence HRM_POST_ID
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_ATTACHMENT_ID
prompt ===================================
prompt
create sequence SYS_ATTACHMENT_ID
minvalue 1
maxvalue 999999999
start with 401
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_BIND_ID
prompt =============================
prompt
create sequence SYS_BIND_ID
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_COLUMN_CONTROL_ID
prompt =======================================
prompt
create sequence SYS_COLUMN_CONTROL_ID
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_EXCEPTION_ID
prompt ==================================
prompt
create sequence SYS_EXCEPTION_ID
minvalue 1
maxvalue 999999999
start with 621
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_GROUP_DETAIL_ID
prompt =====================================
prompt
create sequence SYS_GROUP_DETAIL_ID
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_GROUP_ID
prompt ==============================
prompt
create sequence SYS_GROUP_ID
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_IMAGE_INFO_ID
prompt ===================================
prompt
create sequence SYS_IMAGE_INFO_ID
minvalue 1
maxvalue 999999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_LIBRARY_ID
prompt ================================
prompt
create sequence SYS_LIBRARY_ID
minvalue 2108
maxvalue 999999999
start with 4876
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_METHOD_HELP_ID
prompt ====================================
prompt
create sequence SYS_METHOD_HELP_ID
minvalue 1
maxvalue 999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_PARAM_ID
prompt ==============================
prompt
create sequence SYS_PARAM_ID
minvalue 1
maxvalue 999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_ROLE_DETAIL_ID
prompt ====================================
prompt
create sequence SYS_ROLE_DETAIL_ID
minvalue 1
maxvalue 999999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_ROLE_ID
prompt =============================
prompt
create sequence SYS_ROLE_ID
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_USER_ID
prompt =============================
prompt
create sequence SYS_USER_ID
minvalue 59
maxvalue 999999999
start with 143
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_USER_METHOD_ID
prompt ====================================
prompt
create sequence SYS_USER_METHOD_ID
minvalue 1
maxvalue 999999999
start with 21
increment by 1
cache 20;


spool off
