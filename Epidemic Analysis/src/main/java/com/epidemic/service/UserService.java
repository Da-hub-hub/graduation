package com.epidemic.service;


import com.epidemic.dao.UserMapper;
import com.epidemic.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户名和密码进行用户登录
     * @param user
     * @return
     */

    public UserInfo findByAccount(UserInfo user) {
        return userMapper.findByAccount(user);
    }
}
