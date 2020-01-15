package com.mrbook.security.dto;

import com.mrbook.model.entity.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {
    @NotBlank(message = "用户名不能为空")
    private String name;

    @Length(min = 11, max = 11, message = "手机号格式不正确")
    private String phone;

    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "密码不能为空")
    private String pass;

    private String avatar;

    public User convertTo() {
        return new User(name, pass, avatar, phone, email);
    }
}
