package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(String name);

    @Override
    List<Category> findAll();



    Category findByCategoryId(Long id);

    /*@Query(value = "UPDATE category SET name = ?1 WHERE category_id = ?2", nativeQuery = true)
    void updateCategory(String name, Long id);*/



    /*Category findBySlug(String slug);*/
    // create a method to find a category by name and return list of products
    //Category findByName(String name);


}
