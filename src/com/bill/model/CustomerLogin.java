package com.bill.model;

public class CustomerLogin extends User  {
    public static final String role="customer";
    private String address;
    public CustomerLogin(String name, String email, String contact,String password,String address) {
        super(name, email, contact,password);
        this.address=address;
    }

    public CustomerLogin() {
    }
    public String getRole()
    {
        return role;
    }
}
