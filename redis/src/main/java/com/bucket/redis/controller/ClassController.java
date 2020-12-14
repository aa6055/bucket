package com.bucket.redis.controller;

import com.alibaba.fastjson.JSONObject;
import com.bucket.redis.dto.ClassDO;
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
public class ClassController {
    @Resource
    RedisService redisService;

    @GetMapping("/getClass/{cid}")
    public ClassDO getClass(@PathVariable("cid") Integer cid) {
        String value = redisService.getKey("CLASS-" + cid);
        return JSONObject.parseObject(value, ClassDO.class);
    }

    @PostMapping("/saveClass")
    public ClassDO saveClass(@RequestBody ClassDO classDO) {
        classDO.setId(new Random().nextInt(100));
        redisService.saveKey("CLASS-" + classDO.getId(), JSONObject.toJSONString(classDO));
        return classDO;
    }
}
