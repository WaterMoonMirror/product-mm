package com.example.product.service;

import com.example.product.dataobject.ProductInfo;
import com.example.product.dtd.CartDTD;
import com.example.product.exception.ProductExcepton;

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

    /**
     *  查询商品列表（订单微服务使用）
     * @param listForOrder
     * @return
     */
    List<ProductInfo> listForOrder(List<String> productIdList);

    /**
     * 扣除库存
     * @param cartDTDList
     */
    void decreaseStock(List<CartDTD> cartDTDList) throws ProductExcepton;

    
}
