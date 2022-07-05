package com.spring.core.chap03.config;

import com.spring.core.chap03.computer.Computer;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ComputerAutoConfigTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComputerAutoConfig.class);

    @Test
    void autoConfigTest() {
        Computer computer = ac.getBean(Computer.class);

        computer.showSpec();
    }

}