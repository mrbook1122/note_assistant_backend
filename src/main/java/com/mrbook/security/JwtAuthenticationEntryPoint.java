package com.mrbook.security;

import com.alibaba.fastjson.JSON;
import com.mrbook.model.dto.LoginResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        e.printStackTrace();
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        LoginResult result = new LoginResult(401, "未登录");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
