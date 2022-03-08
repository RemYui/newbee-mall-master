package com.alibaba.newbee.utils;

/**
 * @author
 * @param <S>
 * @param <T>
 */
public interface ListBeansUtilsCallBack<S, T> {

    /**
     * .
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}