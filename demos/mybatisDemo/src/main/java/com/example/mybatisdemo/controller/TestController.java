package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.Goods;
import com.example.mybatisdemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("")
    @ResponseBody
    public String test() {
        //int res = goodsService.insert(2L, "g1", 123, "i3/i4");
        List<Goods> goodsList = goodsService.getByName("g1");
        if (goodsList != null) {
            System.out.println(goodsList);
            /*
            for (Goods goods : goodsList) {
                return goods.getGoodsName();
            }
            */
            return "Get Succeed";
        } else {
            System.out.println("get Failed");
            return "Get Failed";
        }
    }
}
