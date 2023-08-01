package com.example.excelimport.annotation;

import com.example.excelimport.entity.ExcelField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Getter
@AllArgsConstructor
public enum ColorEnums {
    RED("红色", IndexedColors.RED.getIndex()),
    GREEN( "绿色", IndexedColors.GREEN.getIndex()),
    BLACK( "黑色", IndexedColors.BLACK.getIndex()),
    YELLOW( "黄色", IndexedColors.YELLOW.getIndex());

    private final String colorCode;
    private final short colorEnumCode;

    public CellStyle getCellStyle(XSSFWorkbook workbook, ExcelField excelField){
        // Attention 的字体设置
        Font descriptionFont = workbook.createFont();
        descriptionFont.setFontName("宋体");
        descriptionFont.setColor(excelField.getColor().getColorEnumCode());
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
}
