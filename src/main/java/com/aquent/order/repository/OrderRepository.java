package com.aquent.order.repository;

import java.io.IOException;
import java.util.List;

import com.aquent.order.model.OrderOutput;

public interface OrderRepository {
	
	List<String> getRawData(String inputFilePath) throws IOException;

	void writeFormattedData(List<OrderOutput> formattedOrderList, String header, String outputFilePath)
			throws IOException;

}
