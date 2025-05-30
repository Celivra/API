package com.celivra.api.Mapper;

import com.celivra.api.Entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("select * from order")
    Order getOrder(Long id);

    @Insert("insert into order(userid, produceid, quantity, status) " +
            "values(#{userId}, #{produceId}, #{quantity}, #{status})")
    void insert(Order order);

    @Delete("delete from order where id = #{id}")
    void delete(Long id);
}
