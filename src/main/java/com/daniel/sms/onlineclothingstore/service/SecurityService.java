package com.daniel.sms.onlineclothingstore.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String email, String password);
}
