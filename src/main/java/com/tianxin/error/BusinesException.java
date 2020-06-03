package com.tianxin.error;

public class BusinesException extends Exception implements CommonError {

    private  CommonError commonError;

    public BusinesException(CommonError commonError){
        super();
        this.commonError=commonError;
    }

    public  BusinesException(CommonError commonError ,String errMsg){
        super();
        this.commonError=commonError;
        this.commonError.setErrorMsg(errMsg);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String ErrMsg) {
        this.commonError.setErrorMsg(ErrMsg);
        return this;
    }
}
