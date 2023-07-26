package com.example.excelimport.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
public class GetField {
    @Test
    void get(){
        Class<TiDanXinXi> demoClass = TiDanXinXi.class;
        Field[] declaredFields = demoClass.getDeclaredFields();
        for (Field field : declaredFields) {
            Excel annotation = field.getAnnotation(Excel.class);
            System.out.println(annotation.width());
        }

    }
}
