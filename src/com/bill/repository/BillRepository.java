package com.bill.repository;

import com.bill.model.Order;
import com.bill.model.User;

import java.util.List;

public interface BillRepository {
    Order getBillById(int id);
    List<Order> getAllBill();
    List<Order>getBillCustomer(User user);

}
