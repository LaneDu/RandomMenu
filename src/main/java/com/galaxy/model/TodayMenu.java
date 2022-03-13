package com.galaxy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lane
 * @date 2022年03月06日 上午12:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodayMenu {
    private Long id;
    private Integer meatNum;
    private Integer vegetableNum;
    private Integer eggNum;
    private Integer soupNum;
    private Integer maxPrice;
    private Integer personNum;
}
