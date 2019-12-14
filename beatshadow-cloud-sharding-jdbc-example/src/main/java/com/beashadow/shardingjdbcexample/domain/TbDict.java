package com.beashadow.shardingjdbcexample.domain;

import lombok.Data;

/**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/14 13:30
 */
@Data
public class TbDict {
    /**
    * 字典id
    */
    private Long dictId;

    /**
    * 字典类型
    */
    private String type;

    /**
    * 字典编码
    */
    private String code;

    /**
    * 字典值
    */
    private String value;
}