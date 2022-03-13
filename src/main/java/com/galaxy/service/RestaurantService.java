package com.galaxy.service;

import com.galaxy.model.Restaurant;

import java.util.List;

/**
 * @author lane
 * @date 2022年03月05日 下午1:00
 */
public interface RestaurantService {
    /**
     * @author lane
     * @date 2022/3/5 下午1:09
     * @return java.util.List<com.galaxy.model.restaurant>
     */
    public List<Restaurant> selectList();

    /**
     * @author lane
     * @date 2022/3/5 下午1:11
     * @param restaurant
     */
    public void insert(Restaurant restaurant);

    public void updateById(Restaurant restaurant);

    void updateTodayMenu(Restaurant restaurant);

    public void delete(Restaurant restaurant);
}
