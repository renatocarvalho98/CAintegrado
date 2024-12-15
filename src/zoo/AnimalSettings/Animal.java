/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo.AnimalSettings;

public class Animal {
    private static int currentID = 1; // Auto-increment ID

    public static void setCurrentID(int aCurrentID) {
        currentID = aCurrentID;
    }
    private int id;
    private String species;
    private String name;
    private int age;
    private double weight;
    private String habitat;
    private String behavior;
    private String dietType;
    private boolean isFertile;
    private boolean isEndangered;
    private String origin;
    private String zooLocation;
    private boolean isSick; // Indicates if the animal is sick

    // Constructor
    public Animal(String species, String name, int age, double weight, String habitat, String behavior,
                  String dietType, boolean isFertile, boolean isEndangered, String origin, String zooLocation) {
        this.id = currentID++;
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
        this.zooLocation = zooLocation;
        this.isSick = false; // Default to not sick
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getBehavior() {
        return behavior;
    }

    public String getDietType() {
        return dietType;
    }

    public boolean isFertile() {
        return isFertile;
    }

    public boolean isEndangered() {
        return isEndangered;
    }

    public String getOrigin() {
        return origin;
    }

    public String getZooLocation() {
        return zooLocation;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public void setIsFertile(boolean isFertile) {
        this.isFertile = isFertile;
    }

    public void setIsEndangered(boolean isEndangered) {
        this.isEndangered = isEndangered;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setZooLocation(String zooLocation) {
        this.zooLocation = zooLocation;
    }

    public void setIsSick(boolean isSick) {
        this.isSick = isSick;
    }
    
    @Override
    public String toString() {
        return "ID: " + id +
                ", Species: " + species +
                ", Name: " + name +
                ", Age: " + age +
                ", Weight: " + weight +
                ", Habitat: " + habitat +
                ", Behavior: " + behavior +
                ", Diet Type: " + dietType +
                ", Fertile: " + isFertile +
                ", Endangered: " + isEndangered +
                ", Origin: " + origin +
                ", Zoo Location: " + zooLocation +
                ", Sick: " + (isSick ? "Yes" : "No");
    }
}