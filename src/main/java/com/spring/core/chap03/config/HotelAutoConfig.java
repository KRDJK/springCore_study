package com.spring.core.chap03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // 이 클래스가 설정 파일이라고 명시해주는 것은 똑같다.

// "경로" 안의 패키지에 있는 [@Component]가 붙은 클래스들을 자동으로 빈으로 등록한다는 뜻!!
@ComponentScan(basePackages = "com.spring.core.chap03")
public class HotelAutoConfig {
}
