package com.trues.service.model;

/**
 * User: son.nguyen
 * Date: 10/28/13
 * Time: 8:50 PM
 */
public class BaseModel {

    private String hasResult;

    public void setHasResult(String hasResult) {
        this.hasResult = hasResult;
    }

    public boolean isNoResult() {
        return "NODATA".equals(hasResult);
    }
}
