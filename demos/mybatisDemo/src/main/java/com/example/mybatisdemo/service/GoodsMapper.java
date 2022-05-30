package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Goods;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsMapper implements RowMapper<Goods> {
    public Goods mapRow(ResultSet rs, int rownum) throws SQLException {
        Goods goods = new Goods();
        goods.setId(rs.getLong("id"));
        goods.setGoodsName(rs.getString("goodsName"));
        goods.setPrice(rs.getInt("price"));
        goods.setImgList(rs.getString("imgList"));
        return goods;
    }
}
