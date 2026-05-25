/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testLogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thand
 */
public class testLogin {
    
@Test
public void TestUsername(){
        
        // if valid must contain <=5 characters and contains "_"
        String username = "dre_1";
        // if valid must >=8 characters, has a capital,  a number and a special character
        String password = "Q!2qwert"; 
        // if valid must contain +27 and 12 digits
        String cell = "+27824558991"; 

        boolean checkusername = username.length() <= 5 && username.contains("_");
        boolean checkpasswordComplexity = password.length() >= 8 
                                && password.matches(".*[A-Z].*") 
                                && password.matches(".*\\d.*") 
                                && password.matches(".*[!@$%^&*].*");
        boolean checkCellphone = cell.startsWith("+27") 
                            && cell.length() == 12 
                            && cell.matches("\\+27\\d{9}");

        assertTrue(checkusername && checkpasswordComplexity && checkCellphone, "Account registered successfully");

        // Login
        String loginUsername = "dre_1";
        String loginPassword = "Q!2qwert";
        String loginCell = "+27824558991";

        assertTrue(loginUsername.equals(username) 
                   && loginPassword.equals(password) 
                   && loginCell.equals(cell), "Login should succeed");
    }
 @Test
    void testInvalidRegistration() {
        String username = "dre_1"; // invalid: no underscore
        String password = "aqw"; // invalid: too short
        String cell = "0824558991"; // invalid: missing +27

        boolean validUsername = username.length() <= 5 && username.contains("_");
        boolean validPassword = password.length() >= 8 
                                && password.matches(".*[A-Z].*") 
                                && password.matches(".*\\d.*") 
                                && password.matches(".*[!@$%^&*].*");
        boolean validCell = cell.startsWith("+27") 
                            && cell.length() == 12 
                            && cell.matches("\\+27\\d{9}");

        assertFalse(validUsername && validPassword && validCell, "Account should fail registration");
    }

    @Test
    void testLoginFailsWithWrongDetails() {
        String username = "kyl_1";
        String password = "H%rwerty";
        String cell = "+27825448991";

        boolean validUsername = username.length() <= 5 && username.contains("_");
        boolean validPassword = password.length() >= 8 
                                && password.matches(".*[A-Z].*") 
                                && password.matches(".*\\d.*") 
                                && password.matches(".*[!@$%^&*].*");
        boolean validCell = cell.startsWith("+27") 
                            && cell.length() == 12 
                            && cell.matches("\\+27\\d{9}");

        assertTrue(validUsername && validPassword && validCell, "Account should register successfully");

        // Wrong login details
        String loginUsername = "wrong_";
        String loginPassword = "WrongPass1!";
        String loginCell = "+27799999999";

        assertFalse(loginUsername.equals(username) 
                    && loginPassword.equals(password) 
                    && loginCell.equals(cell), "Login should fail");
 
    }
}

