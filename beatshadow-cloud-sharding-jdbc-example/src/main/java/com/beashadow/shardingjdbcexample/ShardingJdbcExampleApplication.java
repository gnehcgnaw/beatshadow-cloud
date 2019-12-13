package com.beashadow.shardingjdbcexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @since 2019年12月13日11:49:32
 * @author gnehcgnaw
 */
@MapperScan(basePackages = {"com.beashadow.shardingjdbcexample.mapper"})
@SpringBootApplication
public class ShardingJdbcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcExampleApplication.class, args);
	}

}
