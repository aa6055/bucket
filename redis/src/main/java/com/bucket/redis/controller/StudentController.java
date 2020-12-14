package com.bucket.redis.controller;

import com.alibaba.fastjson.JSONObject;
import com.bucket.redis.dto.StudentDO;
import com.bucket.redis.service.RedisService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author wei.wang
 */
@RestController
@Api(value = "班级")
@RequestMapping("/class")
public class StudentController {
    @Resource
    RedisService redisService;

    @GetMapping("/getStudent/{stuId}")
    public StudentDO getClass(@PathVariable("stuId") Integer stuId) {
        String value = redisService.getKey("STUDENT-" + stuId);
        return JSONObject.parseObject(value,StudentDO.class);
    }

    @PostMapping("/saveStudent")
    public StudentDO saveStudent(@RequestBody StudentDO studentDO) {
        studentDO.setId(new Random().nextInt(100));
        redisService.saveKey("STUDENT-"+studentDO.getId(),JSONObject.toJSONString(studentDO));
        return studentDO;
    }
}
