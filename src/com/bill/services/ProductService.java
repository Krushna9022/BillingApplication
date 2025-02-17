package com.bill.services;

import com.bill.model.CustomerProductList;
import com.bill.model.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product p);
    List<Product> viewProduct();
    boolean removeProduct(Product p);

    double getBill(List<CustomerProductList> custprod);
}
