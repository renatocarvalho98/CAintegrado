package zoo.EmployeeSettings;

import zoo.AnimalSettings.Animal;
import java.util.ArrayList;
import java.util.List;

public class Veterinary {
    private final String name;
    private final List<Animal> sickAnimals;

    public Veterinary(String name) {
        this.name = name;
        this.sickAnimals = new ArrayList<>();
    }

    public void addSickAnimal(Animal animal) {
        if (animal.isSick()) {
            sickAnimals.add(animal);
            System.out.println(animal.getName() + " has been added to " + name + "'s care.");
        }
    }

    public void listSickAnimals() {
        if (sickAnimals.isEmpty()) {
            System.out.println("No sick animals currently under care.");
        } else {
            System.out.println("Dr. " + name + " is currently treating the following animals:");
            for (Animal animal : sickAnimals) {
               System.out.println("ID: " + animal.getId());
                System.out.println("Name: " + animal.getName());
                System.out.println("Species: " + animal.getSpecies());
                System.out.println("Reason: Sick");
                System.out.println("---------------------------------");
            }
           // sickAnimals.forEach(System.out::println);
        }
    }

    public String getName() {
        return name;
    }
}

