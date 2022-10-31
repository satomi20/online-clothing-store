package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);

   /* void updateCategory(String name,Long id);*/
    /*Category findByName(String name);
    Category findByUrlName(String urlName);
    Category save(Category category);
    void delete(Category category);
    void deleteById(Long id);
    void deleteByName(String name);
    void deleteByUrlName(String urlName);
    Set<Product> findAllProductsByCategory(Category category);
    Set<Product> findAllProductsByCategory(Category category, Sort sort);
    Set<Product> findAllProductsByCategory(Category category, Pageable pageable);
    Set<Product> findAllProductsByCategory(Category category, String sortBy, String order, int pageNumber, int pageSize);*/
}
