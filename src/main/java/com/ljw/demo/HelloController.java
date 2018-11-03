package com.ljw.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

   @Autowired
   private GirlBo mGirlBo;

    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    public String Say(@PathVariable("id") Integer id) {
        return "id:" + id;
    }

//    @RequestMapping(value = "/say2", method = RequestMethod.GET)
    @GetMapping(value = "/say2")
    public String Say2(@RequestParam(value = "id",defaultValue = "100", required = true) Integer myId) {
        return "id:" + myId;
    }
}
