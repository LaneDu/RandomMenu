package com.galaxy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Restaurant {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String distance;
    private String menu;
    private Double totalPrice;
    private Double averagePrice;
    private Long personNum;



}
