package com.mrbook.service.impl;

import com.mrbook.mapper.UserMapper;
import com.mrbook.model.dto.CommonResult;
import com.mrbook.model.entity.User;
import com.mrbook.security.dto.UserParam;
import com.mrbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CommonResult register(UserParam userParam) {
        if (userMapper.getUserByName(userParam.getName()) != null)
            return new CommonResult(400, "用户名已存在");
        userMapper.save(new User(userParam.getName(), passwordEncoder.encode(userParam.getPass()),
                userParam.getPhone(), userParam.getEmail()));
        return new CommonResult(200, "注册成功");
    }
}
