package com.tianxin;

import com.tianxin.dao.UserMapper;
import com.tianxin.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 * @SpringBootApplication(scanBasePackages = {"com.tianxin"})
 */

@SpringBootApplication(scanBasePackages = {"com.tianxin"})
@RestController
@MapperScan("com.tianxin.dao")
public class App 
{
    @Autowired
    private UserMapper userdoMapper;

    @RequestMapping("/")
    public  String home(){
        User user=userdoMapper.selectByPrimaryKey(1);
        if(user==null){
            return "用户对象不存在";
        }else{
            return user.getNickname();
        }
    }



    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }


}
