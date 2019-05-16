package rpg.utilities.map;


public enum Biome {

    

    PLAINS(0.0), DESERT(-2.5), MOUNTIAN(10.0), OCEAN(-10.0), LAKE(-7.5), FOREST(5.0), JUNGLE(-12.5), SNOW(7.5), GRASSLAND(2.5), BEACH(-5.0);

    private double id;

    private Biome(double id) {
        this.id = id;
    }

    public double getId() {
        return this.id;
    }

}