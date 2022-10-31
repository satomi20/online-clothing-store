package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.Orders;
import com.daniel.sms.onlineclothingstore.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Orders> findAll();

    Optional<Orders> findById(Long id);

    Orders save(Orders orders);

    void delete(Long id);

    void deleteAll();

    List<Orders> findOrderByUser(User user);

    Long maxOrderPrice();

    Long minOrderPrice();
}
