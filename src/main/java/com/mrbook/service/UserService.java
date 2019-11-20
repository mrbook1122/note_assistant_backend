package com.mrbook.service;

import com.mrbook.model.dto.CommonResult;
import com.mrbook.security.dto.UserParam;

public interface UserService {
    CommonResult register(UserParam userParam);
}
