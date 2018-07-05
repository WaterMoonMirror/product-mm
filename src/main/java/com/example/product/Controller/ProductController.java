package com.example.product.Controller;

import com.example.product.VO.ProductInfoVO;
import com.example.product.VO.ProductVO;
import com.example.product.VO.ResultVO;
import com.example.product.dataobject.ProductCategory;
import com.example.product.dataobject.ProductInfo;
import com.example.product.dtd.CartDTD;
import com.example.product.exception.ProductExcepton;
import com.example.product.service.ProductCategoryService;
import com.example.product.service.ProductService;
import com.example.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    /**
     * 1. 查询商品详情列表（上架数据）
     * 2. 获取类目type列表（商品详情列表获取）
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
//         * 1. 查询商品详情列表（上架数据）
        List<ProductInfo> upAll = productService.findUpAll();

//         * 2. 获取类目type列表（商品详情列表获取）
        List<Integer> categoryTypeList = upAll.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
//         * 3. 查询类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
//         * 4. 构造数据
        List<ProductVO> productVOList =new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO =new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            for (ProductInfo productInfo:upAll){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryId())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoList(productInfoVOList);
            productVOList.add(productVO);



        }


        return ResultVOUtil.success(productVOList);

    }

    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.listForOrder(productIdList);

    }

    @PostMapping("/decreaseStock")
    public String decreaseStock(@RequestBody List<CartDTD> cartDTDList){
        try {
            productService.decreaseStock(cartDTDList);
            return "ok";
        } catch (ProductExcepton productExcepton) {
            productExcepton.printStackTrace();
            return  productExcepton.getMessage();
        }
    }
}
