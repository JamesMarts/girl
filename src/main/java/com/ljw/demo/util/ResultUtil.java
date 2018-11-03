package com.ljw.demo.util;


import com.ljw.demo.entity.Result;

public class ResultUtil {

    public static Result success(Object o){

        Result result=new Result();
        result.setMsg("成功");
        result.setCode(200);
        result.setData(o);
        return  result;
    }

    public static Result success(){
        return  success(null);
    }


    public static Result error(int code,String msg){

        Result result=new Result();
        result.setMsg(msg);
        result.setCode(code);
        return  result;
    }
}
