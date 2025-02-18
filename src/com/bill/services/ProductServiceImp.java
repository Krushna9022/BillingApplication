package com.bill.services;

import com.bill.model.Product;
import com.bill.repository.ProductRepository;
import com.bill.repository.ProductRepositoryImp;

import java.util.List;

public class ProductServiceImp implements ProductService {
    ProductRepository productRepository=new ProductRepositoryImp();
    @Override
    public boolean addProduct(Product p) {
        return productRepository.addProduct(p);
    }

    @Override
    public List<Product> getAllproduct() {
        return productRepository.getAllProduct() ;
    }
}
