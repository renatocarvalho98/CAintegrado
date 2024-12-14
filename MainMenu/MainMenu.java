package zoo.MainMenu;

import zoo.ZooSetting.Zoo;
import zoo.ZooSetting.ZooImp;

import java.util.Scanner;


public class MainMenu extends ZooImp {


    public static void main(String[] args) {
        ZooImp zoo = new ZooImp();
        Scanner scanner = new Scanner(System.in);

        Zoo.MenuOptions choice = null;
        do {
            System.out.println("\nMenu:");
            for (Zoo.MenuOptions option : Zoo.MenuOptions.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option.name());
            }

            try {
                int option = scanner.nextInt();
                if (option < 1 || option > Zoo.MenuOptions.values().length) {
                    System.out.println("Invalid option!");
                    continue;
                }
                choice = Zoo.MenuOptions.values()[option - 1];

                switch (choice) {
                    case LIST_ANIMALS -> zoo.listAllAnimals();
                    case LIST_TYPES -> zoo.listAllTypes();
                    case ADD_ANIMAL -> {
                        zoo.addAnimal(null);
                    }
                    case RANDOM_ANIMAL -> zoo.getRandom();
                    case EXIT -> System.out.println("Exiting...");

                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number corresponding to the menu options.");
                scanner.nextLine();
            }
        } while (choice != Zoo.MenuOptions.EXIT);
    }
}
