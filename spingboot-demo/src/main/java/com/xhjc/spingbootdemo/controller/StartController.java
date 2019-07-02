package com.xhjc.spingbootdemo.controller;

import com.xhjc.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-01 16:37
 **/
@RestController
public class StartController {

    @Autowired
    HelloService helloService;
    @GetMapping("/startHello")
    public String hello(){
        return helloService.sayHello("test");
    }
}
