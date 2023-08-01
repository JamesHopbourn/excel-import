package com.example.excelimport.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.ColorEnums;
import com.example.excelimport.annotation.ExcelName;
import com.example.excelimport.annotation.ExcelProperties;
import lombok.Data;

@Data
@ExcelName("这是用户表")
public class User {
    @ExcelProperties(uniqueField = true)
    @Excel(name = "用户名")
    private String name;

    @ExcelProperties
    @Excel(name = "密码")
    private String password;

    @Excel(name = "性别")
    @ExcelProperties(value = ColorEnums.BLACK, description = "男或者女")
    private String gender;

    @Excel(name = "备注")
    @ExcelProperties()
    private String note;
}
