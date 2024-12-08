/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

import java.util.*;

public class ZooImp implements Zoo {
    private List<Animal> animals;
    private HashMap<String, List<Animal>> animalCategories;

    public ZooImp() {
        this.animals = new ArrayList<>();
        this.animalCategories = new HashMap<>();
        addPredefinedAnimals();
    }

    private void addPredefinedAnimals() {
        addAnimalToType("Mammal", new Mammal("Lion", 12, 200, "Jungle", "Aggressive", "Carnivore", true, false, "Africa"), false);
        addAnimalToType("Bird", new Bird("Eagle", 5, 9, "Trees", "Majestic", "Carnivore", false, false, "North America"), false);
        addAnimalToType("Fish", new Fish("Shark", 7, 500, "Ocean", "Predatory", "Carnivore", true, false, "Pacific Ocean"), false);
    }

    @Override
    public void listAllAnimals() {
        System.out.println("\nListing All Animals:");
        for (String type : animalCategories.keySet()) {
            for (Animal animal : animalCategories.get(type)) {
                System.out.println(animal.getName() + " (" + type + ")");
            }
        }
    }

    @Override
    public void listAllTypes() {
        System.out.println("\nAnimal Types:");
        animalCategories.forEach((type, list) -> System.out.println(type + ": " + list.size()));
    }

    @Override
    public void addAnimal(Animal animal) {
        String type = animal.getClass().getSimpleName();
        addAnimalToType(type, animal, true);
    }

    @Override
    public void getRandom() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo!");
            return;
        }
        Random random = new Random();
        Animal animal = animals.get(random.nextInt(animals.size()));

        String type = null;
        for (String key : animalCategories.keySet()) {
            if (animalCategories.get(key).contains(animal)) {
                type = key;
                break;
            }
        }

        System.out.println("Random Animal: " + animal.getName() + " (" + type + ")");
    }

    @Override
    public void addNewAnimalType(String type) {
        if (!animalCategories.containsKey(type)) {
            animalCategories.put(type, new ArrayList<>());
            System.out.println("New animal type added: " + type);
        } else {
            System.out.println("Animal type already exists.");
        }
    }

    @Override
    public void addAnimalToType(String type, Animal animal, boolean showMessage) {
        animalCategories.putIfAbsent(type, new ArrayList<>());
        animalCategories.get(type).add(animal);
        animals.add(animal);
        if (showMessage) {
            System.out.println("Animal added successfully!");
        }
    }

    public static void main(String[] args) {
        ZooImp zoo = new ZooImp();
        Scanner scanner = new Scanner(System.in);

        MenuOptions choice = null;
        do {
            System.out.println("\nMenu:");
            for (MenuOptions option : MenuOptions.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option.name());
            }

            int option = scanner.nextInt();
            if (option < 1 || option > MenuOptions.values().length) {
                System.out.println("Invalid option!");
                continue;
            }
            choice = MenuOptions.values()[option - 1];

            switch (choice) {
                case LIST_ANIMALS -> zoo.listAllAnimals();
                case LIST_TYPES -> zoo.listAllTypes();
                case ADD_ANIMAL -> {
                    System.out.println("Enter the type of animal (e.g., Mammal, Bird, Reptile):");
                    scanner.nextLine(); // Limpar buffer
                    String type = scanner.nextLine();

                    if (!zoo.animalCategories.containsKey(type)) {
                        System.out.println("Type does not exist. Do you want to create it? (yes/no)");
                        if (scanner.nextLine().equalsIgnoreCase("yes")) {
                            zoo.addNewAnimalType(type);
                        } else {
                            System.out.println("Animal type creation cancelled.");
                            break;
                        }
                    }

                    System.out.println("Enter animal details (Name, Age, Weight, Habitat, Behavior, DietType, IsFertile, IsEndangered, Origin):");
                    String[] details = scanner.nextLine().split(",");
                    if (details.length == 9) {
                        Animal newAnimal = new Animal(details[0].trim(), Integer.parseInt(details[1].trim()),
                                Double.parseDouble(details[2].trim()), details[3].trim(), details[4].trim(),
                                details[5].trim(), Boolean.parseBoolean(details[6].trim()),
                                Boolean.parseBoolean(details[7].trim()), details[8].trim());
                        zoo.addAnimalToType(type, newAnimal, true);
                    } else {
                        System.out.println("Invalid input format!");
                    }
                }
                case RANDOM_ANIMAL -> zoo.getRandom();
                case EXIT -> System.out.println("Exiting...");
            }
        } while (choice != MenuOptions.EXIT);
    }
}