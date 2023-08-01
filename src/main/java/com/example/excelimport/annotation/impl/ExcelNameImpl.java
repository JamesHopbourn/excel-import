package com.example.excelimport.annotation.impl;

import com.example.excelimport.annotation.ExcelName;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ExcelNameImpl {
    public static String getExcelFileName(Class klass){
        // 获取文件名注解
        ExcelName annotation = (ExcelName) klass.getAnnotation(ExcelName.class);
        // StringBuilder 拼接文件名
        StringBuilder builder = new StringBuilder();
        // 拼接前缀
        if (!StringUtils.isEmpty(annotation.prefix())){
            builder.append(annotation.prefix()).append(" ");
        }
        // 拼接文件名
        String filename = annotation.value();
        builder.append(filename).append(" ");
        // 拼接时间
        if (annotation.enableDateTime()){
            DateFormat dateFormatter = new SimpleDateFormat(annotation.dateTimeFormat());
            String currentDateTime = dateFormatter.format(new Date());
            builder.append(currentDateTime).append(" ");
        }
        // 拼接后缀
        if (!StringUtils.isEmpty(annotation.suffix())){
            builder.append(annotation.suffix());
        }
        return builder.toString();
    }
}
