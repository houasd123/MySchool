package com.school.controller;

import com.school.beans.dto.Dto;
import com.school.beans.pojo.Product;
import com.school.beans.vo.ProductVO;
import com.school.common.Constants;
import com.school.exception.BdqnException;
import com.school.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 作者：noking
 * Product 的摘要说明
 * 数据操作接口
 */

/**
 *  GET /product：列出所有记录
 *  POST /product：新建一个记录
 *  GET /product/ID：获取某个指定的信息
 *  PUT /product/ID：更新某个指定的信息（提供该的全部信息）
 *  DELETE /product/ID：删除某个
 *  GET /product/search?param：查找符合条件的
 *  GET /product/page/{pageIndex}?param：列出符合查询条件的分页记录
 *  stateCode  "0"  msg "success"
 *  stateCode  "10000"  msg "获取数据失败"
 *  stateCode  "10001"  msg "新建数据失败"
 *  stateCode  "10002"  msg "根据ID获取数据失败"
 *  stateCode  "10003"  msg "根据查询条件查找记录的分页列表失败"
 *  stateCode  "10004"  msg "根据查询条件查找记录信息列表失败"
 *  stateCode  "10005"  msg "根据主键删除记录信息"
 *  stateCode  "10006"  msg "根据主键更新记录信息"
 */
@RestController
@EnableSwagger2
@Api(value="ProductController",description="表数据操作接口描述")
@RequestMapping("/api/v1.0/product")
public class ProductController{
    private Logger logger=Logger.getLogger(ProductController.class);
    @Resource
    private ProductService productService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="获取列表",httpMethod="GET",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="得到所有信息" )
    public Dto getAll(){
        Dto dto=new Dto();
        List<Product> list = null;
        try {
            list = productService.getAll();
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(list);
        } catch (Exception e) {
            dto.setData(null);
            dto.setStateCode("10000");
            dto.setMsg(Constants.ERROR10000);
            e.printStackTrace();
        }
        return dto;
    }
    @RequestMapping(value = "",produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="创建一个记录",httpMethod="POST",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="新建一个记录" +"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"productName\": \"string\"<br/>" +
    "}" )
    public Dto insert(@RequestBody ProductVO productVO){
        Dto dto=new Dto();
        Product product=new Product();
        //将VO对象属性转义到POJO对象属性中
        if (productVO.getProductName()!=null){
            product.setProductName(productVO.getProductName());
        }
        try {
            Integer r=productService.insert(product);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(r);
        } catch (Exception e) {
            dto.setStateCode("10001");
            dto.setMsg(Constants.ERROR10001);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="根据主键得到信息",httpMethod="GET",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据ID得到一个记录" )
    public Dto getById(@PathVariable("id")Integer id)  {
        Dto dto=new Dto();
        Product entity= null;
        try {
            entity = productService.getById(id);
            if (entity==null){
                throw new BdqnException("101");
            }
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(entity);
        } catch (Exception e) {
            dto.setStateCode("10002");
            dto.setMsg(Constants.ERROR10002);
            dto.setData(null);
            e.printStackTrace();
        }
        return  dto;
    }

    @RequestMapping(value = "/{productID}", produces = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value="根据主键更新信息",httpMethod="PUT",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据ID更新一个记录"+"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"productName\": \"string\"<br/>" +
    "}" )
    public Dto update(@ApiParam(required = true,name = "productID",value = "") @PathVariable("productID")Integer productID, @RequestBody ProductVO productVO){
        Dto dto=new Dto();
        Product product=new Product();
        //设定主键
        product.setProductID(productID);

        //将VO对象属性转义到POJO对象属性中
        if (productVO.getProductName()!=null){
            product.setProductName(productVO.getProductName());
        }
        try {
            Integer r=productService.update(product);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(r);
        } catch (Exception e) {
            dto.setStateCode("10006");
            dto.setMsg(Constants.ERROR10006);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }

    @RequestMapping(value = "/{productID}", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value="根据主键删除信息",httpMethod="DELETE",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据ID删除一个记录" )
    public Dto deleteById(@PathVariable("productID")Integer productID, HttpServletRequest request){
        Dto dto=new Dto();
        try {
            Integer r=productService.deleteById(productID);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(r);
        } catch (Exception e) {
            dto.setStateCode("10005");
            dto.setMsg(Constants.ERROR10005);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }
    @RequestMapping(value = "/search",produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="根据查询条件查找信息列表",httpMethod="POST",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据查询条件查找信息列表"+"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"productName\": \"string\"<br/>" +
    "}" )
    public Dto getListByMap(@RequestBody ProductVO productVO){
        Dto dto=new Dto();
        List<Product> lists=null;
//JSONObject jsonObject= (JSONObject) JSON.toJSON(productVO);
        //Map<String,Object> maps=new HashMap<String,Object>();
        //Iterator<String> keys =jsonObject.keySet().iterator();
        //while (keys.hasNext()){
        //    String k=keys.next();
        //    maps.put(k,jsonObject.get(k));
        //}
        Map<String,Object> maps=processVOtoMap(productVO);
        try {
            lists=productService.getListByMap(maps);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(lists);
        } catch (Exception e) {
            dto.setStateCode("10004");
            dto.setMsg(Constants.ERROR10004);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }
    @RequestMapping(value = "/page",produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="根据查询条件查找信息的分页列表",httpMethod="POST",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据查询条件查找信息的分页列表"+"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"productName\": \"string\",<br/>" +
    "  \"pageIndex\": 0,<br/>" +
    "  \"pageSize\": 0,<br/>" +
    "  \"start\": 0<br/>" +
    "}" )
    public Dto getPaginationByMap(@RequestBody ProductVO productVO){
        Dto dto=new Dto();
        List<Product> lists=null;
        //JSONObject jsonObject= (JSONObject) JSON.toJSON(productVO);
        //Map<String,Object> maps=new HashMap<String,Object>();
        //Iterator<String> keys =jsonObject.keySet().iterator();
        //while (keys.hasNext()){
        //    String k=keys.next();
        //    maps.put(k,jsonObject.get(k));
        //}
        Map<String,Object> maps=processVOtoMap(productVO);
        try {
            lists=productService.getPaginationByMap(maps);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(lists);
        } catch (Exception e) {
            dto.setStateCode("10003");
            dto.setMsg(Constants.ERROR10003);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }

    private Map<String,Object> processVOtoMap(ProductVO productVO){
            Map<String,Object> maps=new HashMap<String,Object>();
            if (productVO.getProductName()!=null && productVO.getProductName()!=""){
                maps.put("productName",productVO.getProductName());
            }

            if (productVO.getPageSize()!=0){
                maps.put("pageSize",productVO.getPageSize());
            }
            if (productVO.getPageIndex()!=0){
                maps.put("start",productVO.getStart());
            }
            return maps;
    }
}