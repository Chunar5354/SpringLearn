package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;


@Service
public class GoodsService implements GoodsServiceInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    private RowMapper<Goods> getByIdMappper() {
        RowMapper<Goods> goodsRowMapper = (ResultSet rs, int rownum) -> {
            System.out.println(rs);
            Goods goods = new Goods();
            goods.setId(rs.getLong("id"));
            goods.setGoodsName(rs.getString("goodsName"));
            goods.setPrice(rs.getInt("price"));
            goods.setImgList(rs.getString("imgList"));
            return goods;
        };
        return goodsRowMapper;
    }
    */

    @Override
    public Goods getById(Long id) {
        String sql = "select * from Goods where id = ?";
        Object[] params = new Object[]{id};
        //Goods goods = jdbcTemplate.queryForObject(sql, params, getByIdMappper());
        Goods goods = jdbcTemplate.queryForObject(sql, params, new GoodsMapper());
        return goods;
    }

    @Override
    public List<Goods> getByName(String goodsName) {
        String sql = "select * from Goods where goodsName = ?";
        Object[] params = new Object[]{goodsName};
        List<Goods> goods = jdbcTemplate.query(sql, params, new GoodsMapper());
        return goods;
    }

    @Override
    public Integer insert(Long id, String goodsName, Integer price, String imgList) {
        String sql = "insert into Goods values(?, ?, ?, ?)";
        int res = jdbcTemplate.update(sql, id, goodsName, price, imgList);
        return res;
    }
}
