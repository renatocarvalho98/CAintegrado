package zoo.ZooSettings;

import zoo.AnimalSettings.*;
import zoo.EmployeeSettings.Veterinary;
import zoo.ioutils.IOUtils;

import java.util.*;

public class ZooImp implements Zoo {
    private final IOUtils io;
    private final Map<String, List<Animal>> animalCategories;
    private final Veterinary veterinary;

    public ZooImp() {
        this.io = new IOUtils();
        this.animalCategories = new HashMap<>();
        this.veterinary = new Veterinary("Dr. Sam");
        addPredefinedAnimals();
    }

    public IOUtils getIOUtils() {
        return io;
    }

    public Veterinary getVeterinary() {
        return veterinary;
    }

    private void addPredefinedAnimals() {

        AquaticMammal dolphin = new AquaticMammal("Dolphin", "Flipper", 6, 150, "Ocean", "Playful",
            "Carnivore", true, false, "Atlantic Ocean", "Aquatic Zone");
        addAnimalToType("MAMMAL", dolphin, false); // Add to the zoo
        dolphin.setSick(true); // Mark as sick
        veterinary.addSickAnimal(dolphin); // Pass the same instance to the veterinary


        addAnimalToType("BIRD", new FlyingBird("Eagle", "Majestic", 4, 6.5, "Mountains", "Predator",
                "Carnivore", true, false, "North America", "Aviary 1"), false);
        addAnimalToType("FISH", new FreshwaterFish("Goldfish", "Nemo", 1, 0.1, "Pond", "Peaceful",
                "Herbivore", true, false, "Local", "Aquarium 2"), false);
    }




    @Override
    public void listAllTypes() {
        System.out.println("\n--- Animal Types ---");
        animalCategories.forEach((type, animals) ->
                System.out.println(type + ": " + animals.size() + " animals"));
    }


    // List all animals grouped by category
    @Override
    public void listAllAnimals() {
        if (animalCategories.isEmpty()) {
            System.out.println("No animals in the zoo.");
            return;
        }

        System.out.println("\n--- Listing All Animals ---");

        // Iterate through categories and print animals
        animalCategories.forEach((type, animals) -> {
            System.out.println("\nCategory: " + type);
            animals.forEach(animal -> {
                System.out.println("ID: " + animal.getId());
                System.out.println("Species: " + animal.getSpecies());
                System.out.println("Name: " + animal.getName());
                System.out.println("Age: " + animal.getAge());
                System.out.println("Weight: " + animal.getWeight() + " kg");
                System.out.println("Habitat: " + animal.getHabitat());
                System.out.println("Behavior: " + animal.getBehavior());
                System.out.println("Diet Type: " + animal.getDietType());
                System.out.println("Fertile: " + (animal.isFertile() ? "Yes" : "No"));
                System.out.println("Endangered: " + (animal.isEndangered() ? "Yes" : "No"));
                System.out.println("Origin: " + animal.getOrigin());
                System.out.println("Zoo Location: " + animal.getZooLocation());
                System.out.println("Sick: " + (animal.isSick() ? "Yes" : "No"));

                // Add a separation line after each animal
                System.out.println("----------------------------------------\n");
            });
        });
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
        String location = io.getUserTextWithNumbers("Enter zoo location:");

        Animal newAnimal = new Animal(species, name, age, weight, habitat, behavior, diet, fertile, endangered, origin, location);
        newAnimal.setSick(isSick);

        addAnimalToType(type, newAnimal, true);

        if (isSick) {
            veterinary.addSickAnimal(newAnimal);
        }

        System.out.println("Animal added successfully.");
    }

    @Override
    public void editAnimal() {
        System.out.println("\n--- Edit an Animal ---");
        int animalID = io.getUserInt("Enter the ID of the animal you want to edit:");

        Animal targetAnimal = findAnimalById(animalID);

        if (targetAnimal == null) {
            System.out.println("Animal not found.");
            return;
        }

        System.out.println("Editing Animal: " + targetAnimal);

        System.out.println("""
                Which attribute do you want to edit?
                1. Species
                2. Name
                3. Age
                4. Weight
                5. Habitat
                6. Behavior
                7. Diet Type
                8. Fertile
                9. Endangered
                10. Origin
                11. Zoo Location
                12. Sick Status
                """);

        int choice = io.getUserInt("Choose an option:");
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
            case 12 -> {
                boolean wasSick = targetAnimal.isSick();
                targetAnimal.setSick(io.getUserBoolean("Is the animal sick?"));
                if (targetAnimal.isSick() && !wasSick) {
                    veterinary.addSickAnimal(targetAnimal);
                }
            }
            default -> System.out.println("Invalid choice.");
        }

        System.out.println("Animal updated successfully.");
    }

    private Animal findAnimalById(int id) {
        for (List<Animal> animals : animalCategories.values()) {
            for (Animal animal : animals) {
                if (animal.getId() == id) return animal;
            }
        }
        return null;
    }

    @Override
    public void sendSickAnimals() {
        System.out.println("\n--- Sick Animals in Veterinary ---");
        veterinary.listSickAnimals();
    }

    @Override
    public void addNewAnimalType(String type) {
        animalCategories.putIfAbsent(type, new ArrayList<>());
        System.out.println("New animal type added: " + type);
    }

    @Override
    public void addAnimalToType(String type, Animal animal, boolean showMessage) {
        animalCategories.putIfAbsent(type, new ArrayList<>());
        animalCategories.get(type).add(animal);
        if (showMessage) System.out.println("Animal successfully added to " + type + " category.");
    }

    @Override
    public void getRandom() {
        List<Animal> allAnimals = new ArrayList<>();
        animalCategories.values().forEach(allAnimals::addAll);
        if (allAnimals.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }
        Animal randomAnimal = allAnimals.get(new Random().nextInt(allAnimals.size()));
        System.out.println("Random Animal: \n" + randomAnimal);
    }

    @Override
    public void getAnimalById(int id) {
        for (List<Animal> animalList : animalCategories.values()) {
            for (Animal animal : animalList) {
                if (animal.getId() == id) {
                    System.out.println("--- Animal Found ---");
                    System.out.println(animal); // This will now print line by line
                    return;
            }
        }
    }
        System.out.println("No animal found with ID: " + id);

}}

