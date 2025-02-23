package com.bill.repository;

import com.bill.model.Order;
import com.bill.model.User;

import java.util.List;
import java.util.Vector;

public class BillRepositoryImp implements BillRepository{
    static OrderRepository orderRepository=new OrderRepositoryImp();

    @Override
    public Order getBillById(int id) {
        List<Order> list=orderRepository.getAllOrder();
       for(Order order:list)
       {
           System.out.println(id+"\t"+order.getId());
           if(id==order.getId())
           {
               System.out.println(order.getId()+"\t\t");
               return order ;
           }
       }
       return  null;
    }

    @Override
    public List<Order> getAllBill() {
        return orderRepository.getAllOrder();
    }

    @Override
    public List<Order> getBillCustomer(User user) {
        List<Order> orderlist=new Vector();
        for(Order o:orderlist)
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
