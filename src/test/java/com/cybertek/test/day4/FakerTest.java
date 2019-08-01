package com.cybertek.test.day4;

import com.github.javafaker.Faker;

public class FakerTest {
    public static void main(String[] args) {
       Faker faker = new Faker();
       String fact=faker.firstName();
        System.out.println(fact);

    }
}
