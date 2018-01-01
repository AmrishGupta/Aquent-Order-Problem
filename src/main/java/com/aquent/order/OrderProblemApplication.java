package com.aquent.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aquent.order.service.impl.OrderServiceImpl;
import com.aquent.order.utility.OrderException;

@SpringBootApplication
public class OrderProblemApplication {

	static Logger logger = LoggerFactory.getLogger(OrderProblemApplication.class);
	
	public static void main(String[] args) throws OrderException {

		ApplicationContext appContext = SpringApplication.run(OrderProblemApplication.class, args);
		OrderServiceImpl orderServiceImpl = appContext.getBean(OrderServiceImpl.class);
		validateInput(args);
		logger.info("Input File path {} Output file path {}",args[0],args[1]);
		orderServiceImpl.formatOrderData(args[0], args[1]);
	}

	// Method to validate the command line arguments
	public static void validateInput(String[] args) throws OrderException {
		if (!(null != args && args.length == 2)) {
			throw new OrderException("Input/ Output file paths missing");
		}
	}
}
