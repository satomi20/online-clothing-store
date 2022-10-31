package com.daniel.sms.onlineclothingstore.service.impl;

import com.daniel.sms.onlineclothingstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySessionService {

    private final SessionRegistry sessionRegistry;

    @Autowired
    public MySessionService(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void expireUserSessions(String username) {
        for (Object principal : sessionRegistry.getAllPrincipals()) {
            if (principal instanceof User) {
                User user = (User) principal;
                if (user.getEmail().equals(username)) {
                    for (SessionInformation information : sessionRegistry.getAllSessions(user, true)) {
                        information.expireNow();
                        killExpiredSessionForSure(information.getSessionId());
                    }
                }
            }
        }
        System.out.println("End of expire");
    }

    public void killExpiredSessionForSure(String id) {
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Cookie", "JSESSIONID=" + id);
            HttpEntity requestEntity = new HttpEntity(null, requestHeaders);
            RestTemplate rt = new RestTemplate();
            rt.exchange("http://localhost:8088", HttpMethod.GET,
                    requestEntity, String.class);
        } catch (Exception ignored) {
        }
    }


}
