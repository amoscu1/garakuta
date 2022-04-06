package com.czm.gatewaystarter.controller;

import com.czm.gatewaystarter.service.IDoSomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class BeginController {

    @Autowired
    private IDoSomeService doSomeService;

    @GetMapping("/begin")
    public String beginController() {
        return doSomeService.doSome();
    }

    @GetMapping("/fallback")
    public void emptyController() {
        System.out.println("Fallback test start!");
        doSomeService.doAnother();
    }
}
