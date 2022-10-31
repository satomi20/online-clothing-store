package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.Orders;
import com.daniel.sms.onlineclothingstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MyOrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAll();

    List<Orders> findByUserId(Long userId);

    @Query(value = "select sum(o.total_price) from orders o where o.user_id = ?1", nativeQuery = true)
    BigDecimal getTotalPrice(Long userId);

    @Query(value = "select o.total_price from orders o where o.user_id = ?1", nativeQuery = true)
    List<BigDecimal> getTotalPriceList(Long userId);
}

    //@Query(value = "SELECT * FROM orders WHERE total_price = (SELECT MIN(total_price) FROM orders)", nativeQuery = true)
    //List<Orders> maxOrderPrice();

    //List<Order> minOrderPrice();

    //@Query(value ="select max(total_price) from orders", nativeQuery = true)
    //BigDecimal maxOrderPrice();

    //@Query(value = "SELECT * FROM orders WHERE total_price = (SELECT MAX(total_price) FROM orders)", nativeQuery = true)
    //BigDecimal minOrderPrice();

