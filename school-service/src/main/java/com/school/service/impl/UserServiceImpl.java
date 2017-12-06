package com.school.service.impl;

import com.school.beans.pojo.User;
import com.school.dao.UserMapper;
import com.school.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 作者：noking
 * User 的摘要说明
 * 数据操作接口
 * 创建时间：2017/11/06
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;
    public UserMapper getUserMapper() {
        return userMapper;
    }
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public Integer insert(User model) throws Exception{
        return userMapper.insert(model);
    }
    public Integer deleteById(Integer id) throws Exception{
        return userMapper.deleteById(id);
    }
    public Integer update(User model) throws Exception{
        return userMapper.update(model);
    }
    public User getById(Integer id) throws Exception{
        return userMapper.getById(id);
    }
    public List<User> getAll() throws Exception{
        return userMapper.getAll();
    }
    public List<User> getListByMap(Map<String,Object> param) throws Exception{
        return userMapper.getListByMap(param);
    }
    public Integer getPaginationTotalByMap(Map<String,Object> param) throws Exception{
        return userMapper.getPaginationTotalByMap(param);
    }
    public List<User> getPaginationByMap(Map<String,Object> param) throws Exception{
        return userMapper.getPaginationByMap(param);
    }
}


