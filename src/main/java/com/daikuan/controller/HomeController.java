package com.daikuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
       // System.out.println("121");
        return "/index.jsp";

    }
}
