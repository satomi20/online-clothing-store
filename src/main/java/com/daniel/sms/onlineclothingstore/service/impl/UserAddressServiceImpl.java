package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.User;
import com.daniel.sms.onlineclothingstore.entity.UserAddress;
import com.daniel.sms.onlineclothingstore.repository.UserAddressRepository;
import com.daniel.sms.onlineclothingstore.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
@Service
public class UserAddressServiceImpl implements UserAddressService {

    private final UserAddressRepository userAddressRepository;

    @Autowired
    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public Set<UserAddress> findUserAddressByUser(User user) {
        return userAddressRepository.findUserAddressByUser(user);
    }

    //TODO: - написать обработчик исключений
    /*@Transactional
    public void saveAddress(UserAddress userAddress, String country, String address, String city){
        userAddress.setAdress(address);
        userAddress.setCountry(country);
        userAddress.setCity(city);
        userAddressRepository.save(userAddress);
    }*/

    /*public void updateByUser()*/


    @Transactional
    public void saveByUser(User user, UserAddress userAddress){
        userAddress.setUser(user);
        userAddressRepository.save(userAddress);
    }


}
