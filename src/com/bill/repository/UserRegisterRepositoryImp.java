package com.bill.repository;

import com.bill.exception.CustomerNotFound;
import com.bill.model.AdminLogin;
import com.bill.model.CustomerLogin;

import java.util.List;
import java.util.Vector;

public class UserRegisterRepositoryImp implements UserRegisterRepository{
    final  List<CustomerLogin> custreg=new Vector();
    public UserRegisterRepositoryImp()
    {
        custreg.add(new CustomerLogin("krushna","kkp@","9022068508" ,"krushna","Beed"));
        custreg.add(new CustomerLogin("mahesh","mahesh@","125568508" ,"mahesh","A.Nagar"));
        custreg.add(new CustomerLogin("Krushna","kishor@","8080808082" ,"kishor","sangli"));
    }

    @Override
    public boolean registerLogin(CustomerLogin register) {
        boolean b=custreg.add(register);
        //show();
       return b;
    }
    public List show()
    {
        System.out.println(custreg);
        return custreg;
    }

    @Override
    public List<CustomerLogin> getAllCustomer() {
        return custreg;
    }


    @Override
    public boolean registerLogin(AdminLogin login) {
        return false;
    }


}
