package com.aquent.order.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aquent.order.model.OrderInput;
import com.aquent.order.model.OrderOutput;
import com.aquent.order.repository.OrderRepository;
import com.aquent.order.utility.OrderException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

	@Mock
	OrderRepository orderRepository;

	@InjectMocks
	OrderServiceImpl orderServiceImpl;

	@Test
	public void testProcessInputOrder() throws OrderException {

		List<String> rawInputOrderList = new ArrayList<String>(
				Arrays.asList("Order		time", "Pizza		1506176687"));
		List<OrderInput> orderInputList = orderServiceImpl.processInputOrder(rawInputOrderList);
		List<OrderInput> expOrderInputList = new ArrayList<>(Arrays.asList(new OrderInput("Pizza", 1506176687)));
		assertEquals(expOrderInputList, orderInputList);
	}

	@Test
	public void testFormatInputOrder() {
		List<OrderInput> orderInputList = new ArrayList<>(
				Arrays.asList(new OrderInput("pizza", 1506176687), new OrderInput("bread", 1477405487)));
		List<OrderOutput> orderOutputList = orderServiceImpl.formatInputOrder(orderInputList);
		List<OrderOutput> expOrderOutputList = new ArrayList<>(
				Arrays.asList(new OrderOutput("Bread", new Date(1477405487000l)),
						new OrderOutput("Pizza", new Date(1506176687000l))));
		assertEquals(expOrderOutputList, orderOutputList);
	}

}
