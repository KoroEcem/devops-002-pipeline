package com.ecemkoro.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class DevOpsController {

    // http://localhost:8888
    @GetMapping
    public String devopsHello (){
        return "DevOps World : " + LocalDateTime.now();
    }

    // http://localhost:8888/info
    @GetMapping("/info")
    public String info (){
        return "DEVOPS INFO : " + LocalDateTime.now();
    }


}
