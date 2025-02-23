package com.bill.services;

import com.bill.model.Order;
import com.bill.model.Product;

public interface OrderService {
    Product productAvaliable(int pid);
    boolean isStockAvailable(int pid,int stock);
    boolean placedOrder(Order order);

}
