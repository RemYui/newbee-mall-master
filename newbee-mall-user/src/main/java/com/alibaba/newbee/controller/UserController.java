package com.alibaba.newbee.controller;

import com.alibaba.newbee.exception.BaseException;
import com.alibaba.newbee.exception.ErrorCodes;
import com.alibaba.newbee.param.AuthUser;
import com.alibaba.newbee.results.BaseResults;
import com.alibaba.newbee.results.ResultCodes;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: Emilia
 * @Since: 2022.03.08 19:27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public BaseResults<String> login(@Validated @RequestBody AuthUser authUser, HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute(authUser.getUuid());
        if (code.equals(authUser.getCode())) {
            throw new BaseException(ErrorCodes.CODE_WAS_OVER_DUE);
        }
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new BaseResults<>(ResultCodes.SUCCESS, null);
    }

    @GetMapping("/getCode")
    public BaseResults<Object> getCode(HttpServletRequest request) {
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = "";
        try {
            result = new Double(Double.parseDouble(captcha.text())).intValue() + "";
        } catch (Exception e) {
            result = captcha.text();
        }
        //保存
        UUID uuid = UUID.randomUUID();
        request.getSession().setAttribute(uuid.toString(), result);
        // 验证码信息
        Map<String, Object> imgResult = new HashMap<String, Object>(2) {{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        //返回
        return new BaseResults<>(ResultCodes.SUCCESS, imgResult);
    }


}
