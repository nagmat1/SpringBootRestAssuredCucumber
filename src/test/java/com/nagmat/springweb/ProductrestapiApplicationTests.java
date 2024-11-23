package com.nagmat.springweb;

import com.nagmat.springweb.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.nagmat.springweb",
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		monochrome = true)

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	public void testGetProduct() {
		System.out.println("Testing Get Product Method, the baseURL : "+baseURL);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"/1", Product.class);
		assertNotNull(product);
		assertEquals("1+", product.getName());
	}

	@Test
	public void testCreateProduct(){
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung Galaxy");
		product.setDescription("Samsung Galaxy S21");
		product.setPrice(750);
		Product newProduct = restTemplate.postForObject(baseURL, product, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung Galaxy", newProduct.getName());
	}

	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL +"/1", Product.class);
		product.setPrice(1400);
		restTemplate.put(baseURL, product);
	}

}
