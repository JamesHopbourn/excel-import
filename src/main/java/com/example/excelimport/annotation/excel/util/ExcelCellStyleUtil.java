package com.example.excelimport.annotation.excel.util;

import com.example.excelimport.annotation.excel.pojo.ExcelConstant;
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
        descriptionFont.setFontName(ExcelConstant.FONT_NAME);
        descriptionFont.setColor(IndexedColors.BLACK.getIndex());
        descriptionFont.setFontHeightInPoints(ExcelConstant.FONT_HEIGHT_IN_POINTS);
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
        requireFieldFont.setFontName(ExcelConstant.FONT_NAME);
        requireFieldFont.setColor(IndexedColors.BLACK.getIndex());
        requireFieldFont.setFontHeightInPoints(ExcelConstant.FONT_HEIGHT_IN_POINTS);
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
        requireFieldFont.setFontName(ExcelConstant.FONT_NAME);
        requireFieldFont.setColor(IndexedColors.RED.getIndex());
        requireFieldFont.setFontHeightInPoints(ExcelConstant.FONT_HEIGHT_IN_POINTS);
        // 必填单元格样式设置
        CellStyle requireCellStyle = workbook.createCellStyle();
        requireCellStyle.setFont(requireFieldFont);
        // 横向竖向居中
        requireCellStyle.setAlignment(HorizontalAlignment.CENTER);
        requireCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return requireCellStyle;
    }
}
