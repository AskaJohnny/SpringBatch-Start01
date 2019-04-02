package com.johnny.springboot.springbatch.entity;

import lombok.Data;

/**
 * @author johnny
 * @create 2019-04-01 下午4:50
 **/
@Data
public class Person {

    private String lastName;

    private String firstName;

    public Person(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

}