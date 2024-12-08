/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoo;

public interface Zoo {

    enum MenuOptions {
        LIST_ANIMALS,
        LIST_TYPES,
        ADD_ANIMAL,
        RANDOM_ANIMAL,
        EXIT
    }

    void listAllAnimals();

    void listAllTypes();

    void addAnimal(Animal animal);

    void getRandom();

    void addNewAnimalType(String type);

    void addAnimalToType(String type, Animal animal, boolean showMessage);
}