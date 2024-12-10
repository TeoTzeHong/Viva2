/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva2q4;

import java.util.Arrays;
import java.util.Scanner;
public class Viva2Q4 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many ISBN-10 number to check? : ");
        String num= sc.nextLine();
        
        try{
            int check = Integer.parseInt(num);
            String [] ISBN = new String[check];
            System.out.println(Arrays.toString(validateISBNList(ISBN)));
        }catch(NumberFormatException e){
            System.out.println("Invalid Format of input.");
        }
       
    }
    public static boolean isValidISBN (String ISBN)
    {
       
       int sum=0;
       
       for(int i= 0;i<ISBN.length()-1;i++)
       {
           
           sum+=Character.getNumericValue(ISBN.charAt(i))*(i+1);
           
       }
       char last = ISBN.charAt(9);
       int digitCheck;
       if(last == 'X')
           digitCheck = 10;
       else 
           digitCheck = Character.getNumericValue(last);
       
       return sum %11== digitCheck;
       
    }
    public static Boolean[] validateISBNList(String[] ISBN)
    {
        Scanner o = new Scanner(System.in);
        for(int i=0;i<ISBN.length;i++)
        {
            
            System.out.println("Enter the ISBN-10: ");
            String temp = o.nextLine();
            while(temp == null || temp.length()!=10 || (temp.charAt(9)!='X' && !Character.isDigit(temp.charAt(9))))
            {
                System.out.println("Invalid format, please try again:");
                System.out.println("Enter the ISBN-10: ");
                temp = o.nextLine();
            }
            for(int j =0;j<temp.length()-1;j++)
            {
                while(!Character.isDigit(temp.charAt(j)))
                {
                    System.out.println("Invalid format, please try again:");
                    System.out.println("Enter the ISBN-10: ");
                    temp = o.nextLine();
                }
            }
            ISBN[i]=temp;
        }
        
        Boolean [] check = new Boolean[ISBN.length];
        for(int i=0;i<check.length;i++)
        {
            check[i]=  isValidISBN(ISBN[i]);
        }
        System.out.println(Arrays.toString(ISBN));
        return check;
    }
     
}
