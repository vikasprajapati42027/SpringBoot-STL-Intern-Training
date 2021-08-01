package com.phoenix.data.repositories;
/*
 * @author : vikas .prajapati@stltech.in
 * @version: 0.1
 * @Date 29-07-2021
 * @Copyright Sterlite Technology Ltd.
 * @description DAO Interface or Repository Interface
 * 
 */
import org.springframework.data.repository.CrudRepository;

import com.phoenix.data.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	
}
