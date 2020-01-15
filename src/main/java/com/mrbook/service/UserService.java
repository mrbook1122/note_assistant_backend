package com.mrbook.service;

import com.mrbook.model.dto.CommonDTO;
import com.mrbook.security.dto.UserDTO;

public interface UserService {
    CommonDTO register(UserDTO userDTO);
}
