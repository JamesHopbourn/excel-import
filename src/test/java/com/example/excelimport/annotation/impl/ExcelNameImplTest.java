package com.example.excelimport.annotation.impl;

import com.example.excelimport.annotation.ExcelName;
import com.example.excelimport.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExcelNameImplTest {
    @Test
    void getValue() {
        String s = get(User.class);
//        String value = User.class.getAnnotation(ExcelName.class).value();
//        System.out.println(value);
    }

    String get(Class klass){
        ExcelName annotation = (ExcelName) klass.getAnnotation(ExcelName.class);
        System.out.println(annotation.value());
        return null;
    }
}