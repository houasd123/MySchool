package com.school.service.impl;
import com.school.beans.pojo.Product;
import com.school.dao.ProductMapper;
import com.school.service.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.lang.Integer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：noking
 * Product 的摘要说明
 * 数据操作接口
 * 创建时间：2017/11/06
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Resource
    private ProductMapper productMapper;
    public ProductMapper getProductMapper() {
        return productMapper;
    }
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public Integer insert(Product model) throws Exception{
        return productMapper.insert(model);
    }
    public Integer deleteById(Integer id) throws Exception{
        return productMapper.deleteById(id);
    }
    public Integer update(Product model) throws Exception{
        return productMapper.update(model);
    }
    public Product getById(Integer id) throws Exception{
        return productMapper.getById(id);
    }
    public List<Product> getAll() throws Exception{
        return productMapper.getAll();
    }
    public List<Product> getListByMap(Map<String,Object> param) throws Exception{
        return productMapper.getListByMap(param);
    }
    public Integer getPaginationTotalByMap(Map<String,Object> param) throws Exception{
        return productMapper.getPaginationTotalByMap(param);
    }
    public List<Product> getPaginationByMap(Map<String,Object> param) throws Exception{
        return productMapper.getPaginationByMap(param);
    }
}


