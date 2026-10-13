package com.example.fullstack1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fullstack1.controller.CarController;

@SpringBootTest
class CardatabaseApplicationTests {

	@Autowired
	private CarController controller;

	@Test
	@DisplayName("First example test case")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}