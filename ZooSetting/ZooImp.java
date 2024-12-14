/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo.ZooSetting;

import zoo.AnimalSettings.Animal;
import zoo.AnimalSettings.Bird;
import zoo.AnimalSettings.Fish;
import zoo.AnimalSettings.Mammal;

import java.util.*;

public class ZooImp implements Zoo {
    private List<Animal> animals;
    HashMap<String, List<Animal>> animalCategories;

    public ZooImp() {
        this.animals = new ArrayList<>();
        this.animalCategories = new HashMap<>();
        addPredefinedAnimals();
    }

    private void addPredefinedAnimals() {
        addAnimalToType("Mammal", new Mammal("Lion", "King", 5, 200, "Savannah", "Predatory", "Carnivore", true, false, "Africa", "Place 2A"), false);
        addAnimalToType("Bird", new Bird("Parrot", "Polly", 3, 0.5, "Tropical Forest", "Social", "Omnivore", true, false, "South America", "Place 1A"), false);
        addAnimalToType("Fish", new Fish("Goldfish", "Nemo", 1, 0.1, "Freshwater", "Swimming", "Carnivore", true, false, "North America", "Place 3A"), false);
    }



    @Override
    public void listAllAnimals() {
        System.out.println("\nListing All Animals:");
        for (String type : animalCategories.keySet()) {
            for (Animal animal : animalCategories.get(type)) {
                System.out.println(animal.getName() + " (" + type + ")");
                System.out.println("ID: " + animal.getID_animal());
                System.out.println("Species: " + animal.getSpecies());
                System.out.println("Name: " + animal.getName());
                System.out.println("Age: " + animal.getAge());
                System.out.println("Weight: " + animal.getWeight());
                System.out.println("Habitat: " + animal.getHabitat());
                System.out.println("Behavior: " + animal.getBehavior());
                System.out.println("Diet Type: " + animal.getDietType());
                System.out.println("Fertile: " + animal.isFertile());
                System.out.println("Endangered: " + animal.isEndangered());
                System.out.println("Origin: " + animal.getOrigin());
                System.out.println("Place: " + animal.getLocalZOO());
                System.out.println("----------------------------------");
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of animal (e.g., Mammal, Bird, Fish):");
        String type = scanner.nextLine();


        if (!animalCategories.containsKey(type)) {
            String response = "";
            //int check = 0;
            while (true) {
                System.out.println("Type does not exist. Do you want to create it? (yes/no)");
                response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    addNewAnimalType(type);
                  //  check = 0;
                    break; //
                } else if (response.equals("no")) {
                    System.out.println("Animal type creation cancelled.");
                 //   check = 1;
                    break; //

                } else {
                    System.out.println("Invalid input! Please type 'yes' or 'no'.");
                }
            }

            //Basic is when stop looping with No, the IF check break is 1, making back to menu,
            //when yes, check is 0 so just go for next one
          //  if (check == 1) {
           //     break;

          //  }


        }
        boolean valid = false;
        do {
            System.out.println("Enter animal details (Species, Name, Age, Weight, Habitat, Behavior, Diet , Fertile, Endangered, Origin, Place ):");
            String[] details = scanner.nextLine().split(",");




            if (details.length == 11) {
                try {

                    if (!details[0].trim().matches("[a-zA-Z\\s]+") || !details[1].trim().matches("[a-zA-Z\\s]+")) {
                        throw new IllegalArgumentException("Species and Name must contain only letters.");
                    }

                    int age = Integer.parseInt(details[2].trim());
                    if (age < 0) {
                        throw new IllegalArgumentException("Age must be a positive integer.");
                    }


                    double weight = Double.parseDouble(details[3].trim());
                    if (weight <= 0) {
                        throw new IllegalArgumentException("Weight must be a positive number.");
                    }

                    boolean isFertile = parseBoolean(details[7].trim());
                    boolean isEndangered = parseBoolean(details[8].trim());

                    if ( !details[4].trim().matches("[a-zA-Z\\s]+") || !details[9].trim().matches("[a-zA-Z\\s]+")) {
                        throw new IllegalArgumentException("Habitat and Origin contain only letters.");
                    }

                    Animal newAnimal = new Animal(
                            details[0].trim(),
                            details[1].trim(),
                            age,
                            weight,
                            details[4].trim(),
                            details[5].trim(),
                            details[6].trim(),
                            isFertile,
                            isEndangered,
                            details[9].trim(),
                            details[10].trim()
                    );
                    addAnimalToType(type, newAnimal, true);
                    valid = true;

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in input! Please try again.\"");
                }catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }

            } else {
                System.out.println("Invalid input format! Please ensure you provide all 9 attributes separated by commas.");

            }
        }while (!valid);
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
        System.out.println("ID: " + animal.getID_animal());
        System.out.println("Species: " + animal.getSpecies());
        System.out.println("Name: " + animal.getName());
        System.out.println("Age: " + animal.getAge());
        System.out.println("Weight: " + animal.getWeight());
        System.out.println("Habitat: " + animal.getHabitat());
        System.out.println("Behavior: " + animal.getBehavior());
        System.out.println("Diet Type: " + animal.getDietType());
        System.out.println("Fertile: " + animal.isFertile());
        System.out.println("Endangered: " + animal.isEndangered());
        System.out.println("Origin: " + animal.getOrigin());
        System.out.println("Place: " + animal.getLocalZOO());
        System.out.println("----------------------------------");
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


    // To very when add animals at ADD_ANIMAL, validation at Fertile and Endangered yes and no
    private static boolean parseBoolean(String input) throws IllegalArgumentException {
        if (input.equalsIgnoreCase("yes")) {
            return true;
        } else if (input.equalsIgnoreCase("no")) {
            return false;
        } else {
            throw new IllegalArgumentException("The Fertile and Endangered fields must be 'yes' or 'no'.");
        }
    }


}