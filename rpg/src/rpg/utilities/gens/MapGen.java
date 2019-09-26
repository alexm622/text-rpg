package rpg.utilities.gens;

import java.io.IOException;

import rpg.game.Handler;
import rpg.objects.map.Map;
import rpg.utilities.map.ToTiles;


public class MapGen {

    public final int WIDTH = 102, HEIGHT = 102;
    public final double FEATURE_SIZE = 10;

    public MapGen() {

        
        OpenSimplexNoiseTest osnt = new OpenSimplexNoiseTest(WIDTH, HEIGHT, FEATURE_SIZE);
        try {
            double[][] out = osnt.main();
            ConvertToMap(out);
        } catch (IOException e) {
           
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }
    }

    private void ConvertToMap(double[][] map){
        new ToTiles(map);
        Map m = new Map();
        String[][] ids = new String[map.length][map[0].length];
        boolean[][] clear = new boolean[map.length][map[0].length];
        for(int i = 0; i < map.length; i++){ //x
            for(int j = 0; j < map[0].length; j++){ //y
                ids[i][j] = Handler.memory.getMapTiles().getMap()[i][j].getId();
                clear[i][j] = false;
            }
        }
        m.setTileids(ids);
        m.setCleared(clear);
        m.setHeight(map.length);
        m.setWidth(map[0].length);
        Handler.memory.setMap(m);
        
        
        
    }
}