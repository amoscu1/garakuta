package com.czm.gatewaystarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {

    @GetMapping("/web/")
    public void forwardController() {
        System.out.println("Active forward controller");
    }

}
