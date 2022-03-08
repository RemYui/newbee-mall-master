package com.alibaba.newbee.exception;

import lombok.Getter;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 15:45
 */
@Getter
public class BaseException  extends RuntimeException {

    private Integer status;

    private String msg;

    private String tips;

    public BaseException() {
    }

    public BaseException(ErrorCodes errorCodes) {
        this.status = errorCodes.getStatus();
        this.msg = errorCodes.getMsg();
        this.tips = errorCodes.getTips();
    }
}
