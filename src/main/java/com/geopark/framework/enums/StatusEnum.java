package com.geopark.framework.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 * 状态枚举
 * </p>
 *
 * @author lichee
 */
public enum StatusEnum implements IEnum {

    NORMAL(0), DISABLE(1);

    @EnumValue
    private final int value;

    StatusEnum(final int value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
