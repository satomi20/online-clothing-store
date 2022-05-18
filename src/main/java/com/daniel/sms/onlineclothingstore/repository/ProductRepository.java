package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);

    Page<Product> findByPriceBetween(Integer startingPrice, Integer endingPrice, Pageable pageable);

    Page<Product> findByCategoryContaining(String category, Pageable pageable);

    Page<Product> findProductByArticle(String article, Pageable pageable);

    Page<Product> findProductBySize(String size, Pageable pageable);

    Page<Product> findProductByColor(String color, Pageable pageable);

    Page<Product> findByCategories(@Param("category") Category category, Pageable pageable);

    @Query(value = "SELECT max(price) from Product")
    Long minProductPrice();

    @Query(value = "select min(price) from Product")
    Long maxProductPrice();


    //Long countByCategory(String category);







}
