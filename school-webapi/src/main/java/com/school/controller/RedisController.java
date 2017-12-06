package com.school.controller;

import com.school.beans.dto.Dto;
import com.school.beans.pojo.Product;
import com.school.common.Constants;
import com.school.common.RedisAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/Redis",description = "Redis测试接口描述")
@RestController
@RequestMapping("/api/v1.0/Redis")
public class RedisController {

    @Autowired(required = false)
    private RedisAPI redisAPI;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="添加数据",httpMethod="GET",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="添加数据" )
    public Dto add(){
        Dto dto=new Dto();
        try {
            boolean b = redisAPI.set("aaa", "张三三");
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(b);
        } catch (Exception e) {
            dto.setData(null);
            dto.setStateCode("10000");
            dto.setMsg(Constants.ERROR10000);
            e.printStackTrace();
        }
        return dto;
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="获取数据",httpMethod="GET",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="获取数据" )
    public Dto get(){
        Dto dto=new Dto();
        try {
            String str = redisAPI.get("aaa");
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(str);
        } catch (Exception e) {
            dto.setData(null);
            dto.setStateCode("10000");
            dto.setMsg(Constants.ERROR10000);
            e.printStackTrace();
        }
        return dto;
    }
}
