package com.bill.model;

public class AdminLogin  extends User{
    private final String role="Admin";

    public AdminLogin(String name, String password, String email, String contact) {
        super(name, password, email, contact);

    }

    public AdminLogin() {
    }
    public String getRole()
    {
        return role;
    }
}
