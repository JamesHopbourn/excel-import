package com.example.excelimport.controller;

import com.example.excelimport.controller.system.BaseController;
import com.example.excelimport.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    @PostMapping("importExcel")
    public void importExcel(HttpServletRequest request) throws Exception {
        super.importExcelData(request, User.class);
    }

    @GetMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        super.downloadExcel(response, User.class);
    }
}
