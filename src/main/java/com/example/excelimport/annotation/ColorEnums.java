package com.example.excelimport.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ColorEnums {
    RED("红色"),
    GREEN( "绿色"),
    BLACK( "黑色"),
    YELLOW( "黄色");

    private final String colorCode;
}
