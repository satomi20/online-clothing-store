package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
/*
    List<ProductOption> findProductOptionByProductId*/

    @Modifying
    @Transactional
    @Query(value = "select * from product_option where product_id =?1", nativeQuery = true)
    List<ProductOption> getProductOptionByProductId(Long id);

    @Modifying
    @Transactional
    @Query(value = "update product_option set sku = ?1, size = ?2, quantity = ?3 where id = ?4", nativeQuery = true)
    void updateProductOptionByProductId(Long sku, String size, Long quantity, Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into product_option (sku, size, quantity, product_id) values (?1, ?2, ?3, ?4)", nativeQuery = true)
    void save(Long sku,String size, Long quantity, Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from product_option where product_option.id = ?1", nativeQuery = true)
    void deleteProductOptionById(Long id);

}
