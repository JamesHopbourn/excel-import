package com.example.excelimport.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.ColorEnums;
import com.example.excelimport.annotation.ExcelProperties;
import com.example.excelimport.entity.system.TatiumEntity;
import lombok.Data;

@Data
public class User extends TatiumEntity {
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
