package com.excelDemo.controller;

import com.excelDemo.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/excel")
public class ExcelImportController {

    @Autowired
    ExcelImportService excelImportService;

    @GetMapping("/test1")
    @ResponseBody
    public Boolean test1(){
        excelImportService.test1();
        return true;
    }

    @GetMapping("/test2")
    @ResponseBody
    public Boolean test2(){
        excelImportService.test2();
        return true;
    }
}
