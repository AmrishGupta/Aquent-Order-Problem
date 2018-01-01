package com.aquent.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aquent.order.repository.OrderRepository;
import com.aquent.order.utility.OrderException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderProblemApplicationTests {
	
	@Test(expected = OrderException.class)
	public void testMissingCommandLineArg() throws OrderException {
		
		String[] args = null;
		OrderProblemApplication.validateInput(args);
	}

	@Test(expected = OrderException.class)
	public void testOneOfThemissingCommandLineArg() throws OrderException {
		
		String[] args = {"C:\\Users\\Amrish\\demo1.txt"};
		OrderProblemApplication.validateInput(args);
	}
}
