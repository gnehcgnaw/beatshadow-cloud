package com.beatshadow.aotmikosexamples.service.impl;

import com.beatshadow.aotmikosexamples.domain.LogInfo;
import com.beatshadow.aotmikosexamples.mapper.log.LogInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.beatshadow.aotmikosexamples.domain.OrderInfo;
import com.beatshadow.aotmikosexamples.mapper.order.OrderInfoMapper;
import com.beatshadow.aotmikosexamples.service.OrderInfoService;

import java.util.Date;

/**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/14 14:27
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService{

    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private LogInfoMapper logInfoMapper ;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    @Override
    public OrderInfo selectByPrimaryKey(Integer id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertOrderAndOrderLog(OrderInfo orderInfo){
        orderInfoMapper.insert(orderInfo);
        LogInfo logInfo = new LogInfo();
        logInfo.setContent("用户ID:"+orderInfo.getUserId()+"进行了一笔："+orderInfo.getMoney()+"的操作");
        logInfo.setCreateTime(new Date());
        logInfoMapper.insert(logInfo);
        return 0 ;
    }
}
