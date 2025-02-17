package com.bill.exception;

import javax.management.JMRuntimeException;

public class CustomerNotFound extends RuntimeException {
    private String msg;
    public CustomerNotFound(String ms)
    {
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
