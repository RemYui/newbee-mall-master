package com.alibaba.newbee.exception;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 15:51
 */
public class ServiceException extends BaseException {

    public ServiceException(ErrorCodes errorCodes) {
        super(errorCodes);
    }
}
