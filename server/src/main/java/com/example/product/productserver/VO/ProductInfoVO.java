package com.example.product.productserver.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:40
 * @Description:
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;
    //商品名称
    @JsonProperty("name")
    private String productName;
    //单价
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    // 描述
    private String productDescription;
    // 小图
    @JsonProperty("icon")
    private String productIcon;

}
