package zoo.MainMenu;

import zoo.ZooSettings.ZooImp;

public class MainMenu {
    public static void main(String[] args) {
        ZooImp zoo = new ZooImp();
        int choice;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("Veterinarian on duty: " + zoo.getVeterinary().getName());
            System.out.println("1. List all animals");
            System.out.println("2. List all animal types");
            System.out.println("3. Get animal by ID");
            System.out.println("4. Add a new animal");
            System.out.println("5. Edit an animal");
            System.out.println("6. Get a random animal");
            System.out.println("7. Check sick animals at veterinary");
            System.out.println("8. Exit");

            choice = zoo.getIOUtils().getUserInt("Choose an option:");

            switch (choice) {
                case 1 -> zoo.listAllAnimals();
                case 2 -> zoo.listAllTypes();
                case 3 -> zoo.getAnimalById(zoo.getIOUtils().getUserInt("Enter the ID of the animal:"));
                case 4 -> zoo.addAnimal(null);
                case 5 -> zoo.editAnimal();
                case 6 -> zoo.getRandom();
                case 7 -> zoo.sendSickAnimals();
                case 8 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
    }
}