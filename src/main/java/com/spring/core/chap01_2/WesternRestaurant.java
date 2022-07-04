package com.spring.core.chap01_2;

public class WesternRestaurant implements Restaurant {

    private Chef chef;
    private Course course;


    public WesternRestaurant(Chef chef, Course course) {
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
