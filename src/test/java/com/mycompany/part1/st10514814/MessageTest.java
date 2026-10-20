/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part1.st10514814;

import java.nio.file.Files;
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
public class MessageTest {
    
    public MessageTest() {
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

  
     // ---------- Expected texts: edit these to match your code exactly ----------
    private static final String LENGTH_OK = "Your message is ready to be sent.";
    private static final String CELL_OK = "Recipent cell phone number successfully added";
    private static final String CELL_BAD_START = "Cell phone number incorrectly formatted";   // start of your failure text
    private static final String SENT = "Message successfully sent.";
    private static final String DISREGARD = "Press 0 to delete the message.";
    private static final String STORED = "Message successfully stored.";
 
    // ---------- Test data from the brief ----------
    private static final String CELL_1 = "+27718693002";
    private static final String MSG_1 = "Hi Mike, can you join us for dinner tonight";
    private static final String CELL_2 = "08575975889";
    private static final String MSG_2 = "Hi Keegan, did you receive the payment?";
 
    // ---------- 1. Message length ----------
 
    @Test
    void messageLengthSuccess() {
        assertEquals(LENGTH_OK, Message.checkMessageLength(MSG_1));
    }
 
    @Test
    void messageLengthFailure() {
        String tooLong = "a".repeat(260);   // 10 over the limit
        String result = Message.checkMessageLength(tooLong);
 
        assertNotEquals(LENGTH_OK, result);
        assertTrue(result.contains("250"), "Failure text should mention the 250 character limit");
        assertTrue(result.contains("10"), "Failure text should say how many characters it is over by");
    }
 
    // ---------- 2. Recipient cell number ----------
 
    @Test
    void recipientNumberSuccess() {
        Message m = new Message(0, CELL_1, MSG_1);
        assertEquals(CELL_OK, m.checkRecipentCell(CELL_1));
    }
 
    @Test
    void recipientNumberFailure() {
        Message m = new Message(1, CELL_2, MSG_2);   // no international code
        String result = m.checkRecipentCell(CELL_2);
 
        assertNotEquals(CELL_OK, result);
        assertTrue(result.startsWith(CELL_BAD_START));
    }
 
    // ---------- 3. Message hash ----------
 
    @Test
    void messageHashTestCase1() {
        Message m = new Message(0, CELL_1, MSG_1);
        String id = "0012457896";
 
        // First two digits of ID : message number : FIRST + LAST word, all caps
        assertEquals(id.substring(0, 2) + ":0:HITONIGHT", "00:0:HITONIGHT");
    }
 
    @Test
    void messageHashRemainingMessagesInLoop() {
        String[] cells = {CELL_1, CELL_2};
        String[] texts = {MSG_1, MSG_2};
        String[] firstLast = {"HITONIGHT", "HIPAYMENT"};
 
        for (int i = 0; i < texts.length; i++) {
            Message m = new Message(i, cells[i], texts[i]);
            String expected = m.getMessageID().substring(0, 2) + ":" + i + ":" + firstLast[i];
            assertEquals(expected, m.getMessageHash());
        }
    }
 
    // ---------- 4. Message ID ----------
 
    @Test
    void messageIdIsCreated() {
        Message m = new Message(0, CELL_1, MSG_1);
        String id = m.getMessageID();
 
        assertNotNull(id);
        assertFalse(id.isEmpty());
        assertTrue(id.length() == 10, "Message ID must be ten characters long");
    }
 
    // ---------- 5. Send / disregard / store ----------
 
    @Test
    void sendMessage() {
        Message m = new Message(0, CELL_1, MSG_1);
        assertEquals(SENT, m.SentMessage(1));
    }
 
    @Test
    void disregardMessage() {
        Message m = new Message(1, CELL_2, MSG_2);
        assertEquals(DISREGARD, m.SentMessage(2));
    }
     
    

 
    // ---------- 6. Total messages and print ----------
 
    @Test
    void totalMessagesOnlyCountsSentMessages() {
        int before = Message.returnTotalMessages();
 
        new Message(0, CELL_1, MSG_1).SentMessage(1);   // sent: counts
        new Message(1, CELL_2, MSG_2).SentMessage(2);   // disregarded: does not count
 
        assertEquals(before + 1, Message.returnTotalMessages());
    }

}