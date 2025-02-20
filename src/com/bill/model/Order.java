package com.bill.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order {
    int id;
    User user;
    List<Product> list;
    Date order;
    Double grandTotal;

    public Order() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(int id, User user, List<Product> list, Date order) {
        this.id = id;
        this.list = list;
        this.order = order;
        this.user = user;

    }

    public Order(int id, User user, List<Product> list, Date order, Double grandTotal) {
        this.id = id;
        this.list = list;
        this.user = user;
        this.grandTotal = grandTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public Date getOrder() {
        return order;
    }

    public void setOrder(Date order) {
        this.order = order;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }


}
