package com.bill.repository;

import com.bill.model.CustomerLogin;
import com.bill.model.CustomerProductList;
import com.bill.model.Product;

import java.util.List;
import java.util.Vector;

public class ProductRepositoryImp  implements ProductRepository {

  final static  List<Product> product=new Vector();
  public ProductRepositoryImp()
  {
      product.add(new Product("Product 1",200,30));
      product.add(new Product("Product 2",100,100));
      product.add(new Product("Product 3",30,300));
      product.add(new Product("Product 4",200,40));
  }
    @Override
    public boolean addProduct( Product p) {
        boolean b=product.add(p);
        System.out.println(product);
        return b ;
    }

    @Override
    public List<Product> viewProduct() {
        return product;
    }

    @Override
    public boolean removeProduct(Product p) {

        return product.remove(p);
    }

    @Override
    public double getBill(List<CustomerProductList> custprod) {
      double amtount=0;
          for (CustomerProductList customerProductList : custprod) {
              for(Product p:product)
              {
                  if(p.getName().equals(customerProductList.getPname()))
                  {
                     amtount += p.getPrice() * customerProductList.getQty();
                     break;
                  }
              }
      }

        return amtount ;
    }


}
