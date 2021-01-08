package com.epidemic.dao;

import com.epidemic.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {
    //获取所有角色
    @Select("SELECT * FROM SYS_ROLE WHERE ID=#{id}")
    List<Role> findByName(@Param("id") int id);
}
