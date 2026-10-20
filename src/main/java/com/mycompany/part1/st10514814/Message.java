/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1.st10514814;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author 25687
 */
  

    public class Message {

        private static int totalMessagesSent;
        private static int storeMessage;
        private final String messageID;
        private int messageNumber;
        private String recipentCell;
        private String messageText;
        private String messageHash;
        private String print;

        private static String storedJson = "";
        private static int storedCount = 0;

        public Message(int messageNumber, String recipentCell, String messageText) {
            this.messageID = generateMessageID();
            this.messageNumber = messageNumber;
            this.recipentCell = recipentCell;
            this.messageText = messageText;
            this.messageHash = createMessageHash(this.messageID, messageNumber, messageText);
        }

        public String generateMessageID() {
            Random obj = new Random();

            int firstHalf = obj.nextInt(90000) + 10000;
            int secondHalf = obj.nextInt(90000) + 10000;

            return String.valueOf(firstHalf) + "" + String.valueOf(secondHalf);
        }

        public boolean checkMessageID() {
            return messageID.length() == 10;
        }

        public String getMessageID() {
            return messageID;
        }

        public String getMessageHash() {
            return messageHash;
        }

        public String getRecipentCell() {
            return recipentCell;
        }

        public int getMessageNum() {
            return messageNumber;
        }

        public String getMessageText() {
            return messageText;
        }

        public static String checkRecipentCell(String recipentCell) {
            //Code resued from Login Class
            // South African cell phone format -
            //South African cellphone number validation:(Stack Overflow, 2010)
            String CELL_REGEX = "^\\+27[6-8][0-9]{8}$";
            String result;
            // Checks: country code +27 and network prefix [6-8]
            if (recipentCell.matches(CELL_REGEX)) {
                result = "Recipent cell phone number successfully added";

            } else {
                result = "Cell phone number incorrectly formatted "
                        + "or does not contain internatioal code";

            }
            return result;
        }

        public static String checkMessageLength(String message) {
            String result;

            if (message.length() <= 250) {
                result = "Your message is ready to be sent.";
            } else {
                int extra = message.length() - 250;
                result = "Message has" + extra + " extra characters." + "Max 250 characters";
            }
            return result;
        }

        public static String createMessageHash(String messageID, int messageNumber, String message) {

            String firstTwoID = messageID.substring(0, 2);
            String userMessage = message.trim();

            int firstSpace = userMessage.indexOf(" ");
            String firstWord;

            if (firstSpace == -1) {
                firstWord = userMessage;
            } else {
                firstWord = userMessage.substring(0, firstSpace);
            }

            int lastSpace = userMessage.lastIndexOf(" ");

            String lastWord = userMessage.substring(lastSpace + 1);

            String messageHash = firstTwoID + ":" + messageNumber + ":" + firstWord + lastWord;
            return messageHash.toUpperCase();
        }

        public String getMessageDetails() {

            return "Message hash: " + messageHash + "\nMessage ID: " + this.messageID + "\nRecipent: " + this.recipentCell + "\nMessage:" + messageText;
        }

        public String SentMessage(int choice) {
            String result;

            if (choice == 1) {
                result = "Message successfully sent.";
                totalMessagesSent++;
            } else if (choice == 2) {
                result = "Press 0 to delete the message.";

            } else if (choice == 3) {
                result = "Message successfully stored.";
                storeMessage();

            } else {
                result = "Invalid choice.";
            }
            return result;
        }

        public static int returnTotalMessages() {
            return totalMessagesSent;
        }

        public void printMessage() {
        System.out.println("\n========Message Details======");
        System.out.println("MessageID: " + messageID);
        System.out.println("MessageHash: " + messageHash);
        System.out.println("Recipent Cell: " + recipentCell);
        System.out.println("Message Text: " + messageText);
        System.out.println("=============================");
           
        }
    

    public void storeMessage() {
        String entry = "  {\n"
                + "    \"MessageID\": \"" + escape(messageID) + "\",\n"
                + "    \"MessageNumber\": " + messageNumber + ",\n"
                + "    \"MessageHash\": \"" + escape(messageHash) + "\",\n"
                + "    \"Recipient\": \"" + escape(recipentCell) + "\",\n"
                + "    \"Message\": \"" + escape(messageText) + "\"\n"
                + "  }";

        if (storedCount > 0) {
            storedJson += ",\n";          // comma between objects
        }
        storedJson += entry;
        storedCount++;

        String json = "[\n" + storedJson + "\n]\n";

        try (FileWriter writer = new FileWriter("storedMessages.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Could not save the message: " + e.getMessage());
        }
    }

    private static String escape(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

}
