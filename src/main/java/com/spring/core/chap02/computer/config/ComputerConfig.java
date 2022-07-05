package com.spring.core.chap02.computer.config;

import com.spring.core.chap02.computer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {

    // 키보드
    @Bean 
    public Keyboard samsungKeyboard() {
        return new SamsungKeyboard();
    }

    @Bean
    public Keyboard hpKeyboard() {
        return new HpKeyboard();
    }


    // 마우스
    @Bean 
    public Mouse logitecMouse() {
        return new LogitecMouse();
    }

    @Bean
    public Mouse appleMouse() {
        return new AppleMouse();
    }

    // 모니터
    @Bean
    public Monitor samsungMonitor() {
        return new SamsungMonitor();
    }

    @Bean
    public Monitor lgMonitor() {
        return new LgMonitor();
    }


    @Bean
    public Computer computer() {
        return new Computer(samsungKeyboard(), logitecMouse(), samsungMonitor());
    }

}
