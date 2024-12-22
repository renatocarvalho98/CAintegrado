package zoo.ioutils;

import java.util.Scanner;

/**
 * Utility class to handle user input operations.
 */
public class IOUtils {
    private final Scanner scanner;

    /**
     * Constructor initializes the Scanner.
     */
    public IOUtils() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads a valid text input (letters and spaces only).
     * @param prompt The prompt message for the user.
     * @return A valid text input.
     */
    public String getUserText(String prompt) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches("[a-zA-Z\\s]+")) {
                System.out.println("Invalid input. Please enter letters and spaces only.");
            } else {
                return input;
            }
        } while (true);
    }

    /**
     * Reads a valid text input that can include letters, numbers, and spaces.
     * @param prompt The prompt message for the user.
     * @return A valid text-and-number input.
     */
    public String getUserTextWithNumbers(String prompt) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches("[a-zA-Z0-9\\s]+")) {
                System.out.println("Invalid input. Please enter letters, numbers, and spaces only.");
            } else {
                return input;
            }
        } while (true);
    }

    /**
     * Reads a valid integer input.
     * @param prompt The prompt message for the user.
     * @return A valid integer value.
     */
    public int getUserInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    /**
     * Reads a valid double (decimal) input.
     * @param prompt The prompt message for the user.
     * @return A valid double value.
     */
    public double getUserDecimal(String prompt) {
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

    /**
     * Reads a valid boolean input (yes/no).
     * @param prompt The prompt message for the user.
     * @return A boolean value based on user input.
     */
    public boolean getUserBoolean(String prompt) {
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