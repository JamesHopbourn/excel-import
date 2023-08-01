package com.example.excelimport.annotation.excel.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCellStyleUtil {
    /**
     * Description 的字体设置
     * @param workbook
     * @return
     */
    public static CellStyle getDescriptionStyle(XSSFWorkbook workbook){
        // Attention 的字体设置
        Font descriptionFont = workbook.createFont();
        descriptionFont.setFontName("宋体");
        descriptionFont.setColor(IndexedColors.RED.getIndex());
        descriptionFont.setFontHeightInPoints((short) 12);
        // Attention 的单元格样式设置
        CellStyle descriptionCellStyle = workbook.createCellStyle();
        descriptionCellStyle.setAlignment(HorizontalAlignment.CENTER);
        descriptionCellStyle.setFont(descriptionFont);
        // 横向竖向居中
        descriptionCellStyle.setAlignment(HorizontalAlignment.CENTER);
        descriptionCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return descriptionCellStyle;
    }

    /**
     * 普通字段的字体设置
     * @param workbook
     * @return
     */
    public static CellStyle getNormalStyle(XSSFWorkbook workbook){
        Font requireFieldFont = workbook.createFont();
        requireFieldFont.setFontName("宋体");
        requireFieldFont.setColor(IndexedColors.BLACK.getIndex());
        requireFieldFont.setFontHeightInPoints((short) 12);
        // 必填单元格样式设置
        CellStyle requireCellStyle = workbook.createCellStyle();
        requireCellStyle.setFont(requireFieldFont);
        // 横向竖向居中
        requireCellStyle.setAlignment(HorizontalAlignment.CENTER);
        requireCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return requireCellStyle;
    }

    /**
     * 必填字段的字体设置
     * @param workbook
     * @return
     */
    public static CellStyle getRequireStyle(XSSFWorkbook workbook){
        Font requireFieldFont = workbook.createFont();
        requireFieldFont.setFontName("宋体");
        requireFieldFont.setColor(IndexedColors.RED.getIndex());
        requireFieldFont.setFontHeightInPoints((short) 12);
        // 必填单元格样式设置
        CellStyle requireCellStyle = workbook.createCellStyle();
        requireCellStyle.setFont(requireFieldFont);
        // 横向竖向居中
        requireCellStyle.setAlignment(HorizontalAlignment.CENTER);
        requireCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return requireCellStyle;
    }
}
