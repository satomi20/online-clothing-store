package com.daniel.sms.onlineclothingstore.service;

import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;

import java.util.Set;

public interface UserAddressService {
    Set<UserAddress> findUserAddressByUser(User user);

}
