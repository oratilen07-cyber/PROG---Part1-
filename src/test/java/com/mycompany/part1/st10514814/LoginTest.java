/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part1.st10514814;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 25687
 */
public class LoginTest {

    public LoginTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserNameCorrect() {
        String name = "";
        String surname = "";
        String userTest = "kyl_1";
        String password = "";
        String cellNumber = "";

        Login obj = new Login(name, surname, userTest, password, cellNumber);

        boolean expected = true;
        boolean actual = obj.checkUserName(userTest);

        assertEquals(expected, actual);
        assertTrue(obj.checkUserName(userTest));
    }

    @Test
    public void testCheckUserNameIncorrect() {
        String name = "";
        String surname = "";
        String userTest = "kyle!!!!!!!";
        String password = "";
        String cellNumber = "";

        Login obj = new Login(name, surname, userTest, password, cellNumber);

        boolean expected = false;
        boolean actual = obj.checkUserName(userTest);

        assertEquals(expected, actual);
        assertFalse(obj.checkUserName(userTest));
    }






}
