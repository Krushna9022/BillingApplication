package com.bill.exception;

import com.bill.model.User;



public class CustomerNotFound extends RuntimeException {
    User user;
    public CustomerNotFound(User user)
    {
        this.user=user;
    }

    public String getMsg() {
        return "user not found with "+user.getEmail()+"\t"+user.getPassword();
    }
}
