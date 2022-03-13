package com.galaxy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lane
 * @date 2022年03月05日 下午12:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends Model<Menu> implements Comparable<Menu> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long rid;
    private String name;
    private String type;
    private double price;

    @Override
    public int compareTo(Menu o) {
        if (this.price >= o.getPrice()) {
            return 1;
        } else return -1;
    }
}