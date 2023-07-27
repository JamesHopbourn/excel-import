package com.example.excelimport.entity;


import com.example.excelimport.annotation.ColorEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelField {
    /**
     * 字段名称
     */
    private String name;
    /**
     * 字段描述
     */
    private String description;
    /**
     * 文字颜色
     */
    private ColorEnums color;
    /**
     * 单元格长度
     */
    private Integer length;
    /**
     * 单元格位置
     */
    private String orderNum;
}
