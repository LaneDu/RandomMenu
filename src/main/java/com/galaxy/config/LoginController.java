package com.galaxy.config;


import com.galaxy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lane
 * @date 2021年05月15日 下午3:15
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MenuService orderService;


    //只是作为跳转登陆方法
    @RequestMapping("/hello")
    public String hello() {

        System.out.println("=================>跳转到登陆页面");


        return "hello.html";
    }




    //只是作为跳转登陆方法
    @RequestMapping("/toLogin")
    public String toLogin() {

        System.out.println("=================>跳转到登陆页面");


        return "login";
    }

    //判断用户是否正确，是则登陆成功，否则跳转登陆页面
    @RequestMapping("/judge")
    public String JudgeUser(String username, String password, HttpSession session){

        if ("admin".equals(username)&&"admin".equals(password)){
            System.out.println("登陆成功，跳转主页");
            //用户信息放入session当中
            session.setAttribute("username",username+System.currentTimeMillis());
            return "redirect:/home/result";

        }else{
            System.out.println("登陆失败，跳转登陆页");
            return "redirect:toLogin";
        }

    }


}
