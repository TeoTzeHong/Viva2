/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva2;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Viva2Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        
        while(continueProgram){
            System.out.println("Choose the shape to calculate the area:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
            switch(choice){
                case 1: // Circle
                    double radius = alwaysPositive(sc, "Enter the radius of the circle: ");
                    double circleArea = calculateCircleArea(radius);
                    System.out.printf("The area of the circle is: %.2f%n", circleArea);
                    System.out.println();
                    break;
                    
                case 2: // Rectangle
                    double length = alwaysPositive(sc, "Enter the length of the rectangle: ");
                    double width = alwaysPositive(sc, "Enter the width of the rectangle: ");
                    double rectangleArea = calculateRectangleArea(length, width);
                    System.out.printf("The area of the rectangle is: %.2f%n", rectangleArea);
                    System.out.println();
                    break;
                    
                case 3: // Triangle
                    double base = alwaysPositive(sc, "Enter the base of the triangle: ");
                    double height = alwaysPositive(sc, "Enter the base of the triangle: ");
                    double triangleArea = calculateTriangleArea(base, height);
                    System.out.printf("The area of the triangle is: %.2f%n", triangleArea);
                    System.out.println();
                    break;
                    
                case 4: // Exit
                    continueProgram = false;
                    System.out.println("Exiting the program. Bye!");
                    break;
                
                default:
                    System.out.println("Invalid choice. Please Try again.");
            }
        }   
    }
    
    // Method to calculate the area of a circle
    public static double calculateCircleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
    
    // Method to calculate the area of a rectangle
    public static double calculateRectangleArea(double length, double width){
        return length * width;
    }
    
    // Method to calculate the area of a triangle
    public static double calculateTriangleArea(double base, double height){
        return (base * height) / 2;
    }
    
    // Method to get positive input from the user
    public static double alwaysPositive(Scanner sc, String prompt){
        double value;
        do {
            System.out.print(prompt);
            value = sc.nextDouble();
            if (value < 0) {
                System.out.println("Input must be a positive number. Please try again.");
            }
        } while (value < 0);
        return value;
    }
}
