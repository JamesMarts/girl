package com.ljw.demo.entity;

public enum  ApiError {

    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"上小学"),
    HIGH_SCHOOL(101,"上初中");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ApiError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
