package com.mrbook.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 带有数据的通用DTO
 */
@Data
public class CommonDataDTO<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * @param code 状态码
     * @param msg  消息
     * @param data 数据
     */
    public CommonDataDTO(ResultCode code, String msg, T data) {
        this.code = code.getCode();
        this.msg = msg;
        this.data = data;
    }
}
