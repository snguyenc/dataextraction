package com.trues.service.model;

/**
 * User: son.nguyen
 * Date: 10/28/13
 * Time: 11:29 AM
 */
public class DBObject <T>{

    private String errorMsg;
    private int errorCode;
    private T result;


    public DBObject() {
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
