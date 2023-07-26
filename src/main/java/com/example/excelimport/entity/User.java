package com.example.excelimport.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.ColorEnums;
import com.example.excelimport.annotation.ExcelProperties;
import lombok.Data;

@Data
public class User {
    @ExcelProperties
    @Excel(name = "用户名")
    private String username;

    @ExcelProperties
    @Excel(name = "密码")
    private String password;

    @Excel(name = "密码")
    @ExcelProperties(value = ColorEnums.BLACK, description = "男或者女")
    private String gender;
}
