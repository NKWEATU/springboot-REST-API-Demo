package net.javaguides.springboot_rest_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    //for HTTP request we use the @GetMapping annotation
    // http://localhost:8083/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!, this is my first web application guys!";
    }

}
