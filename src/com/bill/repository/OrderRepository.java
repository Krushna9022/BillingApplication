package com.bill.repository;

import com.bill.model.Order;
import com.bill.model.Product;

import java.util.List;

public interface OrderRepository {
    Product productAvaliable(int pid);
    boolean isStockAvailable(int pid,int quantity);
    boolean placedOrder(Order order);
    List<Order> getAllOrder();


}
