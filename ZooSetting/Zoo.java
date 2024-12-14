/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoo.ZooSetting;

import zoo.AnimalSettings.Animal;

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


    //here we add new animal type to zoo, new category of animals.
    //this methodo will show up when we open at ADD_ANIMAL, if we chose to input new animal type
    void addAnimalToType(String type, Animal animal, boolean showMessage);
}