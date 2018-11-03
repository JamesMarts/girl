package com.ljw.demo.handle;

import com.ljw.demo.entity.Result;
import com.ljw.demo.exception.CommonExecption;
import com.ljw.demo.util.ResultUtil;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof CommonExecption){
            CommonExecption execption= (CommonExecption) e;
            return ResultUtil.error(((CommonExecption) e).getCode(),execption.getMessage());
        }else {
            return ResultUtil.error(500,e.getMessage());
        }

    }
}
