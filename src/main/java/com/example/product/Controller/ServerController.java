package com.example.product.Controller;

import com.example.product.dataobject.ProductInfo;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServerController {

    @Autowired
    private ProductService productService;
    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg";
    }


}