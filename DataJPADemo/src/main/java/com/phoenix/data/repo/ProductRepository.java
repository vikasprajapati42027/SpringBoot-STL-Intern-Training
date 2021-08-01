package com.phoenix.data.repo;
import java.util.List;

/*
 * @Author :vikas.prajapati@stltech.in
 * @version 1.0
 * Date 30-07-2021
 * @copyright Sterlite Technologies Ltd.
 * @description persistent class or Entity class of Hibernate
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phoenix.data.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	 List<Product> findByName(String name);
	 
	 
	 @Query("select p from Product p where p.name - ?1 and p.price = ?2 ")
	 List<Product> getProductByNameAndPrice(String name,float price);
}
