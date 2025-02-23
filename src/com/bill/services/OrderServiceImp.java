package com.bill.services;

import com.bill.model.Order;
import com.bill.model.Product;
import com.bill.repository.OrderRepository;
import com.bill.repository.OrderRepositoryImp;

public class OrderServiceImp implements OrderService {
    OrderRepository orderRepository=new OrderRepositoryImp();

    @Override
    public Product productAvaliable(int pid) {
        return orderRepository.productAvaliable(pid);
    }

    @Override
    public boolean isStockAvailable(int pid,int quantity) {
        return orderRepository.isStockAvailable(pid,quantity);
    }

    @Override
    public boolean placedOrder(Order order) {
        return orderRepository.placedOrder(order);
    }
}
