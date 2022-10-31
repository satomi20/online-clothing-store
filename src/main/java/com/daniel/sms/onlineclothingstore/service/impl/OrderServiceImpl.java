package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.Orders;
import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.repository.MyOrdersRepository;
import com.daniel.sms.onlineclothingstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final MyOrdersRepository myOrdersRepository;

    @Autowired
    public OrderServiceImpl(MyOrdersRepository orderRepository) {
        this.myOrdersRepository = orderRepository;
    }

    @Override
    public List<Orders> findAll() {
        return myOrdersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return myOrdersRepository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return myOrdersRepository.save(orders);
    }

    @Override
    public void delete(Long id) {
        myOrdersRepository.deleteById(id);
    }


    @Override
    public void deleteAll() {
        myOrdersRepository.deleteAll();
    }


    @Override
    public List<Orders> findOrderByUser(User user) {
        return myOrdersRepository.findByUserId(user.getId());
    }

    @Override
    public Long maxOrderPrice() {
        return null;
    }

    @Override
    public Long minOrderPrice() {
        return null;
    }
}
