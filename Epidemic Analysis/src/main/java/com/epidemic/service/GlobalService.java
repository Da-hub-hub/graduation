package com.epidemic.service;

import com.epidemic.dao.GlobalMapper;
import com.epidemic.entity.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalService {
    @Autowired
    GlobalMapper globalMapper;
    public List<Global> findAll(){
        return globalMapper.findAll();
    }

}
