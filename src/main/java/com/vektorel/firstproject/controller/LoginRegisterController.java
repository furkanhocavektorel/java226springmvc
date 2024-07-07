package com.vektorel.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lg")
public class LoginRegisterController {

    @GetMapping("register")
    public ModelAndView registerPage(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
