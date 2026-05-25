/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin1;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author thand
 */
public class messageoption {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        //Message option
         System.out.println("\n--Welcome to the QuickChat--");
        
            System.out.println("1. Send messages");
            System.out.println("2.Show recent messages");
            System.out.println("3. Quit");
            System.out.print("Choose option: ");
            int choice= input.nextInt();
            input.nextLine();
            //String   
        String regex = "^\\+27[0-9]{9}$";
        String recipient;
        String[] words;
        String firstWord;
        String lastWord;
        String firstTwoDigits;
        String messageHash;
        int option;
        
        switch (choice) {
            case 1:
                //ask how many message they would like to send
                System.out.print("How many messages would you like to send ? ");
                int numOfMessages = input.nextInt();
                input.nextLine();
                //FOR loop for messages
                for(int i =1; i <= numOfMessages; i++){
                    int messageID = (int)(10 + Math.random()*90);
                    System.out.print("enter your message: " + i + ":");
                    String message= input.nextLine();
                    do{
                        
                        System.out.println("Enter Recipient : ");
                        recipient = input.nextLine();
                        if (!recipient.matches(regex)){
                            System.out.println("Recipient number is invalid,number should not be more than 10 digits and must have a country code");
                        }
                    }  while(!recipient.matches(regex));
                    
                    
                    
                    //condition for less than 250 characters
                    if (message.length()<=250){
                        System.out.println("Message sent: "+ message);
                        
                        //split message into words
                        words= message.split(" ");
                        //first word of the message and the last
                        firstWord = words[0];
                        lastWord = words[words.length -1];
                        //take first two digit from recipient
                        firstTwoDigits = recipient.substring(1,3);
                        //messageID
                        System.out.println("Message ID: "+messageID);
                        //hash message
                        
                        messageHash= firstTwoDigits + ":" + i + ":" + firstWord + " " + lastWord ;
                        
                        
                        System.out.println("Message Hash: " + messageHash.toUpperCase());
                    }else{
                        System.out.println("Please enter a message of less than 250 characters.");
                    }
                    // Menu loop
             boolean validChoice = false;

            while (!validChoice) {

                System.out.println(
                "\n--Choose one of the following--");

                System.out.println(
                        "1. Send Message");

                System.out.println(
                        "2. Disregard Message");

                System.out.println(
                        "3. Save Message");

                System.out.print(
                        "Enter choice: ");

                option = input.nextInt();
                input.nextLine();

                switch (option) {

                    case 1:

                        System.out.println(
                        "Message successfully sent");

                        validChoice = true;
                        break;

                    case 2:

                        System.out.println(
                        "Message deleted");

                        validChoice = true;
                        break;

                    case 3:

                        System.out.println(
                        "Message successfully saved");

                        validChoice = true;
                        break;

                    default:

                        System.out.println(
                        "Invalid option. Try again.");
                }
            }
        }

        break;

    case 2:

        System.out.println(
                "Still under development");

        break;

    case 3:

        System.exit(0);
        break;

    default:

        System.out.println(
                "Invalid menu option.");
        }
        
    }
     public static void saveMessageToFile(int messageID, String messageHash, String recipient, String message) {
    try {
        FileWriter fw = new FileWriter("messages.txt", true); // true = append mode
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Message ID: " + messageID);
        pw.println("Message Hash: " + messageHash);
        pw.println("Recipient: " + recipient);
        pw.println("Message: " + message);
        pw.println("-----------------------");

        pw.close();
        System.out.println("Message saved to file successfully!");
    } catch (IOException e) {
        System.out.println("Error saving message: " + e.getMessage());
    }
}
    }

