package com.example.product.productserver.Controller;

import com.example.product.productserver.VO.ProductInfoVO;
import com.example.product.productserver.VO.ProductVO;
import com.example.product.productserver.VO.ResultVO;
import com.example.product.productserver.dataobject.ProductCategory;
import com.example.product.productserver.dataobject.ProductInfo;
import com.example.product.productserver.dtd.CartDTD;
import com.example.product.productserver.exception.ProductExcepton;
import com.example.product.productserver.service.ProductCategoryService;
import com.example.product.productserver.service.ProductService;
import com.example.product.productserver.utils.ResultVOUtil;
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
