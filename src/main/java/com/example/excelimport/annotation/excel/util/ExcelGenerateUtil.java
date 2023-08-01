package com.example.excelimport.annotation.excel.util;

import com.example.excelimport.annotation.excel.pojo.ColorEnums;
import com.example.excelimport.annotation.excel.impl.ExcelPropertiesImpl;
import com.example.excelimport.annotation.excel.pojo.ExcelField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelGenerateUtil {
    public static Workbook outputExcel(Class klass){
        XSSFWorkbook workbook = new XSSFWorkbook();
        CellStyle descriptionStyle = ExcelCellStyleUtil.getDescriptionStyle(workbook);

        // 第二行考虑使用 for 循环处理
        List<ExcelField> excelFieldList = ExcelPropertiesImpl.allField(klass);
        // 创建 Sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        // row0 填写 description，row1 填写字段名
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        // 两行基本样式配置
        row1.setHeight((short) 400);
        for (int i = 0; i < excelFieldList.size(); i++) {
            // 字段描述信息
            Cell cellAttention = row0.createCell(i);
            cellAttention.setCellValue(excelFieldList.get(i).getDescription());
            cellAttention.setCellStyle(descriptionStyle);
            // 单元格文字
            Cell cell = row1.createCell(i);
            cell.setCellValue(excelFieldList.get(i).getName());
            // 文字颜色
            ColorEnums color = excelFieldList.get(i).getColor();
            CellStyle cellStyle = color.getCellStyle(workbook, excelFieldList.get(i));
            cell.setCellStyle(cellStyle);
            // 单元格宽度
            Integer length = excelFieldList.get(i).getLength();
            if (length != null){
                sheet.setColumnWidth(i, 256 * length);
            }
        }
        return workbook;
    }
}
