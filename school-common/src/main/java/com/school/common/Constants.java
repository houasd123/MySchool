package com.school.common;

/***
 * 常量类 放置一些常量
 */
public class Constants {

    //默认起始页
    public static final Integer DEFAULT_PAGE_NO = 1;
    //默认页大小
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     *  stateCode  "0"  msg "success"
     *  stateCode  "10000"  msg "获取数据失败"
     *  stateCode  "10001"  msg "新建数据失败"
     *  stateCode  "10002"  msg "根据ID获取数据失败"
     *  stateCode  "10003"  msg "根据查询条件查找记录的分页列表失败"
     *  stateCode  "10004"  msg "根据查询条件查找记录信息列表失败"
     *  stateCode  "10005"  msg "根据主键删除记录信息"
     *  stateCode  "10006"  msg "根据主键更新记录信息"
     */
    public static final String ERROR0="success";
    public static final String ERROR10000="获取数据失败";
    public static final String ERROR10001="新建数据失败";
    public static final String ERROR10002="根据ID获取数据失败";
    public static final String ERROR10003="根据查询条件查找记录的分页列表失败";
    public static final String ERROR10004="根据查询条件查找记录信息列表失败";
    public static final String ERROR10005="根据主键删除记录信息";
    public static final String ERROR10006="根据主键更新记录信息";




}
