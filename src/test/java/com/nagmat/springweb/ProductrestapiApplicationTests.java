package com.nagmat.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.nagmat.steps",
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		monochrome = true)

@SpringBootTest
class ProductrestapiApplicationTests {

	@Test
	public void testProductAPI() {
	}

}
