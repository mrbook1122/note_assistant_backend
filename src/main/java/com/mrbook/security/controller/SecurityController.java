package com.mrbook.security.controller;

import com.mrbook.model.dto.CommonDTO;
import com.mrbook.model.dto.ResultCode;
import com.mrbook.security.dto.UserDTO;
import com.mrbook.security.model.LoginUser;
import com.mrbook.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;

@RestController
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private SecretKey secretKey;

    @RequestMapping("/login")
    public CommonDTO login(@RequestBody LoginUser loginUser) {
        UsernamePasswordAuthenticationToken token = new
                UsernamePasswordAuthenticationToken(loginUser.getName(), loginUser.getPass());
        authenticationManager.authenticate(token);
        Calendar calendar = Calendar.getInstance();
        Date createDate = calendar.getTime();
        String jwsToken = Jwts.builder()
                .setSubject(loginUser.getName())
                .setIssuedAt(createDate)
                .signWith(secretKey)
                .compact();
        return new CommonDTO(ResultCode.SUCCESS, jwsToken);
    }

//    @RequestMapping("/register")
//    public LoginResult register(@RequestBody User user) {
//        if (userRepository.findByName(user.getName()) != null) {
//            return new LoginResult(400, "name is exist");
//        }
//        user.setPass(passwordEncoder.encode(user.getPass()));
//        if (userRepository.save(user) != null) {
//            return new LoginResult(200, "success");
//        }
//        return new LoginResult(500, "error");
//    }

    @RequestMapping("/login/status")
    public CommonDTO loginStatus() {
        return new CommonDTO(ResultCode.SUCCESS, "登录成功！");
    }

    @PostMapping("/register")
    public CommonDTO register(@RequestBody @Valid UserDTO userDTO, BindingResult result) {
        return userService.register(userDTO);
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    public CommonDTO exception(UsernameNotFoundException e) {
        return new CommonDTO(ResultCode.REQUEST_ERROR, "username not found");
    }
}
