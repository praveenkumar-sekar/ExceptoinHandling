package com.demoexception.springdemo.model;

public class Account {

    private String accountId;

    public String getAccountId(){
        return accountId;
    }
    public void setAccountId(String accountId){
        this.accountId=accountId;
    }
    public  String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }
    private String name;
}
