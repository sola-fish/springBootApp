package com.jd.jone.sample.service;

import org.springframework.stereotype.Service;

@Service
public class SwitchServiceImpl implements SwitchService{

    @Override
    public String echoStr(String str){
        return str;
    }
}
