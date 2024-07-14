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
    public ModelAndView register(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("")
    public Object register(String name,
                                 String surname,
                                 String username,
                                 String email,
                                 String password){

        customerService.save(name,surname,username,email,password);

        //alınan veriler db ye kaydedilmeli
        //1. yöntem
  /*      ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;*/

        //2.yöntem
        return "redirect:/login";

    }


    @GetMapping("login")
    public ModelAndView login(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("login")
    public Object login (String username,String password){
        System.out.println(username);
        boolean bool=customerService.login(username,password);

        if (bool){
            return "redirect:/home";
        }else {
            return "redirect:/login";
        }

    }







}
