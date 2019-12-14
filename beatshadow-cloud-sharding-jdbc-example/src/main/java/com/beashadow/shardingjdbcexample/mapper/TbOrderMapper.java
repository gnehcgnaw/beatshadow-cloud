package com.beashadow.shardingjdbcexample.mapper;

import com.beashadow.shardingjdbcexample.domain.TbOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/13 15:40
 */
public interface TbOrderMapper {

    int insert(@Param("record") TbOrder record);

    List<TbOrder> selectListByOrderIdList(List<Long> list);

    List<TbOrder> selectListByOrderIdListAndUserId(@Param("orderIdList") List<Long> orderIdList ,@Param("userId") Long userId);
}