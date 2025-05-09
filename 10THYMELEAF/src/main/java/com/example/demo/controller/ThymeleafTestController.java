package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/th")
public class ThymeleafTestController {

    @GetMapping("/test1")
    public void test1() {
        log.info("GET/th/test1...");
    }
}
