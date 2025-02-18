package com.bill;

import com.bill.exception.CustomerNotFound;
import com.bill.model.CustomerLogin;
import com.bill.model.CustomerProductList;
import com.bill.model.Product;
import com.bill.model.User;
import com.bill.services.*;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class BillingApplication {
    static Scanner sc = new Scanner(System.in);
    static UserRegisterService custregisterservice = new UserRegisterServiceImp();
    static User user = null;

    static ProductService productService = new ProductServiceImp();
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
                    user.setEmail(useremail);
                    user.setPassword(userpass);
                    User u = uservalid.validatUser(user);
                    if (u !=null)
                    {
                         System.out.println("Login Sucessfully.....");
                    }





                     /*   List<Product> products = productService.viewProduct();
                        for (Product p : products) {
                            System.out.println(p.getName() + "\t" + p.getPrice());
                        }
                        boolean addprod = true;

                        List<CustomerProductList> custprod = new Vector<>();
                        System.out.println("Select the Enter the product to add cart....");
                        while (addprod) {
                            System.out.println("enter the product name ");
                            String pname = sc.nextLine();
                            System.out.println("enter the product qty");
                            int q = sc.nextInt();
                            System.out.println("Do you want to enter the more product?  '1' ");
                            int more = sc.nextInt();
                            if (more != 1) {
                                addprod = false;
                            }
                            sc.nextLine();
                            CustomerProductList customerproduct = new CustomerProductList(pname, q);
                            custprod.add(customerproduct);
                        }

                        double totalprice;
                        totalprice = productService.getBill(custprod);
                        for (CustomerProductList c : custprod) {
                            System.out.println(c.getPname() + "\t" + c.getQty());
                        }
                        System.out.println(totalprice);
                    }
                        */

                break;
                case 3:
                    back = false;
                    System.out.println("========================================");

            }
        } while (back);
    }

    public static void AdminPanel() {
        sc.nextLine();
        System.out.println("Welocme to Admin...");
        System.out.println("Enter the username");
        String username = sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        if (password.equals("krushna") && username.equals("admin")) {
            boolean back = true;
            do {
                System.out.println("1.Add Products");
                System.out.println("2.View Customer list with bills");
                System.out.println("3.");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("enter the product name");
                        String pname = sc.nextLine();
                        System.out.println("enter the product price");
                        double price = sc.nextDouble();
                        System.out.println("enter the product quantity");
                        int qty = sc.nextInt();
                        System.out.println();
                        productService.addProduct(new Product(pname, price, qty));
                        break;

                    case 4:
                        back = false;
                }
            } while (back);
        } else {
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
}