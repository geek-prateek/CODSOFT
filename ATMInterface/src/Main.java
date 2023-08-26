import java.util.*;
import java.util.Scanner;

class ATM{
    float Balance;
    int PIN;

    public ATM(int initialBalance, int pin) {
        Balance = initialBalance;
        PIN = pin;
    }

    public void checkpin(){
        System.out.println("Enter your pin : ");
        Scanner sc = new Scanner(System.in);
        int enterpin = sc.nextInt();
        if(enterpin == PIN){
            menu();
        }else{
            System.out.println("Enter a valid PIN");
        }
        checkpin();
    }

    public void menu(){
        System.out.println("Enter your choice : ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if(opt == 1){
            checkBalance();
        }else if(opt == 2){
            withdrawMoney();
        }else if(opt == 3){
            depositMoney();
        }else if(opt == 4){
            return;
        }
        else{
            System.out.println("Enter a valid choice");
        }
    }

    public void checkBalance(){
        System.out.println("Balance: "+Balance);
        menu();
    }
    public void withdrawMoney(){
        System.out.println("Enter Amount to Withdraw : ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if(amount > Balance){
            System.out.println("Insufficient Balance");
        }else{
            Balance = Balance - amount;
            System.out.println("Money Withdrawal Successful");
        }
        menu();
    }
    public void depositMoney(){
        System.out.println("Enter the Amount : ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money Deposit Successful");
        menu();
    }
}
public class Main {
    public static void main(String[] args) {
        int initialBalance = 1000;
        int pin = 7345;
        ATM obj = new ATM(initialBalance, pin);
        obj.checkpin();
    }
}