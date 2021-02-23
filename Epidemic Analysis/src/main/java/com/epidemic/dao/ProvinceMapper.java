package com.epidemic.dao;

import com.epidemic.entity.Province;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceMapper {
    @Select("select * from province_data")
    List<Province> findAll();
}
