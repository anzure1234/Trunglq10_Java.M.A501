package fa.training.entities;

import fa.training.utils.Validator;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private String phoneNumber;
    private String address;
    private List<Order> listOfOrder;

    public Customer(String name, String phoneNumber, String address, ArrayList<Order> listOfOrder) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.listOfOrder = listOfOrder;
    }


    public Customer() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getListOfOrder() {
        return listOfOrder;
    }

    public void setListOfOrder(List<Order> listOfOrder) {
        this.listOfOrder = listOfOrder;
    }

    public List<String> createCustomer() {
        Scanner scanner = new Scanner(System.in);
        List<String> customer = new ArrayList<>();
        this.listOfOrder = new ArrayList<Order>();
        System.out.println("Enter name");
        this.name = scanner.nextLine();
        customer.add(this.name);
        System.out.println("Enter phone number");
        boolean valid = false;
        while (valid == false) {
            this.phoneNumber = scanner.nextLine();
            try {
                valid = Validator.isPhoneNumber(this.phoneNumber);
                if (valid == false) {
                    System.out.println("Phone number is not valid");
                }
            } catch (Exception e) {
                valid = false;
            }

        }
        customer.add(phoneNumber);

        System.out.println("Enter address");
        this.address = scanner.nextLine();
        customer.add(address);


        System.out.println("Enter number of orders");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Order order = new Order();
            order.input_Order();
            listOfOrder.add(order);
        }
        customer.add(String.valueOf(listOfOrder));

        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", listOfOrder=" + listOfOrder +
                '}';
    }

    public void display(List<String> customers) {
        for (String customer : customers) {
            System.out.println(customer);
        }
    }

    public String save(List<String> customers) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("customer.dat"));
            for (String customer : customers) {
                writer.write(customer);
                writer.newLine();
            }
            writer.close();
            return "Write success";
        } catch (IOException e) {
            e.printStackTrace();
            return "Write failed";
        }
    }

    List<String> customers = new ArrayList<>();

    public List<String> findAll() {

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("customer.dat"))) {
            while ((line = reader.readLine()) != null) {
                customers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<String> search(String phone) {
        int count =0;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("customer.dat"))) {
            while ((line = reader.readLine()) != null) {
                customers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (customers.size() == 0) {
            System.out.println("No customer");
            return null;
        } else {
            List<String> result = new ArrayList<>();
            for (String customer : customers) {
                if (customer.contains(phone)) {
                    result.add(customer);
                }else{
                    count++;
                }
            }
            if(count !=0){
                System.out.println("No customer");
            }

            return result;

        }
    }


    public boolean remove(String phone) {
        List<String> customers = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("customer.dat"))) {
            while ((line = reader.readLine()) != null) {
                customers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        List<String> result = new ArrayList<>();
        for (String customer : customers) {
            if (customer.contains(phone)) {
                result.add(customer);
            }
        }
        if (result.size() == 0) {
            return false;
        } else {
            customers.removeAll(result);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("customer.dat"))) {
                StringBuilder sb = new StringBuilder();
                for (String customer : customers) {
                    sb.append(customer).append(System.lineSeparator());
                }
                writer.write(sb.toString());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}


