package com.spring.core.chap03;

import org.springframework.stereotype.Component;

@Component("kc") // 이러면 이 빈의 이름이 kc가 된다.
public class KimuraChef implements Chef {
    @Override
    public void cook() {
        System.out.println("일식의 대가 키무라입니다.");
    }
}
