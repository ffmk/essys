package com.ff.common.entity.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 用户session信息
 */
@Component
@Data
public class SessionUserAdminDto {
    private Integer userId;
    private String userName;
    private Boolean superAdmin;
}
