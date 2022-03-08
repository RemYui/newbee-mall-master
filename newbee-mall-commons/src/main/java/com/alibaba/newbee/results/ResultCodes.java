package com.alibaba.newbee.results;

import lombok.Getter;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 15:56
 */
@Getter
public enum ResultCodes {
    /**
     * 200
     */
    SUCCESS(200, "success", "成功"),
    SUCCESS_Found(0, "success", "成功"),
    /**
     * 404
     */
    DATA_NOT_FOUND(404, "data is not found", "找不到资源"),
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

    ResultCodes(Integer status, String msg, String tips) {
        this.status = status;
        this.msg = msg;
        this.tips = tips;
    }
}
