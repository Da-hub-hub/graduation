package com.epidemic.controller;

import com.Result.Result;
import com.Result.ResultCode;
import com.epidemic.entity.Province;
import com.epidemic.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("province")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;
    @RequestMapping("/all")
    public Result findAll(){
        List<Province> provinces = provinceService.findAll();
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据请求成功").setData(provinces);

    }

}
