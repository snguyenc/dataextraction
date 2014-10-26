package com.trues.service.model;

/**
 * User: son.nguyen
 * Date: 9/21/14
 * Time: 5:19 PM
 */
public class QEM_ROUTE extends BaseModel{

    private String product;
    private String grading;
    private String keyword;
    private String priority;
    private String note;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
