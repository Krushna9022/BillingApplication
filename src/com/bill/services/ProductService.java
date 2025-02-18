package com.bill.services;

import com.bill.model.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product p);
    List<Product> getAllproduct();

}
