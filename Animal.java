/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

public class Animal {
    private String species;
    private int age;
    private double weight;
    private String habitat;
    private String behavior;

    //more attributes that we creat about animal in general
    private String dietType;
    private boolean isFertile;
    private boolean isEndangered;
    private String origin;

    //ID to track the animal, local to know where the animals goes in the zoo
    //animal species also, name to species and name will be to name of animal
    private int ID_animal;
    private String name;
    private String localZOO;


    // ID to track the animal
    private static int currentID = 1;

    public Animal(String species,String name, int age, double weight, String habitat, String behavior, String dietType,
                  boolean isFertile, boolean isEndangered, String origin, String localZOO) {

        this.species = species;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
        this.behavior = behavior;
        this.dietType = dietType;
        this.isFertile = isFertile;
        this.isEndangered = isEndangered;
        this.origin = origin;
        this.ID_animal = currentID++;
        this.localZOO = localZOO;
    }

    // Getters and Setters
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public String getHabitat() { return habitat; }
    public void setHabitat(String habitat) { this.habitat = habitat; }
    public String getBehavior() { return behavior; }
    public void setBehavior(String behavior) { this.behavior = behavior; }
    public String getDietType() { return dietType; }
    public void setDietType(String dietType) { this.dietType = dietType; }
    public boolean isFertile() { return isFertile; }
    public void setFertile(boolean fertile) { isFertile = fertile; }
    public boolean isEndangered() { return isEndangered; }
    public void setEndangered(boolean endangered) { isEndangered = endangered; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }


    //add new get sett
    public int getID_animal() { return ID_animal; }
    public void setID_animal(int ID_animal) { this.ID_animal = ID_animal; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocalZOO() { return localZOO; }
    public void setLocalZOO(String localZOO) { this.localZOO = localZOO; }
}