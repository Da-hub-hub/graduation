package com.Result;

import cn.hutool.json.JSONUtil;
/*
* 响应结果封装
* */
public class Result<T> {
    private int code; //状态码
    private String message;  //响应信息
    private T data; //返回数据

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
