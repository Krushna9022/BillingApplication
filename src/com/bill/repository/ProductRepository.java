package com.bill.repository;

import com.bill.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProduct();

    boolean addProduct(Product p);
}
