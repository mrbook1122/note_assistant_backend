package com.mrbook.exception;

/**
 * 笔记标题和内容都为空异常
 */
public class NoteTitleAndContentNullException extends RuntimeException {
    public NoteTitleAndContentNullException() {
        super("笔记标题和内容都为空");
    }
}
