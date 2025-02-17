package com.bill.repository;

import com.bill.model.CustomerProductList;
import com.bill.model.Product;

import java.util.List;

public interface ProductRepository {
    boolean addProduct(Product p);
    List<Product> viewProduct();
    boolean removeProduct(Product p);



    double getBill(List<CustomerProductList> custprod);
}
