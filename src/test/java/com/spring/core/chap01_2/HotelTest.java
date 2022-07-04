package com.spring.core.chap01_2;

import com.spring.core.chap01_2.config.HotelManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HotelTest {

    @Test
    void objectTest() {


//        Hotel hotel = new Hotel(new WesternRestaurant(new KimuraChef(), new SushiCourse()), new JuanChef());
        // 이것도 말이 안되는데? 사용자가 호텔 속 레스토랑을 어떤걸 배치할지 고르고 셰프랑 코스를 고르나? : nope!!



        HotelManager hm = new HotelManager(); // 스프링이 매니저가 될 것이다.
        Hotel hotel = hm.hotel();
        hotel.inform();

    }

}
