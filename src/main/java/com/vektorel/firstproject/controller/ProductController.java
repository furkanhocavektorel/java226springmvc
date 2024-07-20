package com.vektorel.firstproject.controller;

import com.vektorel.firstproject.dto.ProductSaveRequestDto;
import com.vektorel.firstproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("newproduct")
    public ModelAndView newProduct(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("newproduct");
        return modelAndView;
    }

    @PostMapping("newproduct")
    public Object newProduct(ProductSaveRequestDto dto){
       boolean boll= productService.save(dto);
       if (boll){
           return "redirect:/product/newproduct";
       }else {
           return "redirect:/home";
       }
    }

}
