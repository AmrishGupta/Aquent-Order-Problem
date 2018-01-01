package com.aquent.order.repository.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.aquent.order.model.OrderOutput;
import com.aquent.order.repository.OrderRepository;

@Repository
@Primary
public class OrderFileRepositoryImpl implements OrderRepository {

	// Method to read data from the given input file path
	@Override
	public List<String> getRawData(String inputFilePath) throws IOException {

		return Files.readAllLines(Paths.get(inputFilePath));

	}

	// Method to write data to the given output file path.
	@Override
	public void writeFormattedData(List<OrderOutput> formattedOrderList, String header, String outputFilePath)
			throws IOException {

		File file = new File(outputFilePath);
		FileUtils.writeStringToFile(file, header + System.lineSeparator(), Charset.defaultCharset()); 
		FileUtils.writeLines(file, formattedOrderList, true);
	}

}
