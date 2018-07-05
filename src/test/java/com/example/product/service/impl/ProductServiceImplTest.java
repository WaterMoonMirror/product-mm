package com.example.product.service.impl;

import com.example.product.ProductApplicationTests;
import com.example.product.dataobject.ProductInfo;
import com.example.product.dtd.CartDTD;
import com.example.product.exception.ProductExcepton;
import com.example.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;
    @Test
    public void listForOrder() {
        List<ProductInfo> productInfos = productService.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfos.size()>0);
    }

    @Test
    public  void  decreaseStock() throws ProductExcepton {
        CartDTD cartDTD=new CartDTD("157875196366160022",3);
        productService.decreaseStock(Arrays.asList(cartDTD));
    }
}