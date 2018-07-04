package com.example.product.repository;

import com.example.product.ProductApplicationTests;
import com.example.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Test
    public void findByProductStatus() {
        List<ProductInfo> byProductStatus = productRepository.findByProductStatus(1);
        Assert.assertTrue(byProductStatus.size()>0);
//        productRepository.findAll();
    }
}