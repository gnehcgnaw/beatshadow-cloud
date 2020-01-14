package com.beatshadow.aotmikosexamples.service;

import com.beatshadow.aotmikosexamples.domain.OrderInfo;
    /**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/14 14:27
 */
public interface OrderInfoService{


    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int insertOrderAndOrderLog(OrderInfo orderInfo);

}
