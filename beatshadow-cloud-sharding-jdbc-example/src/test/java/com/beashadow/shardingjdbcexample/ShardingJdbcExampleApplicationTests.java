package com.beashadow.shardingjdbcexample;

import com.beashadow.shardingjdbcexample.domain.TbOrder;
import com.beashadow.shardingjdbcexample.mapper.TbOrderMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcExampleApplication.class})
class ShardingJdbcExampleApplicationTests {

	@Autowired
	private TbOrderMapper tbOrderMapper ;

	@Test
	public void testInsert(){
		for (int i = 0; i < 100; i++) {
			TbOrder tbOrder = new TbOrder();
			tbOrder.setPrice(new BigDecimal(new Random().nextInt(100)));
			tbOrder.setUserId(1L);
			tbOrder.setStatus("success");
			System.out.println(tbOrderMapper.insert(tbOrder));
		}
	}
	@Test
	public void testSelectListByOrderIdList(){
		tbOrderMapper.selectListByOrderIdList(Arrays.asList(
				412347183266791424l,
				412347182750892033l,
				412347183430369281l,
				412347183547809792l)).stream().forEach((tbOrder)-> System.out.println(tbOrder));

	}}
