package com.daniel.sms.onlineclothingstore.repository;

import com.daniel.sms.onlineclothingstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update User u set u.firstName = ?1, u.lastName = ?2, u.phoneNumber = ?3, " +
            "u.email = ?4, u.password = ?5 where u.id = ?6")
    void saveUserById(String firstname, String lastname, String phoneNumber, String email, String password, Long id);
    /*User findByEmail(String email);*/
}
