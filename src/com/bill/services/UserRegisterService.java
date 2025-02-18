package com.bill.services;

import com.bill.model.AdminLogin;
import com.bill.model.CustomerLogin;

import java.util.List;

public interface UserRegisterService {

    boolean registerLogin(CustomerLogin login);
    boolean registerLogin(AdminLogin login);


}
