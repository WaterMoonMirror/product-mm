package com.example.product.productserver.Controller;

import com.example.product.productserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @Autowired
    private ProductService productService;
    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg";
    }


}