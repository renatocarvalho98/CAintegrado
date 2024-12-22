package zoo.AnimalSettings;

import zoo.AnimalSettings.Animal;

public class Mammal extends Animal {
    private boolean isAquatic;

    public Mammal(String species, String name, int age, double weight, String habitat, String behavior,
                  String dietType, boolean isFertile, boolean isEndangered, String origin, String zooLocation, boolean isAquatic) {
        super(species, name, age, weight, habitat, behavior, dietType, isFertile, isEndangered, origin, zooLocation);
        this.isAquatic = isAquatic;
    }

    public boolean isAquatic() { return isAquatic; }

    @Override
    public String toString() {
        return super.toString() + ", Aquatic: " + (isAquatic ? "Yes" : "No");
    }
}