package com.example.excelimport.controller.system;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.excelimport.annotation.excel.impl.ExcelNameImpl;
import com.example.excelimport.annotation.excel.util.ExcelGenerateUtil;
import com.google.common.base.CaseFormat;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BaseController<T, S extends IService<T>>{
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    S service;

    public List<T> getDatabaseExistData(List<String> uniqueFieldList){
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        // TODO 目前只支持一个 key 的标记，以后根据业务场景可能需要支持多个 key
        queryWrapper.select(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, uniqueFieldList.get(0)));
        return service.list(queryWrapper);
    }

    public static Field[] getAllFields(Class klass) {
        List<Field> fieldList = new ArrayList<>();
        while (klass != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(klass.getDeclaredFields())));
            klass = klass.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public void importExcelData(HttpServletRequest request, HttpServletResponse response, Class klass) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

        List<T> list = null;
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile file = entity.getValue();
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            params.setHeadRows(1);
            params.setNeedSave(false);
            list = ExcelImportUtil.importExcel(file.getInputStream(), klass, params);
        }
        System.out.println(list);

    }

    public void downloadExcel(HttpServletResponse response, Class klass) throws IOException {
        // 生成文件名
        String excelFileName = ExcelNameImpl.getExcelFileName(klass);
        response.setHeader("Content-Disposition", excelFileName);
        // 缓存协议 HTTP 1.0
        response.setHeader("Pragma", "no-cache");
        // 缓存协议 HTTP 1.1
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        // 生成文件
        Workbook workbook = ExcelGenerateUtil.outputExcel(klass);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
