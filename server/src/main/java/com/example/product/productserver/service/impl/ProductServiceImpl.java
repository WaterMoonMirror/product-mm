package com.example.product.productserver.service.impl;

import com.example.product.productserver.dataobject.ProductInfo;
import com.example.product.productserver.dtd.CartDTD;
import com.example.product.productserver.enums.ProductStatusEnum;
import com.example.product.productserver.enums.ResultEnum;
import com.example.product.productserver.exception.ProductExcepton;
import com.example.product.productserver.repository.ProductRepository;
import com.example.product.productserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:27
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> listForOrder(List<String> productIdList) {
        return productRepository.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<CartDTD> cartDTDList) throws ProductExcepton {
        for (CartDTD cartDTD : cartDTDList) {
            Optional<ProductInfo> productInfoOptional = productRepository.findById(cartDTD.getProductId());
            // 是否为空
            if (!productInfoOptional.isPresent()) {
                throw new ProductExcepton(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            Integer ProductStock = productInfo.getProductStock() - cartDTD.getProductQuantity();
            if (ProductStock < 0) {
                throw new ProductExcepton(ResultEnum.PRODUCT_STOCK_ERRO);
            }
            productInfo.setProductStock(ProductStock);
            productRepository.save(productInfo);
        }
    }
}
