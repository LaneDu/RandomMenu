package com.galaxy.service.impl;

import com.galaxy.mapper.RestaurantMapper;
import com.galaxy.model.Restaurant;
import com.galaxy.model.Restaurant;
import com.galaxy.service.RestaurantService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lane
 * @date 2022年03月05日 下午1:01
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantMapper restaurantMapper;


    /**
     * @author lane
     * @date 2022/3/5 下午1:09
     * @return java.util.List<com.galaxy.model.Restaurant>
     */
    @Override
    public List<Restaurant> selectList(){

        List<Restaurant> Restaurants = restaurantMapper.selectList(null);

        return Restaurants;

    }


    /**
     * @author lane
     * @date 2022/3/5 下午1:11
     * @param Restaurant
     */
    @Override
    public void insert(Restaurant Restaurant){

        int i = restaurantMapper.insert(Restaurant);
        System.out.println("插入行数为"+i);
        //MP会在插入之后为我们添加ID
        System.out.println("user id ："+Restaurant.getId());

    }

    @Override
    public  void updateById(Restaurant Restaurant){

        int i = restaurantMapper.updateById(Restaurant);
        System.out.println("更新行数为"+i);
        //MP会在插入之后为我们添加ID
        System.out.println("restaurantMapper id ："+Restaurant.getId());

    }

    @Override
    public void updateTodayMenu(Restaurant restaurant) {
        restaurantMapper.updateTodayMenu(restaurant);
    }

    @Override
    public void delete(Restaurant Restaurant){

        //deleteById
        int i = restaurantMapper.deleteById(Restaurant.getId());
        System.out.println("restaurantMapper id ："+Restaurant.getId());

    }
}
