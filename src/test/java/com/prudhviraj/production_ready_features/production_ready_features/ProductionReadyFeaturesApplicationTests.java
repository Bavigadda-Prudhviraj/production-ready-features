package com.prudhviraj.production_ready_features.production_ready_features;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.prudhviraj.production_ready_features.production_ready_features.clients.EmployeeClient;
import com.prudhviraj.production_ready_features.production_ready_features.dto.TodoDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ProductionReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllEmployees() {
		log.info("Fetched details : {}", employeeClient.getAllEmployees());
		List<TodoDto> allEmployees = employeeClient.getAllEmployees();

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			// Enable pretty printing
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			String jsonOutput = objectMapper.writeValueAsString(allEmployees);
			log.info(jsonOutput);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
