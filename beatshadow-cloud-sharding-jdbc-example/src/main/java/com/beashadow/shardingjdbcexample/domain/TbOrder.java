package com.beashadow.shardingjdbcexample.domain;

import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/13 15:40
 */
@Data
public class TbOrder {
    /**
    * 订单id
    */
    private Long orderId;

    /**
    * 订单价格
    */
    private BigDecimal price;

    /**
    * 下单用户id
    */
    private Long userId;

    /**
    * 订单状态
    */
    private String status;
}