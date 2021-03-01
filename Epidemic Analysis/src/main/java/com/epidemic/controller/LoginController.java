package com.epidemic.controller;

import com.epidemic.entity.UserInfo;
import com.epidemic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user：封装前台请求的数据，表单name中的值跟user中的属性一致
     * @param model：将后台数据传递给前台
     * @param session：传统的session
     * @return
     */
    @RequestMapping("/login")
    public String login(UserInfo user, Model model, HttpSession session){
        //获取用户信息
        UserInfo u = userService.findByAccount(user);
        if(u==null){
            //账号为空
            model.addAttribute("msg","请输入用户名及密码！");
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
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清理session
        session.invalidate();
        return "redirect:/login.jsp";
    }


}
