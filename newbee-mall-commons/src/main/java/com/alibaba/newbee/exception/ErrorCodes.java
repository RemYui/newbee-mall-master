package com.alibaba.newbee.exception;


import lombok.Getter;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 15:49
 */
@Getter
public enum ErrorCodes {

    /**
     * 账号已存在
     */
    MEMBER_WAS_EXISTED(40001, "member was existed", "账号已存在"),
    /**
     * 验证码不正确
     */
    CODE_IS_NOT_CORRECT(40002, "code is not correct", "验证码不正确"),
    /**
     * 验证码已经过期
     */
    CODE_WAS_OVER_DUE(40002, "code was over due", "验证码已经过期"),
    ;

    private final Integer status;

    private final String msg;

    private final String tips;

    ErrorCodes(Integer status, String msg, String tips) {
        this.status = status;
        this.msg = msg;
        this.tips = tips;
    }
}
