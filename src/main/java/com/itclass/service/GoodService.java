package com.itclass.service;

import com.itclass.model.Good;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodService {

    public static final List<Good> GOODS = initGoods();

    private static List<Good> initGoods() {
        List<Good> goods = new ArrayList<>();
        goods.add(new Good(1L,"Imya", 1));
        goods.add(new Good(1L,"Imya1", 4));
        goods.add(new Good(1L,"Imya2", 3));
        goods.add(new Good(1L,"Imya3", 6));
        goods.add(new Good(1L,"Imya4", 5));
        goods.add(new Good(1L,"Imya5", 8));
        return goods;
    }
}
