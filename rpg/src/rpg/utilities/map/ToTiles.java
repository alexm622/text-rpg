package rpg.utilities.map;

import rpg.game.Handler;
import rpg.objects.map.Tile;

public class ToTiles {

    private double[][] doub;
    private Tile[][] tiles;

    public ToTiles(Handler h){

        doub = h.getG().getMemory().getMem().getMap().getTiles();
        tiles = new Tile[doub.length][doub[0].length];

        //-7.5, -5.0 , -2.5, 0, 2.5, 5.0, 7.5
        for(int i = 0; i < doub.length; i++){
            for(int x = 0; x < doub[i].length; x++){
                String temp = Double.toString(doub[i][x]);
                switch (temp){

                    case "-7.5":
                        break;

                    case "-5.0":
                        break;

                    case "-2.5":
                        break;

                    case "0":
                        break;

                    case "2.5":
                        break;

                    case "5.0":
                        break;

                    case "7.5":
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