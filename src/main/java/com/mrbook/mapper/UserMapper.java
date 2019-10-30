package com.mrbook.mapper;

import com.mrbook.model.entity.User;

public interface UserMapper {
    //保存用户
    int save(User user);

    void delete(User user);

    User getUserByName(String name);

    void update(User user);
}
