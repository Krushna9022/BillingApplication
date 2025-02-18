package com.bill.repository;

import com.bill.model.Product;

import java.util.List;
import java.util.Vector;

public class ProductRepositoryImp implements ProductRepository{
    static List<Product> productlist=new Vector();
    @Override
    public List<Product> getAllProduct() {
        return productlist;
    }

    @Override
    public boolean addProduct(Product p) {
        return productlist.add(p);
    }
}
