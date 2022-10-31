package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    /*Set<UserAddress> findByUserId(Long userId);*/
    Set<UserAddress> findUserAddressByUser(User user);


}
