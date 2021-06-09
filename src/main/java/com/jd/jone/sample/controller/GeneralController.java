package com.jd.jone.sample.controller;


import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;

import com.jd.jone.sample.service.SwitchService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import com.jd.jone.sample.bean.User;

import javax.annotation.Resource;

/**
 * Created by pengchang on 12/09/2018.
 */

@RestController
public class GeneralController {
    @Value("${application.magic:default_application_magic}")
    public String magic;

    @Resource
    private SwitchService xService;

    @RequestMapping(value = "/magic")
    public String index(@RequestParam(value = "name", defaultValue = "hello ldy") String name) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return this.magic + ":" + dateString + ":" + name + "\n";
    }

    @RequestMapping(value = "/get")
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }

    @RequestMapping(value = "/get/{id}/{name}")
    public User getUser(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }

    @RequestMapping(value = "/xyz")
    public HashMap<String, Object> xyz(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", xService.echoStr(name));
        return map;
    }

}
