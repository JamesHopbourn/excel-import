package com.example.excelimport.controller.system;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.excelimport.annotation.impl.ExcelPropertiesImpl;
import com.example.excelimport.util.ExcelGenerateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseController {
    public <T> void importExcelData(HttpServletRequest request, HttpServletResponse response, Class klass) throws Exception {
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

        // 异常提前返回
        if (list == null) {
            response.getWriter().println("空数据！");
        }

        System.out.println("原始数据元素：" + list.size());
        // 获取所有必填字段
        List<String> allRequireField = ExcelPropertiesImpl.getAllRequireField(klass);
        // 使用迭代器删除必填字段包含 null 的数据行
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            Class<?> aClass = next.getClass();
            for (String requireField : allRequireField) {
                Field field = aClass.getDeclaredField(requireField);
                // 必须设置 Accessible = true 允许访问私有属性，否则执行下面这行会报错：
                // can not access a member XXX with modifiers "private"
                field.setAccessible(true);
                if (StringUtils.isEmpty((CharSequence) field.get(next))) {
                    System.out.println(iterator);
                    iterator.remove();
                }
            }
        }

//        list.forEach(System.out::println);
    }

    public void downloadExcel(HttpServletResponse response, Class klass) throws IOException {
        // 时间日期
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        // 文件名编码
        String filename = "提单信息表 " + currentDateTime + ".xlsx";
        filename = URLEncoder.encode(filename, "UTF-8").replace("+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
        // MIME
        response.setContentType("application/vnd.ms-excel;");
        // 缓存协议 HTTP 1.0
        response.setHeader("Pragma", "no-cache");
        // 缓存协议 HTTP 1.1
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        // 导出文件
        Workbook workbook = ExcelGenerateUtil.outputExcel(klass);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
