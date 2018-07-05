package com.example.product.repository;

import com.example.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductInfo,String> {
    /**
     *  根据商品上架下架查询商品信息列表
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     *  查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
