package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.ProductType;
import com.bf.wutan.service.ProductTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

/**
 * <p>
 *  产品类型前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-04-27
 */
@RestController
@RequestMapping("/product-type")
@CrossOrigin
@Api(tags = "产品类型")
public class ProductTypeController {

    final ProductTypeService productTypeService;

    private GlobalResult result;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping("")
    @ApiOperation(value = "添加产品类型")
    public GlobalResult addProductType(@RequestBody ProductType productType){

        if(productTypeService.getProductTypeByName(productType.getTypename())!=null){
            result=GlobalResult.errorMsg("该产品类型已存在");
            return result;
        }

        try {
            if(productTypeService.addProductType(productType)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("添加产品类型失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "删除产品类型")
    public GlobalResult deleteProductTypeByName(@PathVariable String name){
        try {
            if(productTypeService.deleteProductTypeByName(name)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("删除产品类型失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "编辑产品类型")
    public GlobalResult updateProductType(@RequestBody ProductType productType){

        ProductType productType1=productTypeService.getProductTypeByName(productType.getTypename());
        ProductType productType2=productTypeService.getProductTypeById(productType.getId());
        if(productType1!=null&&!productType1.equals(productType2)){
            result=GlobalResult.errorMsg("该产品类型已存在");
            return result;
        }

        try {
            if(productTypeService.updateProductType(productType)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("编辑产品类型失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有产品类型")
    public GlobalResult getProductTypeAll(){
        try {
            List<ProductType> productTypes= productTypeService.getProductTypeAll();
            if(productTypes!=null){
                result=GlobalResult.ok(productTypes);
            }
            else {
                result= GlobalResult.errorMsg("获取所有产品类型失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value = "获取产品类型",notes = "依据页码和页数来获取产品类型")
    public GlobalResult getProductTypeList(Integer pageIndex,Integer pageSize){

        Page<ProductType> page=new Page<>(pageIndex,pageSize);
        try {
            IPage<ProductType> data=productTypeService.getProductTypeList(page);
            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else {
                result=GlobalResult.errorMsg("获取产品类型失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/id/{id}")
    @ApiOperation(value = "获取指定产品类型信息")
    public GlobalResult getProductTypeById(@PathVariable Integer id) {

        try {
            ProductType productType = productTypeService.getProductTypeById(id);
            if (productType != null) {
                result=GlobalResult.ok(productType);
            } else {
                result=GlobalResult.errorMsg("获取指定产品类型失败");
            }
        } catch (Exception e) {
           result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
}
