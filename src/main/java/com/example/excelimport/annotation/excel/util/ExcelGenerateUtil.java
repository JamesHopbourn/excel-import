package com.example.excelimport.annotation.excel.util;

import com.example.excelimport.annotation.excel.impl.ExcelNameImpl;
import com.example.excelimport.annotation.excel.impl.ExcelPropertiesImpl;
import com.example.excelimport.annotation.excel.pojo.ColorEnums;
import com.example.excelimport.annotation.excel.pojo.ExcelConstant;
import com.example.excelimport.annotation.excel.pojo.ExcelField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelGenerateUtil {
    public static Workbook outputExcel(Class klass) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        CellStyle descriptionStyle = ExcelCellStyleUtil.getDescriptionStyle(workbook);

        // 第三行使用 for 循环处理
        List<ExcelField> excelFieldList = ExcelPropertiesImpl.allField(klass);
        // 创建 Sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        // 创建首行注意事项
        Row headRow = sheet.createRow(0);
        // 开启首行换行
        CellStyle headRowStyle = workbook.createCellStyle();
        headRowStyle.setWrapText(true);
        // 创建首行设置样式
        Cell headRowCell = headRow.createCell(0);
        headRowCell.setCellStyle(headRowStyle);
        // 获取注意事项等备注信息
        String attentionNote = ExcelNameImpl.getAttentionNote(klass);
        headRowCell.setCellValue(attentionNote);
        // 根据注意事项文段行数自动调整高度
        int lineNumberOfAttentionNote = attentionNote.split("\n").length;
        headRow.setHeight((short) (ExcelConstant.HEAD_ROW_FONT_HEIGHT_IN_POINTS * lineNumberOfAttentionNote));
        // 合并与字段等宽的单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, excelFieldList.size() - 1));
        // rowDescription 填写 description，rowField 填写字段名
        Row rowDescription = sheet.createRow(1);
        Row rowField = sheet.createRow(2);
        // rowField 字段行单元格高度样式配置
        rowField.setHeight(ExcelConstant.FIELD_ROW_FONT_HEIGHT_IN_POINTS);
        for (int i = 0; i < excelFieldList.size(); i++) {
            // 字段描述信息
            Cell cellAttention = rowDescription.createCell(i);
            cellAttention.setCellValue(excelFieldList.get(i).getDescription());
            cellAttention.setCellStyle(descriptionStyle);
            // 单元格文字
            Cell cell = rowField.createCell(i);
            cell.setCellValue(excelFieldList.get(i).getName());
            // 单元格文字颜色
            ExcelField excelField = excelFieldList.get(i);
            // 有 @Excel 注解但是没有 @ExcelProperties 注解的获取 color 会报 NPE，需要设置一个默认黑色
            if (excelField.getColor() == null) {
                excelField.setColor(ColorEnums.BLACK);
            }
            // 通过获取注解上 color 属性，访问 ColorEnums 枚举类的构造方法，返回颜色对应的单元格样式
            CellStyle cellStyle = excelField.getColor().getCellStyle(workbook, excelFieldList.get(i));
            cell.setCellStyle(cellStyle);
            // 单元格宽度
            Integer length = excelFieldList.get(i).getLength();
            if (length != null) {
                sheet.setColumnWidth(i, 256 * length);
            }
        }
        return workbook;
    }
}
