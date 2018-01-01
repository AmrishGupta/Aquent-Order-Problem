package com.aquent.order.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquent.order.model.OrderInput;
import com.aquent.order.model.OrderOutput;
import com.aquent.order.repository.OrderRepository;
import com.aquent.order.service.OrderService;
import com.aquent.order.utility.OrderException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	private final static String FILE_HEADER = String.format("%-15s", "Item Ordered") + "Time of Order";

	@Override
	public void formatOrderData(String inputFilePath, String outputFilePath) throws OrderException {

		List<String> rawInputOrderList = null;

		// Retrieve input data.In case of reading data from DB change repo methods
		try {
			//Stream the input data to discard and empty lines.
			rawInputOrderList = orderRepository.getRawData(inputFilePath).stream().filter(e -> !e.isEmpty())
					.collect(Collectors.toList());
		} catch (IOException e) {
			logger.error("Unable to retrive data from file path {}.", inputFilePath, e);
			throw new OrderException("Unable to retrive data from file");
		}

		// Write the formatted data.In case of writing to DB change repo methods
		try {
			//Change the arguments of this method to write to DB
			orderRepository.writeFormattedData(this.formatInputOrder(this.processInputOrder(rawInputOrderList)),
					FILE_HEADER, outputFilePath);
		} catch (IOException e) {
			logger.error("Unable to write data from file path {}.", outputFilePath, e);
			throw new OrderException("Unable to write data to the file");
		}

	}

	// This method is to process input string to input object for future easy db
	// portability.
	public List<OrderInput> processInputOrder(List<String> rawInputOrderList) throws OrderException {
		List<OrderInput> orderInputList = new ArrayList<>();
		if (null != rawInputOrderList && !rawInputOrderList.isEmpty()) {
			//Reading from 1 to ignore the header of input file
			for (int i = 1; i < rawInputOrderList.size(); i++) {
				String array[] = rawInputOrderList.get(i).split("\\s+");
				OrderInput order = new OrderInput(array[0].trim(), Long.parseLong(array[1]));
				orderInputList.add(order);
			}
		} else {
			throw new OrderException("The file uploaded either doesn't exist or is empty");
		}
		return orderInputList;
	}

	// This method formats the input object to human readable output format.
	public List<OrderOutput> formatInputOrder(List<OrderInput> orderInputList) {
		List<OrderOutput> formattedOrderOutput = null;
		formattedOrderOutput = orderInputList.stream()
				.map(e -> new OrderOutput(
						e.getItemOrdered().substring(0, 1).toUpperCase() + e.getItemOrdered().substring(1),
						new Date(e.getTimeOfOrder() * 1000)))
				.collect(Collectors.toList());
		Collections.sort(formattedOrderOutput);

		return formattedOrderOutput;
	}

}
