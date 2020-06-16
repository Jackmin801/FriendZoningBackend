package com.meowmeow.dhateapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
// To make it skip servlet check so it doesnt explode
@WebAppConfiguration
class DhateappApplicationTests {

	@Test
	void contextLoads() {
	}

}
