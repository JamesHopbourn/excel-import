package com.example.excelimport.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.excelimport.entity.Demo;
import com.example.excelimport.entity.User;
import com.example.excelimport.util.ExcelGenerateUtil;
import com.google.common.collect.Lists;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ExcelController {
    @PostMapping("excel")
    public void importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile file = entity.getValue();
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            params.setHeadRows(1);
            params.setNeedSave(false);
            List<T> list = ExcelImportUtil.importExcel(file.getInputStream(), Demo.class, params);
            List<List<T>> subSets = Lists.partition(list, 1);
            subSets.forEach(System.out::println);
        }
    }

    @GetMapping("down")
    public void download(HttpServletResponse response) throws IOException {
        // 时间日期
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        // 文件名编码
        String filename = "提货订单表 " + currentDateTime + ".xlsx";
        filename = URLEncoder.encode(filename,"UTF-8").replace("+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
        // MIME
        response.setContentType("application/vnd.ms-excel;");
        // 缓存协议 HTTP 1.0
        response.setHeader("Pragma", "no-cache");
        // 缓存协议 HTTP 1.1
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        // 导出文件
        Workbook workbook = ExcelGenerateUtil.outputExcel(User.class);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
