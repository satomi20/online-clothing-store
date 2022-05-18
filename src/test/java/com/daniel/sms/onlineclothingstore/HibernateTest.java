package com.daniel.sms.onlineclothingstore;

import com.daniel.sms.onlineclothingstore.entity.ShippingDetails;
import com.daniel.sms.onlineclothingstore.enums.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HibernateTest {

    @Test
    void contextLoads() {
    }

    @Test
    void cityTest(){
        /*/City[] cities = City.values();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ShippingDetails shippingDetails = new ShippingDetails();
        shippingDetails.setCity(City.МИНСК);
        shippingDetails.setAddress("gaeev");
        shippingDetails.setFirstName("Joe");
        shippingDetails.setLastName("Billy");
        shippingDetails.setCountry("Nazi");
        shippingDetails.setPhoneNumber(547665656776L);
        shippingDetails.setPaymentType("nal");
        session.save(shippingDetails);
        session.close();*/


    }
}
