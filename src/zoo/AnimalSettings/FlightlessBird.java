package zoo.AnimalSettings;



public class FlightlessBird extends Bird {
    public FlightlessBird(String species, String name, int age, double weight, String habitat, String behavior,
                          String dietType, boolean isFertile, boolean isEndangered, String origin, String zooLocation) {
        super(species, name, age, weight, habitat, behavior, dietType, isFertile, isEndangered, origin, zooLocation, false);
    }

    @Override
    public String toString() {
        return super.toString() + " (Flightless)";
    }
}