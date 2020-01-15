package com.mrbook.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("user")
@Data
@NoArgsConstructor
public class User {
    /**
     * @param name 用户名
     * @param pass 密码
     * @param avatar 头像url
     * @param phoneNumber 手机号
     * @param email 邮箱
     */
    public User(String name, String pass, String avatar, String phoneNumber, String email) {
        this.name = name;
        this.pass = pass;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * 用户id
     */
    private int id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String pass;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 邮箱
     */
    private String email;
}
