package com.example.product.productserver.service;

import com.example.product.productserver.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:30
 * @Description:
 */
public interface ProductCategoryService {
    /**
     * 查询类目列表
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
