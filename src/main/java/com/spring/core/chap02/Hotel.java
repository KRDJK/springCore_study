package com.spring.core.chap02;

public class Hotel {

//    private EasternRestaurant restaurant; // 의존성 부여 호텔 속 (동양식) 레스토랑
//    private KimChef headChef; // 헤드 셰프 : (김 셰프)가 있어야 함.

    // 이렇게 되면 서양식으로 바뀐다면?? 코드의 변경이 많이 일어나게 될 것이다.
    // 역할에 의존하게 해야지 실제적 구현체에 의존하면 안된다.


    // 인터페이스에 의존하도록 설계 변경.
    private Restaurant restaurant; // 레스토랑 인터페이스를 구현받기만 한다면!! 그 어떤 새로운 레스토랑이라도 들어올 수 있다.
    private Chef headChef; // 의존 객체라고 한다.


    public Hotel(Restaurant restaurant, Chef headChef) { // 외부에 맡기는 것. 알아서 잘 구해주겠지~~ 변동가능성이 있기 때문에!!
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
