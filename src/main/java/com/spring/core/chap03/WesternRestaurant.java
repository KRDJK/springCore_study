package com.spring.core.chap03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Setter @Getter
@Component
public class WesternRestaurant implements Restaurant {

    private Chef chef;
    private Course course;


    public WesternRestaurant(@Qualifier("jc") Chef chef, Course course) {
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
