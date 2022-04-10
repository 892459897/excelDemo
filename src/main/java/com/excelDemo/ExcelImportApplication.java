package com.excelDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.excelDemo.mapper")
@SpringBootApplication
public class ExcelImportApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExcelImportApplication.class, args);
    }
}
