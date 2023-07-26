package com.example.excelimport.annotation.impl;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.ColorEnums;
import com.example.excelimport.annotation.ExcelProperties;
import com.example.excelimport.entity.ExcelField;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelPropertiesImpl {
    public static List<ExcelField> allField(Class<?> klass) {
        String excelAnnotationCanonicalName = Excel.class.getCanonicalName();
        String excelPropertiesCanonicalName = ExcelProperties.class.getCanonicalName();
        Field[] declaredFields = klass.getDeclaredFields();
        List<ExcelField> excelFieldList = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            // 创建 POJO
            ExcelField excelField = new ExcelField();
            // 获取所有注解
            Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                // 处理 @ExcelProperties 注解
                if (declaredAnnotation.annotationType().getName().equals(excelPropertiesCanonicalName)){
                    ExcelProperties annotation = declaredField.getAnnotation(ExcelProperties.class);
                    ColorEnums colorCode = annotation.value();
                    excelField.setDescription(annotation.description());
                    excelField.setColor(colorCode);
                }
                // 处理 @Excel 注解
                if (declaredAnnotation.annotationType().getName().equals(excelAnnotationCanonicalName)){
                    Excel annotation = declaredField.getAnnotation(Excel.class);
                    excelField.setName(annotation.name());
                    excelField.setLength((int) annotation.width());
                }
            }
            if (excelField.getName() != null){
                excelFieldList.add(excelField);
            }
        }
        return excelFieldList;
    }
}
