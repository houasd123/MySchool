package com.school.dao;
import com.school.beans.pojo.Product;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
/**
 * 作者：noking
 * Product 的摘要说明
 * 数据操作接口
 * 创建时间：2017/11/06
 */
public interface  ProductMapper{
    Integer insert(Product model) throws Exception;
    Integer deleteById(@Param(value = "productID") Integer id) throws Exception;
    Integer update(Product model) throws Exception;
    Product getById(@Param(value = "productID") Integer id) throws Exception;
    List<Product> getAll() throws Exception;
    List<Product> getListByMap(Map<String, Object> param) throws Exception;
    Integer getPaginationTotalByMap(Map<String, Object> param) throws Exception;
    List<Product> getPaginationByMap(Map<String, Object> param) throws Exception;
}