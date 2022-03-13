package com.galaxy.service;

import com.galaxy.model.Menu;

import java.util.List;

/**
 * @author lane
 * @date 2022年03月05日 下午1:00
 */
public interface MenuService {


    /**
     * @author lane
     * @date 2022/3/5 下午1:09
     * @return java.util.List<com.galaxy.model.Order>
     */
    public List<Menu> selectList();
    public List<Menu> selectListByRid(Long rid);

    /**
     * @author lane
     * @date 2022/3/5 下午1:11
     * @param order
     */
    public void insert(Menu order);

    public void updateById(Menu order);

    public void delete(Menu order);

}
