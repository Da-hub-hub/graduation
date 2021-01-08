package com.epidemic.controller;

import com.Result.Result;
import com.Result.ResultCode;
import com.epidemic.entity.China_daily;
import com.epidemic.service.ChinaDailyPredictedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("predicted")
public class ChinaDailyPredictedController {
    @Autowired
    private ChinaDailyPredictedService chinaDailyPredictedService;
    @PostMapping("/chinaDaily")
    public Result ChinaDailyPredicted(@RequestParam(name = "a1",required = true)double a1, @RequestParam(name = "Sn",required = true) int Sn,
                                      @RequestParam(name = "n",required = true) int n){
        chinaDailyPredictedService.chinaDailyPredicted(a1,Sn,n);
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("预测成功").setData(null);
    }
    //预测数据,哈哈
    @GetMapping("/chinaDailyPredicted")
    public Result ChinaDailyPredicted(){
        List<China_daily> china_dailies = chinaDailyPredictedService.allChinaDailyPredicted();
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("预测数据获取成功！").setData(china_dailies);
    }

}
