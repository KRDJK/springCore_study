package com.spring.core.chap02.config;

import com.spring.core.chap02.*;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 스프링 빈을 등록하는 설정 파일
@Builder
@Configuration // 이 클래스가 설정 파일이라고 명시해주는 것!
public class HotelConfig {


    // 빈 등록 방식 - 생성자 주입 방식, setter 주입 방식
    @Bean // 스프링에게 이게 너가 관리해야할 커피콩(객체)이라고 알려주는 것
    public Chef chef() {
        return new KimuraChef();
    }


    @Bean(name = "sc")
    public Course sushiCourse() {
        return new SushiCourse();
    }


    @Bean(name = "fc")
    public Course frenchCourse() {
        return new FrenchCourse();
    }


    @Bean(name = "res") // 빈의 이름을 이렇게 따로 짓지 않으면 메서드의 이름이 빈의 이름이 되는데, 이렇게 하면 빈의 이름이 res로 간소화된다.
    public Restaurant restaurant() {
        // 생성자 주입 방식(constructor injection)
//        EasternRestaurant er = new EasternRestaurant(chef(), sushiCourse());

        // 수정자 주입(setter injection) : 기본 생성자로 객체 생성 이후 setter로 의존 객체를 만들어 넣어주는 방식
        EasternRestaurant er = new EasternRestaurant();
        er.setChef(chef());
        er.setCourse(sushiCourse());

        return er;
    }


    @Bean
    public Hotel hotel() {
        return new Hotel(restaurant(), chef());
    }


}
