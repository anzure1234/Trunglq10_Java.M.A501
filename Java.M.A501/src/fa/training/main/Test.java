package fa.training.main;

import fa.training.entities.Customer;
import fa.training.utils.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Add a new Customer");
        System.out.println("2.Show all  Customers");
        System.out.println("3.Search Customer");
        System.out.println("4.Remove Customer");
        System.out.println("5.Exit");

        List<String> customerList = new ArrayList<>();

        while (true) {
            System.out.println("Choose option");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    Customer customer = new Customer();
                    System.out.println("-------Enter Customer Information-------");
                    customer.createCustomer();
                    customerList.add(String.valueOf(customer));
                    customer.save(customerList);
                    break;
                case 2 :
                    System.out.println("-------List of Customers-------");

                    Customer customer1 = new Customer();
                    List<String> customerList1 = customer1.findAll();
                    customer1.display(customerList1);
                    break;
                case 3 :
                    System.out.println("-------Search Customer-------");
                    scanner.nextLine();
                    System.out.println("Enter phone number");
                    String phone = null;
                    boolean valid = false;
                    while(valid == false) {
                        phone = scanner.nextLine();
                        try {
                            valid = Validator.isPhoneNumber(phone);
                            if (valid == false) {
                                System.out.println("Phone number is not valid");
                            }
                        } catch (Exception e) {
                            valid = false;
                        }
                    }

                    Customer customer2 = new Customer();
                    List<String> customerList2 = customer2.search(phone);
                    customer2.display(customerList2);

                   break;
                   case 4 :
                       System.out.println("-------Remove Customer-------");
                       scanner.nextLine();
                       System.out.println("Enter phone number");
                       String phone1 = null;
                       boolean valid1 = false;
                       while(valid1 == false) {
                           phone1 = scanner.nextLine();
                           try {
                               valid1 = Validator.isPhoneNumber(phone1);
                               if (valid1 == false) {
                                   System.out.println("Phone number is not valid");
                               }
                           } catch (Exception e) {
                               valid1 = false;
                           }
                       }
                       Customer customer3 = new Customer();
                       customer3.remove(phone1);
                       break;
                case 5 :
                    System.out.println("Exit!!");
                    System.exit(choice);
                default :
                    System.out.println("Data is not valid");

            }
        }

    }
}