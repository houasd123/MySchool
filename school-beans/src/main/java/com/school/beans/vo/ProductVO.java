package com.school.beans.vo;
import com.school.common.Constants;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 作者：noking
 * Product 的摘要说明
 * 前端输入-搜索条件
 * 创建时间：2017/11/06
 */
@ApiModel(value = "ProductVO",description = "搜索")
public class  ProductVO {
	@ApiModelProperty(required = false,notes = "")
	private int productID;
	@ApiModelProperty(required = false,notes = "")
	private String productName;

    @ApiModelProperty(required = false,notes = "当前页码")
    private int pageIndex;

    @ApiModelProperty(required = false,notes = "页面大小")
    private int pageSize;

    @ApiModelProperty(hidden = true)
    private int start;

    /**
	 * 得到
	 * @return int
	 */
	public int getProductID(){
		return productID;
	}
	/**
	 * 设置
	 * @param productID
	 */
	public void setProductID(int productID){
		this.productID=productID;
	}
    /**
	 * 得到
	 * @return String
	 */
	public String getProductName(){
		return productName;
	}
	/**
	 * 设置
	 * @param productName
	 */
	public void setProductName(String productName){
		this.productName=productName;
	}
    public int getPageIndex() {
        if (pageIndex==0){
            pageIndex=1;
        }
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getStart() {
        start=(pageIndex-1)*pageSize;
        return start;
    }

    public int getPageSize() {
        if(pageSize==0){
            pageSize= Constants.DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}


