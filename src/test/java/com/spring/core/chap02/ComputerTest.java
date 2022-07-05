package com.spring.core.chap02;

import com.spring.core.chap02.computer.Computer;
import com.spring.core.chap02.computer.Monitor;
import com.spring.core.chap02.computer.config.ComputerConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComputerConfig.class);


    @Test
    @DisplayName("설정파일에 등록한 Computer 빈을 가져와야 한다.")
    void findAllBeans() {
        Computer computer = ac.getBean(Computer.class);

        computer.showSpec();

    }

    @Test
    @DisplayName("컨테이너에서 조회한 빈은 단 하나의 객체여야 한다.")
    void singleton() {
        // 왜 싱글톤이어야 하냐?????
        // DB와의 송신을 담당하는 Repo 객체가 싱글톤이 아니라면 sql 명령어를 입력할 때마다 Repo 객체가 생성이 되면..??
        // 메모리 감당이 안되는 순간이 올 것이다.. 다 같은 리모컨을 가지고 조작하는게 낫잖아!

        Monitor m1 = ac.getBean("samsungMonitor", Monitor.class);
        Monitor m2 = ac.getBean("samsungMonitor", Monitor.class);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);

        assertEquals(m1, m2); // 둘의 주소값이 같을 것이라고 단언한다.
    }

    @Test
    void findBeanDuplicate() {

        Monitor monitor = ac.getBean("lgMonitor", Monitor.class);

        monitor.info();
    }
}
