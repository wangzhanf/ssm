# 首先创建一个数据库(Tab补全)
drop database if exists java6ssm;
create database if not exists java6ssm;

use java6ssm;

# 创建管理用户数据表
drop table if exists adminuser;
create table if not exists adminuser
(
    uid      integer auto_increment comment '用户id',
    username varchar(20) not null comment '用户登录名',
    password varchar(32) not null comment '登录密码',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`uid`)
) comment '管理用户登录表';

commit;
# 插入管理用户测试数据
insert into adminuser (username, password)
values ('wzf', 'fe8fb64eb34764f9e0a58a32a819dcb2');
insert into adminuser (uid, username, password)
values (null, 'admin', 'fe8fb64eb34764f9e0a58a32a819dcb2');

# 批量插入测试数据
DROP PROCEDURE
    IF
        EXISTS adminuser_insert;

DELIMITER $$
CREATE PROCEDURE adminuser_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 100 DO
            insert into adminuser (username,password) value (concat('user',i),'fe8fb64eb34764f9e0a58a32a819dcb2') ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL adminuser_insert ();

commit;



# 创建商户信息表
drop table if exists business;
create table if not exists business
(
    bid integer auto_increment comment '商户id',
    bname varchar(20) not null comment '商户名称',
    bpass varchar(32) not null comment '密码',
    bdes varchar(20) default null comment '商户介绍',
    bdelivery varchar(64) default null comment '配送标准',
    bmark Double comment '评分',
    bavatar varchar(150) default null comment '头像',
    baddress varchar(50) default null comment '地址',
    brecommendation integer default 0 comment '推荐指数',
    bstatus boolean default false comment '是否禁用',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`bid`)
) auto_increment=1 charset=utf8 comment '商户信息表';
commit ;

# 批量插入测试数据
DROP PROCEDURE IF EXISTS business_insert;

DELIMITER $$
CREATE PROCEDURE business_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 100 DO
            insert into business (bname, bpass, bdes, bdelivery, bmark, bavatar, baddress, brecommendation, bstatus) value
                                (concat('business',i),'fe8fb64eb34764f9e0a58a32a819dcb2',concat('business',i,'的介绍'),'15起送',FlOOR(RAND() * 5 + 1),'/upload/bussiness.png',
                                '高新区火炬路',FlOOR(RAND() * 99 + 1),false) ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL business_insert ();

commit;


# 创建活动信息表
drop table if exists activity;
create table if not exists activity
(
    aid integer auto_increment comment '活动id',
    aname varchar(20) not null comment '活动名称',
    ades varchar(120) default null comment '活动介绍',
    atype integer  comment '活动类型',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`aid`)
) auto_increment=1 charset=utf8 comment '活动信息表';
commit ;

# 批量插入测试数据
DROP PROCEDURE IF EXISTS activity_insert;

DELIMITER $$
CREATE PROCEDURE activity_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 10 DO
            insert into activity (aname, ades, atype) value
                (concat('activity',i),'活动介绍',FlOOR(RAND() * 5 + 1)) ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL activity_insert ();

commit;


# 创建商户和活动映射表
drop table if exists business_to_activity;
create table if not exists business_to_activity(
    baid integer auto_increment comment '索引主键',
    fbid integer not null comment '商户信息',
    faid integer not null comment '活动信息',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`baid`),
    constraint `fk_bta_fbid_to_business_bid` foreign key business_to_activity(`fbid`) references business(`bid`),
    constraint `fk_bta_faid_to_activity_bid` foreign key business_to_activity(`faid`) references activity(`aid`)
)auto_increment=1 charset=utf8 comment '商户和活动映射表';
commit ;

# 批量插入测试数据
DROP PROCEDURE IF EXISTS business_to_activity_insert;

DELIMITER $$
CREATE PROCEDURE business_to_activity_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 100 DO
            insert into business_to_activity (fbid, faid) value
                (FlOOR(RAND() * 99 + 1),FlOOR(RAND() * 5 + 1)) ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL business_to_activity_insert ();

commit;


# 创建商品类别表
drop table if exists types;
create table if not exists types(
    tid integer auto_increment comment '类别id',
    tname varchar(20) not null comment '类别名称',
    tdes varchar(20) default null comment '类别介绍',
    tavatar varchar(50) default null comment '类别图片',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`tid`)
)auto_increment=1 charset=utf8 comment '商品类别表';
commit ;

# 批量插入测试数据
DROP PROCEDURE IF EXISTS types_insert;

DELIMITER $$
CREATE PROCEDURE types_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 10 DO
            insert into types (tname, tdes, tavatar) value
                (CONCAT('类别',i),CONCAT('类别介绍',i),'/upload/types.png') ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL types_insert ();

commit;


# 创建商品信息表
drop table if exists goods;
create table if not exists goods(
    gid integer auto_increment comment '商品id',
    gname varchar(20) not null comment '商品名称',
    gdes varchar(20) default null comment '商品介绍',
    gprice Double comment '商品价格',
    gavatar varchar(50) default null comment '商品图片',
    fbid integer not null comment '商户信息',
    ftid integer not null comment '所属类别',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`gid`),
    constraint `fk_g_fbid_to_business_bid` foreign key goods(`fbid`) references business(`bid`),
    constraint `fk_g_ftid_to_types_tid` foreign key goods(`ftid`) references types(`tid`)
)auto_increment=1 charset=utf8 comment '商品信息表';
commit ;

# 批量插入测试数据
DROP PROCEDURE IF EXISTS goods_insert;

DELIMITER $$
CREATE PROCEDURE goods_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 200 DO
            insert into goods (gname, gdes, gprice, gavatar, fbid, ftid) value
                (CONCAT('商品',i),CONCAT('商品介绍',i),RAND() * 15 + 5,'/upload/goods.png',FlOOR(RAND() * 9 + 1),FlOOR(RAND() * 3 + 1)) ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL goods_insert ();

commit;

# 创建客户数据表
drop table if exists customer;
create table if not exists customer
(
    cid integer auto_increment comment '客户id',
    cname varchar(20) not null comment '客户姓名',
    cphone varchar(20) default null comment '联系电话',
    cemail varchar(64) default null comment '邮箱地址',
    cpass varchar(32) not null comment '密码',
    caddress varchar(64) default null comment '送货地址',
    cbirth date default null comment '生日',
    cavatar varchar(50) default null comment '头像',
    cgender boolean default false comment '性别',
    cstatus boolean default false comment '是否禁用',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`cid`),
    UNIQUE KEY `cid` (`cid`),
    UNIQUE KEY `cname` (`cname`),
    UNIQUE KEY `cphone` (`cphone`),
    UNIQUE KEY `cemail` (`cemail`)
) auto_increment=1 charset=utf8 comment '客户基本信息表';
commit ;

# 通过批处理插入测试数据
DROP PROCEDURE
    IF
        EXISTS customer_insert;

DELIMITER $$
CREATE PROCEDURE customer_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 100 DO
            insert into customer (cname, cphone, cemail, cpass, caddress,cavatar, cgender, cstatus)
            value (concat('cus',i),concat('138',FlOOR(RAND() * 80000000 + 10000000)),concat('138',FlOOR(RAND() * 80000000 + 10000000),'@epss.vip'),'696aa7bb5ee7ac9135f7ed4ef526fe4d'
                  ,concat('收货地址',i),'/upload/customer.png',false,false) ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL customer_insert ();

# 创建订单数据表
drop table if exists orders;
create table if not exists orders
(
    oid integer auto_increment comment '订单id',
    onumber integer comment '购买数量',
    ostatus integer comment '订单状态',
    fgid integer not null comment '商品信息',
    fcid integer not null comment '客户信息',
    fbid integer not null comment '商户信息',
    add_time timestamp   not null default current_timestamp comment '创建时间',
    up_time  timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`oid`),
    constraint `fk_o_fgid_to_goods_gid` foreign key orders(`fgid`) references goods(`gid`),
    constraint `fk_o_fcid_to_customer_cid` foreign key orders(`fcid`) references customer(`cid`),
    constraint `fk_o_fbid_to_business_bid` foreign key orders(`fbid`) references business(`bid`)
) auto_increment=1 charset=utf8 comment '客户基本信息表';
commit ;

# 批量插入测试数据
DROP PROCEDURE IF EXISTS orders_insert;

DELIMITER $$
CREATE PROCEDURE orders_insert ()
BEGIN
    DECLARE
        i INT DEFAULT 1;
    WHILE
            i < 200 DO
            insert into orders (onumber, ostatus, fgid, fcid, fbid) value
                (FlOOR(RAND() * 9 + 1),FlOOR(RAND() * 3 + 1),FlOOR(RAND() * 99 + 1),FlOOR(RAND() * 99 + 1),FlOOR(RAND() * 99 + 1)) ;
            SET i = i + 1;

        END WHILE;
    COMMIT;

END $$
DELIMITER ;
CALL orders_insert ();

commit;