package com.bill.repository;

import com.bill.model.Product;

import java.util.List;
import java.util.Vector;

public class ProductRepositoryImp implements ProductRepository{
    static List<Product> productlist=new Vector();

    public ProductRepositoryImp()
    {
        /*productlist.add(new Product(1,"fan",20,20,"Comp1"));
        productlist.add(new Product(2,"mixer",110,20,"Comp2"));
        productlist.add(new Product(3,"freezer",50,40,"Comp3"));*/
    }
    @Override
    public List<Product> getAllProduct() {

        return productlist!=null?productlist:null;
    }

    @Override
    public boolean addProduct(Product p) {
        boolean flag=true;
        for(Product p1:productlist)
        {
            if(p1.getId()==p.getId())
            {
                flag=false;
            }
        }
        return flag?productlist.add(p):flag;
    }
}
