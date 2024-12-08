/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 *
 * @author Lecturer
 */
public class Animal {
    
    // Create some attributes
    private String name;
    private int age;
    private double weight;
    private String habitat;

    //Add as new 5 attributes
    private String behavior;
    private String dietType;
    private String isFertile;
    private String isEndangered;
    private String origin;


    // Construction for the new 5 attributes and leaving the new attributes default
    public Animal(String name, int age, double weight, String habitat, String behavior, String dietType, String isFertile, String isEndangered, String origin) {

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



    // setting new attributes get and set methods BEHAVIOR, DIETTYPE, ISFERTILE, ISENDANGERED, ORIGIN
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

    public String getIsFertile() {
        return isFertile;
    }

    public void setIsFertile(String isFertile) {
        this.isFertile = isFertile;
    }

    public String getIsEndangered() {
        return isEndangered;
    }

    public void setIsEndangered(String isEndangered) {
        this.isEndangered = isEndangered;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
