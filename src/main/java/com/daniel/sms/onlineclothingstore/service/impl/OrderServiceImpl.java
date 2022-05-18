package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.Order;
import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.repository.OrderDetailsRepository;
import com.daniel.sms.onlineclothingstore.repository.OrderRepository;
import com.daniel.sms.onlineclothingstore.repository.ShippingDetailsRepository;
import com.daniel.sms.onlineclothingstore.repository.UserRepository;
import com.daniel.sms.onlineclothingstore.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ShippingDetailsRepository shippingDetailsRepository;
    private final OrderDetailsRepository orderDetailsRepository;


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Order> findOrderByUser(User user) {
        return orderRepository.findByUser(user);
    }
}
