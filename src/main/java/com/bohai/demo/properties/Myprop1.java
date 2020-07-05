package com.bohai.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Myprop1 {
    @Value("${my1.age}")
    private int age;
    @Value("${my1.name}")
    private String name;
    // 省略 get set

    @Override
    public String toString() {
        return "MyProperties1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
