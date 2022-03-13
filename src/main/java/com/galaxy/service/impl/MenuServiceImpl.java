package com.galaxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.galaxy.mapper.MenuMapper;
import com.galaxy.model.Menu;
import com.galaxy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lane
 * @date 2022年03月05日 下午12:42
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    
    /**
     * @author lane
     * @date 2022/3/5 下午1:09
     * @return java.util.List<com.galaxy.model.Order>
     */
    @Override
    public List<Menu> selectList(){

        List<Menu> orders = menuMapper.selectList(null);

        return orders;

    }

    @Override
    public List<Menu> selectListByRid(Long rid) {
        //根据 entity 条件，查询全部记录 * * @param queryWrapper 实体对象封装操作类（可以为 null）
        QueryWrapper<Menu> queryWrapper = new QueryWrapper();
        queryWrapper.eq("rid", rid);//age 大于27
        List<Menu> listByRid = menuMapper.selectList(queryWrapper);

        return listByRid;
    }


    /**
     * @author lane
     * @date 2022/3/5 下午1:11
     * @param order
     */
    @Override
    public void insert(Menu order){

        int i = menuMapper.insert(order);
        System.out.println("插入行数为"+i);
        //MP会在插入之后为我们添加ID
        System.out.println("user id ："+order.getId());

    }

    @Override
    public  void updateById(Menu order){

        int i = menuMapper.updateById(order);
        System.out.println("更新行数为"+i);
        //MP会在插入之后为我们添加ID
        System.out.println("orderMapper id ："+order.getId());

    }

    @Override
    public void delete(Menu order){

        //deleteById
        int i = menuMapper.deleteById(order.getId());
        System.out.println("orderMapper id ："+order.getId());

    }

}
