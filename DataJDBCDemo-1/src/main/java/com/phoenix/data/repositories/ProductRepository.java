package com.phoenix.data.repositories;
import java.util.List;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
/*
 * @author : vikas.prajapati@stltech.in
 * @version: 0.1
 * @Date 29-07-2021
 * @Copyright Sterlite Technology Ltd.
 * @description DAO Interface or Repository Interface
 * 
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.phoenix.data.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	//custom finder methods
	List<Product>  findByName(String name);
	List<Product>  findByBrand(String brand);
	List<Product>  findByPrice(float price);
	List<Product>  findByPriceBetween(float minPrice,float maxPrice);
	List<Product>  findByNameAndBrand(String name,String brand);
	List<Product>  findByNameAndPrice(String name,float price);
    List<Product>  findByNameLike(String namePattern);

    List<Product> findByNameOrderByPrice(String name);
    List<Product> findByNameOrderByPriceDesc(String name);
    
    
    List<Product> OrderByBrand();
    
    @Query("select * from product order by name")
    List<Product> sortByName();
    
    
    @Query("select * from product where name = :nm and price = :pr")
    List<Product> getProductByNameAndPrice(@Param("nm") String name ,@Param("pr") float price);

    @Modifying
    @Query("update  product set price =price + :pr  where brand = :br")
    int updatePriceByBrand(@Param("br")String brand,@Param("pr") float price);

    @Modifying
    @Query("delete from product where name = :nm")
   boolean deleteProductByName(@Param("nm")String name);

}
