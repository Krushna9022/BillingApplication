package com.bill.services;

import com.bill.model.Order;
import com.bill.repository.BillRepository;
import com.bill.repository.BillRepositoryImp;

import java.util.List;

public class BillServiceImp implements BillService{

   static BillRepository billRepository=new BillRepositoryImp();
    @Override
    public Order getBillById(int id) {
        return billRepository.getBillById(id) ;
    }

    @Override
    public List<Order> getAllBill() {
        return billRepository.getAllBill();
    }

    @Override
    public List<Order> getBillCustomer() {
        return List.of();
    }
}
