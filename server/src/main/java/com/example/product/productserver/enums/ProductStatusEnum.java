package com.example.product.productserver.enums;

import lombok.Getter;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:25
 * @Description:
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
