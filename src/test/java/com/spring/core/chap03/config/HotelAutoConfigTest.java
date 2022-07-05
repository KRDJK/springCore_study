package com.spring.core.chap03.config;

import com.spring.core.chap03.Chef;
import com.spring.core.chap03.Hotel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class HotelAutoConfigTest {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(HotelAutoConfig.class);

    @Test
    @DisplayName("Component 에너테이션이 붙은 빈들이 등록되어야 한다.")
    void checkBeans() {
        Hotel hotel = ac.getBean(Hotel.class);
//        chef.cook();
        hotel.inform();
    }


    @Test
    @DisplayName("중복 빈이 등록되면 자동 주입에 실패해야 한다.")
    void checkDuplicateBeans() {
        Hotel hotel = ac.getBean(Hotel.class);
//        chef.cook();
        hotel.inform();
    }
}