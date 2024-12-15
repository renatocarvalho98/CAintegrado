/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo.AnimalSettings;

public class Bird extends Animal {
    private boolean canFly;

    public Bird(String species, String name, int age, double weight, String habitat, String behavior,
                String dietType, boolean isFertile, boolean isEndangered, String origin, String zooLocation,
                boolean canFly) {
        super(species, name, age, weight, habitat, behavior, dietType, isFertile, isEndangered, origin, zooLocation);
        this.canFly = canFly;
    }

    public boolean canFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public String toString() {
        return super.toString() + ", Can Fly: " + (canFly ? "Yes" : "No");
    }
}