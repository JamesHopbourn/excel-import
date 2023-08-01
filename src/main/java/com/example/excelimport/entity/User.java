package com.example.excelimport.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.excel.pojo.ColorEnums;
import com.example.excelimport.annotation.excel.ExcelName;
import com.example.excelimport.annotation.excel.ExcelProperties;
import lombok.Data;

@Data
@ExcelName(value = "这是用户表", prefix = "PTU", enableDateTime = false)
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
