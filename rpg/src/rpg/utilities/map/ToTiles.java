package rpg.utilities.map;

import rpg.game.Handler;
import rpg.objects.map.Tile;

public class ToTiles {

    private double[][] doub;
    private Tile[][] tiles;
    private Tile[] set;

    public ToTiles(Handler h){

        doub = h.getG().getMemory().getMem().getMap().getTiles();
        set = h.getG().getMemory().getMem().getTileSet().getTiles();
        tiles = new Tile[doub.length-1][doub[0].length-1];

        //-7.5, -5.0 , -2.5, 0, 2.5, 5.0, 7.5
        for(int i = 0; i < doub.length; i++){
            for(int x = 0; x < doub[i].length; x++){
                String temp = Double.toStgetTilesring(doub[i][x]);
                switch (temp){

                    case "-7.5":
	                    tiles[i][x] = set[0];
                        break;

                    case "-5.0":
	                    tiles[i][x] = set[1];
                        break;

                    case "-2.5":
	                    tiles[i][x] = set[2];
                        break;

                    case "0":
	                    tiles[i][x] = set[3];
                        break;

                    case "2.5":
	                    tiles[i][x] = set[4];
                        break;

                    case "5.0":
	                    tiles[i][x] = set[5];
                        break;

                    case "7.5":
	                    tiles[i][x] = set[6];
                        break;
                    
                    default:
                        Error e = new Error("error on map tile " + i + " " + x);
                        e.printStackTrace();
                        break;
                }
            }
        }
        h.getG().getMemory().getMem().setMapTiles(tiles);
    }
}