package com.example.excelimport.annotation.excel.pojo;

import lombok.Getter;

@Getter
public class ExcelConstant {
    /**
     * 标题行（写注释信息）
     */
    public static final int TITLE_ROWS = 1;

    /**
     * 属性行（写字段名称）
     */
    public static final int HEAD_ROWS = 1;

    /**
     * 单元格文字的字体名
     */
    public static final String FONT_NAME = "宋体";

    /**
     * 以「点」表示的字体高度
     */
    public static final short FONT_HEIGHT_IN_POINTS = 12;
}
