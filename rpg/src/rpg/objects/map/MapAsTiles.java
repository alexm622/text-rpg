package rpg.objects.map;

public class MapAsTiles {
    private Tile[][] map;
    private boolean[][] cleared;

    public Tile[][] getMap(){
        return this.map;
    }

    public void setMap(Tile[][] map){
        this.map = map;
    }

    public void setCleared(boolean[][] cleared){
        this.cleared = cleared;
    }

    public boolean[][] getCleared(){
        return this.cleared;
    }
}