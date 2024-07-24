package Banking_System;

import java.util.Scanner;

public class Bank {
    int account_number;
    String name;
    float amount;

    // Method to initialize object

    void insert(int a, String n, float amt){
        account_number = a;
        name = n;
        amount = amt;
    }

    //Method to Deposit Amount
    void deposit(float amt){
        amount += amt;
        System.out.println("Deposit: " + amt);
    }

    // Method to withdraw Amount

    void withdraw(float amt){
        if(amount<amt){
            System.out.println("Amount is Insufficient");
        }else{
            amount -= amt;
            System.out.println("Withdraw: " + amt);
        }

    }
    //Method to check balance of the amount

    void checkBalance(){
        System.out.println("Balance: " + amount);
    }
    //Method to display Account Details

    void display(){
        System.out.println("\n" +"Account Details: "+"\n" +"AccountNo: "+account_number + "\n" + "Amount: " +amount);
    }
}
class TestAmount{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b1 = new Bank();
        System.out.println();
        System.out.println("===Baroda Bank of India ===");
        System.out.println("_______________________________");
        System.out.println("Enter Account Number: , Name and Amount");
        int a = sc.nextInt();
        String name = sc.next();
        float amt = sc.nextFloat();
        b1.insert(a, name, amt);
        b1.display();

        b1.checkBalance();
        System.out.println();
        System.out.println("Enter amount for deposit");
        float d = sc.nextFloat();

        b1.deposit(d);
        b1.checkBalance();
        System.out.println();

        System.out.println("Enter amount for withdraw");
        float w = sc.nextFloat();
        b1.withdraw(w);
        b1.checkBalance();
    }
}