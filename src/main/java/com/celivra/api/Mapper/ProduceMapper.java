package com.celivra.api.Mapper;

import com.celivra.api.Entity.Produce;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProduceMapper {
    @Select("select * from produce where id=#{id}")
    Produce findById(Long id);
    @Select("select * from produce")
    List<Produce> findAll();

    @Insert("insert into produce(name, price, quantity, brand, type, description) " +
            "values(#{name}, #{price}, #{quantity}, #{brand}, #{type}, #{description})")
    void insert(Produce produce);
    @Delete("delete from produce where id = #{id}")
    void delete(Long id);

}
