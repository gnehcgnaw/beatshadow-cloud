package com.beashadow.shardingjdbcexample.mapper;

import com.beashadow.shardingjdbcexample.domain.TbUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/14 12:35
 */
public interface TbUserMapper {
    int insert(@Param("record") TbUser record);
}