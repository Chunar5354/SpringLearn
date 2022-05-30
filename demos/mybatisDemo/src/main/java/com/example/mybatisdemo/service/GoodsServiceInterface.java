package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Goods;

import java.util.List;

public interface GoodsServiceInterface {
    public Goods getById(Long id);
    public List<Goods> getByName(String goodsName);
    public Integer insert(Long id, String goodsName, Integer price, String imgList);
}