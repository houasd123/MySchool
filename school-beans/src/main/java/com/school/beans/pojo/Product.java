package com.school.beans.pojo;
import java.io.Serializable;
import java.util.Date;
/**
 * 作者：noking
 * Product 的摘要说明
 * 
 * 创建时间：2017/11/06
 */
public class Product implements Serializable{
	/* 产品ID */
	private int productID;
	/* 产品名称 */
	private String productName;

    /**
	 * 得到产品ID
	 * @return int
	 */
	public int getProductID(){
		return productID;
	}
	/**
	 * 设置产品ID
	 * @param productID
	 */
	public void setProductID(int productID){
		this.productID=productID;
	}
    /**
	 * 得到产品名称
	 * @return String
	 */
	public String getProductName(){
		return productName;
	}
	/**
	 * 设置产品名称
	 * @param productName
	 */
	public void setProductName(String productName){
		this.productName=productName;
	}

    /**
     * Product的默认构造
	 */
    public Product()
    {
    }
    /**
     * Product的带参构造
	 */
    public Product(int productID,String productName)
    {
        this.productID=productID;
        this.productName=productName;
    }

    /**
     * Product的带参构造
	 */
    public Product(String productName)
    {
        this.productName=productName;
    }
}