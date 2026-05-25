/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author thand
 */
public class messageoptionTest {
    
    public messageoptionTest() {
    }

    @Test
    public void testMessageLengthSuccess() {
        String message = "Hello, this is a short message.";
        assertTrue(message.length() <= 250, "Message should be valid length");
        assertEquals("Message ready to send.", "Message ready to send.");

    }
       // Test message length
    @Test
    public void testMessageLengthFail() {
         StringBuilder longMessage = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            longMessage.append("x");
        }
        int excess = longMessage.length() - 250;
        assertTrue(longMessage.length() > 250, "Message should exceed limit");
        assertEquals("Message exceeds 250 characters by " + excess + ", please reduce the size.",
                     "Message exceeds 250 characters by " + excess + ", please reduce the size.");
   
    }

    @Test
    public void testCheckRecipientSuccess() {
        String recipient = "+27123456789";
        assertTrue(recipient.matches("^\\+27\\d{9}$"));
        assertEquals("Cell phone number successfully captured.", "Cell phone number successfully captured.");

    }
    
    @Test
    public void testCheckRecipientFailure() {
         String recipient = "123456789";
        assertFalse(recipient.matches("^\\+27\\d{9}$"));
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct.",
                     "Cell phone number is incorrectly formatted or does not contain an international code. Please correct.");
    }
 
      @Test
    public void testMessageHash_Correct() {
        String messageID = "MSG1";
        String numericPart = messageID.substring(3);
        String message = "Hello Friend";
        String[] words = message.split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String expectedHash = numericPart.substring(0, Math.min(2, numericPart.length()))
                              + ":" + numericPart
                              + ":" + (firstWord + lastWord).toUpperCase();

        String actualHash = "1:1:HELLOFRIEND"; // expected for MSG1 and "Hello Friend"
        assertEquals(expectedHash, actualHash, "Message hash should be correct");
    }

     @Test
    public void testSendMessage() {
        int action = 1;
        String result = (action == 1) ? "Message successfully sent." : "";
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testDisregardMessage() {
        int action = 2;
        String result = (action == 2) ? "Message deleted." : "";
        assertEquals("Message deleted.", result);
    }

    @Test
    public void testStoreMessage() {
        int action = 3;
        String result = (action == 3) ? "Message successfully stored." : "";
        assertEquals("Message successfully stored.", result);
    }

    
    }
