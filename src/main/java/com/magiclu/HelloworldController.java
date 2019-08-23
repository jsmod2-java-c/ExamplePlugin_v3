package com.magiclu;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * web api
 */
@RestController
public class HelloworldController {

    public HelloworldController(){
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
