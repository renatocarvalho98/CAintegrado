/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

public class Animal {
    private String name;
    private int age;
    private double weight;
    private String habitat;
    private String behavior;
    private String dietType;
    private boolean isFertile;
    private boolean isEndangered;
    private String origin;

    public Animal(String name, int age, double weight, String habitat, String behavior, String dietType,
                  boolean isFertile, boolean isEndangered, String origin) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
        this.behavior = behavior;
        this.dietType = dietType;
        this.isFertile = isFertile;
        this.isEndangered = isEndangered;
        this.origin = origin;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
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
}