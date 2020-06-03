package com.tianxin.service.impl;

import com.tianxin.dao.UserMapper;
import com.tianxin.entity.User;
import com.tianxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int createUser(User user) {

        //ToDo 添加测试用户 后期删除
        userMapper.insert(user);

        return 0;
    }

    @Override
    public User validataLogin(String username, String userPassword) {
       User user= userMapper.selectByTelphone(username,userPassword);
        return user;
    }
}
