package com.fenfei.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shefenfei on 2017/8/25.
 */
@Controller
@RequestMapping(path = "/vm")
public class VelocityController {


    @GetMapping(path = "/hello")
    public String hello(Model model) {
        model.addAttribute("hello" , "hello velocity");
        return "welcome";
    }

}
