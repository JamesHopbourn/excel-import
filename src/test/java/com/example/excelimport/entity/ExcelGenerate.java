package com.example.excelimport.entity;

import com.alibaba.fastjson.JSON;
import com.example.excelimport.annotation.excel.pojo.ColorEnums;
import com.example.excelimport.annotation.excel.pojo.ExcelField;
import com.example.excelimport.annotation.excel.impl.ExcelPropertiesImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.excelimport.annotation.excel.util.ExcelCellStyleUtil.*;

@SpringBootTest
public class ExcelGenerate {
    @Test
    void getAllField(){
        List<ExcelField> excelFields = ExcelPropertiesImpl.allField(TiDanXinXi.class);
        List<ExcelField> collect = excelFields.stream()
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(o.getOrderNum())))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }
    
    @Test
    public void test2() {
        XSSFWorkbook workbook = new XSSFWorkbook();

        CellStyle descriptionStyle = getDescriptionStyle(workbook);
        CellStyle normalStyle = getNormalStyle(workbook);
        CellStyle requireStyle = getRequireStyle(workbook);

        // 第二行考虑使用 for 循环处理
        List<ExcelField> fieldPOJOList = ExcelPropertiesImpl.allField(TiDanXinXi.class);

        // 创建 Sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        // row0 填写 description，row1 填写字段名
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        // 两行基本样式配置
        row1.setHeight((short) 400);
        for (int i = 0; i < fieldPOJOList.size(); i++) {
            // 字段描述信息
            Cell cellAttention = row0.createCell(i);
            cellAttention.setCellValue(fieldPOJOList.get(i).getDescription());
            cellAttention.setCellStyle(descriptionStyle);
            // 单元格文字
            Cell cell = row1.createCell(i);
            cell.setCellValue(fieldPOJOList.get(i).getName());
            // 文字颜色
            ColorEnums value = fieldPOJOList.get(i).getColor();
            if (value == ColorEnums.RED){
                cell.setCellStyle(requireStyle);
            } else if (value == ColorEnums.BLACK){
                cell.setCellStyle(normalStyle);
            }
            // 单元格宽度
            Integer length = fieldPOJOList.get(i).getLength();
            if (length != null){
                sheet.setColumnWidth(i, 256 * length);
            }
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream("提单信息表.xlsx");
            workbook.write(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
