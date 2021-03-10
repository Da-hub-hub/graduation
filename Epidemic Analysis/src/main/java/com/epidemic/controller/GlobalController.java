package com.epidemic.controller;
import com.Result.Result;
import com.Result.ResultCode;
import com.epidemic.entity.Global;
import com.epidemic.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("global")
public class GlobalController {
    @Autowired
    GlobalService globalService;
    @GetMapping("/all")
    public Result findAll(){
        List<Global> all = globalService.findAll();
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("全球数据获取成功").setData(all);
    }
}
