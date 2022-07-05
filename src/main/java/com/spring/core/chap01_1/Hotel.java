package com.spring.core.chap01_1;

public class Hotel {

//    private EasternRestaurant restaurant; // 의존성 부여 호텔 속 (동양식) 레스토랑
//    private KimChef headChef; // 헤드 셰프 : (김 셰프)가 있어야 함.

    // 이렇게 되면 서양식으로 바뀐다면?? 코드의 변경이 많이 일어나게 될 것이다.
    // 역할에 의존하게 해야지 실제적 구현체에 의존하면 안된다.


    // 인터페이스에 의존하도록 설계 변경.
    private Restaurant restaurant;
    private Chef headChef;


    public Hotel() {
        this.restaurant = new EasternRestaurant(); // 구현체에 의존하고 있는 것과 같다. DIP도 위반!!
            // 이건 SRP도 위반하고 있는 것이다. 호텔이라는 감독이 역할에 얘네 캐스팅까지..?? 캐스팅 담당 직원이 따로 구하게 하면 되는건데..??
        this.headChef = new KimuraChef(); // 이렇게 객체가 필요한 객체를 선택해서 직접 넣는 이 과정을 두고 결합도가 높다고 평가한다.
    }



    // 깨알 단축키 !! 컨트롤 + E는 이전 화면 다시 보기

    // 호텔 소개 기능
    public void inform() {
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());

        restaurant.reserve();
    }

}
