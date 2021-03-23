package com.epidemic.controller;

import com.epidemic.entity.UserInfo;
import com.epidemic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
    /*
    * 无密码登录
    * */
    @GetMapping ("/login1")
    public String login1(){
        return "redirect:/epidemic.jsp";
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(UserInfo user, Model model, HttpSession session){
        //获取用户信息
        UserInfo u = userService.findByAccount(user);
        if(u==null){
            //账号为空
            /*model.addAttribute("msg","请输入用户名及密码！");*/
            return "/login.jsp";
        }
        if(u.getPassword().equals(user.getPassword())){
            //登录成功
            //将当前用户的信息保存到session中
            session.setAttribute("loginUser",u);
            return "redirect:/epidemic.jsp";
        }
        return "/login.jsp";


    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清理session
        session.invalidate();
        return "redirect:/login.jsp";
    }


}
