package com.school.beans.dto;

public class Dto<T> {
    private String stateCode; // 该状态码为自定义,一般0表示无错误
    private String msg; // 对应的提示信息
    private T data; // 具体的返回数据内容

    @Override
    public String toString() {
        return "Dto{" +
                "stateCode='" + stateCode + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Dto() {
    }

    public Dto(String stateCode, String msg, T data) {

        this.stateCode = stateCode;
        this.msg = msg;
        this.data = data;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
