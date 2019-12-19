package com.diao.exception;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 9:32
 * @description:自定义异常类
 * @version: 1.0
 */
public class SysException extends Exception{
    private String message;//记录提示信息

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
