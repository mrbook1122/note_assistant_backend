package com.mrbook.model.dto;

public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 服务器错误
     */
    SERVER_ERROR(500),
    /**
     * 客户端请求错误
     */
    REQUEST_ERROR(400),
    /**
     * 未登录
     */
    UNAUTHORIZED(401),
    /**
     * 权限不足
     */
    FORBIDDEN(403);
    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
