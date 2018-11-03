package com.ljw.demo.exception;

import com.ljw.demo.entity.ApiError;

public class CommonExecption extends RuntimeException{

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CommonExecption(ApiError apiError) {
        super(apiError.getMessage());
        this.code = apiError.getCode();
    }
}
