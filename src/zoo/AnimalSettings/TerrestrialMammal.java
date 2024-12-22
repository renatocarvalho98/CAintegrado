package zoo.AnimalSettings;

public class TerrestrialMammal extends Mammal {
    public TerrestrialMammal(String species, String name, int age, double weight, String habitat, String behavior,
                             String dietType, boolean isFertile, boolean isEndangered, String origin, String zooLocation) {
        super(species, name, age, weight, habitat, behavior, dietType, isFertile, isEndangered, origin, zooLocation, false);
    }
}