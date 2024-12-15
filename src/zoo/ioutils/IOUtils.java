/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo.ioutils;
import java.util.Scanner;

public class IOUtils {

    // Get a valid text input (letters and spaces only)
    public String getUserText(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches("[a-zA-Z\\s]+")) {
                System.out.println("Invalid input. Please enter text only (letters and spaces).");
            } else {
                return input;
            }
        } while (true);
    }

    // Get a valid text and number input (letters, numbers, and spaces allowed)
    public String getUserTextWithNumbers(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches("[a-zA-Z0-9\\s]+")) {
                System.out.println("Invalid input. Please enter text and numbers only (letters, numbers, and spaces).");
            } else {
                return input;
            }
        } while (true);
    }

    // Get a valid integer input
    public int getUserInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    // Get a valid double input
    public double getUserDecimal(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Invalid input. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
    }

    // Get a valid boolean input (yes/no)
    public boolean getUserBoolean(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(prompt + " (yes/no):");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }
        }
    }
}