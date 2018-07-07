package com.example.product.productserver.service.impl;

import com.example.product.productserver.dataobject.ProductCategory;
import com.example.product.productserver.repository.ProductCategoryRepository;
import com.example.product.productserver.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:30
 * @Description:
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
