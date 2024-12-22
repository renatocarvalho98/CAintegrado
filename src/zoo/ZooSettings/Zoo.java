package zoo.ZooSettings;

import zoo.AnimalSettings.Animal;

public interface Zoo {


    void listAllAnimals();
    void listAllTypes();
    void addAnimal(Animal animal);
    void editAnimal();
    void getRandom();
    void addNewAnimalType(String type);
    void sendSickAnimals();
    void addAnimalToType(String type, Animal animal, boolean showMessage);
    void getAnimalById(int id);
}
