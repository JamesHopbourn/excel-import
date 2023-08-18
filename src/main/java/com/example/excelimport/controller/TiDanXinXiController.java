package com.example.excelimport.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.excelimport.annotation.excel.impl.CustomExcelExportStyler;
import com.example.excelimport.controller.system.BaseController;
import com.example.excelimport.entity.TiDanXinXi;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tidanxinxi")
public class TiDanXinXiController extends BaseController {
    @PostMapping("importExcel")
    public void importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.importExcelData(request, response, TiDanXinXi.class);
    }

    @GetMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        super.downloadExcel(response, TiDanXinXi.class);
    }

    @GetMapping("exportMissingRequireDataList")
    public void export(HttpServletResponse response) throws IOException {
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("title");
        exportParams.setSecondTitle("导出人：admin");
        exportParams.setStyle(CustomExcelExportStyler.class);
        // 创建表格
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, TiDanXinXi.class, getUserList());
        // 细节调整
        Cell cell = workbook.getSheetAt(0).getRow(1).getCell(0);
        // Attention 的字体设置
        Font descriptionFont = workbook.createFont();
        descriptionFont.setColor(IndexedColors.RED.getIndex());
        // Attention 的单元格样式设置
        CellStyle descriptionCellStyle = workbook.createCellStyle();
        descriptionCellStyle.setAlignment(HorizontalAlignment.LEFT);
        descriptionCellStyle.setFont(descriptionFont);
        // 使用配置样式
        cell.setCellStyle(descriptionCellStyle);
        // 输出文件
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }

    private List<TiDanXinXi> getUserList() {
        List<TiDanXinXi> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TiDanXinXi tiDanXinXi = new TiDanXinXi();
            tiDanXinXi.setTiDanHao(String.valueOf(i));
            arrayList.add(tiDanXinXi);
        }
        return arrayList;
    }
}
