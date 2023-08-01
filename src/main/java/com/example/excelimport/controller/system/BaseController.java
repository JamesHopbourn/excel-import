package com.example.excelimport.controller.system;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.core.util.ReflectUtil;
import com.example.excelimport.annotation.ExcelConstant;
import com.example.excelimport.annotation.impl.ExcelNameImpl;
import com.example.excelimport.annotation.impl.ExcelPropertiesImpl;
import com.example.excelimport.util.ExcelGenerateUtil;
import org.apache.poi.ss.usermodel.Workbook;
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

public class BaseController {

    public static Field[] getAllFields(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public <T> void importExcelData(HttpServletRequest request, HttpServletResponse response, Class klass) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

        List<T> list = null;
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile file = entity.getValue();
            ImportParams params = new ImportParams();
            params.setTitleRows(ExcelConstant.titleRows);
            params.setHeadRows(ExcelConstant.headRows);
            params.setNeedSave(false);
            list = ExcelImportUtil.importExcel(file.getInputStream(), klass, params);
        }

        // 异常提前返回
        if (list == null) {
            response.getWriter().println("空数据！");
        }

        // 过滤唯一字段
        List<String> uniqueField = ExcelPropertiesImpl.getUniqueField(list, klass);
        System.out.println("uniqueField = " + uniqueField);

        // 获取所有字段
        Field[] allFields = getAllFields(klass);
        // 获取所有必填字段
        List<String> allRequireField = ExcelPropertiesImpl.getAllRequireField(klass);
        // 所有需要保存的数据行 == 保存成功的数据列表（如果业务场景需要，可用使用）
        List<T> rowNeedToSave = new ArrayList<>();
        // 必填字段缺失的数据列表（如果业务场景需要，可用使用）
        List<T> rowMissingRequiredFieldList = new ArrayList<>();
        // 遍历所有数据行
        for (T row : list) {
            boolean doSave = true;
            for (Field field : allFields) {
                field.setAccessible(true);
                // 判断是否存在必填项未填写的单元格
                if (allRequireField.contains(field.getName()) && ReflectUtil.getFieldValue(row, field.getName()) == null){
                    rowMissingRequiredFieldList.add(row);
                    doSave = false;
                    break;
                }
                /*
                下面开始写其他的处理逻辑，例如 ES 数据类型转换
                 */
            }
            // 最后如果 doSave 为 true 就把这行数据添加到 rowNeedToSave
            if (doSave){
                rowNeedToSave.add(row);
            }
        }
        rowNeedToSave.forEach(System.out::println);
    }

    public void downloadExcel(HttpServletResponse response, Class klass) throws IOException {
        // 生成文件名
        String excelFileName = ExcelNameImpl.getExcelFileName(klass);
        response.setHeader("Content-Disposition", excelFileName);
<<<<<<< HEAD
=======
        // MIME
        response.setContentType("application/vnd.ms-excel;");
>>>>>>> refs/remotes/origin/master
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
