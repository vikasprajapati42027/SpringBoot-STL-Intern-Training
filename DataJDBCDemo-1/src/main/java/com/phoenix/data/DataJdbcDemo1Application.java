package com.phoenix.data;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product;
import com.phoenix.data.repositories.ProductRepository;

@SpringBootApplication
public class DataJdbcDemo1Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepo;

	private static final Logger LOG = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(DataJdbcDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Iterable<Product> products = productRepo.findAll();
		products.forEach(System.out::println);
		/*
		 * products.forEach(product->LOG.info(product));
		 * 
		 * 
		 * Optional<Product> productOp = productRepo.findById(5634);
		 * if(productOp.isPresent()) { Product p=productOp.get();
		 * LOG.debug("ProductL "+p); }else { LOG.error("Sorry! Product is not found"); }
		 */

		/*
		 * //Count number of product LOG.info("NO of Products: "+productRepo.count());
		 * 
		 * 
		 * //update product by changing the price productOp =
		 * productRepo.findById(1001); if(productOp.isPresent()) { Product
		 * p=productOp.get(); float oldPrice=p.getPrice();
		 * p.setPrice(p.getPrice()+1000.00f); productRepo.save(p);
		 * LOG.info("ProductL "+p.getId()+"Updated syssesssfully!"); float
		 * newPrice=p.getPrice(); LOG.info("Old Prie "+oldPrice);
		 * LOG.info("New Price"+newPrice);
		 * 
		 * }else { LOG.error("Sorry! Product is not found"); }
		 * 
		 * productOp = productRepo.findById(1001); if(productOp.isPresent()) { Product
		 * p=productOp.get(); productRepo.delete(p);
		 * LOG.info("Product: "+p.getId()+"delete successfully!"); }else {
		 * LOG.error("Sorry! Product is not found"); }
		 * 
		 * 
		 * 
		 * //insert new product Product product=new Product(); product.setId(4441);
		 * product.setName("HOME Threater"); product.setBrand("JBL");
		 * product.setPrice(64000.00f); product.setInsert(true);
		 * 
		 * productRepo.save(product);
		 * LOG.info("New Product: "+product.getId()+"inserted successfully!");
		 */

		List<Product> pByNm = productRepo.findByName("Laptop");
		pByNm.forEach(product -> LOG.info(product));
		// products.forEach(System.out::println);

		pByNm = productRepo.findByName("Mobile");
		pByNm.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByBr = productRepo.findByBrand("dell");
		pByBr.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByPr = productRepo.findByPrice(10000.00f);
		pByPr.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByPriceBetween = productRepo.findByPriceBetween(10000.00f, 30000.00f);
		pByPriceBetween.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByPriceBetweenBrand = productRepo.findByNameAndBrand("Laptop", "Mobile");
		pByPriceBetweenBrand.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByNameBetweePrice = productRepo.findByNameAndPrice("TV", 15000.00f);
		pByNameBetweePrice.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByNmLk = productRepo.findByNameLike("L%");
		pByNmLk.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByNmPr = productRepo.findByNameOrderByPrice("Laptop");
		pByNmPr.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> pByNmPrDesc = productRepo.findByNameOrderByPriceDesc("Mobile");
		pByNmPrDesc.forEach(product -> LOG.info(product));

		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> sortBr = productRepo.OrderByBrand();
		sortBr.forEach(product -> LOG.info(product));

		
		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> sortName = productRepo.sortByName();
		sortName.forEach(product -> LOG.info(product));

		
		LOG.info("==================================================");
		LOG.info("==================================================");

		List<Product> sortNameAndPrice = productRepo.getProductByNameAndPrice("Laptop",10000.00f);
		sortNameAndPrice.forEach(product -> LOG.info(product));

		int updateCount = productRepo.updatePriceByBrand("MOBILE",10000.00f);
		LOG.info("No of products updated "+updateCount);
	
		boolean deleteProduct = productRepo.deleteProductByName("Laptop");
		LOG.info("No of products delete "+deleteProduct);
	
		
	}
}
