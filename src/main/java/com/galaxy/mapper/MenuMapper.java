package com.galaxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.model.Menu;

/**
 * @author lane
 * @date 2022年03月05日 下午12:50
 */

public interface MenuMapper extends BaseMapper<Menu> {

    public Menu findById(Long id);

}
