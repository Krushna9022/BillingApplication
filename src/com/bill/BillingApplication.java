package com.bill;

import com.bill.exception.CustomerNotFound;
import com.bill.model.*;
import com.bill.services.*;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class BillingApplication {
    static Scanner sc = new Scanner(System.in);
    static UserRegisterService custregisterservice = new UserRegisterServiceImp();
    static User user = null;
    static ProductService productService=new ProductServiceImp();
    static UserValidatorService uservalid = new UserValidatorServiceImp();

    public static void main(String[] args) {
        do {
            System.out.println("1.Customer panel");
            System.out.println("2.Admin  panel");
            System.out.println("3.System exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    customerPanel();
                    break;
                case 2:
                    AdminPanel();
                    break;
                case 3:
                    System.out.println("Existing system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("wrong choice");


            }
        } while (true);
    }

    public static void customerPanel() {
        System.out.println("Welocme to customer panel");
        boolean back = true;
        do {
            System.out.println("1.Register the Customer");
            System.out.println("2.Login to customer");
            System.out.println("3.Back to home ");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.println("Enter the name");
                    String name = sc.nextLine();
                    System.out.println("Enter the email");
                    String email = sc.nextLine();
                    System.out.println("Enter the contact");
                    String conact = sc.nextLine();
                    System.out.println("Enter the password ");
                    String password = sc.nextLine();
                    System.out.println("Enter the Address");
                    String address = sc.nextLine();
                    boolean b = custregisterservice.registerLogin(new CustomerLogin(name, email, conact, password, address));
                    if (b) {
                        System.out.println("Customer has register successfully");
                    } else {
                        System.out.println("Failed to register");
                    }
                    break;
                case 2:
                     user = new CustomerLogin();
                     try {
                         System.out.println("Welcome to Login DashBorad....");
                         Thread.sleep(1000);
                         System.out.println("\n\nPlease Wait...");
                         Thread.sleep(3000);
                     }catch(Exception ex)
                     {
                         System.out.println(ex.getMessage());
                     }
                     sc.nextLine();
                     System.out.println("enter the email");
                     String useremail=sc.nextLine();
                     System.out.println("Enter the password");
                     String userpass=sc.nextLine();
                    user =new AdminLogin();
                    user.setEmail(useremail);
                    user.setPassword(userpass);
                    User u = uservalid.validatUser(user);

                    if (u !=null)
                    {
                         System.out.println("Login Sucessfully.....");
                         customerMenu(u);
                    }
                    else {
                        System.out.println("login failed....");
                    }

                break;
                case 3:
                    back = false;
                    System.out.println("========================================");

            }
        } while (back);
    }



    public static void AdminPanel() {
        sc.nextLine();
        System.out.println("Welocme to Admin Login...");
        System.out.println("Enter the username");
        String username = sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        user=new AdminLogin();
        user.setEmail(username);
        user.setPassword(password);
        User u =uservalid.validatUser(user);
        //System.out.println(u.getEmail()+u.getPassword());
        if(u!=null)
        {
            System.out.println("Welcome admin");
            adminMenu();
        }
        else {
            try {
                System.out.println("you enter the wrong password");
                Thread.sleep(2000);
                System.out.println("You are Redirect to home page...");
                Thread.sleep(2000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static void customerMenu(User u) {
        boolean cmenu=true;
        do{
            System.out.println("1.Add product ");
            System.out.println("2.back to menu");
            int choice =sc.nextInt();
            switch(choice)
            {
                case 1:


            }

        }while(cmenu);
    }

    private static void adminMenu() {
        boolean adminmenu=true;
        do
        {
            System.out.println("1.Add Product");
            System.out.println("2.View All product");
            System.out.println("3.View All Customer ");
            System.out.println("4.serach product by id");
            System.out.println("5.View All Bills");
            System.out.println("6.View Total Orders");
            System.out.println("8.back");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the product Id");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Product name");
                    String pname=sc.nextLine();
                    System.out.println("Enter Company Name");
                    String cname=sc.nextLine();
                    System.out.println("Enter the price");
                    double price=sc.nextDouble();
                    System.out.println("Enter the qunitity");
                    int qty=sc.nextInt();
                    Product p=new Product(id,pname,price,qty,cname);
                    boolean b=productService.addProduct(p);
                    if(b)
                    {
                        System.out.println("Product has added sucessfully...");
                    }
                    else {
                        System.out.println("product not added");
                    }
                    break;
                case 2:
                    List<Product> listp=productService.getAllproduct();
                    for(Product plist:listp)
                    {
                        System.out.println("ProductId :"+plist.getId()+" productName : "+plist.getName()+"Comapny "+plist.getCompname()+" Price "+plist.getPrice()+" Qunantity "+ plist.getQuantity());
                    }
                    System.out.println("=============================================================================");
                    break;
                case 8:
                    adminmenu=false;
                default:
                    System.out.println("You entered the wrong choice");
            }

        }while(adminmenu);
    }
}