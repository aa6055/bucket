package com.bucket.redis.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDO implements Serializable {
    private Integer id;
    private String name;
    private String className;
    private String grade;
}
