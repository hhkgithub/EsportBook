package com.esportbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hhkmac on 2017/4/17.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET,consumes = "application/json")
    public Map<String, String> index(){
        Logger logger =  LoggerFactory.getLogger(this.getClass());
        logger.info("111111111");
        Map<String,String> m = new HashMap<String,String>();
        m.put("AA","hello");
        m.put("BB","world");
        return m;
    }
}
