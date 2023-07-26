package com.example.excelimport.entity;


import com.example.excelimport.annotation.ColorEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelField {
    private String name;
    private String description;
    private ColorEnums color;
    private Integer length;
}
