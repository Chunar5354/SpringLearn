package com.example.mybatisxml.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Goods{
    private Long id;
    private String goodsName;
    private Integer price;
    private String imgList;

    public Goods(Long id, String goodsName, Integer price, String imgList) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.imgList = imgList;
    }
}