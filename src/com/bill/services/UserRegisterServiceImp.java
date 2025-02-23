package com.bill.services;

import com.bill.model.AdminLogin;
import com.bill.model.CustomerLogin;
import com.bill.repository.UserRegisterRepository;
import com.bill.repository.UserRegisterRepositoryImp;

import java.util.List;

public class UserRegisterServiceImp implements UserRegisterService {
    public static  UserRegisterRepository userRegisterRepository = new UserRegisterRepositoryImp();

    @Override
    public boolean registerLogin(CustomerLogin login) {
        return userRegisterRepository.registerLogin((login));
    }

    @Override
    public boolean registerLogin(AdminLogin login) {
        return false;
    }

    @Override
    public List<CustomerLogin> getAllCustomer() {
        return userRegisterRepository.getAllCustomer();
    }


}
