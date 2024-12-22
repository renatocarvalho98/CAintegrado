package zoo.AnimalSettings;

public class FlyingBird extends Bird {
    public FlyingBird(String species, String name, int age, double weight, String habitat, String behavior,
                      String dietType, boolean isFertile, boolean isEndangered, String origin, String zooLocation) {
        super(species, name, age, weight, habitat, behavior, dietType, isFertile, isEndangered, origin, zooLocation, true);
    }
}