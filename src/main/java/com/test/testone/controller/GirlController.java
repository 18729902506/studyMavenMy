package com.test.testone.controller;

import com.test.testone.entity.Girl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GirlController {

    @PostMapping(value="girls")
    public Girl addGirl(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girl;
    }
}
