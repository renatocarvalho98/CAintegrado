/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo.MainMenu;

import zoo.zooSetting.ZooImp;

public class MainMenu {
    public static void main(String[] args) {
        ZooImp zoo = new ZooImp();
        int choice;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. List all animals");
            System.out.println("2. List all animal types");
            System.out.println("3. Add a new animal");
            System.out.println("4. Edit an animal");
            System.out.println("5. Get a random animal");
            System.out.println("6. Send sick animals to veterinary");
            System.out.println("7. Exit");

            choice = zoo.getIOUtils().getUserInt("Choose an option:");

            switch (choice) {
                case 1 -> zoo.listAllAnimals();
                case 2 -> zoo.listAllTypes();
                case 3 -> zoo.addAnimal(null);
                case 4 -> zoo.editAnimal();
        case 5 -> zoo.getRandom();
        case 6 -> zoo.sendSickAnimals();
        case 7 -> System.out.println("Exiting... Goodbye!");
        default -> System.out.println("Invalid choice. Please enter a number between 1 and 7.");
    }
} while (choice != 7);
        
}
}