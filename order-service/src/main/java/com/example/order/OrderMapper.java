package com.example.order;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("SELECT id as orderId, user_id as userId, total_amount FROM order_tbl WHERE id = #{orderId}")
    Order getOrderById(String orderId);
}
