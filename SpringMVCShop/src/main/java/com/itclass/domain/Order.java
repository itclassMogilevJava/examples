package com.itclass.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
    private Long userId;
    private Double totalPrice;
}
