/*
 * Summary:
 * This program demonstrates how to handle various exceptions in Java through practical examples. 
 * Each exception is deliberately triggered in a realistic scenario and handled using try-catch blocks. 
 * Both checked (e.g., IOException, SQLException) and unchecked exceptions 
 * (e.g., ArithmeticException, NullPointerException) are covered.
 */

import java.io.*;
import java.sql.*;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();
        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();
    }

    // Simulate and handle IOException
    private static void handleIOException() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // Simulate and handle FileNotFoundException
    private static void handleFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("missingfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // Simulate and handle EOFException
    private static void handleEOFException() {
        try {
            DataInputStream dataInput = new DataInputStream(new FileInputStream("emptyfile.txt"));
            while (true) {
                dataInput.readInt();
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: End of file reached.");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // Simulate and handle SQLException
    private static void handleSQLException() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/invalidDB", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // Simulate and handle ClassNotFoundException
    private static void handleClassNotFoundException() {
        try {
            Class.forName("com.unknown.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // Simulate and handle ArithmeticException
    private static void handleArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: Division by zero.");
        }
    }

    // Simulate and handle NullPointerException
    private static void handleNullPointerException() {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Attempted to access a null reference.");
        }
    }

    // Simulate and handle ArrayIndexOutOfBoundsException
    private static void handleArrayIndexOutOfBoundsException() {
        try {
            int[] array = {1, 2, 3};
            int value = array[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Invalid array index accessed.");
        }
    }

    // Simulate and handle ClassCastException
    private static void handleClassCastException() {
        try {
            Object obj = new Integer(10);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: Invalid type casting.");
        }
    }

    // Simulate and handle IllegalArgumentException
    private static void handleIllegalArgumentException() {
        try {
            Thread.sleep(-1000);
        } catch (IllegalArgumentException | InterruptedException e) {
            System.out.println("IllegalArgumentException caught: Invalid argument passed.");
        }
    }

    // Simulate and handle NumberFormatException
    private static void handleNumberFormatException() {
        try {
            int number = Integer.parseInt("NotANumber");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number format.");
        }
    }
}
