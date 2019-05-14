package rpg.utilities.map;


public enum Biome {

    

    PLAINS(0), DESERT(1), MOUNTIAN(2), OCEAN(3), LAKE(4), FOREST(5), JUNGLE(6), SNOW(7), GRASSLAND(8), BEACH(9);

    private int id;

    private Biome(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

}