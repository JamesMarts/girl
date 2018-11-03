package com.ljw.demo.service;

import com.ljw.demo.GirlReponsitory;
import com.ljw.demo.entity.ApiError;
import com.ljw.demo.entity.Girl;
import com.ljw.demo.exception.CommonExecption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GirlService {

    @Autowired
    private GirlReponsitory mGirlReponsitory;


    public void getGirlById(Integer id) throws Exception {
        Girl girl = mGirlReponsitory.getOne(id);
        Integer age = girl.getAge();
        if (age < 20) {
            throw new CommonExecption(ApiError.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 40) {
            throw new CommonExecption(ApiError.HIGH_SCHOOL);
        }

    }


}
