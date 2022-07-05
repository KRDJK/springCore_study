package com.spring.core.chap03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@NoArgsConstructor // 롬복 활용해서 기본 생성자 만들기
//@Setter : setter 주입을 하려면 롬복으로 setter를 만들면 안됨.
@Getter
@Component
public class EasternRestaurant implements Restaurant {

    private Chef chef;

    private Course course;


    // 코스요리가 매일 바뀔 것이고 그 코스를 제일 잘 요리할 수 있는 셰프도 매일 바뀔 것이라고 가정할 것이다.
        // 코드의 내용 변경이 잦아질 것이라고 가정하는 것이다.


    /*
    @Autowired // 생성자 자동 주입 명시
    public EasternRestaurant(@Qualifier("kc") Chef chef, Course course) {
        this.chef = chef;
        this.course = course;
    }
    */


    public EasternRestaurant(Chef chef, Course course) {
        System.out.println("\n\n\n");
        System.out.println("eastern 생성자 호출!");
        System.out.println("\n\n\n");
        this.chef = chef;
        this.course = course;
    }


    @Override
    public void reserve() {
        course.combineMenu();
    }

    @Override
    public void order() {
        chef.cook();
    }


    // setter(수정자) 주입 방식
    @Autowired
    @Qualifier("kc")
    public void setChef(Chef chef) {
        System.out.println("\n\n\n");
        System.out.println("Eastern setChef 호출!");
        System.out.println("\n\n\n");
        this.chef = chef;
    }

    @Autowired
    public void setCourse(Course course) {
        System.out.println("\n\n\n");
        System.out.println("Eastern setCourse 호출!");
        System.out.println("\n\n\n");
        this.course = course;
    }
}
