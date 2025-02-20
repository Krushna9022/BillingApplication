package com.bill.repository;

import com.bill.model.Product;

import java.util.List;

public class OrderRepositoryImp implements  OrderRepository{
    static ProductRepository productRepository=new ProductRepositoryImp();
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
}
