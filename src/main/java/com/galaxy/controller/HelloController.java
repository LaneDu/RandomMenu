package com.galaxy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.galaxy.model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lane
 * @date 2022年03月05日 下午7:18
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    private static final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //只是作为跳转登陆方法
    //http://localhost:8070/html/hello.html
    @RequestMapping(value ="/world",method = RequestMethod.GET)
    public String hello() {

        System.out.println("=================>跳转到登陆页面");

        return "/html/hello.html";
    }
    /**
     * 跳转到首页
     * @author lane
     * @date 2022/3/5 下午8:25
     * @return java.lang.String
     */
    @RequestMapping(value ="/index",method = RequestMethod.GET)
    public String index() {

        System.out.println("=================>跳转到登陆页面:"+simpleDateFormat.format(new Date()));

        return "/html/index.html";
    }

    //只是作为跳转登陆方法
    //http://localhost:8070/html/hello.html
    @RequestMapping(value ="/indexMenue",method = RequestMethod.GET)
    public String menueList(Long rid) {
        ModelAndView moduleAndView = new ModelAndView();
        System.out.println(rid);
        JSONObject jsonObjectData = new JSONObject();
        moduleAndView.addObject("status",0);
        moduleAndView.addObject("msg","success");
        moduleAndView.addObject("items", "items");
        moduleAndView.addObject("total","0");
        jsonObjectData.put("rid", rid);
        moduleAndView.addObject("data",jsonObjectData);


        System.out.println("=================>跳转到登陆页面");

        return "/html/indexMenue.html";
    }

    @RequestMapping(value = "/indexRestaurant",method = RequestMethod.GET)
    public String restaurantList() {

        System.out.println("=================>跳转到登陆页面");

        return "/html/index.html";
    }


}
