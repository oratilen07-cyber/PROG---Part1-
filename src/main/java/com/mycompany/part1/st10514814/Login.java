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


    
}
