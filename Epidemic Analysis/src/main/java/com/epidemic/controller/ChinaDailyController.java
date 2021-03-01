package com.epidemic.controller;
import com.Result.Result;
import com.Result.ResultCode;
import com.epidemic.data.DataBreakUp;
import com.epidemic.entity.China_daily;
import com.epidemic.service.ChinaDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.ServerEndpoint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequestMapping("chinaDaily")
@RestController
public class ChinaDailyController {
    @Autowired
    private ChinaDailyService chinaDailyService;
    //获取中国前日疫情数据
    @RequestMapping("/before")
    public Result findYesterday(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-2);
        Date d = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(d);
        Date date=null;
        try {
            date = simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        China_daily byDate = chinaDailyService.findByDate(date);
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据请求成功！").setData(byDate);
    }
    //获取中国昨日疫情数据
    @RequestMapping("/yesterday")
    public Result findToday(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(d);
        Date date=null;
        try {
            date = simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        China_daily byDate = chinaDailyService.findByDate(date);
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据请求成功！").setData(byDate);
    }

    //获取全部中国每日数据
    @GetMapping("/all")
    public Result findAll(){
        List<China_daily> all = chinaDailyService.findAll();
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据请求成功！").setData(all);
    }
    //根据日期获取中国疫情数据
    @GetMapping("/byDate")
    public  Result findByDate(@RequestParam(value = "date",required = true) String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        China_daily byDate = chinaDailyService.findByDate(date1);
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据请求成功！").setData(byDate);
    }
    //根据日期获取指定时间段内的中国疫情数据
    @GetMapping("/inDate")
    public Result findInDate(@RequestParam(value = "start",required = true) String start,
                             @RequestParam(value = "end",required = true) String end){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start1=null;
        Date end1=null;
        try {
            start1=dateFormat.parse(start);
            end1=dateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<China_daily> inDate = chinaDailyService.findInDate(start1, end1);
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据获取成功！").setData(inDate);
    }

    @GetMapping("/limit/{n}")
    public Result findLimit(@PathVariable int n){
        List<China_daily> limit = chinaDailyService.findLimit(n);
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据获取成功！").setData(limit);
    }
    @GetMapping("/test/{n}")
    public Result findTest(@PathVariable int n){
        int[] totalConfirm = DataBreakUp.getTodayConfirm(n);
        return new Result().setCode(ResultCode.SUCCESS.code()).setMessage("数据获取成功！").setData(totalConfirm);
    }
}
