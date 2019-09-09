package com.mrbook.security.controller;

import com.mrbook.model.dto.LoginResult;
import com.mrbook.model.entity.User;
import com.mrbook.repository.UserRepository;
import com.mrbook.security.model.LoginUser;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;

@RestController
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecretKey secretKey;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public LoginResult login(@RequestBody LoginUser loginUser) {
        System.out.println("hello");
        UsernamePasswordAuthenticationToken token = new
                UsernamePasswordAuthenticationToken(loginUser.getName(), loginUser.getPass());
        authenticationManager.authenticate(token);
        System.out.println("hello2");
        Calendar calendar = Calendar.getInstance();
        Date createDate = calendar.getTime();
        String jwsToken = Jwts.builder()
                .setSubject(loginUser.getName())
                .setIssuedAt(createDate)
                .signWith(secretKey)
                .compact();
        System.out.println("认证。。。");
        return new LoginResult(200, jwsToken);
    }

    @RequestMapping("/register")
    public LoginResult register(@RequestBody User user) {
        if (userRepository.findByName(user.getName()) != null) {
            return new LoginResult(400, "name is exist");
        }
        user.setPass(passwordEncoder.encode(user.getPass()));
        if (userRepository.save(user) != null) {
            return new LoginResult(200, "success");
        }
        return new LoginResult(500, "error");
    }

    @RequestMapping("/login/status")
    public LoginResult loginStatus() {
        return new LoginResult(200, "login success");
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    public LoginResult exception(UsernameNotFoundException e) {
        return new LoginResult(500, "username not found");
    }
}
