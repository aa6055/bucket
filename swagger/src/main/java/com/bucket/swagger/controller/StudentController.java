package com.bucket.swagger.controller;

import com.bucket.swagger.dto.StudentDO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author wei.wang
 */
@RestController
@Api(value = "班级")
@RequestMapping("/class")
public class StudentController {

    @GetMapping("/getStudent/{stuId}")
    public StudentDO getClass(@PathVariable("stuId") Integer stuId) {
        StudentDO stuDo = new StudentDO();
        stuDo.setId(stuId);
        stuDo.setName("学生" + stuId);
        stuDo.setClassName("班级" + stuId);
        stuDo.setGrade("一年级");
        return stuDo;
    }

    @PostMapping("/saveStudent")
    public StudentDO saveStudent(@RequestBody StudentDO studentDO) {
        studentDO.setId(new Random().nextInt(100));
        return studentDO;
    }
}
