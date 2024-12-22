/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo.AnimalSettings;

import zoo.AnimalSettings.Animal;

public class Fish extends Animal {
    private boolean isFreshwater;

    public Fish(String species, String name, int age, double weight, String habitat, String behavior,
                String dietType, boolean isFertile, boolean isEndangered, String origin, String zooLocation,
                boolean isFreshwater) {
        super(species, name, age, weight, habitat, behavior, dietType, isFertile, isEndangered, origin, zooLocation);
        this.isFreshwater = isFreshwater;
    }

    public boolean isFreshwater() {
        return isFreshwater;
    }

    public void setFreshwater(boolean freshwater) {
        isFreshwater = freshwater;
    }

    @Override
    public String toString() {
        return super.toString() + ", Freshwater: " + (isFreshwater ? "Yes" : "No");
    }
}