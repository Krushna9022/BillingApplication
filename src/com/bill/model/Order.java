package com.bill.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order {
    int id;
    User user;
    List<Product> list;
    Date date;
    Double grandTotal;

    public Order() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(int id, User user, List<Product> list, Date date) {
        this.id = id;
        this.list = list;
        this.date = date;
        this.user = user;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return list;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProductList(List<Product> list) {
        this.list = list;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }


}
