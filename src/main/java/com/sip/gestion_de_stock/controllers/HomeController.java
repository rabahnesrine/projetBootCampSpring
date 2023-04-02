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
        return "dashboard/dashboard.html";
    }
    @RequestMapping(value={"login"})

    public String login() {
        return "login.html";
    }
    @RequestMapping(value={"signup"})

    public String registration() {
        return "registration.html";
    }

    public String forgotPassword() {
        return "";
    }
}
