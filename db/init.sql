CREATE TABLE account (
    user_id INT PRIMARY KEY COMMENT '用户id',
    phone VARCHAR(11) UNIQUE COMMENT '手机号',
    user_name VARCHAR(20) COMMENT '用户名',
    password VARCHAR(32) COMMENT '密码',
    status TINYINT DEFAULT 1 COMMENT '状态, 1:正常, 0:禁用',
    roles VARCHAR(100) COMMENT '角色',
    create_time DATETIME COMMENT '创建时间'
)