/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g101;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Duration;

public class G101 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]part;
        int cases = sc.nextInt();
        sc.nextLine();
        for(int i=1;i<=cases;i++)
        {
            String name = sc.nextLine().toUpperCase();
            
            part = name.split("[\\s\\.\\'\\-\\_]");

            String fullName="";
        
            for(int j=0;j<part.length;j++)
            {         
                if(j==part.length-1)
                    fullName+=part[j];
                else
                    fullName+=part[j]+" ";
            }   
          
            String timestart=sc.nextLine().toUpperCase();
            String timefinish=sc.nextLine().toUpperCase();
            System.out.println("");
        
            for(int k=1;k<=60;k++)
            {
                System.out.print("+");
            }
            System.out.println("");
        
            isPrintingWelcomeMessage(fullName);
            generateInitials(fullName,part);
            
            calculateInterval(timestart, timefinish);
            
            
            for(int k=1;k<=60;k++)
            {
                System.out.print("+");
            }
            System.out.println("");
        
        }
        
    }
    
    public static void generateInitials (String fullName, String[] part)
    {
        String initials="";
        if(fullName.contentEquals("KAH SING LEE"))
        {
            String temp = part[part.length-1];
            for(int i=part.length-1;i>0;i--)
            {
                part[i]=part[i-1];
            }
            part[0]=temp;
        }
        
        for(int i =0;i<part.length;i++)
            {
                if(part[i].contentEquals("A/L") || part[i].contentEquals("A/P") || part[i].contentEquals("AL") || part[i].contentEquals("AP"))
                    continue;
                else if(part[i].contentEquals("BIN") || part[i].contentEquals("BINTI"))
                    continue;
                else
                    initials += part[i].charAt(0);
            }
        if(fullName.contentEquals("LEE KAH SING") )
        {
            System.out.println(initials+"!!!!!!!!!!");
            System.out.println("WE KNOW IT'S YOU!");
        }
        else if(fullName.contentEquals("KAH SING LEE")/*|| fullName.contains("KAH SING")*/)
        {      
            System.out.println(initials+"!!!!!!!!!!");
            System.out.println("WE KNOW IT'S YOU! -- LEE KAH SING!");
        }
        else
            System.out.println(initials);
        
        
    }
    
    public static void  isPrintingWelcomeMessage(String fullName)
    {
        if(fullName.contains("KAH SING")||fullName.contains("SURESH")|| fullName.contains("RIDWAN"))
            System.out.println("Welcome to G101, Kolej Kediaman Kinabalu, Universiti Malaya!");

    }
    
    // to calculate the interval between start and end times 
    public static void calculateInterval(String timestart ,String timefinish )
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime start,end;
        Duration difference ;
        
        char tagStart, tagFinish;
            if(timestart.contains("AM"))
            {
                tagStart = 'A';
                timestart = timestart.replace("AM", "");
            }    
            else if(timestart.contains("PM"))
            {
                tagStart = 'P';
                timestart = timestart.replace("PM","");
            }
            else
                tagStart = 'N';    

            if(timefinish.contains("AM"))
            {
                tagFinish = 'A';
                timefinish = timefinish.replace("AM", "");
            }
                
            else if(timefinish.contains("PM"))
            {
                tagFinish = 'P';
                timefinish = timefinish.replace("PM", "");
            }   
            else
                tagFinish = 'N';
            
            while(timestart.contains(" ") || timefinish.contains(" "))
            {
                timestart = timestart.replace(" ","");
                timefinish = timefinish.replace(" ","");
            }
            
            try{
                start = LocalTime.parse(timestart, format);
                end = LocalTime.parse(timefinish, format);
            }catch(DateTimeParseException e){
                System.out.println("Invalid Time Format");
                return;
            }
            
            

        int hourstart = start.getHour();
        int hourfinish = end.getHour();

        
        if(tagStart=='A' && hourstart==12 )//for 12:00:00 am
        {
            start = start.minusHours(12);
        }
        else if(tagStart=='A' && hourstart>12 )//for 13:00:00 am
        {
            System.out.println("Invalid Time Format!");
            return;
        }
        if(tagStart=='P' && hourstart<12 && hourstart>0)//for 01:00:00 pm
        {
            start = start.plusHours(12);
        }
        
        if(tagFinish=='A' && hourfinish==12)
        {
            end = end.minusHours(12);
        }
        else if(tagFinish=='A' && hourfinish>12)
        {
            System.out.println("Invalid Time Format!");
            return;
        }
        if(tagFinish=='P' && hourfinish<12 && hourfinish>0)
        {
            end = end.plusHours(12);
        }    
          
        if(start == end)
        {
            System.out.println("The start time and end time can't be same.");
            return;
        }
        
        //time detect and message
        if(((start.isAfter(LocalTime.MIDNIGHT)||start.equals(LocalTime.MIDNIGHT))&&start.isBefore(LocalTime.of(06, 00, 00))) && 
                    ((end.isAfter(LocalTime.MIDNIGHT)||end.equals(LocalTime.MIDNIGHT)) && end.isBefore(LocalTime.of(06, 00, 00))) && 
                    end.isAfter(start))
                System.out.println("SLEEP NOW!!!!!!!!!!");
        
        //calculations      
        int hour, minute, second;

        LocalTime output = LocalTime.MIN;
        difference = Duration.between(end,start);

        output = output.minus(difference);
        
        hour = output.getHour();
        minute = output.getMinute();
        second = output.getSecond();
        System.out.printf("%02d:%02d:%02d%n", hour,minute,second);
        
            
    }
}
