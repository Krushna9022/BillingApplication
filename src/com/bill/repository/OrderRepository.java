package com.bill.repository;

import com.bill.model.Product;

public interface OrderRepository {
    Product productAvaliable(int pid);
    boolean isStockAvailable(int pid,int quantity);
}
