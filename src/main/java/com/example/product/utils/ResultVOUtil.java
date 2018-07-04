package com.example.product.utils;

import com.example.product.VO.ResultVO;

/**
 * @Auther: tkn
 * @Date: 2018/7/4 22:10
 * @Description:
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){

        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
