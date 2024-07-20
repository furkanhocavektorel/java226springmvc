package com.vektorel.firstproject.controller;

import com.vektorel.firstproject.dto.CategorySaveRequestDto;
import com.vektorel.firstproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("newcategory")
    public Object createCategory(CategorySaveRequestDto dto){
        boolean b=categoryService.save(dto);
        if (b){
            return "redirect:/newproduct";
        }else {
            return "redirect:/category/newcategory";
        }
    }

    @GetMapping("newcategory")
    public ModelAndView createCategory(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("createcategory");
        return modelAndView;
    }



}
