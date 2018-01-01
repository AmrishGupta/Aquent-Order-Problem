package com.aquent.order.repository.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aquent.order.model.OrderOutput;
import com.aquent.order.repository.OrderRepository;

@Repository
public class OrderDBRepositoryImpl implements OrderRepository{

	@Override
	public List<String> getRawData(String inputFilePath) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeFormattedData(List<OrderOutput> formattedOrderList, String header, String outputFilePath)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
