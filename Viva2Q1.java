/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package viva2;

import java.util.Scanner;
public class Viva2Q1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double balance=1000.0;
         String transactionHistory = ""; 
        int option;
        
        System.out.println("Welcome to the Bank!");
        do{
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposit Money ");
        System.out.println("3. Withdraw Money ");
        System.out.println("4. View Transaction History ");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        option=scanner.nextInt();
           
        
         switch(option){
             case 1:
                 checkBalance(balance);
                 System.out.println("");
                 break;
             case 2:
                  // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance = deposit(balance, depositAmount);  // Update balance after deposit
               transactionHistory += String.format("Deposited: %.2f%n", depositAmount);
                    break;
                case 3:
                    // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    balance = withdraw(balance, withdrawAmount);  // Update balance after withdrawal
                   transactionHistory += String.format("Withdrew: %.2f%n", withdrawAmount);
                    break;
                case 4:
                   printTransactions(transactionHistory);
                    break;
                case 5:
                    System.out.println("\nThank you for using the banking system!");
                    System.out.printf("Your final balance is :%.2f%n",balance);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        } while (option != 5);  // Repeat until user chooses to exit

                 
         }
         
    public static void checkBalance(double balance){
                System.out.printf("Current balance: %.2f%n",balance);  
        }
         public static double deposit(double balance, double amount) {
        if (amount > 0) {
            balance += amount;  // Add deposit amount to balance
            System.out.printf("Your balance is now: %.2f%n",balance);
            System.out.println("");
        } else {
            System.out.println("Invalid deposit amount. Please try again.\n");
        }
        return balance;  // Return the updated balance
    }

    public static double withdraw(double balance, double amount) {
        if (amount > 0 && amount <= balance) {  // Ensure there are sufficient funds
            balance -= amount;  // Subtract withdrawal amount from balance
            System.out.printf("Your balance is now: %.2f%n",balance);
            System.out.println("");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.\n");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.\n");
        }
        return balance;  // Return the updated balance
    }
    
    public static void printTransactions(String transactionHistory) {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Transaction History:");
            System.out.println(transactionHistory);  // Print the entire transaction history
        }
    

    }       
}
