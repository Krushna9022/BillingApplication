package com.bill.repository;

import com.bill.model.AdminLogin;
import com.bill.model.CustomerLogin;

import java.util.List;

public interface UserRegisterRepository {
    boolean registerLogin(CustomerLogin register);
    boolean registerLogin(AdminLogin register);
    public List show();



    boolean validateCustomer(String useremail, String useremail1);
}
