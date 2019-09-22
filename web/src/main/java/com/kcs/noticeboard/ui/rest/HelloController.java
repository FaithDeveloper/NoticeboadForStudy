package com.kcs.noticeboard.ui.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/intro")
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/hello", params = "name")
    public String hello(final @RequestParam String name){
        return "hello : " + name;
    }
}
