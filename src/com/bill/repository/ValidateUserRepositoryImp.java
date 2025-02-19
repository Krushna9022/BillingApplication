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
                return user;
            } else {
                CustomerLogin c = (CustomerLogin) user;
                List<CustomerLogin> loginList = uservalid.getAllCustomer();
                System.out.println("Available Users: " + loginList);
                boolean flag = false;

                for (CustomerLogin u : loginList) {
                    System.out.println("Checking: " + u.getEmail() + " " + u.getPassword());
                    if (u.getEmail().equalsIgnoreCase(c.getEmail()) && u.getPassword().equals(c.getPassword())) {
                        flag = true;
                        return u; // Return the found user
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
        return null; // Ensure method returns null if user is not found
    }

}