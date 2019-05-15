package rpg.utilities.gens;

import java.io.IOException;

import rpg.game.Handler;
import rpg.objects.map.Map;
import rpg.utilities.map.ToTiles;


public class MapGen {

    private Handler h;

    public MapGen(Handler h) {
        this.h = h;
        OpenSimplexNoiseTest osnt = new OpenSimplexNoiseTest();
        try {
            double[][] out = osnt.main();
            ConvertToMap(out);
        } catch (IOException e) {
           
            rpg.game.Handler.debug(e.toString(), true);
            e.printStackTrace();
        }
    }

    private void ConvertToMap(double[][] map){
        new ToTiles(h, map);
        Map m = new Map();
        String[][] ids = new String[map.length][map[0].length];
        boolean[][] clear = new boolean[map.length][map[0].length];
        for(int i = 0; i < map.length; i++){ //x
            for(int j = 0; j < map[0].length; j++){ //y
                ids[i][j] = h.getMem().getMapTiles().getMap()[i][j].getId();
                clear[i][j] = false;
            }
        }
        m.setTileids(ids);
        m.setCleared(clear);
        m.setHeight(map.length);
        m.setWidth(map[0].length);
        h.getMem().setMap(m);
        
        
        
    }
}