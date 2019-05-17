package rpg.objects.map;

public class Map {
    private String[][] tileids;
    private boolean[][] cleared;
    private int height;
    private int width;
    

    public String[][] getTileids(){
        return this.tileids;
    }

    public void setTileids(String[][] tileids){
        this.tileids = tileids;
    }

    public void setCleared(boolean[][] cleared){
        this.cleared = cleared;
    }
    
    public boolean[][] getCleared(){
        return this.cleared;
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }
}