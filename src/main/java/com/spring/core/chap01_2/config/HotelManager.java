package com.spring.core.chap01_2.config;


import com.spring.core.chap01_2.*;

// 호텔에 필요한 객체들을 생성하고 조립하여 의존관계를 설정해주는 역할 수행.
public class HotelManager { // Bean Factory : 객체를 생성하는 공장이란 뜻!!!
                            // 스프링에서는 [Spring Container]라고 부른다.
                    // 자바에서의 [Bean]이란 객체를 의미한다고 보면 된다. 커피를 이루는 수많은 콩들


    // 쉐프 객체를 생성하여 리턴하는 메서드
    public Chef chef() {
        return new KimuraChef(); // 여기서 한번 바뀌면 하위에 레스토랑 객체 생성시 매개변수 chef, 호텔 객체 생성시 매개변수 chef 부분이 동시에 변경됨.
    }


    // 코스 객체를 생성하여 리턴하는 메서드
    public Course course() {
        return new SushiCourse();
    }


    // 레스토랑 객체를 생성하여 리턴하는 메서드
    public Restaurant restaurant() {
        return new EasternRestaurant(chef(), course());
    }


    // 호텔 객체를 생성하여 리턴하는 메서드
    public Hotel hotel() {
        return new Hotel(restaurant(), chef());
    }
}
