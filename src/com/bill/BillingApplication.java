package com.bill;

import com.bill.model.*;
import com.bill.repository.OrderRepository;
import com.bill.services.*;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class BillingApplication {
    static Scanner sc = new Scanner(System.in);
    static UserRegisterService custregisterservice = new UserRegisterServiceImp();
    static User user = null;
    static int orderid = 1;
    static ProductService productService = new ProductServiceImp();
    static UserValidatorService uservalid = new UserValidatorServiceImp();
    static OrderService orderService = new OrderServiceImp();
    static BillService billService = new BillServiceImp();

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
        custregisterservice.registerLogin(new CustomerLogin("krushna", "Krushna@gmail.com", "9022068508", "******", "beed"));
        custregisterservice.registerLogin(new CustomerLogin("pravin", "pravin@gmail.com", "5656068508", "######", "shillod"));
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
                    String contact = sc.nextLine();
                    System.out.println("Enter the password ");
                    String password = sc.nextLine();
                    System.out.println("Enter the Address");
                    String address = sc.nextLine();
                    boolean b = custregisterservice.registerLogin(new CustomerLogin(name, email, contact, password, address));
                    if (b) {
                        System.out.println("Customer has register successfully");
                    } else {
                        System.out.println("Failed to register");
                    }
                    break;
                case 2:
                    user = new CustomerLogin();
                    System.out.println("Welcome to Login DashBorad....");
                    System.out.println("\nPlease Wait...");
                    sc.nextLine();
                    System.out.println("enter the email");
                    String useremail = sc.nextLine();
                    System.out.println("Enter the password");
                    String userpass = sc.nextLine();
                    user.setEmail(useremail);
                    user.setPassword(userpass);
                    User u = uservalid.validatUser(user);
                    System.out.println(u);
                    if (u != null) {
                        System.out.println("Login Sucessfully.....");
                        customerMenu(u);
                    } else {
                        System.out.println(" Cutomer login failed....");
                    }

                    break;
                case 3:
                    back = false;
                    System.out.println("____________________________________________");

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
        user = new AdminLogin();
        user.setEmail(username);
        user.setPassword(password);
        User u = uservalid.validatUser(user);
        //System.out.println(u.getEmail()+u.getPassword());
        if (u != null) {
            System.out.println("Welcome admin");
            adminMenu();
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

    private static void customerMenu(User u) {
        boolean cmenu = true;
        do {
            System.out.println("1.Place your order ");
            System.out.println("2.get Bill ");
            System.out.println("3.get All bill ");
            System.out.println("4.back to menu");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    List<Product> listp = productService.getAllproduct();
                    System.out.println(listp);
                    if (listp != null) {
                        for (Product plist : listp) {
                            System.out.println("ProductId : " + plist.getId() + " productName : " + plist.getName() + "  Comapny : " + plist.getCompname() + " Price: " + plist.getPrice() + " Qunantity: " + plist.getQuantity());
                        }
                        System.out.println("=============================================================================");
                        boolean flag = true;
                        List<Product> custProdList = new Vector();
                        do {
                            System.out.println("Enter the id of Product");
                            int pid = sc.nextInt();
                            Product product = orderService.productAvaliable(pid);
                            if (product != null) {
                                System.out.println("Enter the quntity of product");
                                int quantity = sc.nextInt();
                                boolean b = orderService.isStockAvailable(pid, quantity);
                                if (b) {
                                    int newStock = product.getQuantity() - quantity;
                                    product.setQuantity(newStock);
                                    Product product1 = new Product();
                                    product1.setId(pid);
                                    product1.setName(product.getName());
                                    product1.setQuantity(quantity);
                                    product1.setCompname(product.getCompname());
                                    product1.setPrice(product.getPrice());
                                    custProdList.add(product1);
                                    System.out.println("Added to cart 👍");
                                } else {
                                    System.out.println("Available Qunatity is " + product.getQuantity() + " only cant added to cart🙁 ");
                                }
                            } else {
                                System.out.println("Product not found with given id... 😒");
                            }

                            System.out.println("Do you want add more product :y/n");
                            sc.nextLine();
                            char s = sc.next().charAt(0);
                            if (!(s == 'y' || s == 'Y')) {
                                flag = false;
                            }
                        } while (flag);
                        Order order1 = null;
                        if (custProdList != null) {
                            Date date = new Date();
                            order1 = new Order(orderid, u, custProdList, date);
                            orderid++;
                            boolean placeorder = orderService.placedOrder(order1);
                            if (placeorder) {
                                System.out.println("Your order has been placed👍👍");
                            }
                        } else {
                            System.out.println("nothing has been ordered..😞😞");
                        }
                    } else {
                        System.out.println("product are not available....");
                    }
                    break;
                case 2:
                    int oid = orderid - 1;
                    Order order = billService.getBillById((oid));
                    if (order != null) {
                        System.out.println("Order id " + order.getId());
                        System.out.println("👤 " + order.getUser().getName() + "\t\t\t" + order.getDate());
                        List<Product> prodlist = order.getProductList();
                        double totalbill = 0;
                        for (Product p1 : prodlist) {
                            System.out.println(p1.getName() + "\t" + p1.getCompname() + "\t" + p1.getPrice() + "\t" + p1.getQuantity() + "\t" + (p1.getPrice() * p1.getQuantity()));
                            totalbill = totalbill + (p1.getPrice() * p1.getQuantity());
                        }
                        System.out.println("\t\t\t total bill " + totalbill + " /-");
                    } else {
                        System.out.println("You havent any Purchases yet...😞😞");
                    }
                    break;
                case 3:
                    List<Order> orders = billService.getAllBill();
                    if (orders != null) {
                        for (Order ord : orders) {
                            System.out.println("===========================================================");
                            System.out.println("Bill No " + ord.getId() + " \tUser " + ord.getUser().getName() + "\t Date: " + ord.getDate());
                            System.out.println("===========================================================");
                            List<Product> productList = ord.getProductList();
                            double totalbill = 0;
                            for (Product product : productList) {
                                System.out.println(product.getName() + "\t" + product.getCompname() + "\t" + product.getPrice() + "\t" + product.getQuantity() + "\t" + (product.getPrice() * product.getQuantity()));
                                totalbill = totalbill + (product.getPrice() * product.getQuantity());
                            }
                            System.out.println("===========================================");
                            System.out.println("\t\t\t total bill " + totalbill + " /-");
                        }
                        System.out.print("=============================================================\n\n");
                    } else {
                        System.out.println("not found ...");
                    }
                case 4:
                    cmenu = false;
            }

        } while (cmenu);
    }

    public static void adminMenu() {
        boolean adminmenu = true;
        Product p1 = new Product(1, "fan", 200, 20, "Bajaj");
        Product p2 = new Product(2, "cooker", 100, 10, "presti");
        productService.addProduct(p1);
        productService.addProduct(p2);
        do {
            System.out.println("1.Add Product");
            System.out.println("2.View All product");
            System.out.println("3.View All Customer ");
            System.out.println("4.serach product by id");
            System.out.println("5.View All Bills");
            System.out.println("6.View Total Orders");
            System.out.println("8.back to main menu ");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the product Id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Product name");
                    String pname = sc.nextLine();
                    System.out.println("Enter Company Name");
                    String cname = sc.nextLine();
                    System.out.println("Enter the price");
                    double price = sc.nextDouble();
                    System.out.println("Enter the qunitity");
                    int qty = sc.nextInt();
                    Product p = new Product(id, pname, price, qty, cname);
                    boolean b = productService.addProduct(p);
                    if (b) {
                        System.out.println("Product has added sucessfully...");
                    } else {
                        System.out.println("product not added");
                    }
                    break;
                case 2:
                    List<Product> listp = productService.getAllproduct();
                    if (listp != null) {
                        for (Product plist : listp) {
                            System.out.println("ProductId :" + plist.getId() + " productName : " + plist.getName() + "Comapny " + plist.getCompname() + " Price " + plist.getPrice() + " Qunantity " + plist.getQuantity());
                        }
                        System.out.println("=================================================================================");
                    } else {
                        System.out.println("product not found ❌❌...");
                    }
                    break;
                case 3:
                    List<CustomerLogin> customerLogins = custregisterservice.getAllCustomer();
                    for (CustomerLogin customerLogin : customerLogins) {
                        System.out.println(customerLogin.getName() + "\t" + customerLogin.getContact() + "\t" + customerLogin.getEmail());
                    }
                    break;
                case 4:
                    listp = productService.getAllproduct();
                    System.out.println("Enter the product Id to search product detail");
                    int spid = sc.nextInt();
                    boolean flag = false;
                    for (Product product : listp) {
                        if (spid == product.getId()) {
                            System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getCompname() + "\t" + product.getPrice() + "\t" + product.getQuantity());
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("Not found ❌❌❌");
                    }
                    break;

                case 5:
                    List<Order> orders = billService.getAllBill();
                    if (orders != null) {
                        for (Order order : orders) {
                            System.out.println("Bill No " + order.getId() + " \tUser " + order.getUser().getName() + "\t Date: " + order.getDate());
                            System.out.println("===========================================================");
                            List<Product> productList = order.getProductList();
                            double totalbill = 0;
                            for (Product product : productList) {
                                System.out.println(product.getName() + "\t" + product.getCompname() + "\t" + product.getPrice() + "\t" + product.getQuantity() + "\t" + (product.getPrice() * product.getQuantity()));
                                totalbill = totalbill + (product.getPrice() * product.getQuantity());
                            }
                            System.out.println("======================================");
                            System.out.println("\t\t\t total bill " + totalbill + " /-");
                        }
                        System.out.println("\n============================================");
                    } else {
                        System.out.println("not found ...");
                    }
                    break;

                case 8:
                    adminmenu = false;
                default:
                    System.out.println("You entered the wrong choice");
            }

        } while (adminmenu);
    }
}