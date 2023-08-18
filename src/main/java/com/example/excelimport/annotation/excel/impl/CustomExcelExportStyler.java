package com.example.excelimport.annotation.excel.impl;

import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import org.apache.poi.ss.usermodel.*;

public class CustomExcelExportStyler extends ExcelExportStylerDefaultImpl {
    public CustomExcelExportStyler(Workbook workbook) {
        super(workbook);
    }

    /**
     * 第一行 row0
     * @param color
     * @return
     */
    @Override
    public CellStyle getHeaderStyle(short color) {
        Font requireFieldFont = workbook.createFont();
        requireFieldFont.setFontName("宋体");
        requireFieldFont.setColor(IndexedColors.RED.getIndex());
        
        requireFieldFont.setFontHeightInPoints((short) 12);

        CellStyle headerStyle = this.workbook.createCellStyle();
        headerStyle.setFont(requireFieldFont);
        headerStyle.setAlignment(HorizontalAlignment.LEFT);
        return headerStyle;
    }
    
    @Override
    public CellStyle getTitleStyle(short color) {
        Font requireFieldFont = workbook.createFont();
        requireFieldFont.setFontName("宋体");
        requireFieldFont.setColor(IndexedColors.RED.getIndex());

        requireFieldFont.setFontHeightInPoints((short) 12);

        CellStyle headerStyle = this.workbook.createCellStyle();
        headerStyle.setFont(requireFieldFont);
        headerStyle.setAlignment(HorizontalAlignment.LEFT);
        return headerStyle;
    }
}
