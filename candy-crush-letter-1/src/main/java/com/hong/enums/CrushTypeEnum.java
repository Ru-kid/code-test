package com.hong.enums;

/**
 * @author hongrunhao
 * @description 消除形式
 * @date 2024/02/20 020
 */
public enum CrushTypeEnum {

    REMOVE(1),
    REPLACE(2);

    private final Integer code;

    CrushTypeEnum(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CrushTypeEnum getEnumByCode(int code) {
        for (CrushTypeEnum crushTypeEnum : CrushTypeEnum.values()) {
            if (crushTypeEnum.getCode() == code) {
                return crushTypeEnum;
            }
        }
        throw new IllegalArgumentException("请选择规定的数字");
    }

}
