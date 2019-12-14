package com.beashadow.shardingjdbcexample;

import com.beashadow.shardingjdbcexample.domain.TbDict;
import com.beashadow.shardingjdbcexample.domain.TbOrder;
import com.beashadow.shardingjdbcexample.domain.TbUser;
import com.beashadow.shardingjdbcexample.mapper.TbDictMapper;
import com.beashadow.shardingjdbcexample.mapper.TbOrderMapper;
import com.beashadow.shardingjdbcexample.mapper.TbUserMapper;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.assertj.core.error.ShouldOnlyHaveElementsOfTypes;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcExampleApplication.class})
class ShardingJdbcExampleApplicationTests {


	@Autowired
	private TbOrderMapper tbOrderMapper ;

	@Autowired
	private TbUserMapper tbUserMapper ;

	@Autowired
	private TbDictMapper tbDictMapper ;

	@Test
	public void testInsertOrder() {
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			Long l = random.nextLong();
			TbOrder tbOrder = new TbOrder();
			tbOrder.setPrice(new BigDecimal(random.nextInt(100)));
			tbOrder.setUserId(System.currentTimeMillis());
			tbOrder.setStatus("success");
			tbOrderMapper.insert(tbOrder);
		}
	}
	@Test
	public void testSelectListByOrderIdList(){
		tbOrderMapper.selectListByOrderIdList(Arrays.asList(
				412347183266791424l,
				412347182750892033l,
				412347183430369281l,
				412347183547809792l)).stream().forEach((tbOrder)-> System.out.println(tbOrder));

	}
	@Test
	public void testSelectListByOrderIdListAndUserId(){
		long userId = 1576257768056l;
		tbOrderMapper.selectListByOrderIdListAndUserId(Arrays.asList(
				412418228430569472l,
				412418228594147329l,
				412347183430369281l,
				412347183547809792l),userId
		).stream().forEach((tbOrder)->System.out.println(tbOrder));
	}

	@Test
	public void testInsertUser(){
		for (int i = 0; i < 100; i++) {
			String userType ;
			if (i%2+1==1){
				userType = "1";
			}else {
				userType = "2";
			}
			Random random = new Random();
			int index = random.nextInt(100);
			TbUser tbUser = new TbUser();
			tbUser.setFullName("张三"+index);
			tbUser.setUserType(userType);
			tbUserMapper.insert(tbUser);
		}
	}

	@Test
	public void testInsertDict(){

		TbDict dice1 = new TbDict();
		dice1.setType("user_type");
		dice1.setCode("1");
		dice1.setValue("普通用户");
		tbDictMapper.insert(dice1);

		TbDict dice2 = new TbDict();
		dice2.setType("user_type");
		dice2.setCode("2");
		dice2.setValue("会员用户");
		tbDictMapper.insert(dice2);

	}
}


