package com.example.product.repository;

import com.example.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:11
 * @Description:
 */
@Component
public class ProductCategoryRepositoryTest extends ProductRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(categoryTypeIn.size()>0);
    }
}