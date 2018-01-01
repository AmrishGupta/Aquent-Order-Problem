package com.aquent.order.service;

import com.aquent.order.utility.OrderException;

public interface OrderService {
	
	void formatOrderData(String inputFilePath, String outputFilePath) throws OrderException;

}
