package com.bill.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String compname;

    public String getCompname() {
        return compname;
    }

    public Product(int id,String name, double price, int quantity, String compname) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.compname = compname;
        this.id=id;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public Product() {

    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
