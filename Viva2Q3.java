/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva2q3;

/**
 *
 * @author User
 */
import java.util.Scanner;
import java.util.ArrayList;
public class VIVA2Q3 {
    static class Book{
        String bookTitle;
        String bookAuthor;
        
        public Book(String bookTitle,String bookAuthor){
            this.bookTitle=bookTitle;
            this.bookAuthor=bookAuthor;
        }
    //Method to return bookDetails as string
        public String getBookDetails(){
            return "Book Details: " + this.bookTitle +  " by " + this.bookAuthor ;
        }
   
    //Method to return bookDetails as string without prefix
        public String getBookDetailsWithoutPrefix(){
            return this.bookTitle + " by " + this.bookAuthor;
        }
    }
    
    //Array list is created to store the books
    public static ArrayList<Book> books = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
while (true){
        System.out.print("""
                           Choose an action:
                            1. Add a new book
                            2. View the details of a specific book
                            3. View all books
                            4. Exit
                            Choice of action: """);
        int action=sc.nextInt();
        sc.nextLine();
        
        if( action == 1 ){
            
            System.out.print("Enter book title:");
            String bookTitle=sc.nextLine();
            System.out.print("Enter book author:");
            String bookAuthor=sc.nextLine();
            books.add(new Book(bookTitle,bookAuthor));
            sc.nextLine();
           
        }
        
        else if( action == 2 ){
            
            System.out.println("Enter book title:");
            String bookTitle=sc.nextLine();
            System.out.println(bookDetails(bookTitle));
            sc.nextLine();
           
        }
        
        else if ( action == 3){
            
            for (int i = 0; i < books.size(); i++){
                System.out.println(books.get(i).getBookDetailsWithoutPrefix());

            }
            sc.nextLine();
            
        }
        
        else if ( action == 4){
            System.out.println("Program ending. . .");
            break;
        }
    }
}    
        //Method to get details of book title entered specifically
        public static String bookDetails(String bookTitle){
            for (int i = 0; i < books.size(); i++){
                if(books.get(i).bookTitle.equalsIgnoreCase(bookTitle)){
                    return books.get(i).getBookDetails();
                }
            }
            return "Book is not found";
        }
    }





        
   

         
            
            
            
            
            
            
     
