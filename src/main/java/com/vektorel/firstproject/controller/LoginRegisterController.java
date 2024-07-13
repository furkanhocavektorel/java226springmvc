package com.vektorel.firstproject.controller;

import com.vektorel.firstproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginRegisterController {
    @Autowired
    CustomerService customerService;


    @GetMapping("")
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

    @PostMapping("register-button")
    public Object registerButton(String name,
                               String surname,
                               String username,
                               String email,
                               String password){

        System.out.println(name);
        System.out.println(surname);
        System.out.println(username);
        System.out.println(email);
        System.out.println(password);

        customerService.save(name,surname,username,email,password);


        //alınan veriler db ye kaydedilmeli



        //1. yöntem
  /*      ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;*/

        //2.yöntem
        return "redirect:/login";


    }






}
