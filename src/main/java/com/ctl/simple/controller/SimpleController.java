package com.ctl.simple.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ctl.simple.model.Word;
import com.ctl.simple.service.SimpleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ctl
 */
@Log4j2
@RestController
@RequestMapping("/simple")
public class SimpleController {

    @Autowired
    private SimpleService simpleService;

    @GetMapping("/get/{text}")
    public String get(@PathVariable(value = "text") String text) {
        log.info("request simple get interface");
        List<Word> wordList = simpleService.get(text);
        return JSON.toJSONString(wordList, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
    }

    @GetMapping("/add/{count}")
    public String add(@PathVariable(value = "count") int count) {
        long start = System.currentTimeMillis();
        log.info("request simple add interface");
        simpleService.add(count);
        long end = System.currentTimeMillis();
        return "add" + count + "条花费时间" + (end - start)  + "毫秒";
    }
}