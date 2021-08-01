package com.phoenix.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product;
import com.phoenix.data.repo.ProductRepository;



@SpringBootApplication
public class DataJpaDemoApplication implements CommandLineRunner {

	private static final Logger LOG=LogManager.getLogger();
	
	@Autowired
	private ProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DataJpaDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("No of Products : " + productRepo.count());
		
		Iterable<Product> products = productRepo.findAll();
		products.forEach(System.out::println);
		
	}

}
