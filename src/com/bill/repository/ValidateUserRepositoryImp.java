package com.bill.repository;

import com.bill.exception.CustomerNotFound;
import com.bill.model.AdminLogin;
import com.bill.model.CustomerLogin;
import com.bill.model.User;

import java.util.List;

public class ValidateUserRepositoryImp implements ValidateUserRepository {
    static UserRegisterRepository uservalid = new UserRegisterRepositoryImp();


    @Override
    public User validateUser(User user) {
        try {
            if (user.getEmail().equals("admin") && user.getPassword().equals("admin")) {

            } else {
                CustomerLogin c = (CustomerLogin) user;
                List<CustomerLogin> login = uservalid.getAllCustomer();
                boolean flag = false;
                for (CustomerLogin u : login) {
                    if (u.getEmail().equals(c.getEmail()) && u.getPassword().equals(c.getPassword()) && c.getRole().equals("customer")) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    throw new CustomerNotFound(user);
                }
            }
        } catch (CustomerNotFound ex) {
            System.out.println(ex.getMsg());
            return null;
        }
        return user;
    }
}