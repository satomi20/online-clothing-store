package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.Category;
import com.daniel.sms.onlineclothingstore.entity.Product;
import com.daniel.sms.onlineclothingstore.enums.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);

    Page<Product> findByPriceBetween(Integer startingPrice, Integer endingPrice, Pageable pageable);

    Page<Product> findProductByArticle(String article, Pageable pageable);

    Page<Product> findByColor(String color, Pageable pageable);

    @Query(value = "SELECT * FROM product WHERE category_id = ?1", nativeQuery = true)
    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);




    //@Query(value = "SELECT product.* FROM product_category \n" +
       //     "inner join product on (product_category.product_id = product.id)\n" +
        //    "inner join category on (product_category.category_id = category.category_id)", nativeQuery = true)
   // Page<Product> findByCategoriesIn(@Param("product.id") Long productId, @Param("category.category_id") Long categoryId, Pageable pageable);

    @Query(value = "SELECT * FROM mydb.product order by price DESC", nativeQuery = true)
    List<Product> getProductOrderByPriceMax();

    @Query(value = "SELECT * FROM mydb.product order by price ASC", nativeQuery = true)
    List<Product> getProductOrderByPriceMin();

    @Query(value = "SELECT * FROM mydb.product order by percent_discount DESC;", nativeQuery = true)
    List<Product> getProductOrderByPsOrderByPercentDiscountMax();

    @Query(value = "SELECT * FROM mydb.product order by percent_discount ASC;", nativeQuery = true)
    List<Product> getProductOrderByPsOrderByPercentDiscountMin();


    @Modifying
    @Transactional
    @Query("update Product p set p.name = ?1, p.urlName = ?2, p.article = ?3," +
            "p.description = ?4, p.imagePath = ?5, p.color = ?6, p.sale = ?7, " +
            "p.new_product = ?8, p.updatedAt = ?9 where p.id = ?10")
    void saveProductInfoById(String name, String urlName, String  article, String description, String imagePath,
                             String color, Boolean sale, Boolean newProd, Timestamp updateDate, Long id);

    @Modifying
    @Transactional
    @Query("update Product p set p.percentDiscount = ?1, p.oldPrice = ?2 where p.id = ?3")
    void addDiscountToOldPrice(Long percentDiscount, Long oldPrice, Long id);

    @Modifying
    @Transactional
    @Query("update Product p set p.price = ?1 where p.id = ?2")
    void updateDiscountPrice(Long price, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.category.categoryId = ?1 where p.id = ?2")
    void updateCategoryById(Long categoryId, Long id);






}
