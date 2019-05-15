package rpg.utilities.map;

import rpg.game.Handler;
import rpg.objects.map.Map;
import rpg.objects.map.MapAsTiles;
import rpg.objects.map.Tile;

public class PrepareMap {

    private Handler h;
    private Tile[] tiles;
    private Tile[][] map;
    private Map m;
    private MapAsTiles mt;
    private String[] ids;
    private int height, width;
    private boolean[][] clear;

    public PrepareMap(Handler h){
        this.h = h;
        tiles = h.getMem().getTiles();
        m = h.getMem().getMap();
        prepare();
        begin();
        finish();

    }

    //begin preparing

    private void prepare(){
        
        //set height and width

        this.width = m.getWidth();
        this.height = m.getHeight();

        Handler.debug("width: " + width);
        Handler.debug("height: " + height);

        //create ids
        ids = new String[this.tiles.length];

        //map ids
        for(int i = 0; i < tiles.length; i++){
            ids[i] = tiles[i].getId();
        }

        //create map as tiles
        mt = new MapAsTiles();

        //create map
        map = new Tile[width][height];

        //clear

        clear = m.getCleared();

        Handler.debug("is tiles null: " + (h.getMem().getTiles()[0] == null));




    }

    private void begin(){

        //map ids to tiles
        for(int i = 0; i < height; i++){ //y
            for(int j = 0; j < width; j++){ //x
                for(int k = 0; k < ids.length; k++){
                    if(m.getTileids()[j][i] == ids[k]){
                        map[j][i] = h.getMem().getTiles()[k];
                        Handler.debug("is tile null: " + (h.getMem().getTiles()[k] == null));
                        k = ids.length;
                    }else if(k == (ids.length - 1)){
                        Handler.debug("something went wrong", true);

                    }
                }
            }
        }
        mt.setCleared(clear);
        mt.setMap(map);
        
        
    }

    private void finish(){
        
        Handler.debug(mt == null);
        h.getMem().setMapTiles(mt);
    }
}