package com.beatshadow.aotmikosexamples.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.beatshadow.aotmikosexamples.mapper.log.LogInfoMapper;
import com.beatshadow.aotmikosexamples.domain.LogInfo;
import com.beatshadow.aotmikosexamples.service.LogInfoService;
/**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/14 14:27
 */
@Service
public class LogInfoServiceImpl implements LogInfoService{

    @Resource
    private LogInfoMapper logInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return logInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LogInfo record) {
        return logInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(LogInfo record) {
        return logInfoMapper.insertSelective(record);
    }

    @Override
    public LogInfo selectByPrimaryKey(Integer id) {
        return logInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LogInfo record) {
        return logInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LogInfo record) {
        return logInfoMapper.updateByPrimaryKey(record);
    }

}
