package com.beashadow.shardingjdbcexample.domain;

import lombok.Data;

/**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/14 12:35
 */
@Data
public class TbUser {
    /**
    * 用户id
    */
    private Long userId;

    /**
    * 用户姓名
    */
    private String fullName;

    /**
    * 用户类型
    */
    private String userType;
}