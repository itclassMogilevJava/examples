package com.itclass.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Good {

    private Long id;
    private String title;
    private double price;
}
