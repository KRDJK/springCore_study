package com.spring.core.chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HotelXmlTest {
    
    // 스프링 컨테이너 객체 생성 ( xml 실행파일 읽기 )
    GenericXmlApplicationContext ac =
            new GenericXmlApplicationContext("HotelConfig.xml"); // 리소스 폴더 하위에 어떤 폴더 속에 속한게 아니기 때문에 다이렉트로 적는다.


    @Test
    @DisplayName("xml 설정파일에 등록된 빈들을 조회해야 한다.")
    void findBeanTest() {
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();

    }
}
