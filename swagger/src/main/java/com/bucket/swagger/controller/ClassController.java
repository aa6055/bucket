package com.bucket.swagger.controller;

import com.bucket.swagger.dto.ClassDO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author wei.wang
 */
@RestController
@Api(value = "班级")
@RequestMapping("/class")
public class ClassController {

    @GetMapping("/getClass/{cid}")
    public ClassDO getClass(@PathVariable("cid") Integer cid) {
        ClassDO classDO = new ClassDO();
        classDO.setId(cid);
        classDO.setClassName("班级"+cid);
        classDO.setGrade("一年级");
        classDO.setSubject("语文");
        return classDO;
    }

    @PostMapping("/saveClass")
    public ClassDO saveClass(@RequestBody ClassDO classDO){
        classDO.setId(new Random().nextInt(100));
        return classDO;
    }
}
