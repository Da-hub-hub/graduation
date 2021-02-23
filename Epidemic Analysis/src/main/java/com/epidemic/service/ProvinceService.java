package com.epidemic.service;

import com.epidemic.dao.ProvinceMapper;
import com.epidemic.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceService {
    @Autowired
    ProvinceMapper provinceMapper;
    public List<Province> findAll(){
        return provinceMapper.findAll();
    }
}
