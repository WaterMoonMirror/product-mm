package com.example.product.productserver.Controller;

import com.example.product.productserver.config.GirlContig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tkn
 * @Date: 2018/7/8 18:35
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private GirlContig girlContig;

    @GetMapping("/girl/print")
    public String print(){
        return "name:"+girlContig.getName()+" ,age:"+girlContig.getAge();
    }
}
