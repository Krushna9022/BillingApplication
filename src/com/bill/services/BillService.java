package com.bill.services;

import com.bill.model.Order;

import java.util.List;

public interface BillService {
   Order getBillById(int i);
   List<Order> getAllBill();
   List<Order>getBillCustomer();
}
