package zoo.AnimalSettings;

import java.util.HashMap;

public class Animal {
    private static int currentID = 1; // Auto-increment ID
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
    private boolean isSick;

    // HashMap for custom dynamic attributes
    private HashMap<String, String> customAttributes;

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
        this.customAttributes = new HashMap<>(); // Initialize the custom attributes
    }

    // Getters and setters for custom attributes
    public HashMap<String, String> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(HashMap<String, String> customAttributes) {
        this.customAttributes = customAttributes;
    }

    public void addCustomAttribute(String key, String value) {
        customAttributes.put(key, value);
    }

    public void removeCustomAttribute(String key) {
        customAttributes.remove(key);
    }

    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public boolean isFertile() {
        return isFertile;
    }

    public void setIsFertile(boolean fertile) {
        isFertile = fertile;
    }

    public boolean isEndangered() {
        return isEndangered;
    }

    public void setIsEndangered(boolean endangered) {
        isEndangered = endangered;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getZooLocation() {
        return zooLocation;
    }

    public void setZooLocation(String zooLocation) {
        this.zooLocation = zooLocation;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(
                "ID: " + id + "\n" +
                        "Species: " + species + "\n" +
                        "Name: " + name + "\n" +
                        "Age: " + age + "\n" +
                        "Weight: " + weight + " kg\n" +
                        "Habitat: " + habitat + "\n" +
                        "Behavior: " + behavior + "\n" +
                        "Diet Type: " + dietType + "\n" +
                        "Fertile: " + (isFertile ? "Yes" : "No") + "\n" +
                        "Endangered: " + (isEndangered ? "Yes" : "No") + "\n" +
                        "Origin: " + origin + "\n" +
                        "Zoo Location: " + zooLocation + "\n" +
                        "Sick: " + (isSick ? "Yes" : "No")
        );

        // Append custom attributes if they exist
        if (!customAttributes.isEmpty()) {
            result.append("\nCustom Attributes:\n");
            customAttributes.forEach((key, value) -> result.append(key).append(": ").append(value).append("\n"));
        }

        return result.toString();
    }
}