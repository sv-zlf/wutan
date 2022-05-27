package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.Product;
import com.bf.wutan.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
@Api(tags = "产品信息")
public class ProductController {

    final ProductService productService;

    private GlobalResult result;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    @ApiOperation(value = "创建产品")
    public GlobalResult addProduct(@RequestBody Product product){

        if(productService.getProductByName(product.getName())!=null){
            result=GlobalResult.errorMsg("该产品已存在");
            return result;
        }

        try {
            if(productService.addProduct(product)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("产品创建失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("name/{name}")
    public GlobalResult deleteProductByName(@PathVariable String name){

        try {
            if(productService.deleteProductByName(name)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("产品删除失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "编辑产品")
    public GlobalResult updateProduct(@RequestBody Product product){

        try {
            if(productService.updateProduct(product)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("编辑产品失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value = "获取产品信息列表")
    public GlobalResult selectProduct(Integer pageIndex,Integer pageSize){

        Page<Product> page =new Page<>(pageIndex,pageSize);
        try {
            IPage<Product> data=productService.getProductList(page);
            if (data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()), data.getRecords());
            }
            else{
                result=GlobalResult.errorMsg("产品获取失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "获取产品信息",notes = "根据产品名称（name）")
    public GlobalResult getProductByName(@PathVariable String name){

        try {
            Product product=productService.getProductByName(name);
            if(product!=null){
                result=GlobalResult.ok(product);
            }
            else {
                result=GlobalResult.errorMsg("获取产品信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

//    @GetMapping("/length")
//    @ApiOperation(value = "获取所有产品的长度")
//    public GlobalResult getProductLength(){
//        try {
//            Integer length= productService.countProduct();
//            result=GlobalResult.build(200,"已获取所有产品的长度",length);
//        }
//        catch (Exception e){
//            result=GlobalResult.build(500,"获取所有产品的长度异常",e.getMessage());
//        }
//        return result;
//    }

    @GetMapping("/appTypeId/{appTypeId}")
    @ApiOperation(value = "根据应用场景类别获取产品")
    public GlobalResult getProductByAppType(Integer pageIndex,Integer pageSize,@PathVariable Integer appTypeId){

        Page<Product> page=new Page<>(pageIndex,pageSize);
        try {
            IPage<Product> data=productService.getProductByAppType(page,appTypeId);

            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else {
                result=GlobalResult.errorMsg("根据应用场景类别获取产品失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
    @GetMapping("/productTypeId/{productTypeId}")
    @ApiOperation(value = "根据产品类别获取产品")
    public GlobalResult getProductByProductType(Integer pageIndex,Integer pageSize,@PathVariable Integer productTypeId){

        Page<Product> page=new Page<>(pageIndex,pageSize);
        try {
            IPage<Product> data=productService.getProductByProductType(page,productTypeId);

            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else {
                result=GlobalResult.errorMsg("根据产品类别获取产品失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
}
