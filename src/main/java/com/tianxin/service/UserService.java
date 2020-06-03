package com.tianxin.service;

import com.tianxin.entity.User;

public interface UserService {
    int createUser(User user);

    User validataLogin(String username,String userPassword);



}
