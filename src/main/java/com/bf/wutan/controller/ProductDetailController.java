package com.bf.wutan.controller;


import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.ProductDetail;
import com.bf.wutan.service.ProductDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  应用详情前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/product-detail")
@CrossOrigin
@Api(tags = "产品详情")
public class ProductDetailController {

    final ProductDetailService productDetailService;

    private GlobalResult result;

    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @PostMapping("")
    @ApiOperation(value = "添加产品详细内容")
    public GlobalResult addProductDetail(@RequestBody ProductDetail productDetail){

        try {
            if(productDetailService.addProductDetail(productDetail)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("添加产品详情失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "删除产品详细信息")
    public GlobalResult deleteProductDetailByName(@PathVariable String name){

        try {
            if(productDetailService.deleteProductDetailByName(name)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("删除产品详细信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "修改产品详细信息")
    public GlobalResult updateProductDetail(@RequestBody ProductDetail productDetail){

        try {
            if(productDetailService.updateProductDetail(productDetail)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("修改产品详细信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/name/{name}")
    @ApiOperation("获取产品详细信息")
    public GlobalResult getProductDetailByName(@PathVariable String name){

        try {
            ProductDetail productDetail= productDetailService.getProductDetailByName(name);
            if(productDetail!=null){
                result=GlobalResult.ok(productDetail);
            }
            else {
                result=GlobalResult.errorMsg("获取产品详细信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
}

