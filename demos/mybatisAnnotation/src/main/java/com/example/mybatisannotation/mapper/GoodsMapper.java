package com.example.mybatisannotation.mapper;


import com.example.mybatisannotation.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from Goods")
    List<Goods> getAll();

    @Select("select * from Goods where id=#{id}")
    Goods getById(@Param("id") Long id);

    @Insert("insert into Goods(id, goodsName, price, imgList) values(#{id}, #{goodsName}, #{price}, #{imgList})")
    int insert(@Param("id") Long id, @Param("goodsName") String goodsName, @Param("price") Integer price, @Param("imgList") String imgList);

    @Delete("delete from Goods where id < #{num}")
    int delete(@Param("num") Integer num);

    @Update("update Goods set goodsName=#{newName} where id=#{num}")
    int update(@Param("newName") String newName, @Param("num") Integer num);
}