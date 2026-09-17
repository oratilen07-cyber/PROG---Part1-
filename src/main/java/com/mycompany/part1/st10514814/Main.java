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

        System.out.println("Enter your name");
        String name = input.nextLine();

        System.out.println("Enter your surname");
        String surname = input.nextLine();

        System.out.println("Enter your username");
        String user = input.nextLine();

        System.out.println("Enter your password");
        String password = input.nextLine();

        System.out.println("Enter your South African phone number");
        String cellNumber = input.nextLine();

        Login obj = new Login(name, surname, user, password, cellNumber);
        
        obj.registerUser(user, password);

        String result = obj.registerUser(user, password);
      
        String enteredUser;
        String enteredPass;
        boolean loginResult;

        if (result.matches("The two above conditions have been met, and the user has been registered successfully\n")) {
            System.out.println("Enter your username to login");
            enteredUser = input.nextLine();

            System.out.println("Enter your password to login");
            enteredPass = input.nextLine();
            loginResult = obj.loginUser(name, surname, user, password, enteredUser, enteredPass);

            obj.returnLoginStatus(loginResult);
        } else {
            loginResult = false;
            obj.returnLoginStatus(loginResult);
        }
    }
}
