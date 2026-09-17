/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1.st10514814;

/**
 *
 * @author 25687
 */
public class Login {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String cellNumber;

    public Login(String name, String surname, String username, String password, String cellNumber) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
    }
    
// Validates username format: must contain underscore and be max 5 characters
    public boolean checkUserName(String username) {
        String result;
        boolean checkUser;
        // Checks: for underscore and  <= 5 characters 
        if (username.contains("_") && username.length() <= 5) {

            result = "Username successfully captured";
            checkUser = true;
        } else {

            result = "Username is not correctly formatted; please ensure your username contains an underscore and is no more than five characters in length";
            checkUser = false;
        }

        System.out.println(result);
        return checkUser;

    }
    
// Validates password strength using regex pattern matching
    public boolean checkPaswordComplexity(String password) {
        //Password regex requires: minimum 8 characters, at least 1 uppercase, 1 lowercase, 1 number, and 1 special character - https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
        String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        String result;
        boolean checkPassword;

        // Checks: 8+ chars, uppercase, lowercase, digit, special character (!$%^&*)    
        if (password.matches(PASSWORD_REGEX)) {
            result = "Password successfully captured";
            checkPassword = true;
        } else {
            result = "Password not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a speacial character";
            checkPassword = false;
        }

        System.out.println(result);
        return checkPassword;
    }
    
// Validates South African cell phone number format
    public boolean checkCellPhoneNumber(String cellNumber) {
        // South African cell phone format - https://stackoverflow.com/questions/4058001/validate-south-africa-cell-phone-number
        String CELL_REGEX = "^\\+27[6-8][0-9]{8}$";
        String result;
        boolean checkNumber;
        // Checks: country code +27 and network prefix [6-8]
        if (cellNumber.matches(CELL_REGEX)) {
            result = "Cell phone number successfully added";
            checkNumber = true;
        } else {
            result = "Cell phone number incorrectly formatted or does not contain internatioal code\n";
            checkNumber = false;
        }

        System.out.println(result);
        return checkNumber;
    }
    
// Processes user registration with validation
    public String registerUser(String username, String password) {

        String result;
        // Checks: username format, password complexity in sequence
        if (!checkUserName(username)) {
            result = "The username is incorrectly formatted";
        } else if (!checkPaswordComplexity(password)) {
            result = "The password does not meet the complexity requirements";
        } else {
            result = "The two above conditions have been met, and the user has been registered successfully";
        }

        System.out.println(result);
        return result;
    }

// Authenticates user credentials against registered username/password
    public boolean loginUser(String name, String surname, String username, String password, String enteredUser, String enteredPassword) {

        boolean login;
        String result;
        // Compares: entered username and password to stored values
        if (enteredUser.equals(username) && enteredPassword.equals(password)) {
            login = true;
            result = "Welcome " + name + " " + surname + ", it is great to see you again.";
        } else {
            login = false;
            result = "Username or password incorrect, please try again.";
        }

        System.out.println(result);
        return login;
    }
    
// Converts boolean login result to user-friendly message
    public String returnLoginStatus(boolean loginResult) {
        String status;
        // Used for: displaying appropriate feedback after login attempt
        if (loginResult) {
            status = "A successful login";
        } else {
            status = "A failed login";
        }
        
        System.out.println(status);
        return status;
    }
}
