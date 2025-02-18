package com.bill.services;

import com.bill.model.User;
import com.bill.repository.ValidateUserRepository;
import com.bill.repository.ValidateUserRepositoryImp;

public class UserValidatorServiceImp implements UserValidatorService{
    public static ValidateUserRepository valid =new ValidateUserRepositoryImp();
    @Override
    public User validatUser(User user) {
        return valid.validateUser(user);
    }
}
