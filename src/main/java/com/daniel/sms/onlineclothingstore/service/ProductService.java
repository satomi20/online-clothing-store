package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.enums.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ProductService {

    Product findById(Long id);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);

    Page<Product> findByCategoryId(Long categoryId, int pageNo, int pageSize, String sortField, String sortDirection);

    Page<Product> findByPriceBetween(Integer startingPrice, Integer endingPrice, Pageable pageable);

    Page<Product> findProductByArticle(String article, Pageable pageable);

    Page<Product> findByColor(String color, Pageable pageable);

    Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    List<Product> getProductOrderByPriceMax();

    List<Product> getProductOrderByPriceMin();

    List<Product> getProductOrderByPsOrderByPercentDiscountMax();

    List<Product> getProductOrderByPsOrderByPercentDiscountMin();

    void saveProductInfoById(String name, String urlName, String  article, String description, String imagePath,
                             String color, Boolean sale, Boolean newProd, Timestamp updateDate, Long id);

    public void addDiscount(Product product, Long discount, Long oldPrice, Long id);

    public void updateCategoryById(Long categoryId, Long id);

    void saveProduct(Product product);
    void delete(Long id);




}
