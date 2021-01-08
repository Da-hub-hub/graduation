package com.epidemic.service;

import com.epidemic.dao.RoleMapper;
import com.epidemic.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

     public List<Role> findByName(int id) {
        return roleMapper.findByName(id);
    }
}
