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

    public boolean checkUserName(String username) {

        // String USER_REGEX = "[a-zA-Z0-9_]+";  //contains  .length
        String result;
        boolean checkUser;

        if (username.contains("_") && username.length() <= 5) {

            result = "Username successfully captured\n";
            checkUser = true;
        } else {

            result = "Username is not correctly formatted; please ensure your username contains an underscore and is no more than five characters in length\n";
            checkUser = false;
        }

        System.out.println(result);
        return checkUser;

    }

    public boolean checkPaswordComplexity(String password) {

        String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        String result;
        boolean checkPassword;

        if (password.matches(PASSWORD_REGEX)) {
            result = "Password successfully captured\n";
            checkPassword = true;
        } else {
            result = "Password not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a speacial character\n";
            checkPassword = false;
        }

        System.out.println(result);
        return checkPassword;
    }

    public boolean checkCellPhoneNumber(String cellNumber) {

        String CELL_REGEX = "^\\+27[6-8][0-9]{8}$";
        String result;
        boolean checkNumber;

        if (cellNumber.matches(CELL_REGEX)) {
            result = "Cell phone number successfully added\n";
            checkNumber = true;
        } else {
            result = "Cell phone number incorrectly formatted or does not contain internatioal code\n";
            checkNumber = false;
        }

        System.out.println(result);
        return checkNumber;
    }
    public String registerUser(String username, String password) {

        String result;

        if (!checkUserName(username)) {
            result = "The username is incorrectly formatted\n";
        } else if (!checkPaswordComplexity(password)) {
            result = "The password does not meet the complexity requirements\n";
        } else {
            result = "The two above conditions have been met, and the user has been registered successfully\n";
        }

        System.out.println(result);
        return result;
    }
        public boolean loginUser(String name, String surname, String username, String password, String enteredUser, String enteredPassword) {

        boolean login;
        String result;

        if (enteredUser.equals(username) && enteredPassword.equals(password)) {
            login = true;
            result = "Welcome " + name + " " + surname + ". It is great to see you again.";
        } else {
            login = false;
            result = "Username or password incorrect, please try again.";
        }

        System.out.println(result);
        return login;
    }

    public String returnLoginStatus(boolean loginResult) {
        String status;

        if (loginResult) {
            status = "A successful login";
        } else {
            status = "A failed login";
        }

        System.out.println(status);
        return status;
    }
}
