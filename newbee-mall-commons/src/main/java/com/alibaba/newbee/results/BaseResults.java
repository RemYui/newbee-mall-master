package com.alibaba.newbee.results;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 15:53
 */
@Data
@Builder
@AllArgsConstructor
public class BaseResults<T> {

    private Integer status;

    private String msg;

    private String tips;

    private T data;

    public BaseResults() {
    }

    public BaseResults(ResultCodes resultCodes, T data) {
        this.status = resultCodes.getStatus();
        this.msg = resultCodes.getMsg();
        this.tips = resultCodes.getTips();
        this.data = data;
    }

    public BaseResults<T> success(T data) {
        return new BaseResults<>(ResultCodes.SUCCESS, data);
    }

    public BaseResults<T> success(ResultCodes resultCodes, T data) {
        return BaseResults.<T>builder()
                .status(resultCodes.getStatus())
                .msg(resultCodes.getMsg())
                .tips(resultCodes.getTips())
                .data(data)
                .build();
    }

    public BaseResults<T> error() {
        return new BaseResults<T>(ResultCodes.DATA_NOT_FOUND, null);
    }

    public BaseResults<T> error(ResultCodes resultCodes) {
        return BaseResults.<T>builder()
                .status(resultCodes.getStatus())
                .msg(resultCodes.getMsg())
                .tips(resultCodes.getTips())
                .build();
    }
}
