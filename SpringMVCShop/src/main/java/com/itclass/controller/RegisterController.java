package com.itclass.controller;

import com.itclass.exception.DisagreeException;
import com.itclass.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam(value = "isAgree", required = false) String isAgree,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password   ) {
        if (isAgree == null || !isAgree.equals("on")) {
            throw new DisagreeException("You must agree with a terms!");
        }
        userService.save(login, password);
        return new ModelAndView("login");
    }

    @ExceptionHandler(DisagreeException.class)
    public ModelAndView handleException(DisagreeException ex, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("agreeError", ex.getMessage());
        return modelAndView;
    }
}
