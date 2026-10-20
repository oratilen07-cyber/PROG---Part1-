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

        String result = obj.registerUser(user, password, cellNumber);

        String enteredUser;
        String enteredPass;
        boolean loginResult = true;

        //Login : after users enters credentials, system verifies against registration data  
        if (result.matches("The three above conditions have been met, and the user has been registered successfully")) {

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
        //Part 2 
        //Message: if the user logs in succsessfully, they are prompted to choose between three options 

        if (loginResult) {

            System.out.println("=============================");
            System.out.println("Welcome to ChatApp");
            System.out.println("=============================");

            boolean running = true;

            int numMessages = 0;
            int maxNumMessages;

            while (running) {
                System.out.println("==============================");
                System.out.println("1.) Send Messages\n2.) Show Messages\n3.) Quit");
                System.out.println("=============================");
                System.out.print("Enter your choice: ");

                int choice = input.nextInt();

                if (choice == 1) {
                    System.out.println("How many messages do you want to send?");
                    maxNumMessages = input.nextInt();
                    input.nextLine();
                    String recipentCell;

                    for (int i = numMessages; i < maxNumMessages; i++) {
                        System.out.println("Message " + (i + 1) + " of " + maxNumMessages);

                        // ---- 1. recipient: re-ask until valid ----
                        while (true) {
                            System.out.print("Enter the recipient cell number: ");
                            recipentCell = input.nextLine().trim();

                            if (Message.checkRecipentCell(recipentCell).equals("Recipent cell phone number successfully added")) {
                                break;
                            }
                            System.out.println("Enter a correctly formatted cellphone number");
                        }

                        String message;
                        while (true) {
                            System.out.println("Enter a message with no more than 250 characters: ");
                            message = input.nextLine().trim();
                            if (message.trim().isEmpty()) {
                                System.out.println("Please type a message with no more than 250 characters");
                            } else if (Message.checkMessageLength(message).matches("")) {
                                System.out.println("Message is too long, please try again");

                            } else {
                                break;
                            }

                        }
                        int sendChoice;
                        while (true) {

                            System.out.println("1) Send Message  2) Disregard Message  3) Store Message");
                            System.out.print("Choose an option: ");
                            String line = input.nextLine().trim();
                            if (line.equals("1") || line.equals("2") || line.equals("3")) {
                                sendChoice = Integer.parseInt(line);
                                break;
                            }
                            System.out.println("Please enter 1, 2 or 3.");
                        }

                        Message userMessage = new Message(numMessages, recipentCell, message);

                        System.out.println(userMessage.SentMessage(sendChoice));
                        System.out.println(userMessage.getMessageDetails());

                    }
                } else if (choice == 2) {
                    System.out.println("Show recently stored message, Coming Soon");

                } else if (choice == 3) {
                    running = false;
                    System.out.println("Quit");
                }
            }

        }
    }
}

/*
References:
Stack Overflow (2010) ‘Validate South Africa cell phone number’, Stack Overflow. Available at: Stack Overflow (Accessed: 17 September 2026).
https://stackoverflow.com/questions/4058001/validate-south-africa-cell-phone-number
Stack Overflow (2013) ‘Regex for password must contain at least eight characters, at least one number and both lower and uppercase letters 
and special characters’, Stack Overflow. Available at: Stack Overflow (Accessed: 17 September 2026).
https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
Farrell, J. (2022) Java Programming. 10th edn. Boston, MA: Cengage Learning.
 */

/*Reading and writing from Json file
https://www.youtube.com/watch?v=9Xr-o_QWMeE
*/