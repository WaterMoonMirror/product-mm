package com.example.product.productserver.exception;

import com.example.product.enums.ResultEnum;

public class ProductExcepton extends Exception {
    private Integer code;

    public ProductExcepton(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductExcepton(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
