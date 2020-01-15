package com.mrbook.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通用DTO
 */
@Data
public class CommonDTO {
    private int code;
    private String msg;

    /**
     * @param code 状态码
     * @param msg  消息
     */
    public CommonDTO(ResultCode code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
    }
}
