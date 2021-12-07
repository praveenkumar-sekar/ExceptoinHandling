package com.demoexception.springdemo.controller;

import com.demoexception.springdemo.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class HelloController {
    @RequestMapping("api/accounts/{accountId}")
    public ResponseEntity<Account> getAccounts(@PathVariable("accountId") String accountID) {

        //hard coded output

        Account account = new Account();
        account.setAccountId(accountID);
        account.setName("Welocme to my home page ");

        if (accountID.equals("4")) {
            throw new IllegalArgumentException();
        }
        if (accountID.equals("5")) {
            throw new IllegalStateException();
        }

        //response
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @ExceptionHandler(value = { IllegalStateException.class})
    protected ResponseEntity<Object> handleException(IllegalStateException e) {
        return new ResponseEntity<Object>("illegal arg exception in global", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleException(IllegalArgumentException e) {
        return new ResponseEntity<Object>("illegal arg exception in controller", HttpStatus.BAD_REQUEST);
    }

    }


