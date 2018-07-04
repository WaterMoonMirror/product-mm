package com.example.product.service;

import com.example.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:18
 * @Description:
 */
public interface ProductService {
    /**
     *
     * 功能描述:  查询所以在架商品列表
     *
     * @param:
     * @return:
     * @auther: tkn
     * @date: 2018/7/4 21:22
     */
    List<ProductInfo> findUpAll();
    
}
