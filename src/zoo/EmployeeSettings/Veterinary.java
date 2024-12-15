/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package zoo.EmployeeSettings;

import zoo.AnimalSettings.Animal;

import java.util.ArrayList;
import java.util.List;

public class Veterinary {
    private String name;
    private List<Animal> sickAnimals;

    public Veterinary(String name) {
        this.name = name;
        this.sickAnimals = new ArrayList<>();
    }

    // Overloaded method to add a single sick animal
    public void addSickAnimal(Animal animal) {
        if (animal.isSick()) {
            sickAnimals.add(animal);
            System.out.println(animal.getName() + " has been assigned to " + name + ".");
        } else {
            System.out.println(animal.getName() + " is not sick and cannot be added to the veterinary.");
        }
    }

    // Overloaded method to add multiple sick animals
    public void addSickAnimal(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.isSick()) {
                sickAnimals.add(animal);
                System.out.println(animal.getName() + " has been assigned to " + name + ".");
            }
        }
    }

    // List all sick animals assigned to the veterinary
    public void listSickAnimals() {
        System.out.println("\n--- Animals in Veterinary ---");
        if (sickAnimals.isEmpty()) {
            System.out.println("No sick animals in the veterinary.");
        } else {
            for (Animal animal : sickAnimals) {
                System.out.println(animal);
            }
        }
    }
}