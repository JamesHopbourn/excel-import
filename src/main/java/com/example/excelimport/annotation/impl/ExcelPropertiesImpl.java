package com.example.excelimport.annotation.impl;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.ColorEnums;
import com.example.excelimport.annotation.ExcelProperties;
import com.example.excelimport.entity.ExcelField;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExcelPropertiesImpl {
    /**
     * 获取所有必填字段
     * @param klass 传入的实体类
     * @return requireFieldList 实体类必填字段
     */
    public static List<String> getAllRequireField(Class<?> klass){
        Field[] declaredFields = klass.getDeclaredFields();
        String excelPropertiesCanonicalName = ExcelProperties.class.getCanonicalName();
        List<String> requireFieldList = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                if (declaredAnnotation.annotationType().getName().equals(excelPropertiesCanonicalName)){
                    requireFieldList.add(declaredField.getName());
                    break;
                }
            }
        }
        return requireFieldList;
    }

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
                    // Excel orderNum 属性默认值是 "0"，如果是默认值就给它设置一个较大的数值
                    // 最后排序的时候就会排在后面，显式定义的 orderNum 就会排在前面
                    excelField.setOrderNum(annotation.orderNum().equals("0") ? "256" : annotation.orderNum());
                }
            }
            if (excelField.getName() != null){
                excelFieldList.add(excelField);
            }
        }
        // 字段排序
        List<ExcelField> sortedExcelFieldList = excelFieldList.stream()
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(o.getOrderNum())))
                .collect(Collectors.toList());
        return sortedExcelFieldList;
    }
}
