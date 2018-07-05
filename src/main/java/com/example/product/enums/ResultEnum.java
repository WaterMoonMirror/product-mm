package com.example.product.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum  ResultEnum {

    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERRO(2,"库存有误")
        ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
