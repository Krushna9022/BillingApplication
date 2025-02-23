package com.bill.repository;

import com.bill.model.Order;
import com.bill.model.Product;

import java.util.List;
import java.util.Vector;

public class OrderRepositoryImp implements  OrderRepository{
    static ProductRepository productRepository=new ProductRepositoryImp();
    static List<Order> orders=new Vector();
    static List<Product> p;
    @Override
    public Product productAvaliable(int pid) {
        p=productRepository.getAllProduct();
        for(Product product:p)
        {
            if(product.getId()==pid)
            {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isStockAvailable(int pid,int quantity) {
        for(Product product:p)
        {
            if(product.getId()==pid && product.getQuantity()>=quantity)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean placedOrder(Order order) {
        return orders.add(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orders;
    }
}
