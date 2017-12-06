package com.school.controller;

import com.school.beans.dto.Dto;
import com.school.beans.pojo.User;
import com.school.beans.vo.UserVO;
import com.school.common.Constants;
import com.school.exception.BdqnException;
import com.school.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 作者：noking
 * User 的摘要说明
 * 数据操作接口
 */

/**
 *  GET /user：列出所有记录
 *  POST /user：新建一个记录
 *  GET /user/ID：获取某个指定的信息
 *  PUT /user/ID：更新某个指定的信息（提供该的全部信息）
 *  DELETE /user/ID：删除某个
 *  GET /user/search?param：查找符合条件的
 *  GET /user/page/{pageIndex}?param：列出符合查询条件的分页记录
 *  stateCode  "0"  msg "success"
 *  stateCode  "10000"  msg "获取数据失败"
 *  stateCode  "10001"  msg "新建数据失败"
 *  stateCode  "10002"  msg "根据ID获取数据失败"
 *  stateCode  "10003"  msg "根据查询条件查找记录的分页列表失败"
 *  stateCode  "10004"  msg "根据查询条件查找记录信息列表失败"
 *  stateCode  "10005"  msg "根据主键删除记录信息"
 *  stateCode  "10006"  msg "根据主键更新记录信息"
 */
@RestController
@EnableSwagger2
@Api(value="UserController",description="表数据操作接口描述")
@RequestMapping("/api/v1.0/user")
public class UserController{
    private Logger logger=Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="获取列表",httpMethod="GET",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="得到所有信息" )
    public Dto getAll(){
        Dto dto=new Dto();
        List<User> list = null;
        try {
            list = userService.getAll();
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(list);
        } catch (Exception e) {
            dto.setData(null);
            dto.setStateCode("10000");
            dto.setMsg(Constants.ERROR10000);
            e.printStackTrace();
        }
        return dto;
    }
    @RequestMapping(value = "",produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="创建一个记录",httpMethod="POST",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="新建一个记录" +"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"userType\": \"string\",<br/>" +
    "  \"userCode\": \"string\",<br/>" +
    "  \"userPwd\": \"string\",<br/>" +
    "  \"flatID\": \"string\",<br/>" +
    "  \"userNickName\": \"string\",<br/>" +
    "  \"createTime\": 0,<br/>" +
    "  \"lastLoginTime\": 0,<br/>" +
    "  \"isEnableFlag\": \"string\",<br/>" +
    "  \"isOnline\": 0<br/>" +
    "}" )
    public Dto insert(@RequestBody UserVO userVO){
        Dto dto=new Dto();
        User user=new User();
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserType()!=null){
            user.setUserType(userVO.getUserType());
        }
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserCode()!=null){
            user.setUserCode(userVO.getUserCode());
        }
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserPwd()!=null){
            user.setUserPwd(userVO.getUserPwd());
        }
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getFlatID()!=null){
            user.setFlatID(userVO.getFlatID());
        }
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserNickName()!=null){
            user.setUserNickName(userVO.getUserNickName());
        }
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getCreateTime()!=null){
            user.setCreateTime(userVO.getCreateTime());
        }
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getLastLoginTime()!=null){
            user.setLastLoginTime(userVO.getLastLoginTime());
        }
        //将VO对象属性转义到POJO对象属性中
        if (userVO.getIsEnableFlag()!=null){
            user.setIsEnableFlag(userVO.getIsEnableFlag());
        }
        user.setIsOnline(userVO.getIsOnline());
        try {
            Integer r=userService.insert(user);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(r);
        } catch (Exception e) {
            dto.setStateCode("10001");
            dto.setMsg(Constants.ERROR10001);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="根据主键得到信息",httpMethod="GET",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据ID得到一个记录" )
    public Dto getById(@PathVariable("id")Integer id)  {
        Dto dto=new Dto();
        User entity= null;
        try {
            entity = userService.getById(id);
            if (entity==null){
                throw new BdqnException("101");
            }
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(entity);
        } catch (Exception e) {
            dto.setStateCode("10002");
            dto.setMsg(Constants.ERROR10002);
            dto.setData(null);
            e.printStackTrace();
        }
        return  dto;
    }

    @RequestMapping(value = "/{userID}", produces = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value="根据主键更新信息",httpMethod="PUT",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据ID更新一个记录"+"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"userType\": \"string\",<br/>" +
    "  \"userCode\": \"string\",<br/>" +
    "  \"userPwd\": \"string\",<br/>" +
    "  \"flatID\": \"string\",<br/>" +
    "  \"userNickName\": \"string\",<br/>" +
    "  \"createTime\": 0,<br/>" +
    "  \"lastLoginTime\": 0,<br/>" +
    "  \"isEnableFlag\": \"string\",<br/>" +
    "  \"isOnline\": 0<br/>" +
    "}" )
    public Dto update(@ApiParam(required = true,name = "userID",value = "") @PathVariable("userID")Integer userID, @RequestBody UserVO userVO){
        Dto dto=new Dto();
        User user=new User();
        //设定主键
        user.setUserID(userID);

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserType()!=null){
            user.setUserType(userVO.getUserType());
        }

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserCode()!=null){
            user.setUserCode(userVO.getUserCode());
        }

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserPwd()!=null){
            user.setUserPwd(userVO.getUserPwd());
        }

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getFlatID()!=null){
            user.setFlatID(userVO.getFlatID());
        }

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getUserNickName()!=null){
            user.setUserNickName(userVO.getUserNickName());
        }

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getCreateTime()!=null){
            user.setCreateTime(userVO.getCreateTime());
        }

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getLastLoginTime()!=null){
            user.setLastLoginTime(userVO.getLastLoginTime());
        }

        //将VO对象属性转义到POJO对象属性中
        if (userVO.getIsEnableFlag()!=null){
            user.setIsEnableFlag(userVO.getIsEnableFlag());
        }

        user.setIsOnline(userVO.getIsOnline());
        try {
            Integer r=userService.update(user);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(r);
        } catch (Exception e) {
            dto.setStateCode("10006");
            dto.setMsg(Constants.ERROR10006);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value="根据主键删除信息",httpMethod="DELETE",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据ID删除一个记录" )
    public Dto deleteById(@PathVariable("userID")Integer userID, HttpServletRequest request){
        Dto dto=new Dto();
        try {
            Integer r=userService.deleteById(userID);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(r);
        } catch (Exception e) {
            dto.setStateCode("10005");
            dto.setMsg(Constants.ERROR10005);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }
    @RequestMapping(value = "/search",produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="根据查询条件查找信息列表",httpMethod="POST",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据查询条件查找信息列表"+"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"userType\": \"string\",<br/>" +
    "  \"userCode\": \"string\",<br/>" +
    "  \"userPwd\": \"string\",<br/>" +
    "  \"flatID\": \"string\",<br/>" +
    "  \"userNickName\": \"string\",<br/>" +
    "  \"createTime\": 0,<br/>" +
    "  \"lastLoginTime\": 0,<br/>" +
    "  \"isEnableFlag\": \"string\",<br/>" +
    "  \"isOnline\": 0<br/>" +
    "}" )
    public Dto getListByMap(@RequestBody UserVO userVO){
        Dto dto=new Dto();
        List<User> lists=null;
//JSONObject jsonObject= (JSONObject) JSON.toJSON(userVO);
        //Map<String,Object> maps=new HashMap<String,Object>();
        //Iterator<String> keys =jsonObject.keySet().iterator();
        //while (keys.hasNext()){
        //    String k=keys.next();
        //    maps.put(k,jsonObject.get(k));
        //}
        Map<String,Object> maps=processVOtoMap(userVO);
        try {
            lists=userService.getListByMap(maps);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(lists);
        } catch (Exception e) {
            dto.setStateCode("10004");
            dto.setMsg(Constants.ERROR10004);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }
    @RequestMapping(value = "/page",produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="根据查询条件查找信息的分页列表",httpMethod="POST",protocols = "HTTP",response = Dto.class,produces ="application/json",notes="根据查询条件查找信息的分页列表"+"<br/>" +
    "eg:<br/>" +
    "{<br/>" +
    "  \"userType\": \"string\",<br/>" +
    "  \"userCode\": \"string\",<br/>" +
    "  \"userPwd\": \"string\",<br/>" +
    "  \"flatID\": \"string\",<br/>" +
    "  \"userNickName\": \"string\",<br/>" +
    "  \"createTime\": 0,<br/>" +
    "  \"lastLoginTime\": 0,<br/>" +
    "  \"isEnableFlag\": \"string\",<br/>" +
    "  \"isOnline\": 0,<br/>" +
    "  \"pageIndex\": 0,<br/>" +
    "  \"pageSize\": 0,<br/>" +
    "  \"start\": 0<br/>" +
    "}" )
    public Dto getPaginationByMap(@RequestBody UserVO userVO){
        Dto dto=new Dto();
        List<User> lists=null;
        //JSONObject jsonObject= (JSONObject) JSON.toJSON(userVO);
        //Map<String,Object> maps=new HashMap<String,Object>();
        //Iterator<String> keys =jsonObject.keySet().iterator();
        //while (keys.hasNext()){
        //    String k=keys.next();
        //    maps.put(k,jsonObject.get(k));
        //}
        Map<String,Object> maps=processVOtoMap(userVO);
        try {
            lists=userService.getPaginationByMap(maps);
            dto.setStateCode("0");
            dto.setMsg(Constants.ERROR0);
            dto.setData(lists);
        } catch (Exception e) {
            dto.setStateCode("10003");
            dto.setMsg(Constants.ERROR10003);
            dto.setData(null);
            e.printStackTrace();
        }
        return dto;
    }

    private Map<String,Object> processVOtoMap(UserVO userVO){
            Map<String,Object> maps=new HashMap<String,Object>();
            if (userVO.getUserType()!=null && userVO.getUserType()!=""){
                maps.put("userType",userVO.getUserType());
            }
            if (userVO.getUserCode()!=null && userVO.getUserCode()!=""){
                maps.put("userCode",userVO.getUserCode());
            }
            if (userVO.getUserPwd()!=null && userVO.getUserPwd()!=""){
                maps.put("userPwd",userVO.getUserPwd());
            }
            if (userVO.getFlatID()!=null && userVO.getFlatID()!=""){
                maps.put("flatID",userVO.getFlatID());
            }
            if (userVO.getUserNickName()!=null && userVO.getUserNickName()!=""){
                maps.put("userNickName",userVO.getUserNickName());
            }
            if (userVO.getCreateTime()!=null ){
                maps.put("createTime",userVO.getCreateTime());
            }
            if (userVO.getLastLoginTime()!=null ){
                maps.put("lastLoginTime",userVO.getLastLoginTime());
            }
            if (userVO.getIsEnableFlag()!=null && userVO.getIsEnableFlag()!=""){
                maps.put("isEnableFlag",userVO.getIsEnableFlag());
            }
            if (userVO.getIsOnline()!=0){
                maps.put("isOnline",userVO.getIsOnline());
            }

            if (userVO.getPageSize()!=0){
                maps.put("pageSize",userVO.getPageSize());
            }
            if (userVO.getPageIndex()!=0){
                maps.put("start",userVO.getStart());
            }
            return maps;
    }
}