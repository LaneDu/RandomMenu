package com.galaxy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.galaxy.model.Menu;
import com.galaxy.model.Restaurant;
import com.galaxy.model.TodayMenu;
import com.galaxy.service.MenuService;
import com.galaxy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lane
 * @date 2022年03月05日 下午12:41
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RestaurantService restaurantService;

    /**
     * /menu/selectList
     * @author lane
     * @date 2022/3/5 下午3:37
     * @return java.lang.String
     */
    @RequestMapping(value = "/selectList",method = {RequestMethod.GET})
    @ResponseBody
    public String selectList(Long rid){

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectData = new JSONObject();
        jsonObject.put("status",0);
        jsonObject.put("msg","success");
        List<Menu> menus = menuService.selectListByRid(rid);
        if (rid == 0){
            menus = menuService.selectList();
        }
        JSONArray items= JSONArray.parseArray(JSON.toJSONString(menus));
        jsonObjectData.put("items", items);
        jsonObjectData.put("total",menus.size());
        jsonObject.put("data",jsonObjectData);
        String string = JSON.toJSONString(jsonObject);
        return string;

    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody //指定返回值不经过视图解析而是放入response中
    public Menu insert (@RequestBody Menu menu){

        menuService.insert(menu);
        return menu ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody //指定返回值不经过视图解析而是放入response中
    public Menu update (@RequestBody Menu menu){

        menuService.updateById(menu);
        return menu ;
    }



    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody //指定返回值不经过视图解析而是放入response中
    public Menu delete (@RequestBody Menu menu){

        menuService.delete(menu);
        return menu ;
    }


}
