package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.Order;
import com.daniel.sms.onlineclothingstore.entity.OrderDetails;
import com.daniel.sms.onlineclothingstore.entity.ShippingDetails;
import com.daniel.sms.onlineclothingstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();

    List<Order> findByUser(User user);
    

}
