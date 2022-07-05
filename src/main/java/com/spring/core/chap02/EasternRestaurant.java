package com.spring.core.chap02;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 롬복 활용해서 기본 생성자 만들기
@Setter @Getter
public class EasternRestaurant implements Restaurant {

    private Chef chef; // 호텔 안에는 셰프가 있어야지. 이 경우에도 역할에 의존해야지 특정 구현체에 의존하면 안된다.

    private Course course; // 매일 코스 요리가 바뀐다고 가정. 특정 코스요리에 의존하면 안된다!


    // 코스요리가 매일 바뀔 것이고 그 코스를 제일 잘 요리할 수 있는 셰프도 매일 바뀔 것이라고 가정할 것이다.
        // 코드의 내용 변경이 잦아질 것이라고 가정하는 것이다.


    public EasternRestaurant(Chef chef, Course course) {
        // 여기서도 이러면 향후 Chef, Course 인터페이스를 상속받아 구현된 객체만 잘 들어온다면 수정이 필요없어짐.
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


}
