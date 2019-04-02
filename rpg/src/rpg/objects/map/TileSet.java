package rpg.objects.map;

public class TileSet {
    private Tile[] tiles;
    private String id;
    private String name;
    private String biome;

    public String getId(){
        return this.id;
    }

    public void setId(String id){

    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBiome(){
        return this.biome;
    }

    public void setBiome(String biome){
        this.biome = biome;
    }

    public Tile[] getTiles(){
        return this.tiles;
    }

    public void setTiles(Tile[] tiles){
        this.tiles = tiles;
    }

}