package com.mrbook.mapper;

import com.mrbook.model.entity.User;

public interface UserMapper {
    //保存用户
    void save(User user);

    //删除一个用户
    void delete(User user);

    //根据用户名获取用户信息，如果用户名不存在，返回null
    User getUserByName(String name);

    //更新一个用户的信息
    void update(User user);
}
