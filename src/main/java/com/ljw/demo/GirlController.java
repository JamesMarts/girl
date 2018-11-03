package com.ljw.demo;

import com.ljw.demo.entity.Girl;
import com.ljw.demo.entity.Result;
import com.ljw.demo.service.GirlService;
import com.ljw.demo.util.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
public class GirlController {

    @Autowired
    GirlReponsitory mGirlReponsitory;

    @Autowired
    GirlService mGirlService;


    @GetMapping(value = "/girls")
    private List<Girl> getAllGirls() {
        return mGirlReponsitory.findAll();
    }

    @PostMapping(value = "/girls")
    private Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return ResultUtil.error(301,bindingResult.getFieldError().getDefaultMessage());
        }

        return  ResultUtil.success(mGirlReponsitory.save(new Girl(girl.getCupSize(), girl.getAge())));
    }

    //    @Transactional   事务注解
    @GetMapping(value = "/girls/{id}")
    private Girl getGirlById(@PathVariable("id") Integer id) {
        return mGirlReponsitory.findById(id).get();
    }

    @PutMapping(value = "/girls/{id}")
    private String putGirlById(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return mGirlReponsitory.save(girl) != null ? "修改成功！" : "修改失败！";
    }


    @DeleteMapping(value = "/girls/{id}")
    private void deleteGirlById(@PathVariable("id") Integer id) {
        mGirlReponsitory.deleteById(id);
    }

    @GetMapping(value = "/girls/getById/{id}")
    public void getAgeById(@PathVariable("id") Integer id) throws Exception {

        mGirlService.getGirlById(id);
    }
}
