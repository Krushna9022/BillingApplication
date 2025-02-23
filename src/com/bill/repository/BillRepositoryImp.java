package com.bill.repository;

import com.bill.model.Order;
import com.bill.model.User;

import java.util.List;
import java.util.Vector;

public class BillRepositoryImp implements BillRepository{
    static OrderRepository orderRepository=new OrderRepositoryImp();
    static List<Order> list;
    public void  getAllOrder(List<Order> orderlist)
    {
         orderlist=orderRepository.getAllOrder();
        this.list=orderlist;
    }
    @Override
    public Order getBillById(int id) {
       for(Order o:list)
       {
           if(id==o.getId())
           {
               return o ;

           }
       }
       return  null;
    }

    @Override
    public List<Order> getAllBill() {
        return list;
    }

    @Override
    public List<Order> getBillCustomer(User user) {
        List<Order> orderlist=new Vector();
        for(Order o:list)
        {
           User u=o.getUser();
           if(u.getName().equals(user.getName().equals(u.getName())&& u.getPassword().equals(user.getPassword())))
           {
              orderlist.add(o);
           }
        }
        return orderlist;
    }


}
