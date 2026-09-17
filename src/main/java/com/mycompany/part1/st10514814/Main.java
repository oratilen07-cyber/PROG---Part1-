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

     

       
    }
}
