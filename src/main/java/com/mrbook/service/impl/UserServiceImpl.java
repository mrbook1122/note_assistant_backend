package com.mrbook.service.impl;

import com.mrbook.mapper.UserMapper;
import com.mrbook.model.dto.CommonDTO;
import com.mrbook.model.dto.ResultCode;
import com.mrbook.model.entity.User;
import com.mrbook.security.dto.UserDTO;
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
    public CommonDTO register(UserDTO userDTO) {
        if (userMapper.getUserByName(userDTO.getName()) != null)
            return new CommonDTO(ResultCode.REQUEST_ERROR, "用户名已存在");
        User user = userDTO.convertTo();
        user.setPass(passwordEncoder.encode(user.getPass()));
        userMapper.save(user);
        return new CommonDTO(ResultCode.SUCCESS, "注册成功");
    }
}
