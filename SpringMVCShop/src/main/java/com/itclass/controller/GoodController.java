package com.itclass.controller;

import com.itclass.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class GoodController {
    private final GoodService goodService;

    @GetMapping("/goods")
    public ModelAndView goods() {
        ModelAndView modelAndView = new ModelAndView("goods");
        modelAndView.addObject("goods", goodService.findAll());
        return modelAndView;
    }
}
