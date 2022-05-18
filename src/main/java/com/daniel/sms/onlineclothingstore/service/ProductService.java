package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);

    Page<Product> findByPriceBetween(Integer startingPrice, Integer endingPrice, Pageable pageable);

    Page<Product> findByCategoryContaining(String category, Pageable pageable);

    Page<Product> findProductByArticle(String article, Pageable pageable);

    Page<Product> findProductBySize(String size, Pageable pageable);

    Page<Product> findProductByColor(String color, Pageable pageable);

    Long minProductPrice();

    Long maxProductPrice();

    void saveProduct(Product product);
    void deleteProduct(Long id);




}
