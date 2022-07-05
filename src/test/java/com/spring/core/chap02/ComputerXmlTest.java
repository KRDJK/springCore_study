package com.spring.core.chap02;

import com.spring.core.chap02.computer.Computer;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ComputerXmlTest {
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("ComputerConfig.xml");

    @Test
    void findBeanTest() {
        Computer computer = ac.getBean(Computer.class);

        computer.showSpec();
    }
}
