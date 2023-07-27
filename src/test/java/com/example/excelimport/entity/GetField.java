package com.example.excelimport.entity;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
public class GetField {
    @Test
    void get(){
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
        Field[] superDeclaredFields = User.class.getSuperclass().getDeclaredFields();
        for (Field field : superDeclaredFields) {
            System.out.println(field.getName());
        }

    }
}
