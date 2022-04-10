package com.excelDemo.entity;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private String sex;
}
