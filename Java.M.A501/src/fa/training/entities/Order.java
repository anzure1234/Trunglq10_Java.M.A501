package fa.training.entities;

import fa.training.utils.Validator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Order {
    private String number;
    private String date;
    public Order(){

    }
    public Order(String number, String date){
        this.number=number;
        this.date=date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void input_Order() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the order number");
        boolean valid;
        do{
            this.number=scanner.nextLine();
            try{
                valid = Validator.isOrderNumber(this.number);
                if(valid == false){
                    System.out.println("Order number is not valid");
                }
            }catch (Exception e){
                valid = false;
            }
        }while(valid == false);

        System.out.println("Enter the order date");
        this.date=scanner.nextLine();

    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
