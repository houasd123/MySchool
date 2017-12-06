package com.school.beans.vo;
import com.school.common.Constants;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 作者：noking
 * User 的摘要说明
 * 前端输入-搜索条件
 * 创建时间：2017/11/06
 */
@ApiModel(value = "UserVO",description = "搜索")
public class  UserVO {
	@ApiModelProperty(required = false,notes = "")
	private int userID;
	@ApiModelProperty(required = false,notes = "")
	private String userType;
	@ApiModelProperty(required = false,notes = "")
	private String userCode;
	@ApiModelProperty(required = false,notes = "")
	private String userPwd;
	@ApiModelProperty(required = false,notes = "")
	private String flatID;
	@ApiModelProperty(required = false,notes = "")
	private String userNickName;
	@ApiModelProperty(required = false,notes = "")
	private Date createTime;
	@ApiModelProperty(required = false,notes = "")
	private Date lastLoginTime;
	@ApiModelProperty(required = false,notes = "")
	private String isEnableFlag;
	@ApiModelProperty(required = false,notes = "")
	private int isOnline;

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
	public int getUserID(){
		return userID;
	}
	/**
	 * 设置
	 * @param userID
	 */
	public void setUserID(int userID){
		this.userID=userID;
	}
    /**
	 * 得到
	 * @return String
	 */
	public String getUserType(){
		return userType;
	}
	/**
	 * 设置
	 * @param userType
	 */
	public void setUserType(String userType){
		this.userType=userType;
	}
    /**
	 * 得到
	 * @return String
	 */
	public String getUserCode(){
		return userCode;
	}
	/**
	 * 设置
	 * @param userCode
	 */
	public void setUserCode(String userCode){
		this.userCode=userCode;
	}
    /**
	 * 得到
	 * @return String
	 */
	public String getUserPwd(){
		return userPwd;
	}
	/**
	 * 设置
	 * @param userPwd
	 */
	public void setUserPwd(String userPwd){
		this.userPwd=userPwd;
	}
    /**
	 * 得到
	 * @return String
	 */
	public String getFlatID(){
		return flatID;
	}
	/**
	 * 设置
	 * @param flatID
	 */
	public void setFlatID(String flatID){
		this.flatID=flatID;
	}
    /**
	 * 得到
	 * @return String
	 */
	public String getUserNickName(){
		return userNickName;
	}
	/**
	 * 设置
	 * @param userNickName
	 */
	public void setUserNickName(String userNickName){
		this.userNickName=userNickName;
	}
    /**
	 * 得到
	 * @return Date
	 */
	public Date getCreateTime(){
		return createTime;
	}
	/**
	 * 设置
	 * @param createTime
	 */
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
    /**
	 * 得到
	 * @return Date
	 */
	public Date getLastLoginTime(){
		return lastLoginTime;
	}
	/**
	 * 设置
	 * @param lastLoginTime
	 */
	public void setLastLoginTime(Date lastLoginTime){
		this.lastLoginTime=lastLoginTime;
	}
    /**
	 * 得到
	 * @return String
	 */
	public String getIsEnableFlag(){
		return isEnableFlag;
	}
	/**
	 * 设置
	 * @param isEnableFlag
	 */
	public void setIsEnableFlag(String isEnableFlag){
		this.isEnableFlag=isEnableFlag;
	}
    /**
	 * 得到
	 * @return int
	 */
	public int getIsOnline(){
		return isOnline;
	}
	/**
	 * 设置
	 * @param isOnline
	 */
	public void setIsOnline(int isOnline){
		this.isOnline=isOnline;
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


