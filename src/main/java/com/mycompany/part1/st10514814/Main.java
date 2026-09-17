/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.part1.st10514814;

import java.util.Scanner;

/**
 *
 * @author 25687
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Registration: collects name, surname, username, password and cell pohne number
        System.out.println("==========================================");
        System.out.println("Resgistration");
        System.out.println("==========================================");
        
        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your surname: ");
        String surname = input.nextLine();

        System.out.println("Enter your username: ");
        String user = input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();

        System.out.println("Enter your South African phone number: ");
        String cellNumber = input.nextLine();
        
        System.out.println("==========================================");

        Login obj = new Login(name, surname, user, password, cellNumber);
        
        String result = obj.registerUser(user, password);
      
        String enteredUser;
        String enteredPass;
        boolean loginResult;
        
        //Login : after users enters credentials, system verifies against registration data  
        if (result.matches("The two above conditions have been met, and the user has been registered successfully")) {
            
            System.out.println("==========================================");
            System.out.println("Login");
            System.out.println("==========================================");
            
            System.out.println("Re-enter your username to login: ");
            enteredUser = input.nextLine();

            System.out.println("Re-enter your password to login: ");
            enteredPass = input.nextLine();
            
            System.out.println("==========================================");
            loginResult = obj.loginUser(name, surname, user, password, enteredUser, enteredPass);

            obj.returnLoginStatus(loginResult);
        } else {
            loginResult = false;
            obj.returnLoginStatus(loginResult);
        }
    }
}
/*
References:
Stack Overflow (2010) ‘Validate South Africa cell phone number’, Stack Overflow. Available at: Stack Overflow (Accessed: 17 September 2026).
Stack Overflow (2013) ‘Regex for password must contain at least eight characters, at least one number and both lower and uppercase letters 
and special characters’, Stack Overflow. Available at: Stack Overflow (Accessed: 17 September 2026).
Farrell, J. (2022) Java Programming. 10th edn. Boston, MA: Cengage Learning.
*/
