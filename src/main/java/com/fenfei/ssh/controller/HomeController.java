package com.fenfei.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shefenfei on 2017/8/14.
 */
@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping(path = "/index")
    public String index() {
        return "admin/index";
    }
}
