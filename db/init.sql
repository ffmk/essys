DROP TABLE IF EXISTS account;
CREATE TABLE account (
    user_id INT PRIMARY KEY COMMENT '用户id',
    phone VARCHAR(11) UNIQUE COMMENT '手机号',
    user_name VARCHAR(20) COMMENT '用户名',
    password VARCHAR(32) COMMENT '密码',
    status TINYINT DEFAULT 1 COMMENT '状态, 1:正常, 0:禁用',
    roles VARCHAR(100) COMMENT '角色',
    create_time DATETIME COMMENT '创建时间'
);

DROP TABLE IF EXISTS menu;
CREATE TABLE menu (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '菜单id',
    name VARCHAR(32) NOT NULL COMMENT '菜单名',
    type INT(11) NOT NULL DEFAULT '0' COMMENT '菜单类型, 1:按钮, 0:菜单',
    url VARCHAR(256) COMMENT '菜单跳转地址',
    p_id INT(11) NOT NULL COMMENT '上级菜单id',
    sort TINYINT(4) DEFAULT '0' COMMENT '菜单排序',
    permission_code VARCHAR(50) COMMENT '权限编码',
    icon VARCHAR(50) COMMENT '图标'
);