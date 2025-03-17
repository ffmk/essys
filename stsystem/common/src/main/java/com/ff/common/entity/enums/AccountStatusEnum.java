package com.ff.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountStatusEnum {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用");

    private Integer status;
    private String desc;
}
