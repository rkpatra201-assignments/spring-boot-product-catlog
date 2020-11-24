package com.spring.springbootproductcatlog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.springbootproductcatlog.model.Product;
import com.spring.springbootproductcatlog.controller.ProductRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication
public class SpringBootProductCatlogApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductCatlogApplication.class, args);
	}


	@Autowired
	private ProductRestController productRestController;
	@Override
	public void run(String... args) throws Exception {
		// use junit instead invoking like this.
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("data.json");
		ObjectMapper mapper = new ObjectMapper();
		Product p = mapper.readValue(is,Product.class);
		//productRestController.create(p);
	}
}
