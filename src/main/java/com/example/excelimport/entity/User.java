package com.example.excelimport.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.excelimport.annotation.excel.ExcelName;
import com.example.excelimport.annotation.excel.ExcelProperties;
import com.example.excelimport.annotation.excel.pojo.ColorEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ExcelName(value = "用户表", prefix = "PTU", attentionNote = "红色为必填字段\n黑色为可选字段")
public class User {
    @Excel(name = "ID")
    @ExcelProperties(uniqueField = true)
    private String id;

    @Excel(name = "用户名")
    private String name;


    @Excel(name = "性别")
    @ExcelProperties(value = ColorEnums.BLACK, description = "男或者女")
    private String gender;

    @Excel(name = "备注")
    @ExcelProperties()
    private String note;
}
