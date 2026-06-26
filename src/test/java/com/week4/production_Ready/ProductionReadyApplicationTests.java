package com.week4.production_Ready;

import com.week4.production_Ready.clients.EmployeeClient;
import com.week4.production_Ready.dtos.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductionReadyApplicationTests {
	@Autowired
	EmployeeClient employeeClient;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllUsers() {
		System.out.println(employeeClient.getAllEmployee());

	}

	@Test
	void getEmployeeById() {
		System.out.println(employeeClient.getEmployeeById(1L));
	}

	@Test
	void createEmployee() {
		EmployeeDTO employee = new EmployeeDTO(null,"anuk","mu@gmail.com","DGP",true,50000L);
		System.out.println(employeeClient.createEmployee(employee));
	}
}
