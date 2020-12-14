package com.bucket.swagger.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassDO implements Serializable {
    private Integer id;
    private String className;
    private String subject;
    private String grade;
}
