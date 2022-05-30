package com.example.mybatisannotation.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatisannotation.entity.Goods;
import com.example.mybatisannotation.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableTransactionManagement
@RequestMapping("/test")
public class GoodsController {
    @Autowired
    private GoodsMapper goodsMapper;

    @RequestMapping("/getall")
    @ResponseBody
    public JSONObject getAll() {
        List<Goods> goodsList = goodsMapper.getAll();
        JSONObject jsonRes =new JSONObject();
        for (int i = 0; i < goodsList.size(); i++) {
            jsonRes.put(Integer.toString(i), goodsList.get(i));
        }
        return jsonRes;
    }

    @RequestMapping("/getbyid")
    @ResponseBody
    public JSONObject getById() {
        Goods goods = goodsMapper.getById(1L);
        JSONObject jsonRes =new JSONObject();
        jsonRes.put("data", goods);
        return jsonRes;
    }

    @RequestMapping("/insert")
    public int insert() {
        goodsMapper.insert(1L, "g1", 123, "i1/i2");
        int num = goodsMapper.insert(2L, "g1", 456, "i3/i4");
        return num;
    }

    @RequestMapping("/update")
    public int update() {
        int num = goodsMapper.update("g2", 2);
        return num;
    }

    @RequestMapping("/delete")
    public int delete() {
        int num = goodsMapper.delete(3);
        return num;
    }
}