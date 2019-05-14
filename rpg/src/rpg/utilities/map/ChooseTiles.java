package rpg.utilities.map;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import rpg.game.Handler;
import rpg.objects.map.Tile;

public class ChooseTiles {

    private Handler h;

    public ChooseTiles(Handler h){
        this.h = h;
    }

    public Tile select(int id){
        Tile[] tiles;
        int len = 0;

        Tile[] temp = h.getMem().getTiles();
        for(int i = 0; i < temp.length; i++){
            if(Biome.valueOf(temp[i].getBiomeId().toUpperCase()).getId() == id){
                len++;
            }
        }

        tiles = new Tile[len];

        len = 0;

        for(int i = 0; i < temp.length; i++){
            if(Biome.valueOf(temp[i].getBiomeId().toUpperCase()).getId() == id){
                tiles[len] = temp[i];
                len++;
            }
        }

        


        return randomTile(tiles, id);
    }

    private Tile randomTile(Tile[] tiles, int id){

        Random r = new Random();
        int temp = r.nextInt(tiles.length);

        return tiles[temp];
    }

}