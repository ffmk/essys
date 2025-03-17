package com.ff.common.entity;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String phone;
    private String userName;
    @JsonIgnore
    private String password;
    private Integer status;
    private String roles;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
}
