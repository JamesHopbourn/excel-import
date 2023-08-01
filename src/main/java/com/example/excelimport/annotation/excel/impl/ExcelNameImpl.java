package com.example.excelimport.annotation.excel.impl;

import com.example.excelimport.annotation.excel.ExcelName;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelNameImpl {
    public static String getExcelFileName(Class klass) throws UnsupportedEncodingException {
        // 获取文件名注解
        ExcelName annotation = (ExcelName) klass.getAnnotation(ExcelName.class);
        // StringBuilder 拼接文件名
        StringBuilder builder = new StringBuilder();
        // 拼接前缀
        if (!StringUtils.isEmpty(annotation.prefix())){
            builder.append(annotation.prefix()).append(" ");
        }
        // 拼接文件名
        builder.append(annotation.value());
        // 拼接时间
        if (annotation.enableDateTime()){
            DateFormat dateFormatter = new SimpleDateFormat(annotation.dateTimeFormat());
            builder.append(" ").append(dateFormatter.format(new Date()));
        }
        // 拼接后缀
        if (!StringUtils.isEmpty(annotation.suffix())){
            builder.append(" ").append(annotation.suffix());
        }
        // 文件名编码
        builder.trimToSize();
        String excelFilename = URLEncoder.encode(builder.append(".xlsx").toString(), "UTF-8")
                .replace("+", "%20");
        return "attachment; filename*=UTF-8''" + excelFilename;
    }

    public static String getAttentionNote(Class klass){
        StringBuilder builder = new StringBuilder();
        ExcelName annotation = (ExcelName) klass.getAnnotation(ExcelName.class);
        builder.append(annotation.attention());
        if (annotation.operationLog()){
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 模拟获取系统获取当前登陆用户信息
            String operationLog = "\n\n导出人：admin    导出时间：" + dateFormatter.format(new Date());
            builder.append(operationLog);
        }
        return builder.toString();
    }
}
