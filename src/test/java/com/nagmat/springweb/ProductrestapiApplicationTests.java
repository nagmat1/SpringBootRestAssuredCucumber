package com.nagmat.springweb;

import com.nagmat.springweb.entities.Product;
import org.junit.jupiter.api.Test;
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

//@SpringBootTest
class ProductrestapiApplicationTests {

//	@Test
//	public void testGetProduct() {
//		RestTemplate restTemplate = new RestTemplate();
//		Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/1", Product.class);
//		assertNotNull(product);
//		assertEquals("1+", product.getName());
//	}
//
//	@Test
//	public void testCreateProduct(){
//		RestTemplate restTemplate = new RestTemplate();
//		Product product = new Product();
//		product.setName("Samsung Galaxy");
//		product.setDescription("Samsung Galaxy S21");
//		product.setPrice(750);
//		Product newProduct = restTemplate.postForObject("http://localhost:8080/productapi/products", product, Product.class);
//		assertNotNull(newProduct);
//		assertNotNull(newProduct.getId());
//		assertEquals("Samsung Galaxy", newProduct.getName());
//	}
	
//	@Test
//	public void testGetProduct() {
//		RestTemplate restTemplate = new RestTemplate();
//		Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/1", Product.class);
//		assertNotNull(product);
//		assertEquals("1+", product.getName());
//	}

}
