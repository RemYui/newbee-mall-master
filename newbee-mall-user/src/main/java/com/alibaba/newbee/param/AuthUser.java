package com.alibaba.newbee.param;

import lombok.Data;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 20:41
 */
@Data
public class AuthUser {

    private String username;

    private String password;

    private String uuid;

    private String code;
}
