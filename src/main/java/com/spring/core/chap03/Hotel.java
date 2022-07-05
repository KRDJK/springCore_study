package com.spring.core.chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 자동 빈 등록
@Component // 스프링 컨테이너가 관리해준다. but, 자동 등록을 하더라도 Config 클래스가 있어야 한다.
// 빈 이름을 따로 설정해주지 않으면 클래스명을 카멜 케이스로 바꿔서 등록한다. Hotel이면 hotel
public class Hotel {


    private Restaurant restaurant;
    private Chef headChef;


    @Autowired // 자동 의존성 주입을 명시하는 것. 근데 이걸 안붙였는데도 알아서 자동 주입 해주네??
                    // 생성자 주입 사용시 생성자가 딱 한개면 @Autowired없이도 자동으로 생성자 주입을 수행
                    // 여러 생성자가 있다면 하나의 생성자에만 @Autowired를 붙여야 한다. 여러개 붙이면 예외 발생!!

                // 빈으로 등록된 레스토랑 타입과 셰프 타입이 딱 하나라면 스프링이 컨테이너를 뒤져서 알아서 주입해준다.

                                        // 빈에 등록된 같은 타입의 빈이 여러개 있다면 어떤 이름을 가진 빈을 쓸건지 명시해줘야 한다.
                                        // @Qualifier("빈 이름")
    public Hotel(@Qualifier("easternRestaurant") Restaurant restaurant, @Qualifier("kc") Chef headChef) {
        System.out.println("Hotel 생성자 호출!");
        this.restaurant = restaurant;
        this.headChef = headChef;
    }



    // 깨알 단축키 !! 컨트롤 + E는 이전 화면 다시 보기

    // 호텔 소개 기능
    public void inform() {
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());
                // 레스토랑 타입은 인터페이스 타입이라 무슨 객체인지 알고 싶을 때!! getClass()로 메타데이터를 받아온다.
                        // getName을 하면 풀네임이 들어온다. 풀네임?? [com.~~~.~~~~.클래스명] 으로 진행되는 풀 패키지명을 말함.
                        // getSimpleName을 해야 그 클래스의 이름을 가져온다.

        restaurant.reserve();
    }

}
