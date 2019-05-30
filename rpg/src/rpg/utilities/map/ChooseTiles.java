package rpg.utilities.map;

import java.util.Random;


import rpg.game.Handler;
import rpg.objects.map.Tile;

public class ChooseTiles {


    public ChooseTiles(){
    }

    public static Tile select(double id){
        //possible tiles
        Tile[] tiles;

        //length
        int len = 0;

        Tile[] temp = Handler.memory.getTiles();
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

    private static Tile randomTile(Tile[] tiles, double id){

        Random r = new Random();
        
        int temp = r.nextInt(tiles.length);



        return tiles[temp];
    }

}