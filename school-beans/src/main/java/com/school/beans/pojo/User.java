package com.school.beans.pojo;
import java.io.Serializable;
import java.util.Date;
/**
 * 作者：noking
 * User 的摘要说明
 * 
 * 创建时间：2017/11/06
 */
public class  User implements Serializable{
	/*  */
	private int userID;
	/*  */
	private String userType;
	/*  */
	private String userCode;
	/*  */
	private String userPwd;
	/*  */
	private String flatID;
	/*  */
	private String userNickName;
	/*  */
	private Date createTime;
	/*  */
	private Date lastLoginTime;
	/*  */
	private String isEnableFlag;
	/*  */
	private int isOnline;

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

    /**
     * User的默认构造
	 */
    public User()
    {
    }
    /**
     * User的带参构造
	 */
    public User(int userID,String userType,String userCode,String userPwd,String flatID,String userNickName,Date createTime,Date lastLoginTime,String isEnableFlag,int isOnline)
    {
        this.userID=userID;
        this.userType=userType;
        this.userCode=userCode;
        this.userPwd=userPwd;
        this.flatID=flatID;
        this.userNickName=userNickName;
        this.createTime=createTime;
        this.lastLoginTime=lastLoginTime;
        this.isEnableFlag=isEnableFlag;
        this.isOnline=isOnline;
    }

    /**
     * User的带参构造
	 */
    public User(String userType,String userCode,String userPwd,String flatID,String userNickName,Date createTime,Date lastLoginTime,String isEnableFlag,int isOnline)
    {
        this.userType=userType;
        this.userCode=userCode;
        this.userPwd=userPwd;
        this.flatID=flatID;
        this.userNickName=userNickName;
        this.createTime=createTime;
        this.lastLoginTime=lastLoginTime;
        this.isEnableFlag=isEnableFlag;
        this.isOnline=isOnline;
    }
}