package com.example.product.productserver.Controller;

import com.example.product.productserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServerController {

    @Value("${env}")
    private String env;

    @Autowired
    private ProductService productService;

    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg";
    }

    @GetMapping("/getEnv")
    public String getEnv(){
        return env;
    }


}