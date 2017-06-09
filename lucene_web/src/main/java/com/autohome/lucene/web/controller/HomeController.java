package com.autohome.lucene.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/9/13.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/home/index.htm";
    }
}
