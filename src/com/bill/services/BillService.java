package com.bill.services;

import com.bill.model.Order;

import java.util.List;

public interface BillService {
   Order getBillById(int id);
   List<Order> getAllBill();
   List<Order>getBillCustomer();
}
