package com.example.product.VO;

import lombok.Data;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 21:32
 * @Description:
 */
@Data
public class ResultVO<T> {

    /*状态码 0:成功  1:失败*/
    private Integer code;

    /*提示信息*/
    private String msg;

    /*具体内容*/
    private T data;
}
