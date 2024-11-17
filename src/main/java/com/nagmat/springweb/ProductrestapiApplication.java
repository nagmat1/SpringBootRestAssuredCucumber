package com.nagmat.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Random;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ProductrestapiApplication {

	public static void main(String[] args) {
		int[] randomNumbers = new int[10];
		int sum = 0 ;

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			randomNumbers[i] = random.nextInt(100);
			sum += randomNumbers[i];
		}

		System.out.println("The random numbers are : ");
		for (int i = 0; i < 10; i++) {
			System.out.println(randomNumbers[i]);
		}
		System.out.println("The sum is : "+sum);

		SpringApplication.run(ProductrestapiApplication.class, args);
	}

}
