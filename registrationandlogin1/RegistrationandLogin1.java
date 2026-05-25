/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class RegistrationandLogin1 {

    public static void main(String[] args) {
         Scanner input =  new Scanner(System.in);
        
                 
        String username;
        String password;
         String cellphone;
         String loguser;
         String logpass;
         String logcell;
         
        
        System.out.println("\n--Register your account---");
        
        System.out.print("Enter First name: ");
        String firstname=input.nextLine();
        
         System.out.print("Enter last name: ");
        String lastname=input.nextLine();
        
        System.out.print("Enter username :");
        username=input.nextLine();
        
        //conditions for username
            
    if (username.length() <=5 & username.contains("_") ) {
            System.out.println("Username suucessfully captured");
       } else {
            System.out.println("Username is not correctly formatted, please insure username contains and underscore and is no more than 5 characters in length.");
        }
        
        System.out.print("Enter Password: ");
        password = input.nextLine();
        //conditions for password
        // Check null, lenght, a Capital letter, a number and a special character
       if (password.length() >=8 & password.matches(".*[A-Z].*") & password.matches(".*\\d.*") & password.matches(".*[!@#$%^&*(),.?\":{}|<>].*") ){
           System.out.println("Password successfully captured");
       }else{
           System.out.println("Password is not correctly formatted,please ensure that the password contains at least eight characters,a capital letter,a number and a special character");
       }
         System.out.print("Enter Cellphone number : ");
         cellphone=input.nextLine();
         
//conditions for cellphone number
//Check if it starts with country code(27) and 12 characters total (+27 + 9 digits)
        if (cellphone.startsWith("+27") && cellphone.length() == 12 && cellphone.matches("\\+27\\d{9}") && cellphone.equals(cellphone)) {
            System.out.println("Cell number successfully captured");
        } else {
            System.out.println("Cellpnone number incorrectly formatted or does not contain international code");
        }
        boolean ValidUser=username.length() <= 5 && username.contains ("_");
        boolean Validpass=password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        boolean Validcell=cellphone.startsWith("+27") && cellphone.length() == 12 && cellphone.matches("\\+27\\d{9}");
        
        //validation for registered user
        if (ValidUser && Validpass && Validcell){
        System.out.print("This user is registed successfully : " + username);
        }else{
            System.out.print("Account registration failed");
        }
        
         //Login
    
        System.out.println("\n--Login to the chat app--");
        
        System.out.print("Enter Registered username : ");
       loguser=input.nextLine();
        if (loguser.equals(username)){
        System.out.println("username Successfully loged in");
        }else{
            System.out.println("Please ensure Registered username matches entered username");
        }
         
        System.out.print("Enter Registered password : ");
       logpass=input.nextLine();
        if (logpass.equals(password)){
        System.out.println("password Successfully loged in");
        }else{
            System.out.println("Please ensure Registered password matches entered password");
        }
        
        System.out.print("Enter Registered cellphone number : ");
       logcell=input.nextLine();
        if (logcell.equals(cellphone)){
        System.out.println("Cellphone Number Successfully loged in");
        }else{
            System.out.println("Please ensure Cellphone username matches entered cellphone");
        }
        
        //validation for registered login user
       boolean validloguser=username.length() <= 5 && username.contains ("_");
        boolean validlogpass=password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        boolean validlogcell=cellphone.startsWith("+27") && cellphone.length() == 12 && cellphone.matches("\\+27\\d{9}");
        
        if (validloguser && validlogpass && validlogcell){
        System.out.print("Welcome " + firstname +" " + lastname + " it is great to see you ");
        }else{
            System.out.print("Account log in failed");
        }
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

      
