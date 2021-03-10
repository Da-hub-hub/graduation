package com.epidemic.dao;

import com.epidemic.entity.Global;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlobalMapper {
    @Select("select * from global_data")
    List<Global> findAll();


}
