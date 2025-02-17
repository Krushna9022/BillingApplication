package com.bill.services;

import com.bill.model.CustomerProductList;
import com.bill.model.Product;
import com.bill.repository.ProductRepository;
import com.bill.repository.ProductRepositoryImp;

import java.util.List;

public class ProductServiceImp implements ProductService{
    private static final ProductRepository repo=new ProductRepositoryImp();
    @Override
    public boolean addProduct(Product p) {
        return repo.addProduct(p);
    }

    @Override
    public List<Product> viewProduct() {
        return repo.viewProduct();
    }

    @Override
    public boolean removeProduct(Product p) {
        return repo.removeProduct(p);
    }

    @Override
    public double getBill(List<CustomerProductList> custprod) {
        return repo.getBill(custprod);
    }


}
