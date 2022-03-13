package com.galaxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.model.Restaurant;

/**
 * @author lane
 * @date 2022年03月05日 下午12:49
 */
public interface RestaurantMapper extends BaseMapper<Restaurant> {

    public Restaurant findById(Long id);

    void updateTodayMenu(Restaurant restaurant);
}
