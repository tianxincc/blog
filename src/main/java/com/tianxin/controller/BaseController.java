package com.tianxin.controller;

import com.tianxin.error.BusinesException;
import com.tianxin.error.EmBusinesError;
import com.tianxin.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public  static final   String  CONTENT_TYPE_FROMED="application/x-www-form-urlencoded";

    //定义exceptionhandler 解决未被controller 吸收的异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  Object handlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> responseData=new HashMap<>();
        if( ex instanceof BusinesException){
            BusinesException businessException=(BusinesException)ex;
            responseData.put("errCode",businessException.getErrorCode());
            responseData.put("errMsg",businessException.getErrorMsg());
        }else{
            responseData.put("errCode", EmBusinesError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errMsg",EmBusinesError.UNKNOWN_ERROR.getErrorMsg());
        }

        return CommonReturnType.create(responseData,"fail");
    }

}
