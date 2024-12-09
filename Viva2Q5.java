/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva2q5;

/**
 *
 * @author cyq27
 */
public class Viva2q5 {

    public static String[][] getStudentInfo(String[] studentID, String[] studentName, int[] mark) {
        
        String[][] studentInfo = new String[studentID.length][3];
        
        for (int i=0; i<studentID.length; i++) {
            studentInfo[i][0] = studentID[i];
            studentInfo[i][1] = studentName[i];
            studentInfo[i][2] = String.valueOf(mark[i]);
        }
    return studentInfo;
    }

    public static void printStudentInfo(String[][] studentInfo) {
        
        for (String[] student : studentInfo) {
            System.out.printf("%-6s - %-9s : %-5s%n", student[0], student[1], student[2]);
        }
    }
    

    public static void findStudentWithHighestMarks(String[][] studentInfo) {
        
        String highestMarkStudent = studentInfo[0][1];
        int highestMark = Integer.parseInt(studentInfo[0][2]);
        
        for (String[] student : studentInfo) {
            int mark = Integer.parseInt(student[2]);
            
            if (mark > highestMark) {
                highestMark = mark;
                highestMarkStudent = student[1];
            }
            }
        
         System.out.println(highestMarkStudent + ": " + highestMark);
    }

    
    public static double findAverage(int[] mark) {
        double totalMarks=0;
        int totalStudents = mark.length;

        
        for (int m : mark) {
            totalMarks += m;
        }
        
        double average = totalMarks / totalStudents;
        return average;
        
    }


    public static void listStudentsBelowAverage(String[][] studentInfo, double average) {
        
        for (String[] student : studentInfo) {
            int mark = Integer.parseInt(student[2]);
            if (mark < average) {
                System.out.println(student[1] + " : " + mark);
            }
        }
    }
    
    
    public static void main(String[] args) {
        
        String[] studentID = {"S0001", "S0002", "S0003", "S0004", "S0005", "S0006"};
        String[] studentName = {"John", "Cindy", "Alex", "Ali", "Rosli", "Roger"};
        int[] mark = {59, 62, 21, 36, 85, 74};

        String[][] studentInfo = getStudentInfo(studentID, studentName, mark);

        System.out.println("List of Students and their Marks: ");
        printStudentInfo(studentInfo);
        System.out.println("");
        
        System.out.println("Student with highest marks: ");
        findStudentWithHighestMarks(studentInfo);
        System.out.println("");

        System.out.println("Average mark: " + findAverage(mark));
        System.out.println("");

        System.out.println("Students scoring below the average:");
        listStudentsBelowAverage(studentInfo, findAverage(mark));
    }
}
    

