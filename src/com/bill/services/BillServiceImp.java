package com.bill.services;

import com.bill.model.Order;

import java.util.List;

public class BillServiceImp implements BillService{

    BillService billService=new BillServiceImp();
    @Override
    public Order getBillById(int i) {
        return billService.getBillById(i) ;
    }

    @Override
    public List<Order> getAllBill() {
        return List.of();
    }

    @Override
    public List<Order> getBillCustomer() {
        return List.of();
    }
}
