package com.sip.gestion_de_stock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping(value={"/","home"})
    //@ResponseBody
    public String home() {
        return "front/index.html";
    }

    public String login() {
        return "";
    }

    public String registration() {
        return "";
    }

    public String forgotPassword() {
        return "";
    }
}
