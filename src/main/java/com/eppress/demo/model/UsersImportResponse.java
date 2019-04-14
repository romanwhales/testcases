package com.eppress.demo.model;

public class UsersImportResponse {
    private int retryCount;
    private String status;

    public UsersImportResponse(int retryCount,String status){
        this.retryCount = retryCount;
        this.status = status;
    }

    @Override
    public String toString(){
        return "UsersImport Response [retryCount = "+ retryCount + ", status " +
                "= "+ status + "]";

    }

    public int getRetryCount(){
        return retryCount;
    }

    public String getStatus(){
        return status;
    }


}
