package com.mrbook.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtils {
    @Autowired
    private SecretKey secretKey;

    /**
     * 从jwt token中提取用户名
     * @param token jwt token
     * @return 用户名
     */
    public String getNameFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject();
    }
}
