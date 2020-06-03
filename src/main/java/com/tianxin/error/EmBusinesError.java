package com.tianxin.error;

public enum EmBusinesError implements  CommonError{
    //定义通用错误类型00001
    PARAMETRT_VALIDATION_ERROR(00001,"参数不合法"),
    UNKNOWN_ERROR(00002,"未知错误"),

    //10000开头为用户相关错误定义
    USER_NOT_EXIST(10001,"用户不存在"),
    USER_lOGIN_FAIL(10002,"用户或者密码不正确"),
    USER_NOT_lOGIN(10003,"用户还未登录"),

    //20000 开头为 文章相关错误定义
    Article_Not_EXIST(20001,"分类不存在"),
    ;



    private  int errcode;
    private  String errMsg;

    private EmBusinesError(int errcode, String errMsg){
        this.errcode=errcode;
        this.errMsg=errMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errcode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String ErrMsg) {
        this.errMsg=ErrMsg;
        return this;
    }
}
