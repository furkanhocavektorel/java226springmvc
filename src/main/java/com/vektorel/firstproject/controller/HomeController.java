package com.vektorel.firstproject.controller;

import com.vektorel.firstproject.dto.HomeResponse;
import com.vektorel.firstproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    // ad , fiyat,url
    @GetMapping("")
    public ModelAndView homePage(){

        HomeResponse response= new HomeResponse();

        response.setProducts(productService.productResponseForHomePage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("model", response);
        return modelAndView;
    }
}
