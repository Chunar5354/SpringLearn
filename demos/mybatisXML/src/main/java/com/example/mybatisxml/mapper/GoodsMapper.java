package com.example.mybatisxml.mapper;

import com.example.mybatisxml.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> getAll();

    Goods getById(@Param("id") Long id);

    int insert(@Param("id") Long id, @Param("goodsName") String goodsName, @Param("price") Integer price, @Param("imgList") String imgList);

    int delete(@Param("num") Integer num);

    int update(@Param("newName") String newName, @Param("num") Integer num);
}
