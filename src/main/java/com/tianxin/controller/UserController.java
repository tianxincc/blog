package com.tianxin.controller;

import com.tianxin.entity.User;
import com.tianxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userServer;


    //用户登录接口
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public String login(@RequestParam(name="username") String username,@RequestParam(name="password") String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user=userServer.validataLogin(username,EncodeByMd5(password));

        return user.getNickname();
    }

    //用户注册接口
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    @ResponseBody
    public int register(@RequestParam(name="nickname") String nickname,
                        @RequestParam(name="username") String username,
                        @RequestParam(name="userPassword") String userPassword,
                        @RequestParam(name="email") String email,
                        @RequestParam(name="remark") String remark) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        User user=new User();
        user.setNickname(nickname);
        user.setUsername(username);
        user.setEmail(email);
        user.setRemark(remark);
        user.setUserPassword(EncodeByMd5(userPassword));

        userServer.createUser(user);
        return 0;
    }


    //简单Md5加密
    public  String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder=new BASE64Encoder();
        //加密字符串
        String newstr=base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return  newstr;
    }

}
