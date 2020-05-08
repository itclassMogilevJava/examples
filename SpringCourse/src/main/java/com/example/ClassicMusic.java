package com.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("qweqwe")
public class ClassicMusic implements Music{
    public String getSong() {
        return "classic ";
    }
}
