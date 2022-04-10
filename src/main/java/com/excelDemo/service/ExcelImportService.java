package com.excelDemo.service;

import com.excelDemo.entity.User;
import com.excelDemo.mapper.UserMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelImportService {

    @Autowired
    UserMapper userMapper;

    Workbook workbook;

    public void test1(){
        try {
            //获取系统文档
            String filepath = "D:/test.xlsx";
            FileInputStream fis = new FileInputStream(filepath);

            //创建工作薄对象
            if(filepath.endsWith("xls")){
                workbook=new HSSFWorkbook(fis);
            }else {
                workbook=new XSSFWorkbook(fis);
            }

            //创建工作表对象
            Sheet sheet=workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                User user = new User();
                user.setName(row.getCell(0).toString());
                user.setAge(Integer.valueOf(row.getCell(1).toString()));
                user.setSex(row.getCell(2).toString());
                System.out.println("user:"+user);
                userMapper.insert(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test2(){
        try {
            //获取系统文档
            POIFSFileSystem fspoi=new POIFSFileSystem(new FileInputStream("D:/test1.xls"));
            //创建工作薄对象
            HSSFWorkbook workbook=new HSSFWorkbook(fspoi);
            //创建工作表对象
            HSSFSheet sheet=workbook.getSheet("sheet1");

            List<User> userList = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                //得到Excel表格
                HSSFRow row = sheet.getRow(i);
                //得到Excel工作表指定行的单元格
                User user = new User();
                user.setName(row.getCell(0).toString());
                user.setAge(Integer.valueOf(row.getCell(1).toString()));
                user.setSex(row.getCell(2).toString());
                System.out.println("user:"+user);
                userList.add(user);

            }
            userMapper.insertList(userList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
