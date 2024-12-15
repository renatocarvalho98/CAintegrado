/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo.zooSetting;

import zoo.AnimalSettings.Animal;
import zoo.AnimalSettings.Bird;
import zoo.AnimalSettings.Fish;
import zoo.AnimalSettings.Mammal;
import zoo.EmployeeSettings.Veterinary;
import zoo.ioutils.IOUtils;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ZooImp implements Zoo {
    private final IOUtils io;
    private final HashMap<String, List<Animal>> animalCategories;
    private final Veterinary veterinary;

    public ZooImp() {
        this.io = new IOUtils();
        this.animalCategories = new HashMap<>();
        this.veterinary = new Veterinary("Dr. Smith");
        addPredefinedAnimals();
    }

    // Public getter for IOUtils
    public IOUtils getIOUtils() {
        return io;
    }

    // Add predefined animals
    private void addPredefinedAnimals() {
        addAnimalToType("MAMMAL", new Mammal("Lion", "Simba", 5, 200, "Savannah", "Predatory", "Carnivore", true, false, "Africa", "Place 2A", false), false);
        addAnimalToType("BIRD", new Bird("Parrot", "Polly", 2, 0.5, "Tropical Forest", "Social", "Omnivore", true, false, "South America", "Place 1B", true), false);
        addAnimalToType("FISH", new Fish("Goldfish", "Nemo", 1, 0.1, "Freshwater", "Peaceful", "Herbivore", true, false, "North America", "Place 3C", true), false);
    }

    @Override
public void listAllAnimals() {
    if (animalCategories.isEmpty()) {
        System.out.println("No animals in the zoo.");
        return;
    }

    System.out.println("\n--- Listing All Animals ---");
    for (String type : animalCategories.keySet()) {
        System.out.println("\nCategory: " + type);
        for (Animal animal : animalCategories.get(type)) {
            System.out.println("\nID: " + animal.getId());
            System.out.println("Species: " + animal.getSpecies());
            System.out.println("Name: " + animal.getName());
            System.out.println("Age: " + animal.getAge());
            System.out.println("Weight: " + animal.getWeight());
            System.out.println("Habitat: " + animal.getHabitat());
            System.out.println("Behavior: " + animal.getBehavior());
            System.out.println("Diet Type: " + animal.getDietType());
            System.out.println("Fertile: " + (animal.isFertile() ? "Yes" : "No"));
            System.out.println("Endangered: " + (animal.isEndangered() ? "Yes" : "No"));
            System.out.println("Origin: " + animal.getOrigin());
            System.out.println("Zoo Location: " + animal.getZooLocation());
            System.out.println("Sick: " + (animal.isSick() ? "Yes" : "No"));
            System.out.println("\n-----------------------------------------");
        }
    }
}
    @Override
    public void listAllTypes() {
        System.out.println("\n--- Animal Types ---\n");
        animalCategories.forEach((type, animals) -> System.out.println(type + ": " + animals.size() + " animals"));
    }

    @Override
    public void addAnimal(Animal animal) {
        System.out.println("\n--- Add a New Animal ---");

        String type = io.getUserText("Enter the type of animal (e.g., Mammal, Bird, Fish):").trim().toUpperCase();

        if (!animalCategories.containsKey(type)) {
            boolean createNew = io.getUserBoolean("Type does not exist. Do you want to create it?");
            if (createNew) {
                addNewAnimalType(type);
            } else {
                System.out.println("Animal type creation cancelled.");
                return;
            }
        }

        String species = io.getUserText("Enter species:");
        String name = io.getUserText("Enter name:");
        int age = io.getUserInt("Enter age:");
        double weight = io.getUserDecimal("Enter weight:");
        String habitat = io.getUserText("Enter habitat:");
        String behavior = io.getUserText("Enter behavior:");
        String diet = io.getUserText("Enter diet type:");
        boolean fertile = io.getUserBoolean("Is the animal fertile?");
        boolean endangered = io.getUserBoolean("Is the animal endangered?");
        boolean isSick = io.getUserBoolean("Is the animal sick?");
        String origin = io.getUserText("Enter origin:");
        String location = io.getUserTextWithNumbers("Enter zoo location (letters and numbers allowed):");

        Animal newAnimal;
        switch (type) {
            case "MAMMAL" -> {
                boolean isAquatic = io.getUserBoolean("Is the mammal aquatic?");
                newAnimal = new Mammal(species, name, age, weight, habitat, behavior, diet, fertile, endangered, origin, location, isAquatic);
            }
            case "BIRD" -> {
                boolean canFly = io.getUserBoolean("Can the bird fly?");
                newAnimal = new Bird(species, name, age, weight, habitat, behavior, diet, fertile, endangered, origin, location, canFly);
            }
            case "FISH" -> {
                boolean isFreshwater = io.getUserBoolean("Is the fish freshwater?");
                newAnimal = new Fish(species, name, age, weight, habitat, behavior, diet, fertile, endangered, origin, location, isFreshwater);
            }
            default -> {
                newAnimal = new Animal(species, name, age, weight, habitat, behavior, diet, fertile, endangered, origin, location);
            }
        }

        newAnimal.setSick(isSick);
        addAnimalToType(type, newAnimal, true);

        if (isSick) {
            veterinary.addSickAnimal(newAnimal);
        }

        System.out.println("\nAnimal added successfully! Returning to main menu...\n");
    }
    
@Override
public void editAnimal() {
    int animalID = io.getUserInt("Enter the ID of the animal you want to edit:");

    Animal targetAnimal = null;
    for (List<Animal> animalList : animalCategories.values()) {
        for (Animal animal : animalList) {
            if (animal.getId() == animalID) {
                targetAnimal = animal;
                break;
            }
        }
        if (targetAnimal != null) break;
    }

    if (targetAnimal == null) {
        System.out.println("Animal with ID " + animalID + " not found.");
        return;
    }

    System.out.println("\nAnimal Found:");
    System.out.println(targetAnimal);

    System.out.println("\nWhich attribute do you want to edit?");
    System.out.println("1. Species");
    System.out.println("2. Name");
    System.out.println("3. Age");
    System.out.println("4. Weight");
    System.out.println("5. Habitat");
    System.out.println("6. Behavior");
    System.out.println("7. Diet Type");
    System.out.println("8. Fertile");
    System.out.println("9. Endangered");
    System.out.println("10. Origin");
    System.out.println("11. Zoo Location");
    System.out.println("12. Sick Status");

    if (targetAnimal instanceof Mammal) {
        System.out.println("13. Aquatic (true/false)");
    } else if (targetAnimal instanceof Bird) {
        System.out.println("13. Can Fly (true/false)");
    } else if (targetAnimal instanceof Fish) {
        System.out.println("13. Freshwater (true/false)");
    }

    int choice = io.getUserInt("Enter the number of the attribute you want to edit:");

    switch (choice) {
        case 1 -> targetAnimal.setSpecies(io.getUserText("Enter new species:"));
        case 2 -> targetAnimal.setName(io.getUserText("Enter new name:"));
        case 3 -> targetAnimal.setAge(io.getUserInt("Enter new age:"));
        case 4 -> targetAnimal.setWeight(io.getUserDecimal("Enter new weight:"));
        case 5 -> targetAnimal.setHabitat(io.getUserText("Enter new habitat:"));
        case 6 -> targetAnimal.setBehavior(io.getUserText("Enter new behavior:"));
        case 7 -> targetAnimal.setDietType(io.getUserText("Enter new diet type:"));
        case 8 -> targetAnimal.setIsFertile(io.getUserBoolean("Is the animal fertile?"));
        case 9 -> targetAnimal.setIsEndangered(io.getUserBoolean("Is the animal endangered?"));
        case 10 -> targetAnimal.setOrigin(io.getUserText("Enter new origin:"));
        case 11 -> targetAnimal.setZooLocation(io.getUserTextWithNumbers("Enter new zoo location:"));
        case 12 -> targetAnimal.setSick(io.getUserBoolean("Is the animal sick?"));
        case 13 -> {
            if (targetAnimal instanceof Mammal mammal) {
                mammal.setAquatic(io.getUserBoolean("Is the mammal aquatic?"));
            } else if (targetAnimal instanceof Bird bird) {
                bird.setCanFly(io.getUserBoolean("Can the bird fly?"));
            } else if (targetAnimal instanceof Fish fish) {
                fish.setFreshwater(io.getUserBoolean("Is the fish freshwater?"));
            } else {
                System.out.println("Invalid option for this animal type.");
                return;
            }
        }
        default -> {
            System.out.println("Invalid choice. No changes were made.");
            return;
        }
    }

    System.out.println("\nAnimal updated successfully!");
    System.out.println("Updated Animal Information:");
    System.out.println("\n" + targetAnimal);
}

    @Override
public void getRandom() {
    if (animalCategories.isEmpty()) {
        System.out.println("No animals in the zoo!");
        return;
    }

    List<Animal> allAnimals = new ArrayList<>();
    animalCategories.values().forEach(allAnimals::addAll);

    int randomIndex = (int) (Math.random() * allAnimals.size());
    Animal randomAnimal = allAnimals.get(randomIndex);

    System.out.println("\n--- Random Animal ---");
    System.out.println("ID: " + randomAnimal.getId());
    System.out.println("Species: " + randomAnimal.getSpecies());
    System.out.println("Name: " + randomAnimal.getName());
    System.out.println("Age: " + randomAnimal.getAge());
    System.out.println("Weight: " + randomAnimal.getWeight());
    System.out.println("Habitat: " + randomAnimal.getHabitat());
    System.out.println("Behavior: " + randomAnimal.getBehavior());
    System.out.println("Diet Type: " + randomAnimal.getDietType());
    System.out.println("Fertile: " + (randomAnimal.isFertile() ? "Yes" : "No"));
    System.out.println("Endangered: " + (randomAnimal.isEndangered() ? "Yes" : "No"));
    System.out.println("Origin: " + randomAnimal.getOrigin());
    System.out.println("Zoo Location: " + randomAnimal.getZooLocation());
    System.out.println("Sick: " + (randomAnimal.isSick() ? "Yes" : "No"));
    System.out.println("-----------------------------------------");
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
        if (showMessage) {
        }
    }

    public void sendSickAnimals() {
        System.out.println("\n--- Sending Sick Animals to Veterinary ---");
        veterinary.listSickAnimals();
    }
}