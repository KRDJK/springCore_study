package com.spring.core.chap02;

import com.spring.core.chap02.config.HotelConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    
    // 스프링 컨테이너에서 빈 가져오기
    AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(HotelConfig.class); // 메타 데이터를 넣어준다.


    @Test
    @DisplayName("스프링 컨테이너에 등록된 빈들의 의존관계가 잘 결합되어 있어야 한다.")
    void beanTest() {

        Hotel hotel = ac.getBean(Hotel.class); // 호텔 타입의 빈을 가져와라( 정확히는 그 빈을 설명하는 데이터를 가져오세요..?? )
        hotel.inform();
    }


    @Test
    @DisplayName("등록된 빈의 타입으로 빈을 가져와야 한다.")
    void findBeanByType() {

        Chef chef = ac.getBean(Chef.class); // 셰프 타입 가져오세요
        chef.cook();

        // 실무용 테스트 방식
            // 나는 셰프의 실제 인스턴스가 KimuraChef 일거라고 단언한다.
        assertInstanceOf(KimuraChef.class, chef);
    }


    // 이름으로 가져오는건 잘 쓰지 않는다.
    @Test
    @DisplayName("등록된 빈의 이름으로 빈을 가져와야 한다.")
    void findBeanByName() {

        // 빈의 이름은 따로 정해놓지 않으면 등록 메서드명이 이름이 된다.
//        Restaurant restaurant = (Restaurant) ac.getBean("restaurant");
        Restaurant restaurant = (Restaurant) ac.getBean("res");

        assertInstanceOf(EasternRestaurant.class, restaurant);

    }


    @Test
    @DisplayName("등록된 빈의 타입이 중복이면 예외가 발생해야 한다.")
    void findBeanByDuplicateType() {

//        Course course = ac.getBean(Course.class);

        // 예외 발생 테스트
            // 나는 예외가 던져질거라고 단언한다. (괄호 속 예외가 발생할 것이라고 예상)
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(Course.class));
            // 매개변수 2번의 상황을 발생시켰을 때, 매개변수 1번의 예외가 발생할 것이라고 단언한다.
    }


    @Test
    @DisplayName("등록된 빈의 타입이 중복이면 빈의 이름과 타입으로 조회하면 된다.")
    void findBeanByDuplicateType2() {

        Course course = ac.getBean("sc", Course.class); // 나는 코스 타입의 빈을 가져올건데 이름이 sc인 코스타입 빈을 가져올거야.

        assertInstanceOf(SushiCourse.class, course);

    }



    // 중요하진 않음.
    @Test
    @DisplayName("스프링 컨테이너에 등록된 모든 빈들을 출력해야 한다.")
    void findAllBeans() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println("=========================================");
        for (String beanName : beanDefinitionNames) {

            // 등록된 빈의 메타데이터 가져오기 ( 메타데이터 : 등록된 데이터를 설명하는 데이터..? )
            BeanDefinition bd = ac.getBeanDefinition(beanName);


            // ROLE_APPLICATION : 사용자가 직접 등록한 빈
            // ROLE_INFRASTRUCTURE : 스프링이 자체적으로 등록해서 사용하는 빈
            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println(beanName);
            }
        }
        System.out.println("=========================================");
    }
}
