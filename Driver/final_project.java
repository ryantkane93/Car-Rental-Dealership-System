/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class final_project extends javax.swing.JFrame {
    //Declare an array list for each car type.
    static ArrayList<Compact>compactList = new ArrayList<>();
    static ArrayList<Mid>midList = new ArrayList<>();
    static ArrayList<SUV>SUVList = new ArrayList<>();
    static ArrayList<Small>smallList = new ArrayList<>();
    static ArrayList<Sport>sportList = new ArrayList<>();
    static ArrayList<Van>vanList = new ArrayList<>();
    
    //Open a scanner that will be used to gather input for customer information.
    static Scanner userInput = new Scanner(System.in);
    
   static Date today = new Date(2015, 5, 13); //Set the date for today.
    
    //Open a file to write all of today's transactions to.
    static File todayRentals = new File("rentals.txt");
    static File todayReturns = new File("returns.txt");
    static File logFile = new File ("log.txt");
    static File dayEnd = new File("DayEndReport.txt");
    
public static void emptyFile(File file)
{
    //Empties the report for today's rentals so that the previous days data does not remain
    //in the file.
    try
    {
        PrintWriter pw = new PrintWriter(file);
        pw.close();
        PrintWriter header = new PrintWriter(file);
        header.close();
    }
    catch(FileNotFoundException fnf)
    {
        System.err.println("Unable to access one of  the report files. Terminating program!");
        System.exit(1);
    }
}
 
public static void compileReturns(File todayReturns) //Composes the returns report (all cars with a due dates of today)
{
    try{
    FileWriter fileWritter = new FileWriter(todayReturns,true);
    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
    
        for(int i =0; i < compactList.size();i++)
        {
            if(compactList.get(i).getDueDate()==today)
            {
                bufferWriter.newLine();
                bufferWriter.write("--------------------");
                bufferWriter.newLine();
                bufferWriter.write("CUSTOMER:");
                bufferWriter.newLine();
                bufferWriter.write(compactList.get(i).getCurrentOwner().toString());
                bufferWriter.newLine();
                bufferWriter.write("RETURNED THE FOLLOWING VEHICLE:");
                bufferWriter.newLine();
                bufferWriter.write(compactList.get(i).toString());
                bufferWriter.write("ON "+ compactList.get(i).stringDueDate()+"."); //Since dueDate must equal today, this call prints out today's date.
                bufferWriter.newLine();
            }
        }
    
    
        for(int i =0; i < midList.size();i++)
        {
            if(midList.get(i).getDueDate()==today)
            {
                bufferWriter.write("--------------------");
                bufferWriter.newLine();
                bufferWriter.write("CUSTOMER:");
                bufferWriter.newLine();
                bufferWriter.write(midList.get(i).getCurrentOwner().toString());
                bufferWriter.newLine();
                bufferWriter.write("RETURNED THE FOLLOWING VEHICLE:");
                bufferWriter.newLine();
                bufferWriter.write(midList.get(i).toString());
                bufferWriter.write("ON "+ midList.get(i).stringDueDate()+"."); //Since dueDate must equal today, this call prints out today's date.
            }
        }
        
        for(int i =0; i < SUVList.size();i++)
        {
            if(SUVList.get(i).getDueDate()==today)
            {
                bufferWriter.write("--------------------");
                bufferWriter.newLine();
                bufferWriter.write("CUSTOMER:");
                bufferWriter.newLine();
                bufferWriter.write(SUVList.get(i).getCurrentOwner().toString());
                bufferWriter.newLine();
                bufferWriter.write("RETURNED THE FOLLOWING VEHICLE:");
                bufferWriter.newLine();
                bufferWriter.write(SUVList.get(i).toString());
                bufferWriter.write("ON "+ SUVList.get(i).stringDueDate()+"."); //Since dueDate must equal today, this call prints out today's date.
            }
        }
        for(int i =0; i < smallList.size();i++)
        {
            if(smallList.get(i).getDueDate()==today)
            {
                bufferWriter.write("--------------------");
                bufferWriter.newLine();
                bufferWriter.write("CUSTOMER:");
                bufferWriter.newLine();
                bufferWriter.write(smallList.get(i).getCurrentOwner().toString());
                bufferWriter.newLine();
                bufferWriter.write("RETURNED THE FOLLOWING VEHICLE:");
                bufferWriter.newLine();
                bufferWriter.write(smallList.get(i).toString());
                bufferWriter.write("ON "+ smallList.get(i).stringDueDate()+"."); //Since dueDate must equal today, this call prints out today's date.
            }
        }
       
        for(int i =0; i < sportList.size();i++)
        {
            if(sportList.get(i).getDueDate()==today)
            {
                bufferWriter.write("--------------------");
                bufferWriter.newLine();
                bufferWriter.write("CUSTOMER:");
                bufferWriter.newLine();
                bufferWriter.write(sportList.get(i).getCurrentOwner().toString());
                bufferWriter.newLine();
                bufferWriter.write("RETURNED THE FOLLOWING VEHICLE:");
                bufferWriter.newLine();
                bufferWriter.write(sportList.get(i).toString());
                bufferWriter.write("ON "+ sportList.get(i).stringDueDate()+"."); //Since dueDate must equal today, this call prints out today's date.
            }
        }
        
        for(int i =0; i < vanList.size();i++)
        {
            if(vanList.get(i).getDueDate()==today)
            {
                bufferWriter.write("--------------------");
                bufferWriter.newLine();
                bufferWriter.write("CUSTOMER:");
                bufferWriter.newLine();
                bufferWriter.write(vanList.get(i).getCurrentOwner().toString());
                bufferWriter.newLine();
                bufferWriter.write("RETURNED THE FOLLOWING VEHICLE:");
                bufferWriter.newLine();
                bufferWriter.write(vanList.get(i).toString());
                bufferWriter.write("ON "+ vanList.get(i).stringDueDate()+"."); //Since dueDate must equal today, this call prints out today's date.
            }
        }
       bufferWriter.close(); 
    }
    catch(IOException io)
    {
        System.err.println("Returns document unable to be opened! Terminating program.");
        System.exit(1);
    }
}

//The proceeding function makes an array list out of all of the doubles in the dayEnd report and then takes the sum 
//of all of the double values to generate a total. The total is then appended onto the end of the dayEnd file.
public static void compileDayEnd(File dayEnd)
{
    ArrayList <Double> prices = new ArrayList <Double> ();
    double total =0;
    
    String temp; //String that will be parsed into a double value.
    String line; //Used to access a particular line of the file.
     try 
     {
       BufferedReader in = new BufferedReader(new FileReader(dayEnd)); //Buffer reader to check file for rentals toa dd.

       while((line=in.readLine()) != null)
       {
           
           if(line.contains("TOTAL:")) //If the line in the file is a total from a rental.
           {
               String split[] = line.split("\\$"); //Split the line into two pieces, with the second element in the array being the double value.
               double num = Double.parseDouble(split[1]); //Parse the number value to a double.
               prices.add(num); //Add the double value to the array.
           }
       }
        
        for(int i =0; i < prices.size();i++) //Take the sum of all of the prices extracted from the file.
        {
            
            total += prices.get(i);
        }
        
        //Buffer writer to add add the total to the file.
       FileWriter fileWritter = new FileWriter(dayEnd,true);
       BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
        String dailyTotal = String.format("$%.2f",total);
        bufferWriter.newLine();
        bufferWriter.newLine();
        bufferWriter.write("TODAY'S EARNINGS: " + dailyTotal);
        bufferWriter.close();
    }
     catch (FileNotFoundException ex) {
            System.err.println("Unable to find end of day file! Terminating program.");
            System.exit(1);
     }
     catch(IOException ex)
    {
        System.err.println("Unable to write the total to the file. Termianting program!");
        System.exit(1);
    }
}

public static void rentCompact(ArrayList<Compact>compactList, Scanner userInput)
{
           int compactNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        int numDays  = 0;
        System.out.print("The available compact cars are as follows:\n");
        for(int i =0; i < compactList.size(); i++)
        {
           if(compactList.get(i).isAvailable())
           {
           System.out.print(compactList.get(i).toString());     
           System.out.println("");
           }
        }
        
        //Allows the user to see the list of available cars and then decide if they'd like to rent any.
        System.out.println("Would you like to rent a car now ('yes or 'no)?");
        String answer = userInput.next();
        if(answer.equals("yes"))
        {
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model (in all capital letters) of the compact car you wish to lease:");
                String compactModel = userInput.next();
                for(int i =0; i < compactList.size(); i++) //Search the compact array for the available vehicle.
                {
                    if(compactList.get(i).getModel().equals(compactModel) && compactList.get(i).isAvailable()) //If the VIN's are equal and the car is available.
                    {
                        compactNum = i; //Store the position of the car in the array so that changes can be made outside of the toop.
                        break; //Break once we have found that the car was available and have its location in the array.
                    }
                }

                compactList.get(compactNum).setAvailable(false); //Car is now unavailable.
                compactList.get(compactNum).setPickupDate(today); //Set the pick up date to today.
                System.out.println("Please insert the following information on the customer renting the car: ");
                System.out.println("First name: ");
                String fName = userInput.next();
                System.out.println("Last name: ");
                String lName = userInput.next();
                System.out.println("Home street address:");
                userInput.nextLine();
                String address = userInput.nextLine();
                System.out.println("City of residence:");
                String city = userInput.nextLine();
                System.out.println("Zip code: ");
                int zip = userInput.nextInt();
                System.out.println("State: ");
                userInput.nextLine();
                String state = userInput.nextLine();
                System.out.println("Phone number: ");
                String phone = userInput.next();
                System.out.println("Month of birth (numeric value): ");
                int month = userInput.nextInt();
                System.out.println("Day of birth (numeric value): ");
                int day = userInput.nextInt();
                System.out.println("Year of birth (as a four digit number): ");
                int year = userInput.nextInt();
                String birthday;
                birthday = String.format("%2d/%2d/%d", month, day, year);

                System.out.println("For how many days will this car be rented?");
                numDays = userInput.nextInt();
                Date dueDate = new Date();
                dueDate.setTime( today.getTime() + numDays * 86400000 );
                compactList.get(compactNum).setDueDate(dueDate);

                System.out.println("\nIs the customer a business client? (Please enter 'yes' or 'no'");
                String compactClient = userInput.next();

                if("yes".equals(compactClient))
                {
                    System.out.println("What company does the customer belong to?");
                    String company = userInput.next();
                    System.out.println("Company phone number: ");
                    String companyPhone = userInput.next();
                    double businessAmount = numDays *  compactList.get(compactNum).getDailyBusinessRate();
                    BusinessClient bClient = new BusinessClient(lName, fName, address, city, state, zip, phone, birthday, businessAmount, company, companyPhone);
                    compactList.get(compactNum).setCurrentOwner(bClient);
                }
                else //It is a standard client.
                {
                   double standardAmount = numDays *  compactList.get(compactNum).getDailyRate(); 
                   Client client = new Client(lName, fName, address, city, state, zip,phone, birthday, standardAmount);
                   compactList.get(compactNum).setCurrentOwner(client);
                }

                String due = dueDate.toString();
                System.out.println("Car rental complete! " + compactList.get(compactNum).getCurrentOwner().getFirstName() + " " + compactList.get(compactNum).getCurrentOwner().getLastName() 
                        + " is renting this vehicle until "+ due.substring(0,10)+"."); 
                errorCount = 5;
                }  



            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }

            catch(ArrayIndexOutOfBoundsException ob)
            {
                System.err.println("That car is not in our fleet! Please try again!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw ob;
                }
            }
           
        }
        //Car is successfully checked out, now need to write to today's records.
        
       
        try
        {
            //Check if there is a file open yet.
            if(!todayRentals.exists()){
            System.out.println("New rental file created!");
            todayRentals.createNewFile();
            }
            
            FileWriter fileWritter = new FileWriter(todayRentals,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(compactList.get(compactNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("IS RENTING THE FOLLOWING VEHICLE:");
            bufferWriter.newLine();
            bufferWriter.write(compactList.get(compactNum).toString());
            bufferWriter.write("UNTIL "+ compactList.get(compactNum).getPickupDate()+".");
            bufferWriter.close();
            
            //Open another file writer to record the cost of the rental in the day end report.
             FileWriter dayEndReport = new FileWriter(dayEnd,true);
             BufferedWriter endWriter = new BufferedWriter(dayEndReport);
            endWriter.write("----------------------");
            endWriter.newLine();
            endWriter.write("CUSTOMER:");
            endWriter.newLine();
            endWriter.write("Name:");
            endWriter.write(compactList.get(compactNum).getCurrentOwner().getFirstName() + " " + compactList.get(compactNum).getCurrentOwner().getLastName());
            endWriter.newLine();
            endWriter.write("RENTED: ");
            endWriter.write(compactList.get(compactNum).getMake()+ " " + compactList.get(compactNum).getModel());
            endWriter.newLine();
            endWriter.write("VIN: "+ compactList.get(compactNum).getVin());
            endWriter.newLine();
            endWriter.write("FOR: " + numDays + " day(s)");
            endWriter.newLine();
            endWriter.write("TOTAL: $" + compactList.get(compactNum).getCurrentOwner().getAmountOwed());
            endWriter.newLine();
            endWriter.close();
            
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
       }
       else
        {
            System.out.println("Please refer back to the windowed menu to perform another function!");
        }
    }    

    public static void rentMid(ArrayList<Mid>midList, Scanner useInput)
{
        int midNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        int numDays = 0;
          System.out.print("The available mid cars are as follows:\n");
        for(int i =0; i < midList.size(); i++)
        {
           if(midList.get(i).isAvailable())
           {
           System.out.print(midList.get(i).toString());     
           System.out.println("");
           }
        }
        
        //Allows the user to see the list of available cars and then decide if they'd like to rent any.
        System.out.println("Would you like to rent a car now ('yes or 'no)?");
        String answer = userInput.next();
        if(answer.equals("yes"))
        {
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model (in all capital letters) of the mid car you wish to lease:");
                String midModel = userInput.next();
                for(int i =0; i < midList.size(); i++) //Search the mid array for the available vehicle.
                {
                    if(midList.get(i).getModel().equals(midModel) && midList.get(i).isAvailable()) //If the VIN's are equal and the car is available.
                    {
                        midNum = i; //Store the position of the car in the array so that changes can be made outside of the toop.
                        break; //Break once we have found that the car was available and have its location in the array.
                    }
                }

                midList.get(midNum).setAvailable(false); //Car is now unavailable.
                midList.get(midNum).setPickupDate(today); //Set the pick up date to today.
                System.out.println("Please insert the following information on the customer renting the car: ");
                System.out.println("First name: ");
                String fName = userInput.next();
                System.out.println("Last name: ");
                String lName = userInput.next();
                System.out.println("Home street address:");
                userInput.nextLine();
                String address = userInput.nextLine();
                System.out.println("City of residence:");
                String city = userInput.nextLine();
                System.out.println("Zip code: ");
                int zip = userInput.nextInt();
                System.out.println("State: ");
                userInput.nextLine();
                String state = userInput.nextLine();
                System.out.println("Phone number: ");
                String phone = userInput.next();
                System.out.println("Month of birth (numeric value): ");
                int month = userInput.nextInt();
                System.out.println("Day of birth (numeric value): ");
                int day = userInput.nextInt();
                System.out.println("Year of birth (as a four digit number): ");
                int year = userInput.nextInt();
                String birthday;
                birthday = String.format("%2d/%2d/%d", month, day, year);

                System.out.println("For how many days will this car be rented?");
                numDays = userInput.nextInt();
                Date dueDate = new Date();
                dueDate.setTime( today.getTime() + numDays * 86400000 );
                midList.get(midNum).setDueDate(dueDate);

                System.out.println("\nIs the customer a business client? (Please enter 'yes' or 'no'");
                String midClient = userInput.next();

                if("yes".equals(midClient))
                {
                    System.out.println("What company does the customer belong to?");
                    String company = userInput.next();
                    System.out.println("Company phone number: ");
                    String companyPhone = userInput.next();
                    double businessAmount = numDays *  midList.get(midNum).getDailyBusinessRate();
                    BusinessClient bClient = new BusinessClient(lName, fName, address, city, state, zip, phone, birthday, businessAmount, company, companyPhone);
                    midList.get(midNum).setCurrentOwner(bClient);
                }
                else //It is a standard client.
                {
                   double standardAmount = numDays *  midList.get(midNum).getDailyRate(); 
                   Client client = new Client(lName, fName, address, city, state, zip,phone, birthday, standardAmount);
                   midList.get(midNum).setCurrentOwner(client);
                }

                String due = dueDate.toString();
                System.out.println("Car rental complete! " + midList.get(midNum).getCurrentOwner().getFirstName() + " " + midList.get(midNum).getCurrentOwner().getLastName() 
                        + " is renting this vehicle until "+ due.substring(0,10)+"."); 
                errorCount = 5;
                }  
            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }

            catch(ArrayIndexOutOfBoundsException ob)
            {
                System.err.println("That car is not in our fleet! Please try again!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw ob;
                }
            }
           
        }
        //Car is successfully checked out, now need to write to today's records.
        
       
        try
        {
            //Check if there is a file open yet.
            if(!todayRentals.exists()){
            System.out.println("New rental file created!");
            todayRentals.createNewFile();
            }
            
            FileWriter fileWritter = new FileWriter(todayRentals,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(midList.get(midNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("IS RENTING THE FOLLOWING VEHICLE:");
            bufferWriter.newLine();
            bufferWriter.write(midList.get(midNum).toString());
            bufferWriter.write("UNTIL "+ midList.get(midNum).getPickupDate()+".");
            bufferWriter.close();
            
            //Open another file writer to record the cost of the rental in the day end report.
             FileWriter dayEndReport = new FileWriter(dayEnd,true);
             BufferedWriter endWriter = new BufferedWriter(dayEndReport);
            endWriter.write("----------------------");
            endWriter.newLine();
            endWriter.write("CUSTOMER:");
            endWriter.newLine();
            endWriter.write("Name:");
            endWriter.write(midList.get(midNum).getCurrentOwner().getFirstName() + " " + midList.get(midNum).getCurrentOwner().getLastName());
            endWriter.newLine();
            endWriter.write("RENTED: ");
            endWriter.write(midList.get(midNum).getMake()+ " " + midList.get(midNum).getModel());
            endWriter.newLine();
            endWriter.write("VIN: "+ midList.get(midNum).getVin());
            endWriter.newLine();
            endWriter.write("FOR: " + numDays + " day(s)");
            endWriter.newLine();
            endWriter.write("TOTAL: $" + midList.get(midNum).getCurrentOwner().getAmountOwed());
            endWriter.newLine();
            endWriter.close();
            
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
        }
        else
        {
            System.out.println("Please go back to the windowed menu to select another function!");
        }
    }   
    
    public static void rentSUV(ArrayList<SUV>SUVList, Scanner useInput)
{
           int SUVNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        int numDays = 0;
        System.out.print("The available SUV cars are as follows:\n");
        for(int i =0; i < SUVList.size(); i++)
        {
           if(SUVList.get(i).isAvailable())
           {
           System.out.print(SUVList.get(i).toString());     
           System.out.println("");
           }
        }
        
        //Allows the user to see the list of available cars and then decide if they'd like to rent any.
        System.out.println("Would you like to rent a car now ('yes or 'no)?");
        String answer = userInput.next();
        if(answer.equals("yes"))
        {
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model (in all capital letters) of the SUV car you wish to lease:");
                String SUVModel = userInput.next();
                for(int i =0; i < SUVList.size(); i++) //Search the SUV array for the available vehicle.
                {
                    if(SUVList.get(i).getModel().equals(SUVModel) && SUVList.get(i).isAvailable()) //If the VIN's are equal and the car is available.
                    {
                        SUVNum = i; //Store the position of the car in the array so that changes can be made outside of the toop.
                        break; //Break once we have found that the car was available and have its location in the array.
                    }
                }

                SUVList.get(SUVNum).setAvailable(false); //Car is now unavailable.
                SUVList.get(SUVNum).setPickupDate(today); //Set the pick up date to today.
                System.out.println("Please insert the following information on the customer renting the car: ");
                System.out.println("First name: ");
                String fName = userInput.next();
                System.out.println("Last name: ");
                String lName = userInput.next();
                System.out.println("Home street address:");
                userInput.nextLine();
                String address = userInput.nextLine();
                System.out.println("City of residence:");
                String city = userInput.nextLine();
                System.out.println("Zip code: ");
                int zip = userInput.nextInt();
                System.out.println("State: ");
                userInput.nextLine();
                String state = userInput.nextLine();
                System.out.println("Phone number: ");
                String phone = userInput.next();
                System.out.println("Month of birth (numeric value): ");
                int month = userInput.nextInt();
                System.out.println("Day of birth (numeric value): ");
                int day = userInput.nextInt();
                System.out.println("Year of birth (as a four digit number): ");
                int year = userInput.nextInt();
                String birthday;
                birthday = String.format("%2d/%2d/%d", month, day, year);

                System.out.println("For how many days will this car be rented?");
                numDays = userInput.nextInt();
                Date dueDate = new Date();
                dueDate.setTime( today.getTime() + numDays * 86400000 );
                SUVList.get(SUVNum).setDueDate(dueDate);

                System.out.println("\nIs the customer a business client? (Please enter 'yes' or 'no'");
                String SUVClient = userInput.next();

                if("yes".equals(SUVClient))
                {
                    System.out.println("What company does the customer belong to?");
                    String company = userInput.next();
                    System.out.println("Company phone number: ");
                    String companyPhone = userInput.next();
                    double businessAmount = numDays *  SUVList.get(SUVNum).getDailyBusinessRate();
                    BusinessClient bClient = new BusinessClient(lName, fName, address, city, state, zip, phone, birthday, businessAmount, company, companyPhone);
                    SUVList.get(SUVNum).setCurrentOwner(bClient);
                }
                else //It is a standard client.
                {
                   double standardAmount = numDays *  SUVList.get(SUVNum).getDailyRate(); 
                   Client client = new Client(lName, fName, address, city, state, zip,phone, birthday, standardAmount);
                   SUVList.get(SUVNum).setCurrentOwner(client);
                }

                String due = dueDate.toString();
                System.out.println("Car rental complete! " + SUVList.get(SUVNum).getCurrentOwner().getFirstName() + " " + SUVList.get(SUVNum).getCurrentOwner().getLastName() 
                        + " is renting this vehicle until "+ due.substring(0,10)+"."); 
                errorCount = 5;
                }  



            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }

            catch(ArrayIndexOutOfBoundsException ob)
            {
                System.err.println("That car is not in our fleet! Please try again!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw ob;
                }
            }
           
        }
        //Car is successfully checked out, now need to write to today's records.
        
       
        try
        {
            //Check if there is a file open yet.
            if(!todayRentals.exists()){
            System.out.println("New rental file created!");
            todayRentals.createNewFile();
            }
            
            FileWriter fileWritter = new FileWriter(todayRentals,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(SUVList.get(SUVNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("IS RENTING THE FOLLOWING VEHICLE:");
            bufferWriter.newLine();
            bufferWriter.write(SUVList.get(SUVNum).toString());
            bufferWriter.write("UNTIL "+ SUVList.get(SUVNum).getPickupDate()+".");
            bufferWriter.close();
            
            //Open another file writer to record the cost of the rental in the day end report.
             FileWriter dayEndReport = new FileWriter(dayEnd,true);
             BufferedWriter endWriter = new BufferedWriter(dayEndReport);
            endWriter.write("----------------------");
            endWriter.newLine();
            endWriter.write("CUSTOMER:");
            endWriter.newLine();
            endWriter.write("Name:");
            endWriter.write(SUVList.get(SUVNum).getCurrentOwner().getFirstName() + " " + SUVList.get(SUVNum).getCurrentOwner().getLastName());
            endWriter.newLine();
            endWriter.write("RENTED: ");
            endWriter.write(SUVList.get(SUVNum).getMake()+ " " + SUVList.get(SUVNum).getModel());
            endWriter.newLine();
            endWriter.write("VIN: "+ SUVList.get(SUVNum).getVin());
            endWriter.newLine();
            endWriter.write("FOR: " + numDays + " day(s)");
            endWriter.newLine();
            endWriter.write("TOTAL: $" + SUVList.get(SUVNum).getCurrentOwner().getAmountOwed());
            endWriter.newLine();
            endWriter.close();
            
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
      }
        else
        {
            System.out.println("Please refer to the windowed menu in order to perform another function!");
        }
    }   
    
    public static void rentSmall(ArrayList<Small>smallList, Scanner useInput)
{
           int smallNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        int numDays = 0;
         System.out.print("The available small cars are as follows:\n");
        for(int i =0; i < smallList.size(); i++)
        {
           if(smallList.get(i).isAvailable())
           {
           System.out.print(smallList.get(i).toString());     
           System.out.println("");
           }
        }
        
        //Allows the user to see the list of available cars and then decide if they'd like to rent any.
        System.out.println("Would you like to rent a car now ('yes or 'no)?");
        String answer = userInput.next();
        if(answer.equals("yes"))
        {
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model (in all capital letters) of the small car you wish to lease:");
                String smallModel = userInput.next();
                for(int i =0; i < smallList.size(); i++) //Search the small array for the available vehicle.
                {
                    if(smallList.get(i).getModel().equals(smallModel) && smallList.get(i).isAvailable()) //If the VIN's are equal and the car is available.
                    {
                        smallNum = i; //Store the position of the car in the array so that changes can be made outside of the toop.
                        break; //Break once we have found that the car was available and have its location in the array.
                    }
                }

                smallList.get(smallNum).setAvailable(false); //Car is now unavailable.
                smallList.get(smallNum).setPickupDate(today); //Set the pick up date to today.
                System.out.println("Please insert the following information on the customer renting the car: ");
                System.out.println("First name: ");
                String fName = userInput.next();
                System.out.println("Last name: ");
                String lName = userInput.next();
                System.out.println("Home street address:");
                userInput.nextLine();
                String address = userInput.nextLine();
                System.out.println("City of residence:");
                String city = userInput.nextLine();
                System.out.println("Zip code: ");
                int zip = userInput.nextInt();
                System.out.println("State: ");
                userInput.nextLine();
                String state = userInput.nextLine();
                System.out.println("Phone number: ");
                String phone = userInput.next();
                System.out.println("Month of birth (numeric value): ");
                int month = userInput.nextInt();
                System.out.println("Day of birth (numeric value): ");
                int day = userInput.nextInt();
                System.out.println("Year of birth (as a four digit number): ");
                int year = userInput.nextInt();
                String birthday;
                birthday = String.format("%2d/%2d/%d", month, day, year);

                System.out.println("For how many days will this car be rented?");
                numDays = userInput.nextInt();
                Date dueDate = new Date();
                dueDate.setTime( today.getTime() + numDays * 86400000 );
                smallList.get(smallNum).setDueDate(dueDate);

                System.out.println("\nIs the customer a business client? (Please enter 'yes' or 'no'");
                String smallClient = userInput.next();

                if("yes".equals(smallClient))
                {
                    System.out.println("What company does the customer belong to?");
                    String company = userInput.next();
                    System.out.println("Company phone number: ");
                    String companyPhone = userInput.next();
                    double businessAmount = numDays *  smallList.get(smallNum).getDailyBusinessRate();
                    BusinessClient bClient = new BusinessClient(lName, fName, address, city, state, zip, phone, birthday, businessAmount, company, companyPhone);
                    smallList.get(smallNum).setCurrentOwner(bClient);
                }
                else //It is a standard client.
                {
                   double standardAmount = numDays *  smallList.get(smallNum).getDailyRate(); 
                   Client client = new Client(lName, fName, address, city, state, zip,phone, birthday, standardAmount);
                   smallList.get(smallNum).setCurrentOwner(client);
                }

                String due = dueDate.toString();
                System.out.println("Car rental complete! " + smallList.get(smallNum).getCurrentOwner().getFirstName() + " " + smallList.get(smallNum).getCurrentOwner().getLastName() 
                        + " is renting this vehicle until "+ due.substring(0,10)+"."); 
                errorCount = 5;
                }  



            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }

            catch(ArrayIndexOutOfBoundsException ob)
            {
                System.err.println("That car is not in our fleet! Please try again!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw ob;
                }
            }
           
        }
        //Car is successfully checked out, now need to write to today's records.
        
       
        try
        {
            //Check if there is a file open yet.
            if(!todayRentals.exists()){
            System.out.println("New rental file created!");
            todayRentals.createNewFile();
            }
            
            FileWriter fileWritter = new FileWriter(todayRentals,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(smallList.get(smallNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("IS RENTING THE FOLLOWING VEHICLE:");
            bufferWriter.newLine();
            bufferWriter.write(smallList.get(smallNum).toString());
            bufferWriter.write("UNTIL "+ smallList.get(smallNum).getPickupDate()+".");
            bufferWriter.close();
            
            //Open another file writer to record the cost of the rental in the day end report.
             FileWriter dayEndReport = new FileWriter(dayEnd,true);
             BufferedWriter endWriter = new BufferedWriter(dayEndReport);
            endWriter.write("----------------------");
            endWriter.newLine();
            endWriter.write("CUSTOMER:");
            endWriter.newLine();
            endWriter.write("Name:");
            endWriter.write(smallList.get(smallNum).getCurrentOwner().getFirstName() + " " + smallList.get(smallNum).getCurrentOwner().getLastName());
            endWriter.newLine();
            endWriter.write("RENTED: ");
            endWriter.write(smallList.get(smallNum).getMake()+ " " + smallList.get(smallNum).getModel());
            endWriter.newLine();
            endWriter.write("VIN: "+ smallList.get(smallNum).getVin());
            endWriter.newLine();
            endWriter.write("FOR: " + numDays + " day(s)");
            endWriter.newLine();
            endWriter.write("TOTAL: $" + smallList.get(smallNum).getCurrentOwner().getAmountOwed());
            endWriter.newLine();
            endWriter.close();
            
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
        }
        else
        {
            System.out.println("Please go back to the windowed menu and select another function!");
        }
    }   
    
    public static void rentSport(ArrayList<Sport>sportList, Scanner useInput)
{
           int sportNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        int numDays = 0;
        
         System.out.print("The available sport cars are as follows:\n");
        for(int i =0; i < sportList.size(); i++)
        {
           if(sportList.get(i).isAvailable())
           {
           System.out.print(sportList.get(i).toString());     
           System.out.println("");
           }
        }
        
        //Allows the user to see the list of available cars and then decide if they'd like to rent any.
        System.out.println("Would you like to rent a car now ('yes or 'no)?");
        String answer = userInput.next();
        if(answer.equals("yes"))
        {
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model (in all capital letters) of the sport car you wish to lease:");
                userInput.nextLine();
                String sportModel = userInput.nextLine();
                for(int i =0; i < sportList.size(); i++) //Search the sport array for the available vehicle.
                {
                    if(sportList.get(i).getModel().equals(sportModel) && sportList.get(i).isAvailable()) //If the VIN's are equal and the car is available.
                    {
                        sportNum = i; //Store the position of the car in the array so that changes can be made outside of the toop.
                        break; //Break once we have found that the car was available and have its location in the array.
                    }
                }

                sportList.get(sportNum).setAvailable(false); //Car is now unavailable.
                sportList.get(sportNum).setPickupDate(today); //Set the pick up date to today.
                System.out.println("Please insert the following information on the customer renting the car: ");
                System.out.println("First name: ");
                String fName = userInput.next();
                System.out.println("Last name: ");
                String lName = userInput.next();
                System.out.println("Home street address:");
                userInput.nextLine();
                String address = userInput.nextLine();
                System.out.println("City of residence:");
                String city = userInput.nextLine();
                System.out.println("Zip code: ");
                int zip = userInput.nextInt();
                System.out.println("State: ");
                userInput.nextLine();
                String state = userInput.nextLine();
                System.out.println("Phone number: ");
                String phone = userInput.next();
                System.out.println("Month of birth (numeric value): ");
                int month = userInput.nextInt();
                System.out.println("Day of birth (numeric value): ");
                int day = userInput.nextInt();
                System.out.println("Year of birth (as a four digit number): ");
                int year = userInput.nextInt();
                String birthday;
                birthday = String.format("%2d/%2d/%d", month, day, year);

                System.out.println("For how many days will this car be rented?");
                numDays = userInput.nextInt();
                Date dueDate = new Date();
                dueDate.setTime( today.getTime() + numDays * 86400000 );
                sportList.get(sportNum).setDueDate(dueDate);

                System.out.println("\nIs the customer a business client? (Please enter 'yes' or 'no'");
                String sportClient = userInput.next();

                if("yes".equals(sportClient))
                {
                    System.out.println("What company does the customer belong to?");
                    String company = userInput.next();
                    System.out.println("Company phone number: ");
                    String companyPhone = userInput.next();
                    double businessAmount = numDays *  sportList.get(sportNum).getDailyBusinessRate();
                    BusinessClient bClient = new BusinessClient(lName, fName, address, city, state, zip, phone, birthday, businessAmount, company, companyPhone);
                    sportList.get(sportNum).setCurrentOwner(bClient);
                }
                else //It is a standard client.
                {
                   double standardAmount = numDays *  sportList.get(sportNum).getDailyRate(); 
                   Client client = new Client(lName, fName, address, city, state, zip,phone, birthday, standardAmount);
                   sportList.get(sportNum).setCurrentOwner(client);
                }

                String due = dueDate.toString();
                System.out.println("Car rental complete! " + sportList.get(sportNum).getCurrentOwner().getFirstName() + " " + sportList.get(sportNum).getCurrentOwner().getLastName() 
                        + " is renting this vehicle until "+ due.substring(0,10)+"."); 
                errorCount = 5;
                }  



            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }

            catch(ArrayIndexOutOfBoundsException ob)
            {
                System.err.println("That car is not in our fleet! Please try again!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw ob;
                }
            }
        
        }
        //Car is successfully checked out, now need to write to today's records.
        
       
        try
        {
            //Check if there is a file open yet.
            if(!todayRentals.exists()){
            System.out.println("New rental file created!");
            todayRentals.createNewFile();
            }
            
            FileWriter fileWritter = new FileWriter(todayRentals,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(sportList.get(sportNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("IS RENTING THE FOLLOWING VEHICLE:");
            bufferWriter.newLine();
            bufferWriter.write(sportList.get(sportNum).toString());
            bufferWriter.write("UNTIL "+ sportList.get(sportNum).getPickupDate()+".");
            bufferWriter.close();
            
            //Open another file writer to record the cost of the rental in the day end report.
             FileWriter dayEndReport = new FileWriter(dayEnd,true);
             BufferedWriter endWriter = new BufferedWriter(dayEndReport);
            endWriter.write("----------------------");
            endWriter.newLine();
            endWriter.write("CUSTOMER:");
            endWriter.newLine();
            endWriter.write("Name:");
            endWriter.write(sportList.get(sportNum).getCurrentOwner().getFirstName() + " " + sportList.get(sportNum).getCurrentOwner().getLastName());
            endWriter.newLine();
            endWriter.write("RENTED: ");
            endWriter.write(sportList.get(sportNum).getMake()+ " " + sportList.get(sportNum).getModel());
            endWriter.newLine();
            endWriter.write("VIN: "+ sportList.get(sportNum).getVin());
            endWriter.newLine();
            endWriter.write("FOR: " + numDays + " day(s)");
            endWriter.newLine();
            endWriter.write("TOTAL: $" + sportList.get(sportNum).getCurrentOwner().getAmountOwed());
            endWriter.newLine();
            endWriter.close();
            
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
        }
        else
        {
            System.out.println("Please go back to the windowed menu if you wish to perform another function!");
        }
    } 
    
    public static void rentVan(ArrayList<Van>vanList, Scanner useInput)
{
           int vanNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        int numDays = 0;
          System.out.print("The available van cars are as follows:\n");
        for(int i =0; i < vanList.size(); i++)
        {
           if(vanList.get(i).isAvailable())
           {
           System.out.print(vanList.get(i).toString());     
           System.out.println("");
           }
        }
        
        //Allows the user to see the list of available cars and then decide if they'd like to rent any.
        System.out.println("Would you like to rent a car now ('yes or 'no)?");
        String answer = userInput.next();
        if(answer.equals("yes"))
        {
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model (in all capital letters) of the van car you wish to lease:");
                userInput.nextLine();
                String vanModel = userInput.nextLine();
                for(int i =0; i < vanList.size(); i++) //Search the van array for the available vehicle.
                {
                    if(vanList.get(i).getModel().equals(vanModel) && vanList.get(i).isAvailable()) //If the VIN's are equal and the car is available.
                    {
                        vanNum = i; //Store the position of the car in the array so that changes can be made outside of the toop.
                        break; //Break once we have found that the car was available and have its location in the array.
                    }
                }

                vanList.get(vanNum).setAvailable(false); //Car is now unavailable.
                vanList.get(vanNum).setPickupDate(today); //Set the pick up date to today.
                System.out.println("Please insert the following information on the customer renting the car: ");
                System.out.println("First name: ");
                String fName = userInput.next();
                System.out.println("Last name: ");
                String lName = userInput.next();
                System.out.println("Home street address:");
                userInput.nextLine();
                String address = userInput.nextLine();
                System.out.println("City of residence:");
                String city = userInput.nextLine();
                System.out.println("Zip code: ");
                int zip = userInput.nextInt();
                System.out.println("State: ");
                userInput.nextLine();
                String state = userInput.nextLine();
                System.out.println("Phone number: ");
                String phone = userInput.next();
                System.out.println("Month of birth (numeric value): ");
                int month = userInput.nextInt();
                System.out.println("Day of birth (numeric value): ");
                int day = userInput.nextInt();
                System.out.println("Year of birth (as a four digit number): ");
                int year = userInput.nextInt();
                String birthday;
                birthday = String.format("%2d/%2d/%d", month, day, year);

                System.out.println("For how many days will this car be rented?");
                numDays = userInput.nextInt();
                Date dueDate = new Date();
                dueDate.setTime(today.getTime() + numDays * 86400000 );
                vanList.get(vanNum).setDueDate(dueDate);

                System.out.println("\nIs the customer a business client? (Please enter 'yes' or 'no'");
                String vanClient = userInput.next();

                if("yes".equals(vanClient))
                {
                    System.out.println("What company does the customer belong to?");
                    String company = userInput.next();
                    System.out.println("Company phone number: ");
                    String companyPhone = userInput.next();
                    double businessAmount = numDays *  vanList.get(vanNum).getDailyBusinessRate();
                    BusinessClient bClient = new BusinessClient(lName, fName, address, city, state, zip, phone, birthday, businessAmount, company, companyPhone);
                    vanList.get(vanNum).setCurrentOwner(bClient);
                }
                else //It is a standard client.
                {
                   double standardAmount = numDays *  vanList.get(vanNum).getDailyRate(); 
                   Client client = new Client(lName, fName, address, city, state, zip,phone, birthday, standardAmount);
                   vanList.get(vanNum).setCurrentOwner(client);
                }

                String due = dueDate.toString();
                System.out.println("Car rental complete! " + vanList.get(vanNum).getCurrentOwner().getFirstName() + " " + vanList.get(vanNum).getCurrentOwner().getLastName() 
                        + " is renting this vehicle until "+ due.substring(0,10)+"."); 
                errorCount = 5;
                }  



            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }

            catch(ArrayIndexOutOfBoundsException ob)
            {
                System.err.println("That car is not in our fleet! Please try again!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw ob;
                }
            }
           
        }
        //Car is successfully checked out, now need to write to today's records.
        
       
        try
        {
            //Check if there is a file open yet.
            if(!todayRentals.exists()){
            System.out.println("New rental file created!");
            todayRentals.createNewFile();
            }
            
            FileWriter fileWritter = new FileWriter(todayRentals,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(vanList.get(vanNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("IS RENTING THE FOLLOWING VEHICLE:");
            bufferWriter.newLine();
            bufferWriter.write(vanList.get(vanNum).toString());
            bufferWriter.write("UNTIL "+ vanList.get(vanNum).getPickupDate()+".");
            bufferWriter.close();
            
            //Open another file writer to record the cost of the rental in the day end report.
             FileWriter dayEndReport = new FileWriter(dayEnd,true);
             BufferedWriter endWriter = new BufferedWriter(dayEndReport);
            endWriter.write("----------------------");
            endWriter.newLine();
            endWriter.write("CUSTOMER:");
            endWriter.newLine();
            endWriter.write("Name:");
            endWriter.write(vanList.get(vanNum).getCurrentOwner().getFirstName() + " " + vanList.get(vanNum).getCurrentOwner().getLastName());
            endWriter.newLine();
            endWriter.write("RENTED: ");
            endWriter.write(vanList.get(vanNum).getMake()+ " " + vanList.get(vanNum).getModel());
            endWriter.newLine();
            endWriter.write("VIN: "+ vanList.get(vanNum).getVin());
            endWriter.newLine();
            endWriter.write("FOR: " + numDays + " day(s)");
            endWriter.newLine();
            endWriter.write("TOTAL: $" + vanList.get(vanNum).getCurrentOwner().getAmountOwed());
            endWriter.newLine();
            endWriter.close();
            
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
        }
        else
        {
            System.out.println("Please go back to the windowed menu if you wish to perform another function.");
        }
    }   
    
    public static void returnCompact(ArrayList<Compact>compactList, Scanner userInput)
    {
        int compactNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model of the car that the customer is returning:");
                String compactModel = userInput.next();

                System.out.println("Please enter the last name of the customer who is returning the vehicle: ");
                String customerName = userInput.next();
               
                 for(int i =0; i < compactList.size(); i++)
                {
                    if(compactList.get(i).getModel().equals(compactModel) &&compactList.get(i).getCurrentOwner().getLastName().equals(customerName) )
                     {
                         compactNum = i;
                         break;
                     }
                }
               
                compactList.get(compactNum).setAvailable(true); //Car is now available again.
                compactList.get(compactNum).setReturnDate(today); //Set the return date to today.
                System.out.println("Car successfully returned! Thank you!");
                errorCount = 5;
            }
            catch(ArrayIndexOutOfBoundsException aob)
            {
                System.err.println("Rental with the model and last name is not reconized! Please try again.");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw aob;
                }
            }
            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }
        }
            try
            {
            //Check if there is a file open yet.
            if(!logFile.exists()){
            System.out.println("New rental file created!");
            logFile.createNewFile();
            }
            
            //Write the returned vehicle to the log file.
            FileWriter fileWritter = new FileWriter(logFile,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(compactList.get(compactNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("RENTED THE FOLLOWING VEHICLE: ");
            bufferWriter.write(compactList.get(compactNum).getVin());
            bufferWriter.newLine();
            bufferWriter.write("Pick-up date: ");
            bufferWriter.write(compactList.get(compactNum).getPickupDate());
            bufferWriter.newLine();
            bufferWriter.write("Due date: ");
            bufferWriter.write(compactList.get(compactNum).stringDueDate());
            bufferWriter.newLine();
            bufferWriter.write("Date returned: ");
            bufferWriter.write(compactList.get(compactNum).getReturnDate());
            bufferWriter.newLine();
            bufferWriter.write("Amount paid: ");
            bufferWriter.write(compactList.get(compactNum).getCurrentOwner().amountOwedString());
            bufferWriter.close();
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
            
       finally
            {
                 compactList.get(compactNum).setDueDate(today); //Set the due date to today so that it shows up in the report.
                compactList.get(compactNum).setPickupDate(new Date(0,0,1990)); //Set the pick up date to a dummy object.
            }
       
        }   
    
     public static void returnMid(ArrayList<Mid>midList, Scanner userInput)
    {
        int midNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model of the car that the customer is returning:");
                String midModel = userInput.next();

                System.out.println("Please enter the last name of the customer who is returning the vehicle: ");
                String customerName = userInput.next();
               
                 for(int i =0; i < midList.size(); i++)
                {
                    if(midList.get(i).getModel().equals(midModel) &&midList.get(i).getCurrentOwner().getLastName().equals(customerName) )
                     {
                         midNum = i;
                         break;
                     }
                }
               
                midList.get(midNum).setAvailable(true); //Car is now available again.
                midList.get(midNum).setReturnDate(today); //Set the return date to today.
                System.out.println("Car successfully returned! Thank you!");
                errorCount = 5;
            }
            catch(ArrayIndexOutOfBoundsException aob)
            {
                System.err.println("Rental with the model and last name is not reconized! Please try again.");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw aob;
                }
            }
            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }
        }
            try
            {
            //Check if there is a file open yet.
            if(!logFile.exists()){
            System.out.println("New rental file created!");
            logFile.createNewFile();
            }
            
            //Write the returned vehicle to the log file.
            FileWriter fileWritter = new FileWriter(logFile,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(midList.get(midNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("RENTED THE FOLLOWING VEHICLE: ");
            bufferWriter.write(midList.get(midNum).getVin());
            bufferWriter.newLine();
            bufferWriter.write("Pick-up date: ");
            bufferWriter.write(midList.get(midNum).getPickupDate());
            bufferWriter.newLine();
            bufferWriter.write("Due date: ");
            bufferWriter.write(midList.get(midNum).stringDueDate());
            bufferWriter.newLine();
            bufferWriter.write("Date returned: ");
            bufferWriter.write(midList.get(midNum).getReturnDate());
            bufferWriter.newLine();
            bufferWriter.write("Amount paid: ");
            bufferWriter.write(midList.get(midNum).getCurrentOwner().amountOwedString());
            bufferWriter.close();
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
            
       finally
            {
                midList.get(midNum).setDueDate(today); //Set the return date to today so that it shows up in the report.
                midList.get(midNum).setPickupDate(new Date(0,0,1990)); //Set the pick up date to a dummy object.
            }
       
        }  
     
      public static void returnSUV(ArrayList<SUV>SUVList, Scanner userInput)
    {
        int SUVNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model of the car that the customer is returning:");
                String SUVModel = userInput.next();

                System.out.println("Please enter the last name of the customer who is returning the vehicle: ");
                String customerName = userInput.next();
               
                 for(int i =0; i < SUVList.size(); i++)
                {
                    if(SUVList.get(i).getModel().equals(SUVModel) &&SUVList.get(i).getCurrentOwner().getLastName().equals(customerName) )
                     {
                         SUVNum = i;
                         break;
                     }
                }
               
                SUVList.get(SUVNum).setAvailable(true); //Car is now available again.
                SUVList.get(SUVNum).setReturnDate(today); //Set the return date to today.
                System.out.println("Car successfully returned! Thank you!");
                errorCount = 5;
            }
            catch(ArrayIndexOutOfBoundsException aob)
            {
                System.err.println("Rental with the model and last name is not reconized! Please try again.");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw aob;
                }
            }
            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }
        }
            try
            {
            //Check if there is a file open yet.
            if(!logFile.exists()){
            System.out.println("New rental file created!");
            logFile.createNewFile();
            }
            
            //Write the returned vehicle to the log file.
            FileWriter fileWritter = new FileWriter(logFile,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(SUVList.get(SUVNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("RENTED THE FOLLOWING VEHICLE: ");
            bufferWriter.write(SUVList.get(SUVNum).getVin());
            bufferWriter.newLine();
            bufferWriter.write("Pick-up date: ");
            bufferWriter.write(SUVList.get(SUVNum).getPickupDate());
            bufferWriter.newLine();
            bufferWriter.write("Due date: ");
            bufferWriter.write(SUVList.get(SUVNum).stringDueDate());
            bufferWriter.newLine();
            bufferWriter.write("Date returned: ");
            bufferWriter.write(SUVList.get(SUVNum).getReturnDate());
            bufferWriter.newLine();
            bufferWriter.write("Amount paid: ");
            bufferWriter.write(SUVList.get(SUVNum).getCurrentOwner().amountOwedString());
            bufferWriter.close();
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
            
       finally
            {
                SUVList.get(SUVNum).setDueDate(today); //Set the return date to today so that it shows up in the report.
                SUVList.get(SUVNum).setPickupDate(new Date(0,0,1990)); //Set the pick up date to a dummy object.
            }
       
        }  
      
       public static void returnSmall(ArrayList<Small>smallList, Scanner userInput)
    {
        int smallNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model of the car that the customer is returning:");
                String smallModel = userInput.next();

                System.out.println("Please enter the last name of the customer who is returning the vehicle: ");
                String customerName = userInput.next();
               
                 for(int i =0; i < smallList.size(); i++)
                {
                    if(smallList.get(i).getModel().equals(smallModel) &&smallList.get(i).getCurrentOwner().getLastName().equals(customerName) )
                     {
                         smallNum = i;
                         break;
                     }
                }
               
                smallList.get(smallNum).setAvailable(true); //Car is now available again.
                smallList.get(smallNum).setReturnDate(today); //Set the return date to today.
                System.out.println("Car successfully returned! Thank you!");
                errorCount = 5;
            }
            catch(ArrayIndexOutOfBoundsException aob)
            {
                System.err.println("Rental with the model and last name is not reconized! Please try again.");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw aob;
                }
            }
            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }
        }
            try
            {
            //Check if there is a file open yet.
            if(!logFile.exists()){
            System.out.println("New rental file created!");
            logFile.createNewFile();
            }
            
            //Write the returned vehicle to the log file.
            FileWriter fileWritter = new FileWriter(logFile,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(smallList.get(smallNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("RENTED THE FOLLOWING VEHICLE: ");
            bufferWriter.write(smallList.get(smallNum).getVin());
            bufferWriter.newLine();
            bufferWriter.write("Pick-up date: ");
            bufferWriter.write(smallList.get(smallNum).getPickupDate());
            bufferWriter.newLine();
            bufferWriter.write("Due date: ");
            bufferWriter.write(smallList.get(smallNum).stringDueDate());
            bufferWriter.newLine();
            bufferWriter.write("Date returned: ");
            bufferWriter.write(smallList.get(smallNum).getReturnDate());
            bufferWriter.newLine();
            bufferWriter.write("Amount paid: ");
            bufferWriter.write(smallList.get(smallNum).getCurrentOwner().amountOwedString());
            bufferWriter.close();
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
            
       finally
            {
                smallList.get(smallNum).setDueDate(today); //Set the return date to today so that it shows up in the report.
                smallList.get(smallNum).setPickupDate(new Date(0,0,1990)); //Set the pick up date to a dummy object.
            }
       
        }  
       
        public static void returnSport(ArrayList<Sport>sportList, Scanner userInput)
    {
        int sportNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model of the car that the customer is returning:");
                userInput.nextLine();
                String sportModel = userInput.nextLine();

                System.out.println("Please enter the last name of the customer who is returning the vehicle: ");
                String customerName = userInput.next();
               
                 for(int i =0; i < sportList.size(); i++)
                {
                    if(sportList.get(i).getModel().equals(sportModel) &&sportList.get(i).getCurrentOwner().getLastName().equals(customerName) )
                     {
                         sportNum = i;
                         break;
                     }
                }
               
                sportList.get(sportNum).setAvailable(true); //Car is now available again.
                sportList.get(sportNum).setReturnDate(today); //Set the return date to today.
                System.out.println("Car successfully returned! Thank you!");
                errorCount = 5;
            }
            catch(ArrayIndexOutOfBoundsException aob)
            {
                System.err.println("Rental with the model and last name is not reconized! Please try again.");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw aob;
                }
            }
            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }
        }
            try
            {
            //Check if there is a file open yet.
            if(!logFile.exists()){
            System.out.println("New rental file created!");
            logFile.createNewFile();
            }
            
            //Write the returned vehicle to the log file.
            FileWriter fileWritter = new FileWriter(logFile,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(sportList.get(sportNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("RENTED THE FOLLOWING VEHICLE: ");
            bufferWriter.write(sportList.get(sportNum).getVin());
            bufferWriter.newLine();
            bufferWriter.write("Pick-up date: ");
            bufferWriter.write(sportList.get(sportNum).getPickupDate());
            bufferWriter.newLine();
            bufferWriter.write("Due date: ");
            bufferWriter.write(sportList.get(sportNum).stringDueDate());
            bufferWriter.newLine();
            bufferWriter.write("Date returned: ");
            bufferWriter.write(sportList.get(sportNum).getReturnDate());
            bufferWriter.newLine();
            bufferWriter.write("Amount paid: ");
            bufferWriter.write(sportList.get(sportNum).getCurrentOwner().amountOwedString());
            bufferWriter.close();
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
            
       finally
            {
                sportList.get(sportNum).setDueDate(today); //Set the return date to today so that it shows up in the report.
                sportList.get(sportNum).setPickupDate(new Date(0,0,1990)); //Set the pick up date to a dummy object.
            }
       
        }  
        
         public static void returnVan(ArrayList<Van>vanList, Scanner userInput)
    {
        int vanNum = -1;
        int errorCount = 0;
        int maxErrors = 3;
        
        while(errorCount < maxErrors)
        {    
            try
            {
                System.out.println("Please enter the model of the car that the customer is returning:");
                userInput.nextLine();
                String vanModel = userInput.nextLine();

                System.out.println("Please enter the last name of the customer who is returning the vehicle: ");
                String customerName = userInput.next();
               
                 for(int i =0; i < vanList.size(); i++)
                {
                    if(vanList.get(i).getModel().equals(vanModel) &&vanList.get(i).getCurrentOwner().getLastName().equals(customerName) )
                     {
                         vanNum = i;
                         break;
                     }
                }
               
                vanList.get(vanNum).setAvailable(true); //Car is now available again.
                vanList.get(vanNum).setReturnDate(today); //Set the return date to today.            
                System.out.println("Car successfully returned! Thank you!");
                errorCount = 5;
            }
            catch(ArrayIndexOutOfBoundsException aob)
            {
               System.err.println("Rental with the model and last name is not reconized! Please try again.");
                if(++errorCount==maxErrors)
                {
                    System.err.println("Unable to locate a car based off of user input. Please go back to the main menu and try again!");
                    throw aob;
                }
            }
            catch(InputMismatchException ex)
            {
                System.err.println("Improper input detected! Please try again and be sure to enter the values as specified!");
                if(++errorCount==maxErrors)
                {
                    System.err.println("You have gone over the maximum number of attempts for entering customer information. Please go back to the main menu and try again!");
                    throw ex;
                }
            }
        }
            try
            {
            //Check if there is a file open yet.
            if(!logFile.exists()){
            System.out.println("New rental file created!");
            logFile.createNewFile();
            }
            
            //Write the returned vehicle to the log file.
            FileWriter fileWritter = new FileWriter(logFile,true);
    	    BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
            
            bufferWriter.newLine();
            bufferWriter.write("--------------------");
            bufferWriter.newLine();
            bufferWriter.write("CUSTOMER:");
            bufferWriter.newLine();
            bufferWriter.write(vanList.get(vanNum).getCurrentOwner().toString());
            bufferWriter.newLine();
            bufferWriter.write("RENTED THE FOLLOWING VEHICLE: ");
            bufferWriter.write(vanList.get(vanNum).getVin());
            bufferWriter.newLine();
            bufferWriter.write("Pick-up date: ");
            bufferWriter.write(vanList.get(vanNum).getPickupDate());
            bufferWriter.newLine();
            bufferWriter.write("Due date: ");
            bufferWriter.write(vanList.get(vanNum).stringDueDate());
            bufferWriter.newLine();
            bufferWriter.write("Date returned: ");
            bufferWriter.write(vanList.get(vanNum).getReturnDate());
            bufferWriter.newLine();
            bufferWriter.write("Amount paid: ");
            bufferWriter.write(vanList.get(vanNum).getCurrentOwner().amountOwedString());
            bufferWriter.close();
        }
        catch(IOException ex)
        {
            System.err.println("There is no file to write today's logs to! Terminating program!");
            System.exit(1);
        }
            
       finally
            {
                vanList.get(vanNum).setDueDate(today); //Set the due date to today so that the vehicle is printed out in the return report.
                vanList.get(vanNum).setPickupDate(new Date(0,0,1990)); //Set the pick up date to a dummy object.
            }
       
        }  
    public final_project() {
        super("Urban Car Rental Management Program");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("Availability");

        jMenuItem5.setText("Compact-size");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Small-size");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Mid-size");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("SUV");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Van");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Sport");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("Exit Sub-menu");
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Return");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem12.setText("Compact-size");
        jMenuItem12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem12MouseClicked(evt);
            }
        });
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Small-size");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("Mid-size");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem15.setText("SUV");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuItem16.setText("Van");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem17.setText("Sport");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);

        jMenuItem18.setText("Exit Sub-menu");
        jMenu2.add(jMenuItem18);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reports");

        jMenuItem1.setText("Today's Rentals");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Today's Returns");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Day End Report");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Exit Sub-menu");
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Exit");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        jTextArea1.append("Please refer to the console for the list of cars and to enter customer information.\n");    
        rentSUV(SUVList, userInput);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
//    jTextArea1.append("The available compact cars are as follows: ");
//        for(int i =0; i < compactList.size(); i++)
//        {
//            if(compactList.get(i).isAvailable())
//            {
//                jTextArea1.append(compactList.get(i).toString());
//            }    
//        }
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       jTextArea1.append("Please refer to the console for the list of cars and to enter customer information.\n");
        rentCompact(compactList, userInput);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jTextArea1.append("Please refer to the console for the list of cars and to enter customer information.\n");
        rentSmall(smallList, userInput);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       jTextArea1.append("Please refer to the console for the list of cars and to enter customer information.\n");
        rentMid(midList, userInput);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        jTextArea1.append("Please refer to the console for the list of cars and to enter customer information.\n");
        rentVan(vanList, userInput);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        jTextArea1.append("Please refer to the console for the list of cars and to enter customer information.\n");
        rentSport(sportList, userInput);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jTextArea1.append("File successfully generated! Please open 'todayRentals.txt' to view today's rentals!\n");
        //Today's rental are automatically added into a file once the user selects a car to rent out to a customer.
        //Since the file is constructed while a car is being rented, there is no reason to perform any other methods.
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
          returnCompact(compactList, userInput);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem12MouseClicked

    }//GEN-LAST:event_jMenuItem12MouseClicked

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        returnSmall(smallList, userInput);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        returnMid(midList, userInput);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        returnSUV(SUVList, userInput);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        returnVan(vanList, userInput);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        returnSport(sportList, userInput);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //Traverse each array list and then each car that has a dueDate of today
        //to the file.
        compileReturns(todayReturns);
        jTextArea1.append("Returns report successfully generated! Please open 'returns.txt' to view the results.");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        compileDayEnd(dayEnd);
        jTextArea1.append("\nDay end report successfully generated! Please open 'DayEndReport.txt' to view the results.");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
    
        //This is strictly for testing purposes. Report files are written using a StreamBuffer and therefore data remains in them even after
        //the program is terminated. Advancing to the "next day" would mean that new file would need to be created in order
        //to hold a new days worth of values. Discovering whether or not the use would like to advance a day allows us
        //to determine whether or not the files should be written to from the beginning. This allows for the user to 
        //exit in and out of the program without losing track of what processes took place on the same day.
        System.out.println("Would you like to advance the program to a new day (enter 'yes' or 'no')? Please note that doing so will result in all report files being emptied.");
        String answer = userInput.next();
        if(answer.equals("yes"))
        {
            Date newToday = new Date();
            newToday.setTime( today.getTime() + 86400000 ); //Adding 86400000 milliseconds results in a date variable advancing one day.
            today = newToday;
            //Empty all of the files if the user wishes to advance a day.
            emptyFile(todayRentals);
            emptyFile(dayEnd);
            emptyFile(todayReturns);
            
        }
        //Else, the day remains in the file and will continue to be written to.
        
        System.out.println("Thank you! Please refer to the windowed menu to perform a function.");
        //Load the data from the input file into arrayLists for each car type.
       try
       {
            Scanner readCSV = new Scanner (Paths.get("CarInventory.csv"));
       while(readCSV.hasNext())
       {
            String temp = readCSV.nextLine();
            String[] split = temp.split(","); //Split each string into its own element in the array.
            
            if("COMPACT".equals(split[7]))
            {
                Compact compact = new Compact();
                compact.setMake(split[0]);
                compact.setModel(split[1]);
                compact.setYear(split[2]);
                compact.setColor(split[3]);
                compact.setVin(split[4]);
                compact.setCylinder(Integer.parseInt(split[5]));
                compact.setPrice(Double.parseDouble(split[6]));
                compact.setType(split[7]);
                Compact compClone = new Compact(compact);
                compactList.add(compClone);
            }
            
           else if("MID".equals(split[7]))
            {
                Mid mid = new Mid();
                mid.setMake(split[0]);
                mid.setModel(split[1]);
                mid.setYear(split[2]);
                mid.setColor(split[3]);
                mid.setVin(split[4]);
                mid.setCylinder(Integer.parseInt(split[5]));
                mid.setPrice(Double.parseDouble(split[6]));
                mid.setType(split[7]);
                Mid midClone = new Mid(mid);
                midList.add(midClone);
            }
            
            else if("SMALL".equals(split[7]))
            {
                Small small = new Small();
                small.setMake(split[0]);
                small.setModel(split[1]);
                small.setYear(split[2]);
                small.setColor(split[3]);
                small.setVin(split[4]);
                small.setCylinder(Integer.parseInt(split[5]));
                small.setPrice(Double.parseDouble(split[6]));
                small.setType(split[7]);
                Small smallClone = new Small(small);
                smallList.add(smallClone);
            }
           
            else if("SUV".equals(split[7]))
            {
                SUV suv = new SUV();
                suv.setMake(split[0]);
                suv.setModel(split[1]);
                suv.setYear(split[2]);
                suv.setColor(split[3]);
                suv.setVin(split[4]);
                suv.setCylinder(Integer.parseInt(split[5]));
                suv.setPrice(Double.parseDouble(split[6]));
                suv.setType(split[7]);
                SUV suvClone = new SUV(suv);
                SUVList.add(suvClone);
            }
            
            else if("SPORT".equals(split[7]))
            {
                Sport sport = new Sport();
                sport.setMake(split[0]);
                sport.setModel(split[1]);
                sport.setYear(split[2]);
                sport.setColor(split[3]);
                sport.setVin(split[4]);
                sport.setCylinder(Integer.parseInt(split[5]));
                sport.setPrice(Double.parseDouble(split[6]));
                sport.setType(split[7]);
                //Checks if the car is a camaro, as the price rates are different when compared to other 
                //sports cars.
                if(sport.getModel().equals("CAMARO ZL1")) 
                {
                    sport.setDailyRate(265.99);
                    sport.setDailyBusinessRate(265.99);
                }
                else //The car is not a camaro, and therefore follows the normal rates.
                {
                     sport.setDailyRate(305.99);
                    sport.setDailyBusinessRate(305.99);
                }
                Sport sportClone = new Sport(sport);
                sportList.add(sportClone);
            }
            
            else if("VAN".equals(split[7])) //The car is a van.
            {
                Van van = new Van();
                van.setMake(split[0]);
                van.setModel(split[1]);
                van.setYear(split[2]);
                van.setColor(split[3]);
                van.setVin(split[4]);
                van.setCylinder(Integer.parseInt(split[5]));
                van.setPrice(Double.parseDouble(split[6]));
                van.setType(split[7]);
                Van vanClone = new Van(van);
                vanList.add(vanClone);
            }
            
            //Do not code an else statement so that the column heading are ignored and are not stored into objects.
       }
        readCSV.close(); //Close the scanner object.
        //End reading of file.
        
        //Sort each of the arrays using the base class comparator.
        compactList.sort(carBase.carBaseComparator);
        midList.sort(carBase.carBaseComparator);
        SUVList.sort(carBase.carBaseComparator);
        sportList.sort(carBase.carBaseComparator);
        vanList.sort(carBase.carBaseComparator);
        smallList.sort(carBase.carBaseComparator);
                   
    }
       catch(IOException ex)
       {
           System.err.println("Input file unable to be found. Terminating the program!");
           System.exit(1);
       }
      
       
       
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(final_project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(final_project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(final_project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(final_project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new final_project().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

