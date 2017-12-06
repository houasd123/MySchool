package com.school.dao;
import com.school.beans.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
/**
 * 作者：noking
 * User 的摘要说明
 * 数据操作接口
 * 创建时间：2017/11/06
 */
public interface  UserMapper{
    Integer insert(User model) throws Exception;
    Integer deleteById(@Param(value = "userID") Integer id) throws Exception;
    Integer update(User model) throws Exception;
    User getById(@Param(value = "userID") Integer id) throws Exception;
    List<User> getAll() throws Exception;
    List<User> getListByMap(Map<String, Object> param) throws Exception;
    Integer getPaginationTotalByMap(Map<String, Object> param) throws Exception;
    List<User> getPaginationByMap(Map<String, Object> param) throws Exception;
}