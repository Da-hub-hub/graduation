package com.Result;


public enum ResultCode {
    SUCCESS(200),//响应成功
    FAIL(404),//资源未找到
    BADREQUEST(400),//参数列表错误
    ERROR(500);//系统内部错误
    private final int code;
    ResultCode (int code){
        this.code=code;
    }
    public int code(){
        return code;
    }

}
