package com.school.exception;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class BdqnException extends RuntimeException {

    private static final Map<String,String> message=new HashMap<String, String>();
    private String key;
    static {
        message.put("101","变量不能为空.");
    }

    public BdqnException(){
        super();
    }
    public BdqnException(String key){
        this.key=key;
    }
    @Override
    public String getMessage() {
        return JSON.toJSONString(key+":"+message.get(key));
    }
}
